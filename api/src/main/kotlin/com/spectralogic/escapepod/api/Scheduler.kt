package com.spectralogic.escapepod.api

import com.google.common.collect.ImmutableList
import java.time.Instant

interface Scheduler : Managed {
    var configuration : EscapePodConfiguration
    fun migrate(tapeGroupName: String)
}

data class EscapePodConfiguration(val bpConfig: BpConfiguration, val devaConfig: DevaConfiguration, val timeSchedule: ImmutableList<TimeRange>)

data class BpConfiguration(val endpoint: String, val accessKey: String, val secretKey: String)

data class DevaConfiguration(val endpoint: String)

data class TimeRange(val startTime: Instant, val endTime: Instant)
