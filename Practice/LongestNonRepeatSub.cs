using System;
namespace Assignment6
{
    public class Solution{
    // slide window, when there occus duplicate char, remove the chars from beginning till the duplicate char
    // T : O(n)
    // S :O(n)
        public static int LongestNonRepeatSub(string s){
            if(s == null) return 0;
            Queue queue = new Queue();
            int len = 0;
            for(int i = 0; i< s.Length; i++){
                char currChar = s[i];
                if(queue.Count==0 || !queue.Contains(currChar)){
                    queue.Enqueue(currChar);
                    len = Math.Max(len, queue.Count);
                }else{
                    while(queue.Count>0 &&  !queue.Peek().Equals(currChar) ){
                        queue.Dequeue();
                    }
                    if(queue.Peek().Equals(currChar)){
                        queue.Dequeue();
                    }
                    queue.Enqueue(currChar);
                }
            }
            return len==0?s.Length:len;
        } 


        public  static void Main(string[] args){
            string s = "abcab";
            Console.WriteLine("{0}",LongestNonRepeatSub(s));
        }
    }
}