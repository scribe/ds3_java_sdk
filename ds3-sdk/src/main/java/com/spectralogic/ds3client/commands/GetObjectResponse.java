/*
 * ******************************************************************************
 *   Copyright 2014-2015 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

// This code is auto-generated, do not modify
package com.spectralogic.ds3client.commands;

import com.spectralogic.ds3client.networking.WebResponse;
import java.io.IOException;
import java.io.InputStream;
import com.spectralogic.ds3client.models.HttpErrorResultApiBean;
import com.spectralogic.ds3client.serializer.XmlOutput;

public class GetObjectResponse extends AbstractResponse {

    private HttpErrorResultApiBean httpErrorResultApiBeanResult;

    public GetObjectResponse(final WebResponse response) throws IOException {
        super(response);
    }

    @Override
    protected void processResponse() throws IOException {
        try {
            this.checkStatusCode(200, 206, 307);

            switch (this.getStatusCode()) {
            case 200:
                //Do nothing, payload is null
                break;
            case 206:
                //Do nothing, payload is null
                break;
            case 307:
                try (final InputStream content = getResponse().getResponseStream()) {
                    this.httpErrorResultApiBeanResult = XmlOutput.fromXml(content, HttpErrorResultApiBean.class);
                }
            default:
                assert false : "checkStatusCode should have made it impossible to reach this line.";
            }
        } finally {
            this.getResponse().close();
        }
    }

    public HttpErrorResultApiBean getHttpErrorResultApiBeanResult() {
        return this.httpErrorResultApiBeanResult;
    }

}