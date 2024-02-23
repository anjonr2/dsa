package com.dsa.linkedListProblems;

import java.util.HashMap;
import java.util.Map;

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
    public static Node findIntersection(Node head1, Node head2){
        Map<Node,Integer> map = new HashMap<Node,Integer>();
        Node temp = head1;
        while (temp != null){
            map.put(temp,1);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public static Node findIntersection2(Node head1, Node head2){
        Node temp1 = head1, temp2=head2;
        int n1=0,n2=0;
        while (temp1!=null){
            n1++;
            temp1=temp1.next;
        }
        while (temp2!=null){
            n2++;
            temp2=temp2.next;
        }
        if(n1<n2){
            return intersection(head1,head2,n2-n1);
        }else {
            return intersection(head2,head1,n1-n2);
        }
    }
    public static Node intersection(Node head1, Node head2, int d){
        while (d>0){
            d--;
            head2=head2.next;
        }
        while (head1 != head2){
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }
    public static Node findIntersection3(Node head1, Node head2){
        if(head1==null || head2==null) return null;
        Node temp1= head1, temp2=head2;
        while (temp1 != temp2){
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1==temp2) return temp1;
            if(temp1 == null) temp1=head2;
            if(temp2 == null) temp2=head1;
        }
        return temp1;
    }
    public static boolean detectLoop(Node head){
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while (temp!=null){
            if(map.containsKey(temp)) return true;
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }
    /*Approach 2: to detect a loop using tortoise & hare*/
    public static boolean detectLoop1(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!= null&&fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static int lengthOfTheLoop(Node head){
        Map<Node,Integer> map = new HashMap<>();
        Node temp = head;
        int cnt=1;
        int length=0;
        while (temp!=null){
            if(map.containsKey(temp)) {
                length = cnt - map.get(temp);
            }
            map.put(temp,cnt);
            cnt++;
            temp=temp.next;
        }
        return 0;
    }
    public static int lengthOfTheLoop1(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                return findLength(slow,fast);
            }
        }
        return 0;
    }
    public static int findLength(Node slow, Node fast){
        int length=1;
        while (slow!=fast){
            length++;
            fast=fast.next;
        }
        return length;
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
