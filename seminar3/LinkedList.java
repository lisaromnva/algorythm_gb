public class LinkedList <T extends Comparable<T>> {
    private Node root;
    private int size;

    public void revert(){
        if (root != null && root.next != null){
            Node temp = root;
            revert(root.next, root);
            temp.next = null;
        }
    }
    private void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            root = currentNode;
        } else {
            revert( currentNode.next, currentNode );
        }
        currentNode.next = previousNode;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }

    public void print() {
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private class Node {
        T value;
        Node next;

        Node() {
        }

        Node(T _value) {
            this.value = _value;
        }

        Node(T _value, Node _next) {
            this.value = _value;
            this.next = _next;
        }
    }
}