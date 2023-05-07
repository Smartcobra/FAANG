package STACK_USING_LinkedList;

public class StackUsingLL<T> {
    private int size;
    Node<T> head;

    public int size(){
        return size;
    }

    public T peek() throws StackEmptyExecption { //Top
        if(size==0){
            throw new StackEmptyExecption("empty");
        }
        return head.data;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void push(T element){
        Node<T> newNode= new Node<>(element);
        newNode.next=head;
        head=newNode;
        size++;

    }

    public T pop() throws StackEmptyExecption {
        if(size==0){
            throw new StackEmptyExecption("empty");
        }
        T data=head.data;
        head= head.next;
        size--;
        return data;

    }

    public static void main(String[] args) throws StackEmptyExecption {
        StackUsingLL<Integer> stack= new StackUsingLL<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println( "first peek::  "+stack.peek());
        System.out.println("1st pop  ::  "+stack.pop());
        System.out.println("1st size::" +stack.size());
        System.out.println( "first peek::  "+stack.peek());
        System.out.println("1st pop  ::  "+stack.pop());
        //stack.peek();
        System.out.println("lst size::" +stack.size());

    }
}
