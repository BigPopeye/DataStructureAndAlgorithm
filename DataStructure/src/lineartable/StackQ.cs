public class Stack{
    // implement Stack using 2 Queues
    // q1 : dequeue from q1
    // q2 : enqueue to q2
    // after enqueue to q2, dequeue every items in q1 to q2, then switch q1 and q2
    private Queue q1;
    private Queue q2;

    public int Size{get;set;}

    public Stack(){
        q1 = new Queue();
        q2 = new Queue();
        Size = 0;
    }

    public void push(Object obj){
        Size ++;
        q2.Enqueue(obj);
        while(q1.Count > 0){
            q2.Enqueue(q1.Dequeue());
        }
        Queue q = q1;
        q1 = q2;
        q2 = q;
    }
    public Object pop(){
        if(q1.Count == 0){
            return null
        }
        Size --;
        return q1.Dequeue;
    }

}