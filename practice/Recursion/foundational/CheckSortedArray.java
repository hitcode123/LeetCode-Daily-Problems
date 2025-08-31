package practice.Recursion.foundational;


/*

Recurrence Relation
          {
f(n)  --->  n==0 return true;
            n>0 f(n-1) && [n-1]>[n];
          }

 */
public class CheckSortedArray {

    public  boolean checkSortedArraySolution(int[] arr ,int i){
        if(i==0){
            return true;
        }

        return (checkSortedArraySolution(arr,i-1)&&arr[i]>=arr[i-1]);

    }

    public static void main(String[]  args){

        CheckSortedArray checkSortedArray=new CheckSortedArray();
        boolean result=checkSortedArray.checkSortedArraySolution(new int[]{
                1,2,2,4
        },3);

        System.out.println("hence the passed array is sorted ?" + " "+ result);

    }
}
