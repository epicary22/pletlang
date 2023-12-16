package io;

import java.io.File;
import java.io.IOException;

/**
 * An exception for when a given filetype is invalid for a given operation.
 */
public class InvalidFiletypeException extends IOException
{
    /**
     * Initializes an InvalidFiletypeException with no message.
     */
    public InvalidFiletypeException()
    {
        super();
    }

    /**
     * Initializes an InvalidFiletypeException with a message.
     * @param message The message for the cause of this exception.
     */
    public InvalidFiletypeException(String message)
    {
        super(message);
    }

    /**
     * Initializes an InvalidFiletypeException with a message.
     * <br>
     * Automatically constructs a message based off of what the intended filetype was and the
     * file that had an invalid filetype.
     * @param intendedFiletype The intended filetype extension. ex. .exe, .py
     * @param invalidFile The file that had an invalid filetype extension.
     */
    public InvalidFiletypeException(String intendedFiletype, File invalidFile)
    {
        super(String.format("File `%s` is not of type `%s`.",
                invalidFile.getAbsolutePath(), intendedFiletype));
    }
}
