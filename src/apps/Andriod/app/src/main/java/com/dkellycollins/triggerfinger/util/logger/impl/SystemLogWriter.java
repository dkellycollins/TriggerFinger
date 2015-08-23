package com.dkellycollins.triggerfinger.util.logger.impl;

import android.util.Log;

import com.dkellycollins.triggerfinger.util.logger.ILogWriter;

import java.util.logging.*;
import java.util.logging.Logger;

public class SystemLogWriter implements ILogWriter {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger("TriggerFinger");

    @Override
    public void logDebug(String message) {
        LOGGER.info(message);
    }

    @Override
    public void logDebug(String message, Throwable exception) {
        LOGGER.log(Level.INFO, message, exception);
    }

    @Override
    public void logInfo(String message) {
        LOGGER.info(message);
    }

    @Override
    public void logWarn(String message) {
        LOGGER.warning(message);
    }

    @Override
    public void logWarn(String message, Throwable exception) {
        LOGGER.log(Level.WARNING, message, exception);
    }

    @Override
    public void logError(String message, Throwable exception) {
        LOGGER.log(Level.SEVERE, message, exception);
    }
}
