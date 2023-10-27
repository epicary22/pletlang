from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from typing import Union


class PletlangInt:
	"""
	Methods and values relating to translating Pletlang into or from integers.
	"""
	VALUES = [char.value for char in PletlangChar]
	
	@staticmethod
	def from_pletlang_char(pletlang_char: PletlangChar) -> int:
		"""
		Finds the int equivalent of a given PletlangChar.\n
		:param pletlang_char: The PletlangChar to be translated to an int.
		:return: The int equivalent of a given PletlangChar.
		"""
		return pletlang_char.value
	
	@staticmethod
	def to_pletlang_char(integer: int) -> Union[PletlangChar, None]:
		"""
		Finds the PletlangChar representation of the given integer.\n
		If the integer cannot be translated into a PletlangChar, None is returned.\n
		:param integer: The integer to translate into a PletlangChar.
		:return: The PletlangChar representation of the given integer.
		"""
		if integer in PletlangInt.VALUES:
			return PletlangCharHelper.VALUES[integer]
		return None
	