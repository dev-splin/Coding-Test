import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    class Solution {
        private String str = "";
        private int length = 0;

        class StartPoint {
            public int start;
            public int end;

            public StartPoint(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public boolean findStartPoints(int index) {
            return str.charAt(index) == str.charAt(index + 1);
        }

        public String findPalindromic(int start, int end) {

            while(start >= 0 && end < length) {
                if (str.charAt(start) == str.charAt(end)) {
                    --start;
                    ++end;
                } else {
                    break;
                }
            }

            return str.substring(start+1, end);
        }

        public String longestPalindrome(String s) {
            this.str = s;
            this.length = s.length();

            if (this.length == 1) {
                return this.str;
            }

            String result = "";
            List<StartPoint> list = new ArrayList<>();

            for (int i = 0; i < length - 1 ; i++) {
                String palindromic = this.findPalindromic(i, i);
                result = palindromic.length() > result.length() ? palindromic : result;

                if (findStartPoints(i)) {
                    list.add(new StartPoint(i, i+1));
                }
            }


            for (StartPoint startPoint : list) {
                String palindromic = this.findPalindromic(startPoint.start, startPoint.end);

                result = palindromic.length() > result.length() ? palindromic : result;
            }

            return result;
        }
    }
}
