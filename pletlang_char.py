from enum import IntEnum
from typing import Union
from pletlang_int import PletlangInt
from pletlang_alpha import PletlangAlpha


class PletlangChar(IntEnum):
    """
    An enum representation of one of the 16 characters of Pletlang.
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
    BACKSLASH = 0b1110
    START = 0b1111
