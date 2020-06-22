using System;
namespace Assignment6
{
    public class Solution{
    // shorten the url string into fixed length string
    // 1. generate ramdom char set based on [a-z],[0-9],[A-Z], and store them into dictionary[,cache,Database]
    // mapU2S : URL -> shortURL, 
    // mapS2U : shortURL -> URL
    // 2. check duplicate
    // 
    // improve : use LRU cache to retrieve most often used URL 
        private static Dictionary<string, string> mapU2S = new Dictionary<string, string>();
        private static Dictionary<string, string> mapS2U = new Dictionary<string, string>();
        private static String CharSetDefault = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        private static int URL_LENGTH = 6;

        private static Random rdm = new Random();
        public static string URLShorter(string s){
            
            // if contains URL, return shortURL
            if(mapU2S.ContainsKey(s)){
                return mapU2S[s]; 
            }
            string shortURL = generateRandURL();
            // update shortURL if it's duplicate
            while(mapS2U.ContainsKey(shortURL)){
                shortURL = generateRandURL();
            }
            mapU2S.Add(s, shortURL);
            mapS2U.Add(shortURL, s);
            return shortURL;
        } 
        public static string RetrieveURL(string shortURL){
            if(mapS2U.ContainsKey(shortURL)){
                return mapS2U[shortURL];
            }else{
                return "404 Not found";
            }
        }

        private static string generateRandURL(){
            char[] output = new char[URL_LENGTH];
            for(int i = 0; i < URL_LENGTH; i++){
                output[i] = CharSetDefault[rdm.Next(CharSetDefault.Length)];
            }
            return new string(output);
        }

        public  static void Main(string[] args){
            string url1 = "www.google.com";
            string shortURL1 = URLShorter(url1);
            string url2 = "www.amazon.com";
            string shortURL2 = URLShorter(url2);
            Console.WriteLine("Short URL : kal.bc/{0}", shortURL2);
            Console.WriteLine("Retrieve origin URL : {0}", RetrieveURL(shortURL2));

        }
    }
}