package composition;

import java.util.List;
import java.util.ArrayList;

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
                )
        );
    }
}
