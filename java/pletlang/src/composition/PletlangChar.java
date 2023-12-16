package composition;

/**
 * Provides an enumeration for Pletlang's 16 characters.<br>
 * Assigns each character's value with its byte value (ex. m -> 0010 -> 2)
 */
public enum PletlangChar
{
    /**
     * Character 0000 of Pletlang.<br>
     * Used to signal the end of a transmission.<br>
     * TODO define their exact PletASM definitions?
     * Also written as "]".
     */
    END(0b0000),
    /**
     * Character 0001 of Pletlang.<br>
     * Used to make the voiced dental fricative /ð/ by default.<br>
     * Also written as "d".
     */
    D(0b0001),
    /**
     * Character 0010 of Pletlang.<br>
     * Used to make the voiced bilabial nasal /m/ by default.<br>
     * Also written as "m".
     */
    M(0b0010),
    /**
     * Character 0011 of Pletlang.<br>
     * Used to make the voiced palatal nasal /ɲ/ by default.<br>
     * Also written as "n".
     */
    N(0b0011),
    /**
     * Character 0100 of Pletlang.<br>
     * Used to make the voiced labiodental fricative /v/ by default.<br>
     * Also written as "v".
     */
    V(0b0100),
    /**
     * Character 0101 of Pletlang.<br>
     * Used to make the voiced labial-velar approximant /w/ by default.<br>
     * Also written as "w".
     */
    W(0b0101),
    /**
     * Character 0110 of Pletlang.<br>
     * Used to make the voiced alveolar fricative /z/ by default.<br>
     * Also written as "z".
     */
    Z(0b0110),
    /**
     * Character 0111 of Pletlang.<br>
     * Used to make the voiced post-alveolar fricative /ʒ/ by default.<br>
     * Also written as "j".
     */
    J(0b0111),
    /**
     * Character 1000 of Pletlang.<br>
     * Used to make the open front unrounded vowel /a/ by default.<br>
     * Also written as "a".
     */
    A(0b1000),
    /**
     * Character 1001 of Pletlang.<br>
     * Used to make the close front unrounded vowel /i/ by default.<br>
     * Also written as "i".
     */
    I(0b1001),
    /**
     * Character 1010 of Pletlang.<br>
     * Used to make the close-mid back rounded vowel /o/ by default.<br>
     * Also written as "o".
     */
    O(0b1010),
    /**
     * Character 1011 of Pletlang.<br>
     * Used to make the close back rounded vowel /u/ by default.<br>
     * Also written as "u".
     */
    U(0b1011),
    /**
     * Character 1100 of Pletlang.<br>
     * Used to set the tone of the current vowel to high.<br>
     * TODO this is weird to define.
     * Also written as ",".
     */
    LO(0b1100),
    /**
     * Character 1101 of Pletlang.<br>
     * Used to set the tone of the current vowel to low.<br>
     * TODO this is weird to define.
     * Also written as "'".
     */
    HI(0b1101),
    /**
     * Character 1110 of Pletlang.<br>
     * Can escape following characters.<br>
     * Also written as "\".
     */
    ESC(0b1110),
    /**
     * Character 1111 of Pletlang.<br>
     * Used to signal the start of a transmission.<br>
     * Also written as "[".
     */
    START(0b1111);

    private final int value;

    /**
     * Assigns a PletlangChar with a value. Meant to only be used within the enum definition.
     * @param value The int value to set the PletlangChar to.
     */
    PletlangChar(final int value)
    {
        this.value = value;
    }

    /**
     * Returns the value of the PletlangChar calling this.
     * @return The value of the PletlangChar calling this.
     */
    public int getValue()
    {
        return this.value;
    }

    /**
     * Returns the PletlangChar representation of an integer value between 0 and 15.<br>
     * If the value is not between 0 and 15, it will return null.
     * @param nybble An integer value between 0 and 15 that corresponds to the wanted PletlangChar's
     *               value.
     * @return The PletlangChar with `nybble` as its value. null if there is no such PletlangChar.
     */
    public static PletlangChar of(int nybble)
    {
        for (PletlangChar p : PletlangChar.values())
        {
            if (nybble == p.getValue())
            {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns the enumerated name of this PletlangChar.<br>
     * ex. <code>PletlangChar.HI.toString() -> "HI"</code>
     * @return The enumerated name of this PletlangChar.
     */
    @Override
    public String toString()
    {
        return this.name();
    }

    /**
     * Returns the 4-character nybble string value of this PletlangChar.<br>
     * ex. <code>PletlangChar.HI.toNybbleString() -> "1101"</code>
     * @return the 4-character nybble string value of this PletlangChar.
     */
    public String toNybbleString()
    {
        String binaryString = Integer.toBinaryString(this.value);
        String nybbleString = binaryString;
        for (int i = binaryString.length(); i < 4; i++)
        {
            nybbleString = '0' + nybbleString;
        }
        return nybbleString;
    }
}
