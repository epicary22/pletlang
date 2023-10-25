from typing import Union
from pletlang_char import PletlangChar


class PletlangCharHelper:
    """
    Helper methods and values for the PletlangChar enum.\n
    Any operations for PletlangChars can be found here.
    """
    VALID_INTS = [char.value for char in PletlangChar]
    VALID_CHARS = [']', 'd', 'm', 'n', 'v', 'w', 'z', 'j', 'a', 'i', 'o', 'u', ',', '\'', '\\', '[']

    @staticmethod
    def to_pletlang_char(obj: Union[int, str, None] = None) -> Union[PletlangChar, None]:
        """
        Finds the Pletlang character representation of a given int, str, or None.\n
        ints between 0 and 15 are valid. ints < 0 are interpreted as 0. ints > 15 are interpreted as 15.\n
        strs only have their first character interpreted. Invalid first characters are interpreted as ' '.
        If the str is '', it is interpreted as ' '.\n
        None is interpreted as PletlangChar.END.\n
        :param obj: The object to be translated into a single PletlangChar.
        :return: The PletlangChar that the object passed in represents.
        """
        if type(obj) is str:
            return PletlangCharHelper.to_pletlang_char_from_char(obj)
        elif type(obj) is int:
            return PletlangCharHelper.to_pletlang_char_from_int(obj)
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
        if char_to_check not in PletlangCharHelper.VALID_CHARS:
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
        char = PletlangCharHelper.__to_interpretable_char(string)
        if char is None:
            return None
        return PletlangCharHelper.VALID_CHARS.index(char)

    @staticmethod
    def to_pletlang_char_from_char(char: str) -> Union[PletlangChar, None]:
        """
        Finds the PletlangChar representation of a singular character.\n
        If a multi-character str is provided, only the first character is interpreted.\n
        :param char: The character to be interpreted into Pletlang.
        :return: The PletlangChar representation of the single character.
        """
        pletlang_char_index = PletlangCharHelper.__to_interpretable_int(char)
        if pletlang_char_index is None:
            return None
        else:
            return PletlangCharHelper.to_pletlang_char_from_int(pletlang_char_index)

    @staticmethod
    def to_pletlang_char_from_int(pletlang_char_index: int) -> Union[PletlangChar, None]:
        """
        Finds the PletlangChar representation of a single int.\n
        ints provided between 0 and 15 will return proper PletlangChar values, and anything
        else will return None.\n
        :param pletlang_char_index: The int to be interpreted as a PletlangChar.
        :return: The PletlangChar interpretation, if one exists.
        """
        if pletlang_char_index in PletlangCharHelper.VALID_INTS:
            return [char for char in PletlangChar][pletlang_char_index]
        return None
