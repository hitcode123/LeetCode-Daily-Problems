package A2ZSheet;

import java.util.Arrays;

public class CountInversions {

    public static   int countInv=0;
    public static void countInversions(int [] arr,int low,int high){
        if(low==high){
            return ;
        }
        int mid=(low+high)/2;
        countInversions(arr,low,mid);
        countInversions(arr,mid+1,high);
        mergeSort(low,mid,high,arr);

    }

    private static int mergeSort(int low, int mid, int high, int[] arr) {
        int i=0;
        int j=0;
        int[] arr1;
        int[] arr2;
        arr1=Arrays.copyOfRange(arr,low,mid+1);
        arr2=Arrays.copyOfRange(arr,mid+1,high+1);
        int n1=arr1.length;
        int n2=arr2.length;
        int count=high-low+1;
        int k=low;
        while(i<n1&&j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i];
                i++;
                k++;
            }else{
                arr[k]=arr2[j];
                countInv+=n1-i;
                j++;
                k++;
            }
        }

        while(i<n1) {
            arr[k]=arr1[i];
            k++;
            i++;
        }
        while (j<n2){
            arr[k]=arr2[j];
            j++;
            k++;
        }

        return countInv;

    }


    public static void main(String[] args) {
        int[] arr=new int[]{
                1,2,3,4,5
        };
        int n=arr.length;
        CountInversions.countInversions(arr,0,arr.length-1);
        System.out.println(countInv);
    }
}
