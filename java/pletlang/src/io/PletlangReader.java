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
    public static final String NYBBLE_PATTERN = "\\d{4}";
    private final File inputFile;
    private final Scanner fileScanner;

    /**
     * TODO
     * @param inputFile The .plet file to read from.
     */
    public PletlangReader(File inputFile) throws FileNotFoundException, InvalidFiletypeException
    {
        if (!isReadableFiletype(inputFile))
        {
            throw new InvalidFiletypeException(PLETLANG_FILE_EXTENSION, inputFile);
        }
        this.inputFile = inputFile;
        this.fileScanner = new Scanner(this.inputFile);
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
        // TODO finish this
        this.fileScanner.next(NYBBLE_PATTERN);
        return null;
    }

    /**
     * Checks if the file has a next nybble to read in.
     * @return Whether the file has a next nybble to read in.
     */
    public boolean hasNext()
    {
        return this.fileScanner.hasNext(NYBBLE_PATTERN);
    }

    /**
     * Gets the file that this PletlangReader is reading from.
     * @return The file that this PletlangReader is reading from.
     */
    public File getInputFile()
    {
        return this.inputFile;
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
