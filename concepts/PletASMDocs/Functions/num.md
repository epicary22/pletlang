# The `num` function

PletASM: `num <mode> <nybbles>`  
Pletlang: `1110 1111 <mode> <nybbles>`  
Plaintext: `\[<nybble><nybbles>`

## Defines a numeric value.

`num` allows you to define a wide array of number types. It takes two arguments:
 * The number "mode" (defining the number's nybble size and meaning)
 * The number's value, in nybbles that can be interpreted according to the mode.

For instance:  

The different possible modes are:
 * `nybble <n>` (mode argument: `0001`)
   * Interprets the nybble as its unsigned integer value.
   * ex. `num nybble F` -> `0xf` -> 15
 * `byte <nn>` (mode argument: `0010`)
   * Interprets the 2 nybbles as a signed byte integer value.
   * ex. `num byte 80` -> `0x80` -> -128
 * `short <nnnn>` (mode argument: `0011`)
   * Interprets the 4 nybbles as a two-byte integer value.
   * ex. `num short 3579` -> `0x3579` -> 13689
 * `int <nnnnnnnn>` (mode argument: `0100`)
   * Interprets the 8 nybbles as a signed four-byte integer value.
   * ex. `num int FFFFFFFF` -> `0xffffffff` -> -1
 * `long <nnnnnnnnnnnnnnnn>` (mode argument: `0101`)
   * Interprets the 16 nybbles as a signed eight-byte integer value.
   * ex. `num long FEDCBA9876543210` -> `0xfedcba9876543210` -> -81985529216486896
 * `float <nnnnnnnn>` (mode argument: `0110`)
   * Interprets the 8 nybbles as a single-precision floating-point number, according to the IEEE 754 floating-point standard.
   * Can have values of Infinity, -Infinity, and NaN.
   * ex. `num float 40C00000` -> 6.0
 * `double <nnnnnnnnnnnnnnnn>` (mode argument: `0111`)
   * Interprets the 16 nybbles as a double-precision floating-point number, according to the IEEE 754 floating-point standard.
   * Can have values of Infinity, -Infinity, and NaN.
   * ex. `num double EF0123456789ABCD` ~> -5.0748e226