package A2ZSheet;

import java.util.*;

public class ImplementStackUsingQueue {
    Queue<Integer> queueArray;
    ImplementStackUsingQueue(){
        queueArray=new LinkedList<>();
    }

    public int push(int n){
        if(!queueArray.isEmpty()){
            int size=queueArray.size();
            for(int i=0;i<size;i++){
                int k=queueArray.poll();
                queueArray.add(k);
                
            }

        }else{
            queueArray.add(n);
        }
        return n;
    }


}
