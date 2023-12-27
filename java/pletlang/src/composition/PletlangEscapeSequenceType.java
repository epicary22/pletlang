package composition;

/**
 * A library of Pletlang Escape Sequence Types.<br>
 * Each escape sequence has its own identifier and number of arguments, much akin to functions
 * in other languages. The purpose of this library is to document which identifiers in Pletlang
 * or PletASM correspond to each other.<br>
 * Each item's description declares its Pletlang representation, minus the 1110 at the start, as
 * well as its PletASM function name. It also says how many nybbles it takes as arguments.
 * TODO rewrite this wordy ahh description
 */
public enum PletlangEscapeSequenceType
{
    /**
     * The Pletlang Escape Sequence Type for invalid escape sequences.
     */
    INVALID(new PletlangString(), "invalid", Integer.MAX_VALUE),
    /**
     * Pletlang: <code>1000 0000</code><br>PletASM: <code>color off</code><br>
     * 0 argument nybbles.
     */
    COLOR_OFF(new PletlangString(PletlangChar.A, PletlangChar.END),
            "color off", 0),
    /**
     * Pletlang: <code>1000 0001</code><br>PletASM: <code>color hex</code><br>
     * 6 argument nybbles.
     */
    COLOR_HEX(new PletlangString(PletlangChar.A, PletlangChar.D),
            "color hex", 6),
    /**
     * Pletlang: <code>1000 0010</code><br>PletASM: <code>color ansi16</code><br>
     * 1 argument nybble.
     */
    COLOR_ANSI16(new PletlangString(PletlangChar.A, PletlangChar.M),
            "color ansi16", 1),
    /**
     * Pletlang: <code>1000 0011</code><br>PletASM: <code>color ansi256</code><br>
     * 2 argument nybbles.
     */
    COLOR_ANSI256(new PletlangString(PletlangChar.A, PletlangChar.N),
            "color ansi256", 2),
    /**
     * Pletlang: <code>1000 1110</code><br>PletASM: <code>color default</code><br>
     * 0 argument nybbles.
     */
    COLOR_DEFAULT(new PletlangString(PletlangChar.A, PletlangChar.ESC),
            "color default", 0),
    /**
     * Pletlang: <code>1000 1111</code><br>PletASM: <code>color on</code><br>
     * 0 argument nybbles.
     */
    COLOR_ON(new PletlangString(PletlangChar.A, PletlangChar.START),
            "color on", 0),
    /**
     * Pletlang: <code>1110</code><br>PletASM: <code>???</code><br>
     * 0 argument nybbles.
     */
    ESC(new PletlangString(PletlangChar.ESC),
            "out \\", 0);

    private final PletlangString pletlangIdentifier;
    private final String pletAsmIdentifier;
    private final int argumentNybbles;

    /**
     * Creates the definition for a Pletlang Escape Sequence Type, given its identifier and number
     * nybbles required as arguments.
     *
     * @param pletlangIdentifier The Pletlang identifier for this escape sequence. Does NOT contain
     *                           the initial PletlangChar.ESC character at the beginning that
     *                           signifies an escape code.
     * @param pletAsmIdentifier  The PletASM identifier for this escape sequence.
     * @param argumentNybbles    The number of nybbles that this escape sequence takes as an
     *                           argument.
     */
    PletlangEscapeSequenceType(PletlangString pletlangIdentifier, String pletAsmIdentifier,
                               int argumentNybbles)
    {
        this.pletlangIdentifier = pletlangIdentifier;
        this.pletAsmIdentifier = pletAsmIdentifier;
        this.argumentNybbles = argumentNybbles;
    }

    /**
     * Finds the Pletlang Escape Sequence Type of the given PletlangString.
     * This means that the PletlangString starts with a Pletlang Escape Sequence Identifier and is
     * long enough to handle the arguments for that Escape Sequence.
     * @param escapeString A PletlangString to find the Escape Sequence Type of. Does not have the
     *                     initial PletlangChar.ESC that escape sequences start with.
     * @return The Pletlang Escape Sequence Type of the given PletlangString. Returns
     *         PletlangEscapeSequenceType.INVALID if no valid type is found or there is a valid type
     *         but there aren't enough argument nybbles.
     */
    public static PletlangEscapeSequenceType of(PletlangString escapeString)
    {
        for (PletlangEscapeSequenceType escapeSequenceType : PletlangEscapeSequenceType.values())
        {
            if (escapeString.startsWith(escapeSequenceType.pletlangIdentifier)
                && escapeString.length() >= escapeSequenceType.nybbleLength())
            {
                return escapeSequenceType;
            }
        }
        return INVALID;
    }

    /**
     * Returns the number of argument nybbles this Pletlang Escape Sequence requires.
     *
     * @return The number of argument nybbles this Pletlang Escape Sequence requires.
     */
    public int numArgumentNybbles()
    {
        return this.argumentNybbles;
    }

    /**
     * Returns the Pletlang identifier for this Pletlang Escape Sequence Type.
     *
     * @return The Pletlang identifier for this Pletlang Escape Sequence Type.
     */
    public PletlangString getPletlangIdentifier()
    {
        return this.pletlangIdentifier;
    }

    /**
     * Returns the PletASM identifier for this Pletlang Escape Sequence Type.
     *
     * @return The PletASM identifier for this Pletlang Escape Sequence Type.
     */
    public String getPletAsmIdentifier()
    {
        return this.pletAsmIdentifier;
    }

    /**
     * Finds the number of nybbles that this Pletlang escape sequence needs, including its escape
     * sequence identifier nybbles and its argument nybbles.
     * @return The number of nybbles that this Pletlang escape sequence needs.
     */
    public int nybbleLength()
    {
        return this.pletlangIdentifier.length() + this.argumentNybbles;
    }
}
