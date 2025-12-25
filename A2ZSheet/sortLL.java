package A2ZSheet;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class sortLL {

    static Scanner sc = new Scanner(in);

    // =========================
    // CREATE LINKED LIST (RUNTIME)
    // =========================
    static ListNode createLinkedListRuntime() {
        out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n == 0) return null;

        out.print("Enter value: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode cur = head;

        for (int i = 1; i < n; i++) {
            out.print("Enter value: ");
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        return head;
    }

    // =========================
    // CREATE LINKED LIST (COMPILE-TIME)
    // =========================
    static ListNode createLinkedListCompileTime() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        return head;
    }

    // =========================
    // PRINT LINKED LIST
    // =========================
    static void printLinkedList(ListNode head) {
        while (head != null) {
            out.print(head.val + " -> ");
            head = head.next;
        }
        out.println("null");
    }

    // =========================
    // REVERSE LINKED LIST
    // =========================
    static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // =========================
    // SPLIT LINKED LIST (MIDDLE)
    // =========================
    static ListNode splitInMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // split
        return slow;      // second half head
    }

    // =========================
    // MERGE TWO SORTED LISTS
    // =========================
    static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // =========================
    // MAIN MENU
    // =========================



    static ListNode sortTwoListNode(ListNode l1){
        if(l1==null||l1.next==null){
            return l1;
        }
        ListNode secondHalf=splitInMiddle(l1);
        ListNode first=sortTwoListNode(l1);
        ListNode second=sortTwoListNode(secondHalf);
        ListNode fullList=mergeSortedLists(first,second);
        return fullList;


    }
    public static void main(String[] args) {

        ListNode head=null;
        ListNode secondHalf = null;
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode merged = null;
        while (true) {
            out.println("\n==== LINKED LIST MENU ====");
            out.println("1. Create Linked List (Runtime)");
            out.println("2. Create Linked List (Compile-Time)");
            out.println("3. Reverse Linked List");
            out.println("4. Split Linked List in Middle");
            out.println("5. Merge Two Sorted Linked Lists");
            out.println("6. sort ll");
            out.println("0. print & Exit");

            out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    head = createLinkedListRuntime();
                    printLinkedList(head);
                }

                case 2 -> {
                    head = createLinkedListCompileTime();
                    printLinkedList(head);
                }

                case 3 -> {
                    head = createLinkedListRuntime();
                    head = reverseLinkedList(head);
                    printLinkedList(head);
                }

                case 4 -> {
                    head = createLinkedListRuntime();
                    secondHalf = splitInMiddle(head);

                    out.print("First Half: ");
                    printLinkedList(head);

                    out.print("Second Half: ");
                    printLinkedList(secondHalf);
                }

                case 5 -> {
                    out.println("First sorted list:");
                    l1 = createLinkedListRuntime();

                    out.println("Second sorted list:");
                    l2 = createLinkedListRuntime();

                    merged = mergeSortedLists(l1, l2);
                    printLinkedList(merged);
                }

                case 6 -> {
                    head=sortLL.sortTwoListNode(head);
                }

                case 0 -> {
                    printLinkedList(head);
                    out.println("Exiting...");
                    return;
                }

                default -> out.println("Invalid choice!");
            }
        }

    }
}


