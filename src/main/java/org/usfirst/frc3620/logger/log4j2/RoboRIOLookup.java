package org.usfirst.frc3620.logger.log4j2;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.usfirst.frc3620.logger.LoggingMaster;

@Plugin(name = "roborio", category = StrLookup.CATEGORY)
public class RoboRIOLookup implements StrLookup {
    public RoboRIOLookup() {
        System.out.println ("RoboRIOLookup instantiated");
    }
    @Override
    public String lookup(String key) {
        if (key.equalsIgnoreCase("logdir")) {
            return LoggingMaster.getLoggingDirectory().getAbsolutePath();
        } else if (key.equalsIgnoreCase("timestamp")) {
            return LoggingMaster.convertTimestampToString(LoggingMaster.getTimestamp());
        }
        return null;
    }

    @Override
    public String lookup(LogEvent event, String key) {
        return lookup(key);
    }
}
