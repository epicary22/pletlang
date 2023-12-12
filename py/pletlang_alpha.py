from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from typing import Union


class PletlangAlpha:
	"""
	Methods and values relating to translating Pletlang into or from human-readable text.
	"""
	VALUES = [']', 'd', 'm', 'n', 'v', 'w', 'z', 'j', 'a', 'i', 'o', 'u', ',', '\'', '\\', '[']
	
	@staticmethod
	def from_pletlang_char(pletlang_char: Union[PletlangChar | None]) -> str:
		"""
		Finds the char representation of a given PletlangChar.
		Returns " " if None is passed in.
		:param pletlang_char: The given PletlangChar.
		:return: The char representation.
		"""
		if pletlang_char is None:
			return " "
		return PletlangAlpha.VALUES[pletlang_char.value]
	
	@staticmethod
	def to_pletlang_char(alpha_char: str) -> Union[PletlangChar, None]:
		"""
		Finds the PletlangChar representation of a given char.
		Uses only the first char of the given string.
		Returns None if the given char is not in PletlangAlpha.VALUES (such as " ").
		:param alpha_char: The given char.
		:return: The PletlangChar representation.
		"""
		if len(alpha_char) == 0:
			return None
		if alpha_char[0] in PletlangAlpha.VALUES:
			return PletlangCharHelper.VALUES[PletlangAlpha.VALUES.index(alpha_char)]
		return None
