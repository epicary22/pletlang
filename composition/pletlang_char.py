from enum import IntEnum


class PletlangChar(IntEnum):
	"""
	Enum of all 16 possible Pletlang characters.\n
	Each enumerated character's value is its corresponding `nybble` value.
	(ex. M is represented with the `nybble` ``0010``, which means ``PletlangChar.M = 0b0010``.)
	"""
	END = 0b0000
	D = 0b0001
	M = 0b0010
	N = 0b0011
	V = 0b0100
	W = 0b0101
	Z = 0b0110
	J = 0b0111
	A = 0b1000
	I = 0b1001
	O = 0b1010
	U = 0b1011
	LO = 0b1100
	HI = 0b1101
	ESC = 0b1110
	START = 0b1111
	