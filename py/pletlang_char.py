from enum import Enum
from typing import Union


class PletlangChar(Enum):
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

    # ITEMS = [END, D, M, N, V, W, Z, J, A, I, O, U, LO, HI, BACKSLASH, START]
    # ALPHA_VALUES = [']', 'd', 'm', 'n', 'v', 'w', 'z', 'j', 'a', 'i', 'o', 'u', ',', '\'', '\\', '[']
    # INT_VALUES = [value.value for value in ITEMS]
    # TODO well this part didn't go over so smooth. Find a way to do this.

    @staticmethod
    def of(obj: Union[int, str, None] = None) -> Union["PletlangChar", None]:
        """
        Finds the PletlangChar representation of a given int, str, or None.\n
        ints between 0 and 15 are valid. ints < 0 are interpreted as 0. ints > 15 are interpreted as 15.\n
        strs only have their first character interpreted. Invalid first characters are interpreted as ' '.
        If the str is '', it is interpreted as ' '.\n
        None is interpreted as None.\n
        :param obj: The object to be translated into a single PletlangChar.
        :return: The PletlangChar that the object passed in represents.
        """
        if type(obj) is str:
            return PletlangChar.from_alpha(obj)
        elif type(obj) is int:
            return PletlangChar.from_int(obj)
        return None

    @staticmethod
    def __to_interpretable_char(string: str) -> Union[str, None]:
        """
        Turns any str into a Pletlang-interpretable character.\n
        Returns None if the first character of string is ' ', or string is ''.\n
        :param string: Any str.
        :return: A character that can be interpreted into a PletlangChar.
        """
        if len(string) == 0:
            return None
        char_to_check = string[0].lower()
        if char_to_check not in PletlangChar.ALPHA_VALUES:
            return None
        return char_to_check

    @staticmethod
    def __to_interpretable_int(string: str) -> Union[int, None]:
        """
        Turns any str into a Pletlang-interpretable int.\n
        Returns None if the first character of string is ' ', or string is ''.\n
        :param string: Any str.
        :return: An int that can be interpreted into a PletlangChar.
        """
        char = PletlangChar.__to_interpretable_char(string)
        if char is None:
            return None
        return PletlangChar.ALPHA_VALUES.index(char)

    @staticmethod
    def from_alpha(char: str) -> Union["PletlangChar", None]:
        """
        Finds the PletlangChar representation of a singular character.\n
        If a multi-character str is provided, only the first character is interpreted.\n
        :param char: The character to be interpreted into Pletlang.
        :return: The PletlangChar representation of the single character.
        """
        pletlang_char_index = PletlangChar.__to_interpretable_int(char)
        if pletlang_char_index is None:
            return None
        else:
            return PletlangChar.from_int(pletlang_char_index)

    @staticmethod
    def from_int(pletlang_char_index: int) -> Union["PletlangChar", None]:
        """
        Finds the PletlangChar representation of a single int.\n
        ints provided between 0 and 15 will return proper PletlangChar values, and anything
        else will return None.\n
        :param pletlang_char_index: The int to be interpreted as a PletlangChar.
        :return: The PletlangChar interpretation, if one exists.
        """
        if pletlang_char_index in PletlangChar.INT_VALUES:
            return [char for char in PletlangChar][pletlang_char_index]
        return None

