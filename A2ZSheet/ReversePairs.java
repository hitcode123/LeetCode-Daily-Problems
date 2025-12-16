package A2ZSheet;

import java.util.Arrays;

public class ReversePairs {

    public static   int countInv=0;
    public static void reversePairs(int [] arr,int low,int high){
        if(low==high){
            return ;
        }
        int mid=(low+high)/2;
        reversePairs(arr,low,mid);
        reversePairs(arr,mid+1,high);
        countPair(arr,low,mid,high);
        mergeSort(low,mid,high,arr);

    }

    private static void countPair(int[] arr, int low, int mid, int high) {

        int i=low;
        int j=mid+1;
        while(i<mid+1){
            while(j<=high&&arr[i]>2*arr[j]){
                j++;
            }
            countInv+=j-(mid+1);
            i++;
        }
    }

    private static int mergeSort(int low, int mid, int high, int[] arr) {
        int i=0;
        int j=0;
        int[] arr1;
        int[] arr2;
        arr1= Arrays.copyOfRange(arr,low,mid+1);
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
    public static void main(String[] args){
        ReversePairs reversePairs=new ReversePairs();
        ReversePairs.reversePairs(new int[]{
                2,4,3,5,1
        },0,4);
        System.out.println(countInv);
    }
}
