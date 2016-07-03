package com.dkellycollins.triggerfinger.util.logger

/**
 * Created by Devin on 8/22/2015.
 */
interface ILogger {

    fun debug(message: String)

    fun debug(message: String, exception: Throwable)

    fun info(message: String)

    fun warn(message: String)

    fun warn(message: String, exception: Throwable)

    fun error(message: String, exception: Throwable)

}
