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
