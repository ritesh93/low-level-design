package org.example.loggingframework.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.loggingframework.LogLevel;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LogMessage {
    private LogLevel logLevel;
    private String message;
    private String loggerName;
    private LocalDateTime timestamp;
}
