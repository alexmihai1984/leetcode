package rocks.alexmihai.medium.longestpalindrome;

public class Solution {
    public String longestPalindrome(String s) {
        int maxL = 0, maxR = 0;

//        int r;
//        for (int l = 0; l < s.length() - 1; l++) {
//            r = l;
//
//            var isPalindrome = false;
//            do {
//                r++;
//                System.out.println("-----");
//                System.out.println("l=" + l);
//                System.out.println("r=" + r);
//                if (r >= s.length()) break;
//
//                isPalindrome = isPalindrome(s.substring(l, r));
//            } while (isPalindrome);
//
////            if (r < s.length()) {
////                System.out.println("r--, r=" + r);
////                r--;
////            }
//
//            if (isPalindrome && (r - l > maxR - maxL)) {
//                maxL = l;
//                maxR = r;
//                System.out.println("maxL=" + maxL);
//                System.out.println("maxR=" + maxR);
//            }
//        }

        for (int i = 0; i < s.length() - 1; i++) {
            int r, l;
            if (i > 0 && s.charAt(i + 1) == s.charAt(i - 1)) {
                l = i - 1;
                r = i + 1;
            } else if (s.charAt(i + 1) == s.charAt(i)) {
                l = i;
                r = i + 1;
            } else {
                continue;
            }

            while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--; r++;
            }

            if (r - l > maxR - maxL) {
                maxR = r;
                maxL = l;
            }
        }

        return s.substring(maxL, maxR + 1);
    }

    private boolean isPalindrome(String s) {
        System.out.println("Testing: " + s);
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println("false");
                return false;
            }

            i++;
            j--;
        }

        System.out.println("true");
        return true;
    }
}
