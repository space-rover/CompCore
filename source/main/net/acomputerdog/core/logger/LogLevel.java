package net.acomputerdog.core.logger;

/**
 * Logging levels such as DEBUG, INFO, ERROR, etc.
 */
public enum LogLevel {
    /**
     * LogLevel for full debug logging
     */
    DEBUG("DEBUG", 0, true, false),
    /**
     * LogLevel for smaller debug logging
     */
    DETAIL("DETAIL", 1, true, false),
    /**
     * LogLevel for normal message logging.
     */
    INFO("INFO", 2, false, false),
    /**
     * LogLevel for logging warnings, such as when an unexpected value is encountered.
     */
    WARNING("WARNING", 3, false, false),
    /**
     * LogLevel for logging errors, such as an exception
     */
    ERROR("ERROR", 4, false, true),
    /**
     * LogLevel for logging application-terminating errors, such as when a required library could not be loaded
     */
    FATAL("FATAL", 5, false, true),
    /**
     * LogLevel for logging stack traces.
     */
    STACK("STACK", 6, false, true);

    /**
     * The name of this LogLevel
     */
    private String levelName;

    /**
     * The numerical priority of this LogLevel
     */
    private int priority;

    /**
     * If this LogLevel is a debug level
     */
    private boolean isDebug;

    /**
     * If this LogLevel is an error level
     */
    private boolean isError;

    /**
     * Creates a new LogLevel
     *
     * @param levelName The name of this Level
     * @param priority  The priority of this level
     * @param isDebug   If this Level is a debug level
     * @param isError   If this level is an error level
     */
    private LogLevel(String levelName, int priority, boolean isDebug, boolean isError) {
        this.levelName = levelName;
        this.priority = priority;
        this.isDebug = isDebug;
        this.isError = isError;
    }

    /**
     * Gets a String representing the name of this logging level.
     *
     * @return Return a String representing the name of this logging level.
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Gets an int representing the priority level of this logging level.
     *
     * @return Return an int representing the priority level of this logging level.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns true if this Logging level is a debug level (DEBUG or DETAIL).
     *
     * @return Return true if this Logging level is a debug level
     */
    public boolean isDebug() {
        return isDebug;
    }

    /**
     * Returns true if this logging level is an error level (ERROR or FATAL)
     *
     * @return Return true if this logging level is an error level
     */
    public boolean isError() {
        return isError;
    }

    /**
     * Returns true if this ELogLevel is allowed with the specified priority.
     *
     * @param priority The priority to compare to.
     * @return Returns true if this ELogLevel is allowed with the specified priority.
     */
    public boolean isAllowedBy(int priority) {
        return this.priority >= priority;
    }

    /**
     * Returns true if this ELogLevel is allowed with the specified priority.
     *
     * @param priority The priority to compare to.
     * @return Returns true if this ELogLevel is allowed with the specified priority.
     */
    public boolean isAllowedBy(LogLevel priority) {
        return this.priority >= priority.getPriority();
    }

    /**
     * Gets the ELogLevel identified by the given name.
     *
     * @param name The name of the ELogLevel to get.
     * @return Return the ELogLevel identified by the given name, or null if none exists.
     */
    public static LogLevel getByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null!");
        } else {
            for (LogLevel level : values()) {
                if (name.equals(level.getLevelName())) {
                    return level;
                }
            }
            return null;
        }
    }
}
