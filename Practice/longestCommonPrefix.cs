using System;
namespace Assignment6
{
    public class Solution{
    // compare common prefix with each string in the array, update common prefix
    // T : n * average(L)
    // S : O(L)
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0){
                return "";
            }
            String com = strs[0];
            for(int i = 1; i< strs.length; i++){
                com = longestCommonPrefix(com,strs[i]);
                if(com.Length == 0){
                    return com;
                }
            }
            return com;
        }
    
        private String longestCommonPrefix(String str1, String str2){
            StringBuilder sb = new StringBuilder();
            for(int i = 0, j = 0; i < str1.Length & j < str2.Length ; i++,j++){
                if(str1[i] == str2[j]){
                    sb.append(str1[i]);
                }else{
                    break;
                }
            }
            return sb.toString();
        } 


        public  static void Main(string[] args){
            string[] strs = ["flower","flow","flight"]
            Console.WriteLine("{0}",longestCommonPrefix(strs));
        }
    }
}