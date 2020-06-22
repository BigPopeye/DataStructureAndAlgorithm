using System;
namespace Assignment6
{
    public class Solution{
    // use digit dictionary to map the character with value
    // check every char in the Roman, if current char bigger than previous char, result = result - previousValue + currentValue - previousValue,
    // otherwise, result += currentValue
    // T : O(n), n is the length of Roman
    // S : O(1)
        public static int Roman2Int(String s){
            int result = 0;
            int[] map = new int[26];
            map['I' - 'A'] = 1;
            map['V' - 'A'] = 5;
            map['X' - 'A'] = 10;
            map['L' - 'A'] = 50;
            map['C' - 'A'] = 100;
            map['D' - 'A'] = 500;
            map['M' - 'A'] = 1000;

            char[] roman = s.ToCharArray();

            int preChar = roman[0] - 'A';
            foreach (char ch in roman)
            {
                int currChar = ch - 'A';
                if(map[preChar] < map[currChar]){
                    result = result - 2*map[preChar] + map[currChar];
                }else{
                    result += map[currChar];
                }
                preChar = currChar;
            }
            return result;

        } 

        

        public  static void Main(string[] args){
            string s = "XVII"
            Console.WriteLine("{0}",Roman2Int(s));
        }
    }
}
