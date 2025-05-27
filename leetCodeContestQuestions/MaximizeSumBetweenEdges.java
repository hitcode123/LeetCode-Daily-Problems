package leetCodeContestQuestions;


import java.util.*;

class Pair{
    int u;
    int v;
    Pair(int u,int v){
        this.v=v;
        this.u=u;
    }
}
public class MaximizeSumBetweenEdges {

    public int findMaxNumberOfCount(int maxCount){
        int maxSum = 2 * maxCount;
        int[] dp = new int[maxSum + 1];
        dp[0] = 1;

        for (int i = 1; i <= maxCount; i++) {
            int[] newDp = new int[maxSum + 1];
            for (int sum = 0; sum <= maxSum - 2; sum++) {
                if (dp[sum] > 0) {
                    newDp[sum + 1] += dp[sum];
                    newDp[sum + 2] += dp[sum];
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int sum = 1; sum <= maxSum; sum += 2) {
            result += dp[sum];
        }

        return result;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>> lst=new ArrayList<>();
        for(int i=0;i<=n;i++){
            lst.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            lst.get(edge[0]).add(edge[1]);
            lst.get(edge[1]).add(edge[0]);
        }

        Queue<Pair> queue=new LinkedList();
        queue.add(new Pair(1,0));
        int[] vis=new int[n+1];

        Arrays.fill(vis,-1);
        vis[1]=1;
        int count=Integer.MIN_VALUE;
        while (!queue.isEmpty()){
           Pair p=queue.poll();
           int first=p.u;
           int second=p.v;
           count=Math.max(count,second);
           for(Integer  l:lst.get(first)){
               if(vis[l]==-1){
                   vis[l]=1;
               queue.add(new Pair(l,second+1));
               }
           }
        }

        return findMaxNumberOfCount(count);
    }

    public static void main(String[] args){
        int[][] arr=new int[][]{{1,2},{2,3},{3,4},{4,5}};
        MaximizeSumBetweenEdges maximizeSumBetweenEdge=new MaximizeSumBetweenEdges();

        System.out.println(maximizeSumBetweenEdge.assignEdgeWeights(arr));
    }


    }
