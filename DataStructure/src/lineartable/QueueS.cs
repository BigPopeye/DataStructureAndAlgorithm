public class QueueS{
    private Stack _s1; // for enqueue
    private Stack _s2; // for dequeue
    public int Size{get{
        return _s1.Size;
    }}

    public Queue(){
        _s1 = new Stack();
        _s2 = new Stack();
    }

    public void Enqueue(Object obj){
        _s1.Push(obj);
    }

    public Object Dequeue(){
        if(Size == 0){
            Console.WriteLine("Queue is empty!");
            return null;
        }
        while(_s1.Peek() != null){
            _s2.Push(_s1.Pop())
        }
        Object obj = _s2.Pop();
        while(_s2.Peek() != null){
            _s1.Push(s2.Pop())
        }
        return obj;
    }

    public Object Peek(){
        if(Size == 0){
            Console.WriteLine("Queue is empty!");
            return null;
        }
        while(_s1.Peek() != null){
            _s2.Push(_s1.Pop())
        }
        Object obj = _s2.Peek();
        while(_s2.Peek() != null){
            _s1.Push(s2.Pop())
        }
        return obj;
    }
}