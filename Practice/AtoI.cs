using System;
namespace Assignment6
{
    public class Solution{
    // convert string to integer
    // verify char -> int; 0 in the head; nagetive sign
    // T : O(L)
    // S : O(1)
        public static int AtoI(string s){
            String str = s.Trim();
            if(str.Length == 0){
                return 0;
            }
            int sign = 1;
            int index = 0;
            int number = 0
            // check if there is sign in the beginning
            if(str[0] == '+' || str[0] == '-'){
                if(str[0] == '-'){
                    sign = -1;
                }
                index++;
            }
            
            while(index < str.Length){
                int digit = str[index] - '0';
                // check if currChar is number
                if(digit < 0 || digit > 9){
                    break;
                }
                // check if the number value exceed the max value that may cause overflow
                if(number > Int32.MaxValue / 10 || (number == Int32.MaxValue / 10 && digit > Int32.MaxValue % 10)){
                    return sign == 1? Int32.MaxValue : Int32.MinValue;
                }
                number = number * 10 + digit;
                index ++;
            }
            return total * sign;
        } 


        public  static void Main(string[] args){
            string s = " 78 df"
            Console.WriteLine("{0}",AtoI(s));
        }
    }
}
