package A2ZSheet;
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
public class deleteAllOccurenceDLL {

    // User function Template for Java

//     Structure of Doubly Linked List


        static Node deleteAllOccurOfX(Node head, int x) {
            // Write your code here
            Node cur=head;
            Node prev=null;



            while(cur!=null&&cur.data==x){
                cur=cur.next;
            }

            head=cur;

            while(cur!=null){
                while(cur!=null&&cur.data==x){
                    cur=cur.next;
                }

                if(prev!=null){
                    prev.next=cur;

                }
                prev=cur;
                if(cur!=null){
                    cur.prev=null;
                    cur=cur.next;
                }
            }

            return head;


        }

        public static void main(String[] args){

        }
}





