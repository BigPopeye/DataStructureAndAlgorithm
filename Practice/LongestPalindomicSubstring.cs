using System;
namespace Assignment6
{
    public class Solution{
    // 1. for string index i,j, 2 for loop to check substring in [i,j] is palidomic
    // T : n2 * n check,O(n3)
    // waste time : 
    // if s[i,j] is palindrome, then s[i+1, j-1] also true, no need to caculate again
    // same with if s[i,j] isn't palindrome, then s[i+1, j-1] also false, no need to caculate again
    // so start from mid, not outside.
    // 2. T : n * n check, O(n2)
    // S : O(1)
        public String LongestPalindomicSubstring(String s){
            if(s == "" || s.Length <= 1){
                return s;
            }
            int maxLen = 1;
            // when find the maxLen of substring, relocate the startIndex of the substring to get substring of s
            int startIndex = 0;
            for(int i = 0; i < s.Length; i++){
                int len1 = maxPalindomicLenth(s,i,i);
                int len2 = maxPalindomicLenth(s,i,i+1);
                int len = Math.Max(len1,len2);
                if(len > maxLen){
                    maxLen = len;
                    startIndex = i - (len-1)/2 ;
                }
            }
            return s.Substring(startIndex, maxLen);
        } 

        private int maxPalindomicLenth(String s, int left, int right){
            while(left >= 0 && right < s.Length && s[left] == s[right]{
                left--;
                right++;
            }
            //palidomic string length =  (r - l + 1)
            // length = (++r) - (--l) -2 + 1 = right - left -1
            return right - left -1;
        }

        public  static void Main(string[] args){
            String s = "babad";
            Console.WriteLine("Substring of s is: {0}", LongestPalindomicSubstring(s));
        }
    }
}
