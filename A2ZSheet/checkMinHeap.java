package A2ZSheet;

public class checkMinHeap {


    public static void main(String[] args){
        int[] heapSam=new int[1000];
        for(int i=0;2*i+2<1000;i++){
            if(heapSam[i]<=heapSam[2*i+1]&&heapSam[i]<=heapSam[2*i+2]){
                continue;
            }else{
                System.out.println("Not a heap");
            }
        }


    }
}
