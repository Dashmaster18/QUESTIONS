class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        str = ""

        for i in s:
            if i.isalnum():
                str+=i
        
        return str == str[::-1]