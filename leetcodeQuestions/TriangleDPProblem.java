package leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TriangleDPProblem {


    public   int calCulateTheSumOfTriangle(List<List<Integer>> triangle ,int level,int i){
        if(level==triangle.size()){
            return 0;
        }

        int sum1=0,sum2=0;
        sum1=calCulateTheSumOfTriangle(triangle,level+1,i);
        sum2=calCulateTheSumOfTriangle(triangle,level+1,i+1);
        return Math.min(triangle.get(level).get(i)+sum1,triangle.get(level).get(i)+sum2);

    }
    public  int minimumTotal(List<List<Integer>> triangle) {

        int maxSumPath=calCulateTheSumOfTriangle(triangle,0,0);
        return maxSumPath;

    }
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose input type:");
        System.out.println("1. Dynamic input (user input)");
        System.out.println("2. Static input (hardcoded)");

        int choice = sc.nextInt();

        List<List<Integer>> triangle = new ArrayList<>();

        if (choice == 1) {
            // Dynamic Input
            System.out.println("Enter number of rows:");
            int n = sc.nextInt();

            System.out.println("Enter triangle values row by row:");
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    row.add(sc.nextInt());
                }
                triangle.add(row);
            }
        } else {
            // Static Input (You can modify this triangle easily)
            triangle = Arrays.asList(
                    Arrays.asList(2),
                    Arrays.asList(3, 4),
                    Arrays.asList(6, 5, 7),
                    Arrays.asList(4, 1, 8, 3)
            );
        }

        TriangleDPProblem triangleDPProblem=new TriangleDPProblem();

        // Now call your method
        System.out.println(triangleDPProblem.minimumTotal(triangle));
    }
}
