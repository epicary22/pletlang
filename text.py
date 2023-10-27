from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from pletlang_string import PletlangString

print(PletlangCharHelper.to_pletlang_char("z").name)

p = PletlangString([PletlangChar.START, PletlangChar.A, PletlangChar.I])
p.concat_pletlang_char(PletlangChar.END)
print(p.pletlang_chars)
