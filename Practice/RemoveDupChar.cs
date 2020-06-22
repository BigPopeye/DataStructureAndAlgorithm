using System;
namespace Assignment6
{
    public class Solution{
    // 1. using stack
    // T : O(n)
    // S : O(n) 
        public static String RemoveDupChar(String s){
            Stack stack = new Stack();
            for(int i = 0; i < s.Length; i++){
                if(stack.Count != 0 && stack.Peek() != s[i]){
                    Char curr = stack.Pop();
                    bool hasDup = false;
                    while(stack.Count!= 0 && curr == stack.Peek()){
                        hasDup = true;
                        stack.Pop();
                    }
                    // if no duplicate, push back
                    if(!hasDup){
                        stack.Push(curr);
                    }
                }
                stack.Push(s[i]);
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
