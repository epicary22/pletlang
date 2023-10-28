from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from pletlang_string import PletlangString
from pletlang_int import PletlangInt

p = PletlangString([PletlangChar.START, PletlangChar.A, PletlangChar.I, PletlangChar.HI, PletlangChar.W, PletlangChar.O, PletlangChar.M, PletlangChar.END])
print(p.as_literal_binary_string())
