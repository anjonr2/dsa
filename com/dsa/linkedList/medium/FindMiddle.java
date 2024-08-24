public class FindMiddle {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt += 1;
            temp = temp.next;
        }
        int middle = (cnt / 2 + 1);
        temp = head;
        while (temp != null) {
            middle -= 1;
            if (middle == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

}
