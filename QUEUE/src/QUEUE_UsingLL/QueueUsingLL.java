package QUEUE_UsingLL;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T front() throws QueueIsEmptyException {
        if(size==0){
            throw new QueueIsEmptyException();
        }
        return front.data;
    }

    public void enqueue(T element){
        Node<T> newNode= new Node<>(element);
        if(size==0){
            front=newNode;
            rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }

    public T dequeue() throws QueueIsEmptyException {
        if(size==0){
            throw new QueueIsEmptyException();
        }
        T tmp=front.data;
        front=front.next;
        if(size==1){
            rear=null;
        }
        size--;
        return tmp;
    }
}
