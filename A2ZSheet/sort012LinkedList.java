package A2ZSheet;

import java.util.Scanner;

public class sort012LinkedList {




        // ===== ListNode =====
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        // ===== Create Linked List from User Input =====
        static ListNode createListUserInput() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();

            if (n == 0) return null;

            System.out.print("Enter values: ");
            ListNode head = new ListNode(sc.nextInt());
            ListNode current = head;

            for (int i = 1; i < n; i++) {
                current.next = new ListNode(sc.nextInt());
                current = current.next;
            }
            return head;
        }

        // ===== Create Static Linked List =====
        static ListNode createStaticList() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(3);
            head.next.next = new ListNode(5);
            head.next.next.next = new ListNode(7);
            return head;
        }

        // ===== Print Linked List =====
        static void printList(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }

        static ListNode sort012(ListNode node){

           ListNode dum0=new ListNode(-1);
           ListNode dum1=new ListNode(-1);
           ListNode dum2=new ListNode(-1);


           ListNode cur=node;
           ListNode c0=dum0;
           ListNode c1=dum1;
           ListNode c2=dum2;
           while(cur!=null){
               if(cur.val==0) {
                   c0.next=cur;
                   c0=c0.next;
               }else if(cur.val==1){
                  c1.next=cur;
                  c1=c1.next;
               }else{
                  c2.next=cur;
                  c2=c2.next;
               }
               cur=cur.next;

           }
           c2.next=null;
           c0.next=null;
           c1.next=null;

           c0.next=dum1.next;
           c1.next=dum2.next;
           return dum0.next;
        }

        // ===== Reverse Linked List =====
        static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        // ===== Main =====
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Linked List Type:");
            System.out.println("1. User Input");
            System.out.println("2. Static Input");
            int choice = sc.nextInt();

            ListNode head;

            if (choice == 1) {
                head = createListUserInput();
            } else {
                head = createStaticList();
            }

            System.out.print("Original List: ");
            sort012(head);
            printList(head);

            head = reverseList(head);
            System.out.print("Reversed List: ");
            printList(head);
        }
    }


