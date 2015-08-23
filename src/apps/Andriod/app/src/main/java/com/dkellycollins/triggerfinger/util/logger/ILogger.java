package com.dkellycollins.triggerfinger.util.logger;

/**
 * Created by Devin on 8/22/2015.
 */
public interface ILogger {

    void debug(String message);

    void debug(String message, Throwable exception);

    void info(String message);

    void warn(String message);

    void warn(String message, Throwable exception);

    void error(String message, Throwable exception);

}
