import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstringSolution {
    class Solution {

        public String getPalindromeLength(String str, int start, int end) {
            while (start >=0 && end < str.length() && (str.charAt(start) == str.charAt(end))) {
                --start;
                ++end;
            }

            return str.substring(start+1, end);
        }

        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }

            String result = "";

            for (int i = 0; i < s.length(); i++) {
                String str1 = this.getPalindromeLength(s, i, i);
                String str2 = this.getPalindromeLength(s, i, i+1);
                String cmpStr = str1.length() > str2.length() ? str1 : str2;

                result = result.length() > cmpStr.length() ? result : cmpStr;
            }

            return result;
        }
    }
}
