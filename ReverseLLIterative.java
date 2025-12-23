import java.util.List;

public class ReverseLLIterative {
    static class ListNode{
        int value;
        ListNode nextNode;

        ListNode(int value){
            this.value=value;
        }

        ListNode(int value,ListNode node){
            this.nextNode=node;
            this.value=value;
        }

        ListNode(ListNode node){
            this.nextNode=node;
        }
    }

    public ListNode reverseNodeList(ListNode nodeRoot,int n){

        ListNode prevNode=null;
        ListNode  curNode=nodeRoot;

        while(curNode!=null){
            ListNode temp=curNode.nextNode;
            curNode.nextNode=prevNode;
            prevNode=curNode;
            curNode=temp;
         }

         return prevNode;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.nextNode = new ListNode(2);
        head.nextNode.nextNode = new ListNode(3);
        head.nextNode.nextNode.nextNode = new ListNode(4);
        ReverseLLIterative  reverseLLIterative=new ReverseLLIterative();
        reverseLLIterative.reverseNodeList(head,1);
    }
}
