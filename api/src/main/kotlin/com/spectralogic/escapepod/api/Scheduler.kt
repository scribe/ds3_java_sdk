package com.spectralogic.escapepod.api

import com.google.common.collect.ImmutableList
import java.time.Instant

interface Scheduler : Managed {
    val configuration : EscapePodConfiguration?
}

data class EscapePodConfiguration(val timeSchedule: ImmutableList<TimeRange>)

data class TimeRange(val startTime: Instant, val endTime: Instant)
