package io;

import composition.PletlangChar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Closeable;
import java.util.Scanner;

/**
 * TODO
 * A reader for .plet files which implements Scanner methods.<br>
 * Transmutes binary Pletlang into PletlangStrings.
 */
public class PletlangReader implements Closeable
{
    public static final String PLETLANG_FILE_EXTENSION = ".plet";
    private final File fromFile;
    private final Scanner fileScanner;

    /**
     * TODO
     * @param fromFile The .plet file to read from.
     */
    public PletlangReader(File fromFile) throws FileNotFoundException, InvalidFiletypeException
    {
        if (!isReadableFiletype(fromFile))
        {
            throw new InvalidFiletypeException(PLETLANG_FILE_EXTENSION, fromFile);
        }
        this.fromFile = fromFile;
        this.fileScanner = new Scanner(this.fromFile);
    }

    /**
     * Checks if the given filename implicitly is valid for reading Pletlang from.
     * @param fromFile The file to check.
     * @return Whether the given filename implies it's valid to read Pletlang from.
     */
    public static boolean isReadableFiletype(File fromFile)
    {
        return fromFile.getAbsolutePath().endsWith(PLETLANG_FILE_EXTENSION);
    }

    /**
     * Returns the next nybble from this PletlangReader's file, enumerated as a PletlangChar.
     * @return The PletlangChar representing the next nybble found in this PletlangReader's file.
     */
    public PletlangChar next()
    {
        return null;
    }

    // TODO is this @Override?

    /**
     * Closes the underlying readers in this PletlangReader.
     */
    public void close()
    {
        this.fileScanner.close();
    }
}
