package io.github.reblast.kpresence.utils

import kotlinx.cinterop.*
import platform.posix.*

@OptIn(ExperimentalForeignApi::class)
actual fun epochMillis(): Long = memScoped {
  val timeVal = alloc<timeval>()
  gettimeofday(timeVal.ptr, null)
  (timeVal.tv_sec * 1000) + (timeVal.tv_usec / 1000)
}