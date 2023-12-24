package io;

import composition.PletlangChar;
import composition.PletlangString;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TODO
 * A reader for .plet files which implements Scanner methods.<br>
 * Transmutes Pletlang into PletlangStrings.
 */
public class PletlangReader implements Closeable
{
    public static final String PLETLANG_FILE_EXTENSION = ".plet";
    public static final String NYBBLE_PATTERN = "[01]{4}";
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
     * @throws InputMismatchException The next token is not a readable nybble.
     */
    public PletlangChar next() // throws EOFException
    {
//        if (!this.fileScanner.hasNext())
//        {
//            throw new EOFException("The input file has no more tokens to read.");
//        }
        if (!this.hasNext())
        {
            throw new InputMismatchException("Next token `" + this.fileScanner.next() + "` is " +
                "not a nybble in the form of /" + NYBBLE_PATTERN + "/.");
        }
        String nybble = this.fileScanner.next(NYBBLE_PATTERN);
        int nybbleValue = Integer.parseInt(nybble, 2);
        return PletlangChar.of(nybbleValue);
    }

    /**
     * Returns the next <code>amount</code> nybbles from this Pletlang file, enumerated into a
     * PletlangString. If more nybbles are requested than there are left in the file, this will
     * only read in the remaining nybbles.
     * @param amount The number of nybbles to read in from the file. If more than the amount of
     *               nybbles left in the file, it will only read in the nybbles left.
     * @return The nybbles read in turned into a PletlangString.
     */
    public PletlangString next(int amount)
    {
        PletlangString nextCharacters = new PletlangString();
        for (int i = 0; i < amount; i++)
        {
            try
            {
                PletlangChar nextChar = this.next();
                nextCharacters.add(nextChar);
            }
            catch (InputMismatchException e)
            {
                break;
            }
        }
        return nextCharacters;
    }

    public PletlangString readAll()
    {
        PletlangString allChars = new PletlangString();
        while (this.hasNext())
        {
            allChars.add(this.next());
        }
        return allChars;
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

    /**
     * Closes the underlying readers in this PletlangReader.
     */
    @Override
    public void close()
    {
        this.fileScanner.close();
    }
}
