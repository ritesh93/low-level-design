package org.example.loggingframework.LogFormatter;

import org.example.loggingframework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}
