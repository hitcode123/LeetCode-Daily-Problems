package A2ZSheet;

public class MaxMinHeap {


    public void convertToMaxHeap(int[] arr){
        int n=arr.length;
        for(int i=(n-1)/2;i>=0;i--){
            maxHeapify(arr,i);
        }
    }

    private void maxHeapify(int[] arr, int i) {


        int n=arr.length;
        int largest=0;
        while(i>0){
            int rightIndex=2*i+2;  // storing the index of right
            int leftIndex=2*i+1;  // storing the index of left
            if(rightIndex<n){
                largest=rightIndex;
            }

            if(leftIndex<n&&arr[leftIndex]>largest){
                largest=leftIndex;
            }


            if(arr[i]>largest){
                break;
            }else{
                int temp=arr[i];
                arr[i]=arr[largest];
                arr[largest]=temp;
                i=(i-1)/2;
            }

        }

    }

    public static void main(String[] args){

    }
}
