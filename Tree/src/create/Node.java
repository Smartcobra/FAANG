package create;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node() {
    }

    public Node(T data){
        this.data=data;
        right=null;
        left=null;
    }

}
