package com.dkellycollins.triggerfinger.util.logger.impl;

import com.dkellycollins.triggerfinger.util.logger.ILogWriter;
import com.dkellycollins.triggerfinger.util.logger.ILogger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logger implements ILogger {

    private final Iterable<ILogWriter> _writers;

    public Logger(Iterable<ILogWriter> writers) {
        _writers = writers;
    }


    @Override
    public void debug(String message) {
        for(ILogWriter writer : _writers) {
            writer.logDebug(message);
        }
    }

    @Override
    public void debug(String message, Throwable exception) {
        for(ILogWriter writer : _writers) {
            writer.logDebug(message, exception);
        }
    }

    @Override
    public void info(String message) {
        for(ILogWriter writer : _writers) {
            writer.logInfo(message);
        }
    }

    @Override
    public void warn(String message) {
        for(ILogWriter writer : _writers) {
            writer.logWarn(message);
        }
    }

    @Override
    public void warn(String message, Throwable exception) {
        for(ILogWriter writer : _writers) {
            writer.logWarn(message, exception);
        }
    }

    @Override
    public void error(String message, Throwable exception) {
        for(ILogWriter writer : _writers) {
            writer.logError(message, exception);
        }
    }
}
