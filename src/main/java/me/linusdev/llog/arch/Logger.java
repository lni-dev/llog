package me.linusdev.llog.arch;

import me.linusdev.llog.arch.data.LogData;
import org.jetbrains.annotations.NotNull;

/**
 * Logger specification
 */
public interface Logger {

    /**
     *
     * @param logLevel {@link LogLevel}
     * @param data {@link LogData}
     */
    void log(@NotNull LogLevel logLevel, @NotNull LogData data);

    /**
     * Flushes the logger if possible.
     * @return whether the flush was successful.
     */
    boolean flush();

    /**
     * Whether this stream is flushable.
     * @return {@code true} if {@link #flush()} will always return {@code false}.
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