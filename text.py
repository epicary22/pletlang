from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from pletlang_string import PletlangString
from pletlang_int import PletlangInt

p = PletlangString(reversed(PletlangChar.ITEMS))
print(p.as_alpha())
