public class MinStack
{
    // O(1) time & O(1) spaceto get mininum value => use variable to store min
    // bigger oldMin -> smaller newMin, lost oldMin value, but newMin can be stored in minValue,
    // need to use stack to keep track of oldMin
    // 2 * small - big < small, store (2 * small - big) into stack
    // number in Stack
    public Stack stack;
    public int minValue;

    public MinStack()
    {
        stack = new Stack();
        minValue = Int32.MaxValue;
    }

    public int getMin()
    {
        if (stack.Count == 0){
            Console.WriteLine("Stack is empty");
            return -1;
        }else{
            return minValue;
        }
            
    }
    
    public void Push(int num){
        if (stack.Count == 0){
            minValue = num;
            stack.Push(num);
            return;
        }
        // update minValue, and store oldMin to the stack using math
        if (num < minValue){
            stack.Push(2 * num - minValue);
            minValue = num;
        }else{
            stack.Push(num);
        }        
    }

    public int Pop(){
        if (stack.Count == 0){
            Console.WriteLine("Stack is empty");
            return;
        }
        int temp = (int)stack.Pop();

        // 
        if (temp < minValue){
            int popMin = minValue;
            minValue = 2 * minValue - temp;
            return popMin;
        }else{
            return temp;
        }
            
    }

    public int Peek()
    {
        if (stack.Count == 0){
            Console.WriteLine("Stack is empty ");
            return;
        }
        int temp = (int)stack.Peek(); 

        if (temp < minValue){
            return minValue;
        }else{
            return temp;
        }
    }
}