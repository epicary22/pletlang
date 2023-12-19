from pletlang_char import PletlangChar

class PletlangEscapeCode:
	dictionary = {
		PletlangChar.A: {
			PletlangChar.END: "color off",
			PletlangChar.D: "color hex nnnnnn",
			PletlangChar.M: "color ansi16 n",
			PletlangChar.N: "color ansi256 nn",
			PletlangChar.BACKSLASH: "color default",
			PletlangChar.START: "color on"
		}
		# ahhhhhh this is hard to do
	}