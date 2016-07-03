package com.dkellycollins.triggerfinger.util.logger.impl

import android.util.Log

import com.dkellycollins.triggerfinger.util.logger.ILogWriter

import java.util.logging.*
import java.util.logging.Logger

class SystemLogWriter : ILogWriter {

    override fun logDebug(message: String) {
        LOGGER.info(message)
    }

    override fun logDebug(message: String, exception: Throwable) {
        LOGGER.log(Level.INFO, message, exception)
    }

    override fun logInfo(message: String) {
        LOGGER.info(message)
    }

    override fun logWarn(message: String) {
        LOGGER.warning(message)
    }

    override fun logWarn(message: String, exception: Throwable) {
        LOGGER.log(Level.WARNING, message, exception)
    }

    override fun logError(message: String, exception: Throwable) {
        LOGGER.log(Level.SEVERE, message, exception)
    }

    companion object {

        private val LOGGER = Logger.getLogger("TriggerFinger")
    }
}
