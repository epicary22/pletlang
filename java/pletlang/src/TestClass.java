import composition.PletlangChar;
import composition.PletlangString;
import io.PletlangReader;
import io.InvalidFiletypeException;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

/*
TODO
====

 - PletlangWriter
 - Some way of encoding Pletlang into PletASM... this is the difficult part, isn't it?
   o This means I need to make some standard on what PletASM is. I need to write that before
     I can encode it or decode it.
 */

public class TestClass
{
    public static void main(String[] args)
    {
        System.out.println("Wow this is a test class!");
        System.out.println(PletlangChar.A.getValue());
        System.out.println(
                new PletlangString(
                        new ArrayList<>(
                                List.of(
                                        PletlangChar.START,
                                        PletlangChar.W,
                                        PletlangChar.A,
                                        PletlangChar.HI,
                                        PletlangChar.END
                                )
                        )
                ).toBinaryString()
        );

        try (PletlangReader p = new PletlangReader(new File("pletlang_files/vi.plet")))
        {
            System.out.println(p.readAll());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
