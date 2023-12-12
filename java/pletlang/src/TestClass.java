import composition.PletlangChar;
import composition.PletlangString;

import java.util.List;
import java.util.ArrayList;

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
                                        PletlangChar.A,
                                        PletlangChar.I,
                                        PletlangChar.HI,
                                        PletlangChar.END
                                )
                        )
                ).toBinaryString()
        );
    }
}
