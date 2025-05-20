package leetcodeQuestions;

public class UniquePaths {




    public static int uniquePaths(int m, int n) {

        int grid[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==m-1)||j==n-1){
                    grid[i][j]=1;
                }
                else{
                    grid[i][j]=-1;
                }
            }
        }

        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(grid[i][j]==-1)
                {
                    grid[i][j]=grid[i+1][j]+grid[i][j+1];
                }
            }
        }

        return grid[0][0];
    }

        public static void main(String[] args){
            int value=uniquePaths(3,7);
            System.out.println(value);
        }

    }




