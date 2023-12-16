# The `color` function
PletASM: `color <mode> <nybbles>`  
Pletlang: `1110 1000 <nybble> <nybbles>`  
Plaintext: `\a<nybble><nybbles>`

## Sets the color of speech globally.

`color`, at a high level, takes these two arguments:
 * a color type, such as hex or 256-color
 * an integer value that matches the color type.

From this, 

For instance:  
`1110 1000 0001 1111 1111 1111 1111 0000 0000` corresponds to  
`color.... hex. f... f... f... f... 0... 0...`, which is the command  
`color hex ffff00`. This sets the color of speech to a bright yellow.

All usable color modes are:
 * `off`
    * Corresponds to the mode argument being `0000`
    * Turns color off. 

 * `hex <nnnnnn>`
    * Corresponds to the mode argument being `0001`.
    * The six nybbles are interpreted as a `#xxxxxx` color.
    * ex. `color hex ff0080` corresponds to the color `#ff0080`. (`\e[38;2;256;0;128m`)
    
 * `ansi16 <n>`
    * Corresponds to the mode argument being `0010`.
    * The one nybble is interpreted as an ANSI-16-color-standard color.
    * ex. `color ansi16 6` refers to terminal-standard dimmed cyan. (`\e[1;36m`)
   
 * `ansi256 <nn>`
    * Corresponds to the mode argument being `0011`.
    * The two nybbles are interpreted as an ANSI 256-color color.
    * ex. `color ansi256 9a` refers to a vibrant greenish yellow. (`\e[38;5;154m`)

 * `default`
    * Corresponds to the mode argument being `1110`.
    * Sets the color of speech back to the default.

 * `on`
    * Corresponds to the mode argument being `1111`
    * Turns color on.