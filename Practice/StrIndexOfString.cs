using System;
namespace Assignment6
{
    public class Solution{
    // substring index of string
    // bru force
    // for 
    // MD5 method 1:
        public static string StrIndexOfString(string s, string t){
            if(t.Length == 0) return 0;
            string tMD5 = CreateMD5(t);
            for(int i = 0; i < s.Length; i++){
                if(i + t.Length > s.Length){
                    return -1;
                }
                if(s[i] == t[0]){
                    string sMD5 = CreateMD5(s.Substring(i,t.Length));
                    if(sMD5.Equals(tMD5)){
                        return i;
                    }
                }
            }
            return -1;
        } 

         public static string CreateMD5(string input){
            // Use input string to calculate MD5 hash
            using (System.Security.Cryptography.MD5 md5 = System.Security.Cryptography.MD5.Create())
            {
                byte[] inputBytes = System.Text.Encoding.ASCII.GetBytes(input);
                byte[] hashBytes = md5.ComputeHash(inputBytes);

                // Convert the byte array to hexadecimal string
                return System.Text.Encoding.UTF8.GetString(hashBytes);
                // StringBuilder sb = new StringBuilder();
                // for (int i = 0; i < hashBytes.Length; i++)
                // {
                //     sb.Append(hashBytes[i].ToString("X2"));
                // }
                // return sb.ToString();
            }
        }

        // MD5 method 2:
        public static string StrIndexOfString(string s, string t){
            if(t.Length == 0) return 0;
            using (System.Security.Cryptography.MD5 md5 = System.Security.Cryptography.MD5.Create()){
                byte[] tBytes = System.Text.Encoding.ASCII.GetBytes(t);
                byte[] tHash = md5.ComputeHash(tBytes);

                 for(int i = 0; i < s.Length; i++){
                    if(i + t.Length > s.Length){
                        return -1;
                    }
                    if(s[i] == t[0]){
                        string subs = s.Substring(i,t.Length);
                        byte[] sBytes = System.Text.Encoding.ASCII.GetBytes(subs);
                        byte[] sHash = md5.ComputeHash(sBytes);
                        if(Enumerable.SequenceEqual(tHash, sHash)){
                            return i;
                        }
                    }
                }
            }
           
            return -1;
        } 


        public  static void Main(string[] args){
            Console.WriteLine("{0}",isRotated(s1,s2));
        }
    }
}
