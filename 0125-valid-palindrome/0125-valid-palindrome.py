class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        str = ""

        for i in s:
            if i.isalnum():
                str+=i
        
        # return str == str[::-1]
        l = 0
        r = len(str)-1

        while l<r:
            if str[l]!=str[r]:
                return False
            l+=1
            r-=1
        return True