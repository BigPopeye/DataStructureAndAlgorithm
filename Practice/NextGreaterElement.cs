/* // NextGreaterElement
// Example cases：

// 4 -> 5   
// 5 -> 25
// 2 -> 25
// 25 -> -1

// 13 -> -1
// 7 -> 12
// 6 -> 12
// 12 -> -1

// output is not about order, about value.
// unsorted, change sequence order => stack / heap(priority queue) / dictionary 
4 ,5 ,2 ,25 

s : 25
p : 5, 25, 25,

13 ,7 ,6 ,12 
// 1st try
s : 12,13 
p : 12,12,
while i < n;
if empty push curr
while stack != empty & i<n, if curr > peek(),  map.add(pop(),curr) // need to know index to get the value
push curr
move curr to next.


// 2nd try
while i < n;
if empty push i
while stack != empty & i<n, if arr[i] > arr[peek()],  out[pop()] = arr[i]
push i
i++

//while stack != empty 
//else out[pop()] = -1
init out[] = -1

i = 3
stack :3,0
out = [-1,12,12,-1]

// T/S complexity 
Time : O(n)
Space : O(n) */

// Code
public class solution{
    public int[] NextGreaterElement(int[] array){
        if(array == null or array.Length == 0){
            return array;
        }
        int len = array.Length;
        int[] out = new int[len]; // store out put value
        Stack stack = new Stack(); 

        // intilize out
        foreach (var item in out)
        {
            item = -1;
        }
        for(int i = 0; i < len; i++){
            if(stack.Count == 0){
                stack.Push(i);
            }else{
                while(stack.Count != 0 && i < len){
                    if(array[i] > array[stack.Peak()]){
                        out[stack.Pop()] = array[i];
                    }
                }
                stack.Push(i++);
            }
        }
        return out;
    }
    private print(int[] arr){
        foreach (var item in arr)
        {
            Consolo.WriteLine(item);   
        }
    }
    public static void Main(string[] args) 
    { 
        int[] arr = new int[] {11, 13, 21, 3}; 
        int[] out = NextGreaterElement(arr); 
        print(out);
    } 
}







