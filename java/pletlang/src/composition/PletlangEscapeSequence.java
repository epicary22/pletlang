package composition;

public class PletlangEscapeSequence
{
    private final PletlangEscapeSequenceType type;
    private final PletlangString arguments;
    private PletlangString cutEscapeString;

    public PletlangEscapeSequence(PletlangString escapeString)
    {
        this.cutEscapeString = escapeString.copy();
        // cut down escape string if it's more than just ESC
        if (this.cutEscapeString.length() > 1
            && this.cutEscapeString.pletlangCharAt(0) == PletlangChar.ESC)
        {
            this.cutEscapeString = this.cutEscapeString.substring(1);
        }

        this.type = PletlangEscapeSequenceType.of(this.cutEscapeString);
        if (this.type != PletlangEscapeSequenceType.INVALID)
        {
            this.cutEscapeString = this.cutEscapeString.substring(0, this.type.nybbleLength());
            this.arguments = this.cutEscapeString.substring(this.type.getPletlangIdentifier().length());
        }
        else
        {
            this.cutEscapeString = new PletlangString();
            this.arguments = new PletlangString();
        }
    }

    /**
     * Returns the Pletlang Escape Sequence Type of this PletlangEscapeSequence.
     * @return The Pletlang Escape Sequence Type of this PletlangEscapeSequence.
     */
    public PletlangEscapeSequenceType getType()
    {
        return this.type;
    }

    /**
     * Returns the arguments for this PletlangEscapeSequence.
     * @return The arguments for this PletlangEscapeSequence.
     */
    public PletlangString getArguments()
    {
        return this.arguments;
    }

    /**
     * Returns the length of this Escape Sequence. If this has an invalid Escape Sequence Type,
     * returns 0.
     * @return The length of this Escape Sequence.
     */
    public int getLength()
    {
        return this.cutEscapeString.length();
    }

    /**
     * TODO document
     * @return
     */
    public String getPletAsmRepresentation()
    {
        return this.type.getPletAsmIdentifier() + " " + this.arguments.toHexString();
    }
}
