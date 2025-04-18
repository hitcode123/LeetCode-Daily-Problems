package leetCodeToughQuestions;

import javax.crypto.spec.PSource;
import java.util.*;

public class MostProfitablePathInATree {


   static int[] boothPath;
    static boolean[] visited;
    static  List<List<Integer>> trvMap;
    static int maxi = Integer.MIN_VALUE;

    static  boolean  traverseBob(Integer bob, Integer time) {

        boothPath[bob] = time;
        visited[bob] = true;
        if (bob == 0) {
            return true;
        }


        for (int num : trvMap.get(bob)) {
            if (!visited[num]) {
                if (traverseBob(num, time + 1)) {
                    return true;
                }
            }

        }
        boothPath[time] = -1;
        return false;
    }



    // i want a dfs traversal to find bob's route to root then update time in according to second
    // track visited for dfs
    // track visited for bfs
    // need to create a queue for bfs
    // now key is to implement them
    // if found true then put true in that root

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        boothPath = new int[n];
        Arrays.fill(boothPath, -1);
        trvMap=new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            trvMap.add(new ArrayList<>());
        }

        for(int[] node:edges){
            trvMap.get(node[0]).add(node[1]);
            trvMap.get(node[1]).add(node[0]);
        }


        traverseBob(bob, 0);
        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[]{0, 0, 0});


        Arrays.fill(visited, false);
        while (!nodeQueue.isEmpty()) {
            int[] val = nodeQueue.poll();
            int sourceNode = val[0];
            int weight = val[1];
            int time = val[2];
            visited[sourceNode] = true;

            if ((boothPath[sourceNode] == -1 || time < boothPath[sourceNode])) {
                weight += amount[sourceNode];
            } else if (time == boothPath[sourceNode]) {
                weight += amount[sourceNode] / 2;
            }

            if (trvMap.get(sourceNode).size() == 1&&sourceNode!=0) {
                maxi = Math.max(weight, maxi);

            }


            for (int node : trvMap.get(sourceNode)) {
                if (!visited[node]) {
                    nodeQueue.add(new int[]{node,weight , time + 1});
                }
            }


        }

        return maxi;
    }

    public static void main(String [] args)
    {
        int[][] edges={{0,1},{1,2},{1,3},{3,4}};
        int[] amount= {-2,4,2,-4,6};
        System.out.println(mostProfitablePath(edges,3,amount));

    }

}
