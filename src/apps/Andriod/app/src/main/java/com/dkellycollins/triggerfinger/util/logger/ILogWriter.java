package com.dkellycollins.triggerfinger.util.logger;

public interface ILogWriter {

    void logDebug(String message);

    void logDebug(String message, Throwable exception);

    void logInfo(String message);

    void logWarn(String message);

    void logWarn(String message, Throwable exception);

    void logError(String message, Throwable exception);

}
