from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from pletlang_int import PletlangInt
from pletlang_alpha import PletlangAlpha


class PletlangString:
	def __init__(self, pletlang_chars: list[PletlangChar]) -> None:
		# TODO I'll need a helper to convert text and binary strings into Pletlang.
		# TODO This is only for creating the base class to branch out from in the future.
		# TODO also create a set of classes (PletlangInt, PletlangPhoneme, PletlangAlpha) for conversion methods.
		self.pletlang_chars = pletlang_chars
	
	def concat_pletlang_char(self, pletlang_char: PletlangChar) -> None:
		self.pletlang_chars.append(pletlang_char)
	
	def as_literal_binary_string(self) -> str:
		"""
		The literal binary string representation of this PletlangString.
		For example, [PletlangChar.START, PletlangChar.I, PletlangChar.END] -> 1111 1001 0000.
		:return: The binary string representation of this PletlangString.
		"""
		return " ".join([PletlangInt.to_string(pletlang_char) for pletlang_char in self.pletlang_chars])
	
	def as_alpha(self):
		return "".join([PletlangAlpha.from_pletlang_char(pletlang_char) for pletlang_char in self.pletlang_chars])
	
	def as_phonemic(self):
		pass