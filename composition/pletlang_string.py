from pletlang_char import PletlangChar
from typing import Union


class PletlangString:
	"""
	TODO
	Provides a basic interface for interacting with lists of PletlangChars.\n
	"""
	def __init__(self, chars: list[PletlangChar]) -> None:
		"""
		Initializes the PletlangString with a list of PletlangChars.\n
		The list of PletlangChars is copied as to not edit the original from inside this object.
		:param chars: The list of PletlangChars that the PletlangString will represent.
		"""
		self.chars: list[PletlangChar] = chars.copy()  # not a deepcopy because references to enum vals doesn't matter
		# TODO check for START and END?
	
	def raw_concat(self, other: "PletlangString") -> None:
		"""
		Concatenates another PletlangString to the end of this PletlangString.\n
		Does so crudely, as it conjoins both of the PletlangStrings exactly as they are.
		:param other: Another PletlangString to concatenate.
		"""
		self.chars.extend(other.chars)
		