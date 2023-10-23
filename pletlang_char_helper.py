from pletlang_char import PletlangChar


class PletlangCharHelper:
	VALID_INTS = [char.value for char in PletlangChar]
    VALID_CHARS = [']', 'd', 'm', 'n', 'v', 'w', 'z', 'j', 'a', 'i', 'o', 'u', ',', '\'', '\\', '[']

    @staticmethod
    def to_pletlang_char(obj: int | str | None):
        """
        Finds the Pletlang character representation of a given int, str, or None.\n
        ints between 0 and 15 are valid. ints < 0 are interpreted as 0. ints > 15 are interpreted as 15.\n
        strs only have their first character interpreted. Invalid first characters are interpreted as ' '.
        If the str is '', it is interpreted as ' '.\n
        None is interpreted as PletlangChar.END.\n
        :param obj: The object to be translated into a single PletlangChar.
        :return: The PletlangChar that the object passed in represents.
        """
        if obj is str:
            return PletlangChar.from_char(obj)
        return PletlangChar.A

    @staticmethod
    def __to_interpretable_char(string: str) -> str | None:
        """
        Turns any str into a Pletlang-interpretable character.\n
		Returns None if the first character of string is ' ', or string is ''.\n
        :param string: Any str.
        :return: A character that can be interpreted into a PletlangChar.
        """
        if len(string) == 0:
            return None
        char_to_check = string[0]
        if char_to_check not in [VALID_CHARS]:
            return None
        return char_to_check

	@staticmethod
	def __to_interpretable_int(string: str) -> int | None:
		"""
		Turns any str into a Pletlang-interpretable int.\n
		Returns None if the first character of string is ' ', or string is ''.\n
		:param string: Any str.
		:return: An int that can be interpreted into a PletlangChar.
		"""
		char = PletlangCharHelper.__to_interpretable_char(string)
		if char is None:
			return None
		return VALID_CHARS.index(char)

    @staticmethod
    def to_pletlang_char_from_char(char: str) -> PletlangChar | None:
        """
        Finds the PletlangChar representation of a singular character.\n
        If a multi-character str is provided, only the first character is interpreted.\n
        :param char: The character to be interpreted into Pletlang.
        :return: The PletlangChar representation of the single character.
		"""
        char = PletlangCharHelper.__to_interpretable_char(char)
        if char == ' ':
            return None
        else:
            char_index = PletlangCharHelper.VALID_CHARS.index(char)
            # TODO aaaaaaa I need to change the data structure of PletlangChar

