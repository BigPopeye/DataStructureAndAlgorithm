public class solution{
    public void firstNonRepeatElem(string path ){
        // new arrFreq store non-repeat characters appear count
        // new queue store characters by show up order
        int[] arrFreq = new int[26];
        Queue queue = new Queue();
        int nRepeatChar = 0;
        using(StreamReader sr = new StreamReader(path)){
            while(sr.Peek() >= 0){
                int currChar = sr.Read();
                Console.WriteLine("Reading {0} from stream",System.Convert.ToChar(currChar));
                arrFreq[currChar - 'a']++;
                queue.Enqueue(currChar);
                nRepeatChar = queue.Peek();
                if(arrFreq[nRepeatChar-'a'] == 1){
                    Console.WriteLine("First non-repeating character is : {0}" , System.Convert.ToChar(nRepeatChar));
                }else if(nRepeatChar == currChar || arrFreq[nRepeatChar-'a'] > 1){
                    while(arrFreq[queue.Peek() - 'a'] > 1 && queue.Count > 0){
                        queue.Dequeue();
                    }
                    if(queue.Count == 0){
                        Console.WriteLine("-1");
                    }else{
                        nRepeatChar = queue.Peek();
                        Console.WriteLine("First non-repeating character is : {0}", System.Convert.ToChar(nRepeatChar));
                    }
                }
            }
        }
    }
}