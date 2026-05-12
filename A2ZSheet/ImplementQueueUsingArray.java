package A2ZSheet;

public class ImplementQueueUsingArray {
    int start=-1;
    int last=-1;
    int[] queueArray;
    int capacity;

    ImplementQueueUsingArray(int n){
        queueArray=new int[n];
        this.capacity=n;
    }

    public int pop(){
        if(start==-1){
            last=-1;
            System.out.println("Please Add Elements to Remove");
            return -1;
        }else{
            int value=queueArray[start];
            start++;
            if(start==last) {
                start = last = -1;
            }
            return value;
        }
    }
    public void push(int n){
        if(last==capacity-1){
            System.out.println("Queue is Full try again later");
            return;
        }
        if(start==-1){
            start=last=0;
            queueArray[last]=n;
            last++;
        }else{
            queueArray[last++]=n;
        }
    }
}
