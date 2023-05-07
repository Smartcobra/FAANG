package stack;

public class StackLL<T> {
    private int size;
    private StackNode<T> head;

    public int size(){
        return size;
    }

    ///peek
    public T peek() throws StackEmptyException {
        if(size==0){
            throw  new StackEmptyException("stack is Empty");
        }

        return head.data;
    }

    //push
    public void push(T data) {
        StackNode<T> newNode= new StackNode<>(data);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public T pop() throws StackEmptyException{
        if(size==0){
            throw new StackEmptyException("Stack is empty");
        }
        T element = head.data;
        head=head.next;
        size--;

        return element;
    }
}
