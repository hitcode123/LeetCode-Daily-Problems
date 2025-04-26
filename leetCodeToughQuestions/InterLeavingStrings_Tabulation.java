package leetCodeToughQuestions;
class SolutionInterLeavingSolution {



    public boolean isInterleave(String s1, String s2, String s3) {


        int m=s1.length();
        int n=s2.length();
        int o=s3.length();

        if(m+n!=o){
            return false;
        }
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i>0&&s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j]=dp[i][j]||dp[i-1][j];
                }
                if(j>0&&s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j]=dp[i][j-1]||dp[i][j];
                }

            }
        }
        return dp[m][n];

    }


}


public class InterLeavingStrings_Tabulation {
    public static void main(String[] args) {
        SolutionInterLeaving solutionInterLeavin = new SolutionInterLeaving();
//       System.out.println(solutionInterLeavin.isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(solutionInterLeavin.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}

