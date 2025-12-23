package A2ZSheet;

public class PalindromeUsingInterationLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, PalindromeUsingInterationLinkedList.ListNode next) { this.val = val; this.next = next; }
    }

    public void findSolution(){
        PalindromeUsingInterationLinkedList.ListNode head=new PalindromeUsingInterationLinkedList.ListNode();
        revLinkedList(head);
    }

    private ListNode revLinkedList(ListNode head){
        if(head.next==null){
            return head;
        }

        PalindromeUsingInterationLinkedList.ListNode headNode=revLinkedList(head.next);
        headNode.next=head;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
        }

        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }

        ListNode cur1=head;
        ListNode cur2=prev;
        while(cur1!=null&&cur2!=null){
            if(cur1.val==cur2.val){
                cur1=cur1.next;
                cur2=cur2.next;
            }else{
                return false;
            }
        }

        return true;

    }
}
