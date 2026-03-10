package A2ZSheet;

public class StackUsingArray {
    int capacity;
    int[] array;
    int currentIndex=-1;


    StackUsingArray(int capacity){
        this.array=new int[capacity];
        this.capacity=capacity;
    }

    public void pop(){
        if(currentIndex==-1){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("Popped out element is" +array[currentIndex--]);
        }
    }

    public int push(int n){
        if(currentIndex==capacity-1){
            System.out.println("Stack is Full");
            return-1;
        }else{
            array[++currentIndex]=n;
            System.out.println("Pushed element is "+array[currentIndex]);
            return array[currentIndex];
        }
    }

    public int top(){
        if(currentIndex==-1){
            System.out.println("No element present in this");
            return -1;
        }
        return array[currentIndex];
    }
    public boolean IsEmpty(){
        return currentIndex == -1;
    }

    public static void main(String[] args){

    }

}
