using System;
namespace Assignment6
{
    public class Solution{
    // recursion : stack overflow when s Length grow
         public static int longestCommonSub(string s1, string s2){
            int m = s1.Length;
            int n = s2.Length;
            int maxLen = 0;
            maxLen = helper(s1, s2, m, n, 0);
            return maxLen;
        } 
        private static int helper(string s1, string s2, int i, int j, int max){
             if (i == 0 || j == 0){ 
                return max; 
            } 
            if (s1[i - 1] == s2[j - 1]){ 
                max = helper(s1, s2, i - 1, j - 1, max + 1); 
            } 
            return Math.Max(max, Math.Max(helper(s1, s2, i, j - 1, 0),  helper(s1, s2, i - 1, j, 0))); 
        }

    // DP table way:
    // if s1[i-1] = s1[j-1]
    // dp[i][j] = dp[i-1][j-1] + 1
    // T: m * n
    // S : m * n
        public static int longestCommonSub(string s1, string s2){
            int m = s1.Length;
            int n = s2.Length;
            int maxLen = 0;
            int[,] dp = new int[m+1, n+1];
            for(int i = 0; i<= m; i++){
                for(int j = 0; j <= n; j++){
                    if(i == 0 || j == 0){
                        dp[i,j] = 0;
                    }else if(s1[i-1] == s2[j-1]){
                        dp[i,j] = dp[i-1,j-1] +1;
                        maxLen = Math.Max(result, dp[i,j]);
                    }else{
                        dp[i,j] = 0;
                    }
                }
            }
            return maxLen;
        } 

        public  static void Main(string[] args){
            string s1 = "abcdxyz";
            string s2 = "xyzabcd";
            Console.WriteLine("{0}",longestCommonSub(s1,s2));
        }
    }
}
