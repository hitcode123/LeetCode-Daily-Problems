package A2ZSheet;

public class LinkedListForKGroup {

//      Definition for singly-linked list.
     public class ListNode {
        int val;
         ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }







        public ListNode reverseKGroup(ListNode head, int k) {
            //count the nodes

            ListNode cur=head;
            int n=0;
            while(cur!=null){
                cur=cur.next;
                n++;
            }

            boolean flagHead=false;
            ListNode parentNode=null;
            int c=0;
            while(cur!=null&&n-c*k>0){
                int count=0;
                cur=head;
                ListNode prev=null;
                while(cur!=null&&count<=k){
                    ListNode temp=cur.next;
                    cur.next=prev;
                    prev=cur;
                    cur=temp;
                    count++;
                }

                if(count>=k&&flagHead==false){
                    parentNode=prev;
                    flagHead=true;
                }
                head.next=cur;
                head=cur;
                c++;
            }
            head=parentNode;
            return head;
        }
    }


    

