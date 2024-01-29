package com.dsa.linkedListProblems;

public class ReverseDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data,Node next, Node prev){
            this.data = data;
            this.next=next;
            this.prev=prev;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    static Node reverseDLL(Node head){
        if(head == null || head.next == null) return head;
        Node current = head, prevNode=null;
        while (current !=null){
            prevNode = current.prev;
            current.prev=current.next;
            current.next = prevNode;
        }
        return prevNode.prev;
    }
    static void print(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    static Node convertArr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i],null,temp);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    /*problem statement & explaination : https://www.youtube.com/watch?v=XmRrGzR6udg&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=7
    * firstdigit and last digit of a number : https://www.geeksforgeeks.org/find-first-last-digits-number/
    using above technique new node data and carry is calculated
    * data = sum % 10
    * carry = sum/10*/
    static Node add2List(Node head1, Node head2){
        Node temp1 = head1,temp2=head2;
        Node dummy = new Node(-1), curr = dummy;
        int carry =0;
        while (temp1 != null || temp2 != null || carry==1){
            int sum = 0;
            if(temp1!=null){
                sum=sum + temp1.data;
                temp1=temp1.next;
            }
            if(temp2!=null) {
                sum=sum + temp2.data;
                temp2=temp2.next;
            }
            sum +=carry;
            Node node = new Node(sum%10);
            carry = sum/10;
            curr.next=node;
            curr=node;
        }
        return dummy.next;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        int arr1[] = {1, 3, 7, 9, 0};
        int arr2[] = {2, 5, 6, 8, 4};
        Node head = convertArr2LL(arr);
        Node head1 = convertArr2LL(arr1);
        Node head2 = convertArr2LL(arr2);
        print(head);
        Node reversedHead = reverseDLL(head);
        System.out.println("LinkedList after reversal");
        print(reversedHead);

        Node head3 = add2List(head1,head2);
        print(head3);

    }
}
