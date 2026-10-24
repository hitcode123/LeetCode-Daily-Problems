package A2ZSheet.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KSortedArray {

    public int[] getResult(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] res = new int[n];

        int index = 0;

        // Insert first k+1 elements
        for (int i = 0; i <= k && i < n; i++) {
            pq.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k + 1; i < n; i++) {

            // Extract minimum
            res[index++] = pq.poll();

            // Add next element
            pq.add(arr[i]);
        }

        // Remove remaining heap elements
        while (!pq.isEmpty()) {
            res[index++] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        KSortedArray obj = new KSortedArray();

        int[] res = obj.getResult(arr, k);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}