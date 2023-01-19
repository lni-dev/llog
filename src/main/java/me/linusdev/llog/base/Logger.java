package me.linusdev.llog.base;

import me.linusdev.data.so.SOData;
import me.linusdev.llog.base.data.LogData;
import me.linusdev.llog.base.impl.LogSOData;
import me.linusdev.llog.base.impl.TextLogData;
import org.jetbrains.annotations.NotNull;

/**
 * Logger specification
 */
public interface Logger {

    /**
     * log given {@link LogData} on given {@link LogLevel}
     * @param logLevel {@link LogLevel}
     * @param data {@link LogData}
     */
    void log(@NotNull LogLevel logLevel, @NotNull LogSource source, @NotNull LogData data);

    /**
     * log given {@code text} on given {@link LogLevel}
     * @param logLevel {@link LogLevel}
     * @param text text to log
     */
    default void log(@NotNull LogLevel logLevel, @NotNull LogSource source, @NotNull String text) {
        log(logLevel, source, new TextLogData(text));
    }

    /**
     * log given {@link SOData} as json on given {@link LogLevel}.
     * @param logLevel {@link LogLevel}
     * @param data {@link SOData} to log
     */
    default void log(@NotNull LogLevel logLevel, @NotNull LogSource source, @NotNull SOData data) {
        log(logLevel, source, new LogSOData(data));
    }

    /**
     * Flushes the logger if possible.
     * @return whether the flush was successful.
     */
    boolean flush();

    /**
     * Whether this stream is flushable.
     * @return {@code false} if {@link #flush()} will always return {@code false}.
     */
    boolean isFlushable();

    /**
     * Sets the minimum numerical log level to {@link LogLevel#getLevel()}.
     * @param level minimum {@link LogLevel}
     */
    default void setMinimumLogLevel(@NotNull LogLevel level) {
        setMinimumLogLevel(level.getLevel());
    }

    /**
     * Sets the minimum numerical log level to given {@code level}.
     * @param level minimum numerical log level
     */
    void setMinimumLogLevel(int level);

}