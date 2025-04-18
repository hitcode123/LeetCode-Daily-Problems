class SolutionCalc {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n=grid.length*grid.length;
        int actualSum=0;
        int actualSquareSum=0;
        for(int i=1;i<=n;i++){
            actualSum+=i;
            actualSquareSum+=i*i;
        }

        int calcSum=0;
        int calcSquareSum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                calcSum+=grid[i][j];
                calcSquareSum+=(grid[i][j]*grid[i][j]);
            }
        }

        int sumDiff=calcSum-(actualSum);
        int sqDiff=calcSquareSum-(actualSquareSum);

        return new int[] {(sqDiff/sumDiff+sumDiff)/2,(sqDiff/sumDiff-sumDiff)/2};




    }
}


public class CalCulateMissingAndRepeating {

    public static void main(String [] args){

        SolutionCalc obj= new SolutionCalc();
        int[] arr=(obj.findMissingAndRepeatedValues(new int[][]{{1,2},{2,3}}));
        for(int a:arr){
            System.out.println(a);
        }


    }
}
