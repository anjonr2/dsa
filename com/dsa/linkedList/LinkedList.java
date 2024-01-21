package com.dsa.linkedList;
/*Converting an Array to LinkedList
* Time complexity is O(n) since it's traversing linearly
* Time complexity for calculating the length of the linkedList is also O(n)*/
public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node convertArr2LL(int []arr){
        /*Since head is always the first node*/
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    static void traverse(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
    static int lengthOfLinkedList(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
            count++;
        }
        return count;
    }
    /*Given an integer value
    * check if that is present in any node
    * If present return true*/
    static boolean checkIfPresent(Node head, int value){
        Node temp = head;
        while (temp != null){
            if(temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }
    /*Delete the head of the linkedList*/
    static Node removeHead(Node head){
        if(head == null) return head;
        Node temp = head;
        head = temp.next;
        return head;
    }
    static Node deleteTailNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    static Node deleteKthNode(Node head, int k){
        if(head == null) return head;
        if(k==1){
            head = head.next;
            return head;
        }
        Node temp = head;
        int counter = 0;
        Node prev = null;
        while (temp != null){
            counter++;
            if(counter == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    static Node removeElement(Node head, int value){
        if(head == null) return head;
        if(head.data == value){
            head = head.next;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null){
            if(temp.data == value){
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String []args){
        int arr[] = {2,5,6,8};
        Node node = new Node(arr[0]);
        System.out.println("Node data "+node.data);

        Node head = convertArr2LL(arr);
        System.out.println("After converting array to the linkedList "+head.data);

        System.out.println("Traversing the list");
        traverse(head);

        int length = lengthOfLinkedList(head);
        System.out.println("length of the linkedList "+length);

        boolean present = checkIfPresent(head,16);
        System.out.println("Data present in the list "+present);

        Node newHead = removeHead(head);
        System.out.println("LinkedList after deleting the head");
        traverse(newHead);

        newHead = deleteTailNode(head);
        System.out.print("After deleting the tail");
        traverse(newHead);

        Node remove = deleteKthNode(head,3);
        System.out.println("LinkedList after deleting the node");
        traverse(remove);

        Node removeElement = removeElement(head,5);
        System.out.println("LinkedList after deleteting "+5);
        traverse(removeElement);
    }
}
