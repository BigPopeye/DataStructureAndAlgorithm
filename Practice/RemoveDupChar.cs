using System;
namespace Assignment6
{
    public class Solution{
    //2. remove adjacent duplicate characters from string
        // eg : "azxxzy" => "ay"
        // eg : "caaabbbaacdddd" => ""
        // eg : "acaaabbbacdddd" => "acac"
        // T : O(n)
        // S : O(n) 
        public static string RemoveDupChar(string s){
            Stack stack = new Stack();
            // for the last duplicate, since we didn't check, it will left in the stack
            string temp = s + "!";
            for(int i = 0; i < temp.Length; i++){
                if(stack.Count != 0 && !stack.Peek().Equals(temp[i])){
                    char curr = (char)stack.Pop();
                    bool hasDup = false;
                    while(stack.Count!= 0 && curr.Equals(stack.Peek())){
                        hasDup = true;
                        stack.Pop();
                    }
                    // if no duplicate, push back
                    if(!hasDup){
                        stack.Push(curr);
                    }
                }
                if(i != s.Length) stack.Push(temp[i]);
            }

            StringBuilder sb = new StringBuilder();
            while(stack.Count!=0){
                sb.Insert(0,stack.Pop());
            }
            return sb.ToString();

        } 
        
        public static void Main(string[] args){
            String s = "caaabbbaacdddd";
            String noDup = RemoveDupChar(s);
            Console.WriteLine("{0}",noDup);
        }
    }
}
