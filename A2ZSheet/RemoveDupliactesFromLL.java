package A2ZSheet;

public class RemoveDupliactesFromLL {

class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}

        Node removeDuplicates(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            if (head.next.data == head.data && head.next.next == null) {
                return null;
            }

            Node cur = head;
            Node prev=null;


            while (cur != null) {
                while (cur != null && prev != null && cur.data == prev.data) {
                    cur = cur.next;
                }

                if (prev != null) {
                    prev.next = cur;
                }


                if (cur != null) {
                    cur.prev = prev;
                }

                prev = cur;
                if(cur!=null){
                    cur = cur.next;
                }
            }



            return head;
        }


}
