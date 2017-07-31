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

package com.spectralogic.escapepod.cluster.config

import com.spectralogic.escapepod.util.resource.FileResource
import com.spectralogic.escapepod.util.resource.ProtoBuffMarshaller
import com.spectralogic.escapepod.util.resource.Resource
import com.spectralogic.escapepod.cluster.models.ClusterConfigProto
import java.nio.file.Path
import javax.inject.Inject
import javax.inject.Named

class ClusterConfigResource @Inject constructor(@Named("configDir") configDir : Path) :
        Resource<ClusterConfigProto.ClusterConfig>
        by FileResource(configDir, "cluster.buff", ProtoBuffMarshaller<ClusterConfigProto.ClusterConfig>(ClusterConfigProto.ClusterConfig::newBuilder))
