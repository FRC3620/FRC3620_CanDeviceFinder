package org.usfirst.frc3620.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import edu.wpi.first.wpilibj.DriverStation;
import org.apache.logging.log4j.Level;

public class EventLogging {

    // make some levels that correspond to the different SLF4J logging
    // methods. Have the mappings to the underlying j.u.l logging levels.
    public enum Level {
        TRACE(org.apache.logging.log4j.Level.TRACE), //
        DEBUG(org.apache.logging.log4j.Level.DEBUG), //
        INFO(org.apache.logging.log4j.Level.INFO), //
        WARN(org.apache.logging.log4j.Level.WARN), //
        ERROR(org.apache.logging.log4j.Level.ERROR);

        org.apache.logging.log4j.Level log4jLevel;

        Level(org.apache.logging.log4j.Level _log4jLevel) {
            log4jLevel = _log4jLevel;
        }
    }

    // do this when first loaded
    static {
        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
    }

    /**
     * Get an SLF4J logger for a class. Set the underlying j.u.l logger to the
     * desired level.
     * 
     * @param clazz
     *            class for the logger
     * @param l
     *            Level that we want to log at
     * @return
     */
    static public org.slf4j.Logger getLogger(Class<?> clazz, Level l) {
        return getLogger(clazz.getName(), l);
    }

    /**
     * Get an SLF4J logger for a name. Set the underlying j.u.l logger to the
     * desired level.
     * 
     * @param sClazz
     *            name for the logger
     * @param l
     *            Level that we want to log at
     * @return
     */
    static public org.slf4j.Logger getLogger(String sClazz, Level l) {
        // set up the underlying logger to log at the level we want
        org.apache.logging.log4j.core.config.Configurator.setLevel(sClazz, l.log4jLevel);

        // and return the SLF4J logger.
        org.slf4j.Logger rv = org.slf4j.LoggerFactory.getLogger(sClazz);
        return rv;
    }
    
    /**
     * Log command starts and stops
     * 
     * @param logger
     * 			  logger to log to.
     */
    public static void commandMessage (org.slf4j.Logger logger) {
  	  Throwable t = new Throwable();
  	  StackTraceElement[] stackTraceElement = t.getStackTrace();
  	  logger.info("command {}", stackTraceElement[1].getMethodName());
    }

    /**
     * Write a warning message to the DriverStation.
     * 
     * @param message
     *            Message to log.
     */
    public static final void writeWarningToDS(String message) {
        if (DriverStation.getInstance().isDSAttached()) {
        	DriverStation.reportWarning(message, false);
        }
    }
}
