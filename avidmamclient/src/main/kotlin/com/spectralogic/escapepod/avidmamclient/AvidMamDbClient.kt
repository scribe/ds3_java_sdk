/*
 * *****************************************************************************
 *    Copyright 2014-2017 Spectra Logic Corporation. All Rights Reserved.
 *    Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *    this file except in compliance with the License. A copy of the License is located at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file.
 *    This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *    CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *    specific language governing permissions and limitations under the License.
 *  ****************************************************************************
 */

package com.spectralogic.escapepod.avidmamclient

import com.google.common.collect.ImmutableList
import com.spectralogic.escapepod.util.ifNotNull
import java.io.Closeable
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement

data class DivaFile(val fileName : String, val category: String)

interface AvidMamDbClient {
    fun listDivaAssets() : Sequence<DivaFile>
}

internal class AvidMamDbClientImpl(private val connection : Connection, private val carrierGuid: String) : AvidMamDbClient, Closeable {
    override fun listDivaAssets(): Sequence<DivaFile> {

        val builder = ImmutableList.builder<DivaFile>()

        var queryStatement : PreparedStatement? = null
        try {
            queryStatement = connection.prepareStatement("SELECT filename, filepath AS category FROM emv4location WHERE carrierguid= ?")

            if (queryStatement != null) {

                queryStatement.setNString(1, carrierGuid)

                val resultSet = queryStatement.executeQuery()

                while(resultSet.next()) {
                    builder.add(DivaFile(resultSet.getString("filename"), resultSet.getString("category")))
                }
            }
        } finally {
            queryStatement.ifNotNull {
                it.close()
            }
        }
        return builder.build().asSequence()
    }

    override fun close() {
        connection.close()
    }
}

class AvidMamDbClientFactory {

    /**
     * "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=your_password";
     */

    fun createClient(endpoint : String, username : String, password : String, carrierGuid : String = "DIVA") : AvidMamDbClient {
        // TODO need to consider sanitizing inputs
        val connectionString = "jdbc:sqlserver://$endpoint:1433;databaseName=Mam_System;user=$username;password=$password"

        // TODO consider using connection pooling in the future
        val connection = DriverManager.getConnection(connectionString)

        return AvidMamDbClientImpl(connection, carrierGuid)
    }
}