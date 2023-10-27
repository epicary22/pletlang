from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
import pletlang_string


class PletlangString:
	def __init__(self, pletlang_chars: list[PletlangChar]) -> None:
		# TODO I'll need a helper to convert text and binary strings into Pletlang.
		# TODO This is only for creating the base class to branch out from in the future.
		# TODO also create a set of classes (PletlangInt, PletlangPhoneme, PletlangAlpha) for conversion methods.
		self.pletlang_chars = pletlang_chars
	
	def concat_pletlang_char(self, pletlang_char: PletlangChar) -> None:
		self.pletlang_chars.append(pletlang_char)
	
	def as_binary(self):
		pass
	
	def as_alpha(self):
		pass
	
	def as_phonemic(self):
		pass