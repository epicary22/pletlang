package composition;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A wrapper class for ArrayLists of PletlangChars, which implements basic String functionalities.
 */
public class PletlangString
{
    private final ArrayList<PletlangChar> chars;

    /**
     * Creates a new PletlangString.
     * @param chars The list of PletlangChars this PletlangString will represent.
     *              Will not be changed by any methods called on this PletlangString.
     */
    public PletlangString(final ArrayList<PletlangChar> chars)
    {
        this.chars = new ArrayList<>(chars.size());
        this.chars.addAll(chars);
    }

    /**
     * Creates a new PletlangString.
     * @param chars The chars to turn into a PletlangString.
     */
    public PletlangString(final PletlangChar... chars)
    {
        this.chars = new ArrayList<>(chars.length);
        this.chars.addAll(Arrays.asList(chars));
    }

    /**
     * Adds a singular PletlangChar to the end of this PletlangString.
     * @param character The PletlangChar to add.
     */
    public void add(PletlangChar character)
    {
        this.chars.add(character);
    }

    /**
     * Adds the given PletlangString to the end of this current PletlangString.
     * @param string The PletlangString to add.
     */
    public void add(PletlangString string)
    {
        this.chars.addAll(string.toPletlangCharArrayList());
    }

    /**
     * Returns this PletlangString as an ArrayList of its PletlangChars.
     * @return This PletlangString as an ArrayList of its PletlangChars.
     */
    public ArrayList<PletlangChar> toPletlangCharArrayList()
    {
        ArrayList<PletlangChar> copyString = new ArrayList<>(this.chars.size());
        copyString.addAll(this.chars);
        return copyString;
    }

    /**
     * Returns a String representation of this PletlangString.<br>
     * Each PletlangChar is represented with its enumerated name.
     * @return A String representation of this PletlangString.
     */
    @Override
    public String toString()
    {
        String stringRepresentation = "";
        for (int i = 0; i < this.chars.size(); i++)
        {
            stringRepresentation += this.chars.get(i);
            if (i < this.chars.size() - 1)
            {
                stringRepresentation += " ";
            }
        }

        return stringRepresentation;
    }

    /**
     * Returns a binary String representation of this PletlangString.<br>
     * Each PletlangChar is represented with its nybble value in binary.
     * @return A binary String representation of this PletlangString.
     */
    public String toBinaryString()
    {
        String stringRepresentation = "";
        for (int i = 0; i < this.chars.size(); i++)
        {
            stringRepresentation += this.chars.get(i).toNybbleString();
            if (i < this.chars.size() - 1)
            {
                stringRepresentation += " ";
            }
        }

        return stringRepresentation;
    }
}
