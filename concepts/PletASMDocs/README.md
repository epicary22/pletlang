# PletASM

## What is it?
PletASM is a way of defining operations that Pletlang can run.
For instance, the Pletlang string:

`0.........1....2.........3.........4........`  
`1110 1000 0001 1000 0000 1111 1111 0000 0000`

Defines the color #80ff00, a greenish yellow.

0. is \a, which declares there's an upcoming color sequence.
1. is \a's first argument, which asks which type of color it will be (#xxxxxx in this case)
2. is \a's second argument, based on \a's first argument. It is one byte, which defines the red value.
3. is \a's third argument, based on \a's first argument. It is one byte, which defines the green value.
4. is \a's fourth argument, based on \a's first argument. It is one byte, which defines the blue value.

This can be defined in PletASM:

`color hex 80 ff 00`

This is much easier to interpret with a parser than raw Pletlang.
