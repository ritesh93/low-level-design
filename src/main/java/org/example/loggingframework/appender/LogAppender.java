package org.example.loggingframework.appender;

import org.example.loggingframework.LogFormatter.LogFormatter;
import org.example.loggingframework.entities.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
}
