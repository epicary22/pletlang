package composition;

public enum PletlangEscapeSequenceType
{
    /**
     * Matches the Pletlang escape code of <code>1000 0000</code>,
     * for PletASM <code>color off</code>. Takes 0 arguments.<br>
     *
     */
    COLOR_OFF(new PletlangChar[] {PletlangChar.A, PletlangChar.END}, 0);

    private final PletlangChar[] identifier;
    private final int argumentNybbles;

    PletlangEscapeSequenceType(PletlangChar[] identifier, int argumentNybbles)
    {
        this.identifier = identifier;
        this.argumentNybbles = argumentNybbles;
    }
}
