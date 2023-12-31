# The `num` function

PletASM: `num <mode> <nybbles>`  
Pletlang: `1110 1111 <mode> <nybbles>`  
Plaintext: `\[<nybble><nybbles>`

## Defines a numeric value.

`num` allows you to define a wide array of number types. It takes two arguments:
 * The number "mode" (defining the number's nybble size and what it means)
 * The number's value, in nybbles that can be interpreted according to the mode.

For instance:  

The different possible modes are:
 * `nybble` (mode argument: `0000`)