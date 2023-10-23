from enum import Enum


class PletlangChar(Enum):
    """
    All of the 16 possible Pletlang characters, in enum form.
    """
    END = {"int": 0b0000, "str": "]"}
    D = {"int": 0b0001, "str": "d"}
    M = {"int": 0b0010, "str": "m"}
    N = {"int": 0b0011, "str": "n"}
    V = {"int": 0b0100, "str": "v"}
    W = {"int": 0b0101, "str": "w"}
    Z = {"int": 0b0110, "str": "z"}
    J = {"int": 0b0111, "str": "j"}
    A = {"int": 0b1000, "str": "a"}
    I = {"int": 0b1001, "str": "i"}
    O = {"int": 0b1010, "str": "o"}
    U = {"int": 0b1011, "str": "u"}
    LO = {"int": 0b1100, "str": ","}
    HI = {"int": 0b1101, "str": "'"}
    BACKSLASH = {"int": 0b1110, "str": "\\"}
    START = {"int": 0b1111, "str": "["}
    # TODO change up this data structure? It seems a little backwards...
