package A2ZSheet;

public class PalindDromeLinkedList {
    public PalindDromeLinkedList() {
    }

    public static void main(String args[]){
         extracted();
    }

    private static boolean extracted() {
        ReverseLLIterative.ListNode cur=head;
        StringBuilder s=new StringBuilder();
        while(cur!=null){
            s.append(cur.val);
            cur=cur.next;
        }

        String real=s.toString();
        String temp=s.reverse().toString();
        if(real.equalsIgnoreCase(temp)){
            return true;
        }else{
            return false;
        }
    }
}
