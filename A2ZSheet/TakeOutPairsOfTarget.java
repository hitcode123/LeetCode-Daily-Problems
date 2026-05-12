package A2ZSheet;
import  java.util.*;

public class TakeOutPairsOfTarget {
    /*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

        public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                          Node head) {

            Node cur=head;
            Node tail=null;
            while(cur.next!=null)    {
                cur=cur.next;
            }

            tail=cur;
            cur=head;
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            while(tail.data>cur.data&&tail!=null&&cur!=null){


                if(tail.data+cur.data==target){
                    ArrayList<Integer> tempAns=new ArrayList<>();
                    tempAns.add(cur.data);
                    tempAns.add(tail.data);
                    ans.add(tempAns);
                    cur=cur.next;
                    tail=tail.prev;
                }else if(tail.data+cur.data>target){
                    tail=tail.prev;
                }else{
                    cur=cur.next;
                }
            }

            return ans;

        }

        public static void main(String [] args){

        }
    }


