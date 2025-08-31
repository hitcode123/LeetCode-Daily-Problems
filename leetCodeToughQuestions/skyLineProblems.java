package leetCodeToughQuestions;

import java.util.*;

public class skyLineProblems {
    public List<List<Integer>> getSkyline(int[][] house) {
        int right = -1;
        int n = house.length;

        // Max-heap based on height (descending)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        Arrays.sort(house, (a, b) -> a[0] == b[0] ? b[2] - a[2] : a[0] - b[0]);

        List<List<Integer>> pairOfList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = house[i][0];
            int end = house[i][1];
            int height = house[i][2];

            if (pq.isEmpty()) {
                pq.add(new int[]{start, end, height});
                pairOfList.add(Arrays.asList(start, height));
                right = Math.max(right, end);
            } else if (right >= start) {
                if (pq.peek()[2] < height) {
                    pairOfList.add(Arrays.asList(start, height));
                }
                pq.add(new int[]{start, end, height});
                right = Math.max(right, end);
            } else if (right < start) {
                while (!pq.isEmpty()) {
                    int[] top = pq.peek();
                    int currentHeight = top[2];
                    int currentEnd = top[1];

                    if (currentEnd < right) {
                        pq.poll();
                    }
                    int nextHeight = pq.isEmpty() ? 0 : pq.peek()[2];
                    if (!pq.isEmpty()&&(currentHeight != nextHeight||(pq.peek())[1]==right)) {
                        if(currentHeight!=nextHeight) {
                            pairOfList.add(Arrays.asList(currentEnd, nextHeight));
                        }
                        if (pq.peek()[1] == right) {
                            pairOfList.add(Arrays.asList(pq.peek()[1], 0));
                            pq.poll();
                            while(!pq.isEmpty()){
                                pq.poll();
                            }
                        }
                    }
                }
                pq.add(new int[]{start, end, height});
                pairOfList.add(Arrays.asList(start, height));
                right = Math.max(right, end);

            }
            right = Math.max(right, end);
            if (i == n - 1) {
                while (!pq.isEmpty()) {
                    int[] top = pq.peek();
                    int currentHeight = top[2];
                    int currentEnd = top[1];

                    if (currentEnd < right) {
                        pq.poll();
                    }
                    int nextHeight = pq.isEmpty() ? 0 : pq.peek()[2];
                    if (!pq.isEmpty()&&(currentHeight != nextHeight||(pq.peek())[1]==right)) {
                        if(currentHeight!=nextHeight) {
                            pairOfList.add(Arrays.asList(currentEnd, nextHeight));
                        }                        if (pq.peek()[1] == right) {
                            pairOfList.add(Arrays.asList(pq.peek()[1], 0));
                            pq.poll();
                            while(!pq.isEmpty()){
                                pq.poll();
                            }
                            break;
                        }
                    }
                }
            }

        }

        return pairOfList;
    }
    public static void main(String[] args){
        skyLineProblems skyLineProblems= new skyLineProblems();
        skyLineProblems.getSkyline(new int[][]{{0,2,3},{2,5,3}});

    }
    //{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
//    {1,2,1},{2147483646,2147483647,2147483647}
}
