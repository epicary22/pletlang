# What am I doing?

I want this to have a nice class hierarchy...

PletlangChar: IntEnum  

Now how do I nicely edit PletlangChars?
I want the user to believe that they're just typing
in normal text, and have the PletlangChars be
underlying data structure.

In essence, PletlangChars can be stored inside a
PletlangString, which is a list of PletlangChars
that can be mutated like a normal str.

I also need a way of processing the codes in the
PletlangString, with maybe a PletlangCodeProcessor,
that can declare that colors have been spoken,
volume turned up/down, etc. and writes these as
instructions for various other processors.

These processors could include a way of turning the
codes into audio, or text, or an executable/string
that can be stored for later use with the ip
lookup mode.

By the way, I need a way of processing all of those
escapes. I think I can process them into codes that
can be interpreted later by something else.

For instance, a code ColorCode("#ff00ff") could be
interpreted as purple text, or turning the toaster's
screen purple. Brightness could "turn down" the text
color, or the screen brightness. 1110 0011 could be
read as a \n character, or it could have a special
operation for each toaster. There's the ip lookup,
which creates a code that will search up codes at
Pletlang-compile-time.