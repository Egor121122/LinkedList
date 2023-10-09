package org.example;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLust("lust");
        linkedList.addLust("ff");
        linkedList.addLust("gg");
        System.out.println(linkedList);
        linkedList.addFirst("first");
        System.out.println(linkedList);
        System.out.println("index \"ff\" =  " + linkedList.get("ff"));
        System.out.println("index \"fff\" =  " + linkedList.get("fff"));
        linkedList.remove("first");
        System.out.println(linkedList);
    }
}

class LinkedList<T>{
    private Node<T> head;

    public void addFirst(T t){
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

    public void addLust(T t){
        if(head == null){
            head = new Node<>(t);
            return;
        }

        Node<T> thisNode = head;
        while (thisNode.next != null){
            thisNode = thisNode.next;
        }

        thisNode.next = new Node<>(t);
    }

    public int get(T t){
        if(head == null){return -1;}
        if(head.data == t){return 0;}

        Node<T> thisNode = head;
        int result = 0;

        while (thisNode.next != null){
            ++result;
            if(thisNode.next.data == t){
                return result;
            }
            thisNode = thisNode.next;
        }
        return -1;
    }

    public void remove(T t){
        if (head == null)
            return;
        if(head.data == t){
            head = head.next;
            return;
        }
        Node<T> thisNode = head;
        while (thisNode.next != null){
            if(thisNode.next.data == t){
                thisNode.next = thisNode.next.next;
                return;
            }
            thisNode = thisNode.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    public static class Node<T>{
        private T data;
        private Node <T> next;

        public Node(T data){
            this.data = data;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}