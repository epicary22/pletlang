# PletASM Documentation

# DEFINITIONS

### nybble
A "nybble" refers to a 4-byte data value. In Pletlang, it's written as four adjacent bytes. In PletASM, it's written as a single hex character. As a PletASM argument, a nybble is referred to as `<n>`, and multiple nybbles can be written as `<nnnnnn>`, for however many nybbles are necessary.

# THE ENVIRONMENT
TODO talk about the environment.

# FUNCTIONS
## `esc2 (\], 1110 0000)`
### Enters escape 2 mode.
 * give some specific uses of this?

## `color (\a, 1110 1000)`
### Sets the color of speech.
`color`, at a high level, takes these arguments:
 * a color type, such as hex or 256-color
 * an integer value that matches the color type.

For instance:  
`1110 1000 0001 1111 1111 1111 1111 0000 0000` corresponds to  
`color.... hex. f... f... f... f... 0... 0...`, which is the command  
`color hex ffff00`. This sets the color of speech to a bright yellow.

All usable color modes are:
 * `sixteen <n>`
    * Corresponds to the first color code argument being `0000`.
    * Requires one nybble, which can represent up to 16 different colors.
    * Sets the color of speech with the ANSI standard for 16-color display.
 * `hex <nnnnnn>`
    * Corresponds to the first color code argument being `0001`.
    * Requires six nybbles: the first pair represents the red byte, the second pair represents the blue byte, and the third pair represents the green byte.
    * Sets the color of speech with the HTML standard for 3-byte hex colors.
 * 