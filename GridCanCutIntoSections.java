import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SolutionForThisSectionGrid {


    public static  void sortByIndex(List<List<Integer>> simpleArray){
        simpleArray.sort(Comparator.comparingInt(a -> a.get(0)));

    }
    public boolean checkValidCuts(int x, int[][] rectangles) {

        List<List<Integer>> finalX=new ArrayList<>();
        List<List<Integer>> finalY=new ArrayList<>();
        int n=rectangles.length;
        for(int i=0;i<n;i++){
            List<Integer>  tempX=new ArrayList<>();
            List<Integer>  tempY=new ArrayList<>();
            for(int j=0;j<4;j++){
                if(j%2==0){//even
                    tempX.add(rectangles[i][j]);
                }else{//odd
                    tempY.add(rectangles[i][j]);
                }
            }
            finalX.add(tempX);
            finalY.add(tempY);
        }

        sortByIndex(finalX);
        sortByIndex(finalY);
        int low=finalX.get(0).get(0);
        int high=finalX.get(0).get(1);
        int countX=0;
        for(int i=1;i<finalX.size();i++){
            if(high>finalX.get(i).get(0)){
                if(high<finalX.get(i).get(1)){
                    high=finalX.get(i).get(1);
                }
            }else{
                high=finalX.get(i).get(1);
                low=finalX.get(i).get(0);
                countX++;
            }

        }

        high=finalY.get(0).get(1);
        low=finalY.get(0).get(0);
        int countY=0;
        for(int i=1;i<finalY.size();i++){
            if(high>finalY.get(i).get(0)){
                if(high>finalY.get(i).get(1)){
                    high=finalY.get(i).get(1);
                }
            }else{
                high=finalY.get(i).get(1);
                low=finalY.get(i).get(0);
                countY++;
            }

        }


        return (countX>=2||countY>=2);
    }
}

public class GridCanCutIntoSections {
    public static void main(String[] args){
        SolutionForThisSectionGrid obj= new SolutionForThisSectionGrid();
        int [][] testarr=new int[][]{{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
        boolean val= obj.checkValidCuts(5,testarr);
        // answer here
        System.out.println(val);

    }

}
