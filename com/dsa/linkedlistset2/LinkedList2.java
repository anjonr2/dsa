package com.dsa.linkedlistset2;

public class LinkedList2 {
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data = data;
        }
    }
    public static void print(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static Node convertarr2LL(int []arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static Node groupOddEven(Node head){
        if(head == null || head.next == null) return head;
        Node odd = head, even = head.next, evenHead = even;
        while (even !=null && even.next.next==null){
            odd.next = odd.next.next;
            even.next=even.next.next;
            odd = odd.next;
            even=even.next.next;
        }
        odd.next=evenHead;
        return head;
    }
    /*Sort a list of 0's,1's,2's*/
    public static Node sort(Node head){
        Node temp = head;
        /*initialized three variables to keep a count of 0's,1's and 2's present in the list*/
        int cnt0=0,cnt1=0,cnt2=0;
        /*After this traversal cnt0,1 and 2 will have the total count of 0's, 1's amd 2's present in the list*/
        while (temp != null){
            switch (temp.data){
                case 0 :{
                    cnt0++;
                    break;
                }
                case 1 :{
                    cnt1++;
                    break;
                }
                case 2 :{
                    cnt2++;
                    break;
                }
            }
            temp=temp.next;
        }
        temp = head;
        while (temp!=null){
            if(cnt0>0){
                temp.data=0;
                cnt0--;
            } else if (cnt1>0) {
                temp.data=1;
                cnt1--;
            }else {
                temp.data=2;
                cnt2--;
            }
            temp=temp.next;
        }
        return  head;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        int arr1[] = {1, 1, 0, 0, 2,1,2,0};
        Node head = convertarr2LL(arr);
        System.out.println("After converting array to list");
        print(head);
        head = groupOddEven(head);
        Node head1 = convertarr2LL(arr1);
        System.out.println("After grouping odd and even nodes together");
        print(head);

        Node head2 = sort(head1);
        System.out.println("After sorting the list of 0's, 1's & 2's");
        print(head2);
    }
}
