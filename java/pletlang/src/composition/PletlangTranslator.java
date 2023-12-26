package composition;

import java.util.EnumMap;
import java.util.Map;

public class PletlangTranslator
{
    public static final EnumMap<PletlangChar, Character> pletAsmOutRepresentations = new EnumMap<>(Map.of());;


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

    public String toPletAsm(PletlangString original)
    {
        PletlangString toTranslate = original.copy();
        StringBuilder translation = new StringBuilder();

        for (int i = 0; i < toTranslate.length(); i++)
        {
            PletlangChar character = toTranslate.pletlangCharAt(i);
            if (character == PletlangChar.ESC)
            {

            }
            else
            {
                translation.append(String.format("out %c", pletAsmOutRepresentations.get(character)));
            }
        }

        return translation.toString();
    }
}
