# PletASM

## What is it?
PletASM is a way of defining operations that Pletlang can run in an easy-to-read format.  

For instance, the Pletlang string:

`0.........1....2.........3.........4........`  
`1110 1000 0001 1000 0000 1111 1111 0000 0000`

Sets the global color of speech to `#80ff00`, a greenish yellow. Here's what's happening here:

0. is \a, which declares there's an upcoming color sequence.
1. is \a's mode argument, which asks which type of color it will be (0001 is for 6-digit hex format).
2. is the color's red byte.
3. is the color's green byte.
4. is the color's blue byte.

This can be defined in PletASM:  
`color hex 80ff00`

