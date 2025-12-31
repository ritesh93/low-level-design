package org.example.loggingframework.appender;

import org.example.loggingframework.LogFormatter.LogFormatter;
import org.example.loggingframework.LogFormatter.SimpleTextFormatter;
import org.example.loggingframework.entities.LogMessage;

public class ConsoleAppender implements LogAppender {
    private LogFormatter formatter;

    public ConsoleAppender() {
        this.formatter = new SimpleTextFormatter();
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }

    @Override
    public void close() {

    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }
}
