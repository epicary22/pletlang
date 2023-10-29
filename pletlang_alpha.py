from pletlang_char import PletlangChar
from pletlang_char_helper import PletlangCharHelper
from typing import Union


class PletlangAlpha:
	"""
	Methods and values relating to translating Pletlang into or from human-readable text.
	"""
	VALUES = [']', 'd', 'm', 'n', 'v', 'w', 'z', 'j', 'a', 'i', 'o', 'u', ',', '\'', '\\', '[']
	
	@staticmethod
	def from_pletlang_char(pletlang_char: PletlangChar) -> str:
		"""
		
		:param pletlang_char:
		:return:
		"""
		return PletlangAlpha.VALUES[pletlang_char.value]
	
	@staticmethod
	def to_pletlang_char(alpha_char: str) -> Union[PletlangChar, None]:
		"""
		
		:param alpha_char:
		:return:
		"""
		if alpha_char in PletlangAlpha.VALUES:
			return PletlangCharHelper.VALUES[PletlangAlpha.VALUES.index(alpha_char)]
		return None
