package composition;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TODO
 */
public class PletlangString
{
    private final ArrayList<PletlangChar> chars;

    /**
     * TODO
     * @param chars
     */
    public PletlangString(ArrayList<PletlangChar> chars)
    {
        this.chars = new ArrayList<>(chars.size());
        this.chars.addAll(chars);
    }

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder(this.chars.size() * 5);
        for (int i = 0; i < this.chars.size(); i++)
        {
            String baseBinaryString = Integer.toBinaryString(this.chars.get(i).getValue());
            for (int z = baseBinaryString.length(); z < 4; z++)
            {
                string.append("0");
            }
            string.append(baseBinaryString);
            if (i < this.chars.size() - 1)
            {
                string.append(" ");
            }
        }

        return string.toString();
    }
}
