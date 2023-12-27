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
     * Gets a singular PletlangChar from this PletlangString, at the specified index.
     * @param index The index to get the PletlangChar from.
     * @return The PletlangChar at the given index.
     */
    public PletlangChar pletlangCharAt(int index)
    {
        return this.chars.get(index);
    }

    /**
     * Adds the given PletlangString to the end of this current PletlangString.
     * @param string The PletlangString to add.
     */
    public void add(PletlangString string)
    {
        this.chars.addAll(string.toArrayList());
    }

    /**
     * Returns this PletlangString as an ArrayList of its PletlangChars.
     * @return This PletlangString as an ArrayList of its PletlangChars.
     */
    public ArrayList<PletlangChar> toArrayList()
    {
        ArrayList<PletlangChar> copyString = new ArrayList<>(this.chars.size());
        copyString.addAll(this.chars);
        return copyString;
    }

    /**
     * Returns the number of characters in this PletlangString.
     * @return The number of characters in this PletlangString.
     */
    public int length()
    {
        return this.chars.size();
    }

    /**
     * Creates a copy of this PletlangString. Is not connected at all to the PletlangString it was
     * copied from.
     * @return A copy of this PletlangString.
     */
    public PletlangString copy()
    {
        return new PletlangString(new ArrayList<>(this.chars));
    }

    /**
     * Creates a substring of this PletlangString, given a starting index.
     * Does not affect the original PletlangString.
     * @param startIndex The index to start the substring from. If this index is beyond the length
     *                   of this PletlangString, it will return an empty PletlangString.
     * @return The substring of this PletlangString.
     */
    public PletlangString substring(int startIndex)
    {
        ArrayList<PletlangChar> newChars = new ArrayList<>(this.chars.size() - startIndex);
        for (int i = startIndex; i < this.chars.size(); i++)
        {
            newChars.add(this.chars.get(i));
        }
        return new PletlangString(newChars);
    }

    /**
     * Creates a substring of this PletlangString, given a starting index and an ending index.
     * Does not affect the original PletlangString.
     * @param startIndex The index to start the substring from. If this index is beyond the length
     *                   of this PletlangString, an empty PletlangString will be returned.
     * @param endIndex The index to end the substring at. If this index is beyond the length of
     *                 this PletlangString, it will be set to the final index of this string.
     * @return The substring of this PletlangString.
     */
    public PletlangString substring(int startIndex, int endIndex)
    {
        endIndex = Math.min(this.chars.size(), endIndex);
        ArrayList<PletlangChar> newChars = new ArrayList<>(endIndex - startIndex);
        for (int i = startIndex; i < endIndex; i++)
        {
            newChars.add(this.chars.get(i));
        }
        return new PletlangString(newChars);
    }

    /**
     * Determines whether this PletlangString starts with another PletlangString smaller than it.
     * @param startString The PletlangString to check if this PletlangString begins with.
     * @return true if this PletlangString starts with the startString.
     */
    public boolean startsWith(PletlangString startString)
    {
        if (startString.length() > this.length())
        {
            return false;
        }
        for (int i = 0; i < startString.length(); i++)
        {
            if (this.pletlangCharAt(i) != startString.pletlangCharAt(i))
            {
                return false;
            }
        }
        return true;
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

    /**
     * Creates a hexadecimal String representation of this PletlangString, where each PletlangChar
     * is one uppercase hex digit. There is no spacing between the digits.<br>
     * For instance, the PletlangString `A I HI` would become `89C`.
     * @return The hexadecimal String representation of this PletlangString.
     */
    public String toHexString()
    {
        String stringRepresentation = "";
        for (int i = 0; i < this.chars.size(); i++)
        {
            stringRepresentation += Integer.toHexString(this.chars.get(i).getValue()).toUpperCase();
        }
        return stringRepresentation;
    }
}
