package com.dsa.linkedListProblems;

import java.util.HashMap;
import java.util.Map;

public class LinkedList4 {
    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node convertArr2LL(int arr[]){
        Node head=new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static void print(Node head){
        while (head!=null){
            System.out.print(" "+head.data+" ");
            head=head.next;
        }
    }
    public static int length(Node node){
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    public static Node deleteMiddle(Node head){
        if(head==null && head.next==null){
            return null;
        }
        Node temp = head;
        int length = length(temp);
        int res = length/2;
        temp=head;
        while (temp!=null){
            res--;
            if(res==0){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static Node deleteMiddleNode(Node head){
        Node slow=head;
        Node fast=head;
        fast=fast.next.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public static Node startingNodeOfALoop(Node head){
        Map<Node,Integer> map = new HashMap<>();
        Node temp=head;
        while (temp!=null){
            if(map.containsKey(temp)) return temp;
            map.put(temp,1);
            temp=temp.next;
        }
        return null;
    }
    public static Node startingNodeOfLoop(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        Node head = convertArr2LL(arr);
        head=deleteMiddleNode(head);
        System.out.println("After deleting middle node");
        print(head);

        head=deleteMiddleNode(head);
        System.out.println("After deleting middle node of even length list");
        print(head);
    }
}
