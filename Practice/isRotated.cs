using System;
namespace Assignment6
{
    public class Solution{
    // rotate by 2 places, mean either first 2 chars go to the end(backword), or the last 2 chars go to the start(forward)
    // just check 2 cases to see if it equals to S1
    // T : O(1)
    // S : O(L), L is the length of the string. 
        public static bool isRotated(string s1, string s2){
            if(s2 == null || s1 == null || s2.Length != s1.Length){
                    return false;
            }
            string rotateForward = "" + s2.Substring(len-2, 2) + s2.Substring(0, len-2);
            string rotateBackward = "" + s2.Substring(2) + s2.Substring(0,2);

            return (s1.Equals(rotateForward) || s1.Equals(rotateBackward));
        } 

        

        public  static void Main(string[] args){
            string s1 = "amazon";
            string s2 = "azonam";
            Consolo.WriteLine("{0}",isRotated(s1,s2));
        }
    }
}
