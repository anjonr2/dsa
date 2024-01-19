package com.dsa.linkedList;
/*Converting an Array to LinkedList
* Time complexity is O(n) since it's traversing linearly*/
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
    public static void main(String []args){
        int arr[] = {2,5,6,8};
        Node node = new Node(arr[0]);
        System.out.println("Node data "+node.data);

        Node head = convertArr2LL(arr);
        System.out.println("After converting array to the linkedList "+head.data);
    }
}
