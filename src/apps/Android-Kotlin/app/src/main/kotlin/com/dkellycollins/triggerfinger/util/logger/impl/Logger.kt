package com.dkellycollins.triggerfinger.util.logger.impl

import com.dkellycollins.triggerfinger.util.logger.ILogWriter
import com.dkellycollins.triggerfinger.util.logger.ILogger

import java.io.PrintWriter
import java.io.StringWriter

class Logger(private val _writers: Iterable<ILogWriter>) : ILogger {


    override fun debug(message: String) {
        for (writer in _writers) {
            writer.logDebug(message)
        }
    }

    override fun debug(message: String, exception: Throwable) {
        for (writer in _writers) {
            writer.logDebug(message, exception)
        }
    }

    override fun info(message: String) {
        for (writer in _writers) {
            writer.logInfo(message)
        }
    }

    override fun warn(message: String) {
        for (writer in _writers) {
            writer.logWarn(message)
        }
    }

    override fun warn(message: String, exception: Throwable) {
        for (writer in _writers) {
            writer.logWarn(message, exception)
        }
    }

    override fun error(message: String, exception: Throwable) {
        for (writer in _writers) {
            writer.logError(message, exception)
        }
    }
}
