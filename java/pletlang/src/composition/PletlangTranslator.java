package composition;

import java.util.HashMap;
import java.util.Map;

public class PletlangTranslator
{
    public static final HashMap<PletlangChar, Character> pletAsmOutRepresentations = new HashMap<>(Map.of());


    static {
        pletAsmOutRepresentations.put(PletlangChar.END,     ']');
        pletAsmOutRepresentations.put(PletlangChar.D,       'd');
        pletAsmOutRepresentations.put(PletlangChar.M,       'm');
        pletAsmOutRepresentations.put(PletlangChar.N,       'n');
        pletAsmOutRepresentations.put(PletlangChar.V,       'v');
        pletAsmOutRepresentations.put(PletlangChar.W,       'w');
        pletAsmOutRepresentations.put(PletlangChar.Z,       'z');
        pletAsmOutRepresentations.put(PletlangChar.J,       'j');
        pletAsmOutRepresentations.put(PletlangChar.A,       'a');
        pletAsmOutRepresentations.put(PletlangChar.I,       'i');
        pletAsmOutRepresentations.put(PletlangChar.O,       'o');
        pletAsmOutRepresentations.put(PletlangChar.U,       'u');
        pletAsmOutRepresentations.put(PletlangChar.LO,      ',');
        pletAsmOutRepresentations.put(PletlangChar.HI,      '\'');
        pletAsmOutRepresentations.put(PletlangChar.ESC,     '\\');
        pletAsmOutRepresentations.put(PletlangChar.START,   '[');
    }

    public static String toPletAsm(PletlangString original)
    {
        PletlangString toTranslate = original.copy();
        StringBuilder translation = new StringBuilder();

        for (int i = 0; i < toTranslate.length(); i++)
        {
            PletlangChar character = toTranslate.pletlangCharAt(i);
            String pletAsmCommand = "";
            switch (character)
            {
                case ESC ->
                {
                    // TODO PletlangEscapeSequence.escapeSequenceAt();
                    pletAsmCommand = "esc";
                }
                case START -> pletAsmCommand = "start"; // TODO document this
                case END -> pletAsmCommand = "end"; // TODO document this
                case LO -> pletAsmCommand = "tone lo"; // TODO document this
                case HI -> pletAsmCommand = "tone hi"; // TODO document this
                default -> pletAsmCommand = "out " + pletAsmOutRepresentations.get(character);
            }
            translation.append(pletAsmCommand);
            translation.append("\n");
        }

        return translation.toString();
    }
}
