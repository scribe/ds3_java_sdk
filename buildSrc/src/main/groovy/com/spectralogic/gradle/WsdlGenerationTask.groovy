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

package com.spectralogic.gradle

import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.TaskAction

class WsdlGenerationTask extends JavaExec {

    String packageName
    String fileLocation

    @TaskAction
    void exec() {
        main = 'org.apache.axis.wsdl.WSDL2Java'
        setWorkingDir("$project.projectDir/src/main/java")
        setClasspath(project.files(project.fileTree("$project.rootDir/buildSrc/tools/axis/lib")))
        args = ['-p', packageName, fileLocation]

        super.exec()
    }
}
