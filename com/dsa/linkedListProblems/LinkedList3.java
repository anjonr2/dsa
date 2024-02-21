package com.dsa.linkedListProblems;

public class LinkedList3 {
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void traverse(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static Node convertArr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static Node reverse(Node head){
        Node temp = head;
        Node back = null;
        while (temp!=null){
            Node front = temp.next;
            temp.next=back;
            back=temp;
            temp=front;
        }
        return back;
    }
    public static Node findMiddle(Node head){
        Node slow=head, fast = head;
        while (fast.next.next != null && fast.next != null){
            //moves one node at a time
            slow = slow.next;

            //moves two Node at a tine
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean checkPalindrome(Node head){
        Node middle = findMiddle(head);
        Node newHead = reverse(middle.next);
        Node first = head;
        Node second = newHead;
        while (second!=null){
            if(first.data!=second.data){
                reverse(newHead);
                return false;
            }
            /*Move first and second by one node*/
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    public static int addHelper(Node node){
        if(node == null){
            return 1;
        }
        int carry = addHelper(node.next);
        node.data=node.data+carry;
        if(node.data<10){
            return 0;
        }
        node.data=0;
        return 1;
    }
    public static Node addOne(Node head){
        int carry = addHelper(head);
        if(carry==1){
            Node node = new Node(1);
            node.next=head;
            head=node;
        }
        return head;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        int arr1[] = {9, 9, 9, 9, 9};
        Node head = convertArr2LL(arr);
        Node head2 = convertArr2LL(arr1);
        System.out.println("After converting array to LinkedList");
        traverse(head);

//        head = reverse(head);
//        System.out.println("After reversing the linkedList");
//        traverse(head);

//        Boolean palindrome = checkPalindrome(head);
//        System.out.println("Given linkedList is palindrome "+palindrome);

         Node newHead = addOne(head);
         head2 = addOne(head2);
         System.out.println("After adding 1 to the linkedList");
         traverse(newHead);
         traverse(head2);
    }
}
