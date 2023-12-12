package composition;

import java.util.ArrayList;

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
            stringRepresentation += this.chars.get(i).toBinaryString();
            if (i < this.chars.size() - 1)
            {
                stringRepresentation += " ";
            }
        }

        return stringRepresentation;
    }
}
