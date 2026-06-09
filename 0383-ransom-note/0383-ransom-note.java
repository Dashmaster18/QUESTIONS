class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (char c : ransomNote.toCharArray()) {
            String ch = String.valueOf(c);

            if (!magazine.contains(ch))
                return false;

            magazine = magazine.replaceFirst(ch, "");
        }
        return true;
    }
}