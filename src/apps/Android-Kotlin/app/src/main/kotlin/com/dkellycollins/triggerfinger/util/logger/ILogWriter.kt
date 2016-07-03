package com.dkellycollins.triggerfinger.util.logger

interface ILogWriter {

    fun logDebug(message: String)

    fun logDebug(message: String, exception: Throwable)

    fun logInfo(message: String)

    fun logWarn(message: String)

    fun logWarn(message: String, exception: Throwable)

    fun logError(message: String, exception: Throwable)

}
