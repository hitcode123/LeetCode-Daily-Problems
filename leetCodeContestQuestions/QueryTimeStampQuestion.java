package leetCodeContestQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryTimeStampQuestion {
    public List<String> findTheQuery(int[] t,String[] q,int threshold){
        int low=0;
        int high;
        int n=q.length;
        List<String> ans=new ArrayList<>();
        Map<String,Integer> mp=new HashMap<>();
        mp.put(q[0],1);
        int tdiff=0;
        for(int i=1;i<n;i++){
            high=i;
            tdiff=(t[high]-t[low]);
            int count=mp.getOrDefault(q[i],0);
            mp.put(q[i],count+1);
            if(tdiff<=600){

                for(Map.Entry<String,Integer> x:mp.entrySet()){
                    if(x.getValue()>=threshold){
                       ans.add(x.getKey());
                    }
                }

            }else if(tdiff>600){
                while((t[high]-t[low])>600){
                    count=mp.get(q[low]);
                    mp.put(q[low],--count);
                    low++;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args){
        int[] timeStamp={100,150,200,250,700};
        String[]  queries={"Q1","Q1","Q1","Q2","Q1"};
        QueryTimeStampQuestion obj=new QueryTimeStampQuestion();
        List<String> ans=obj.findTheQuery(timeStamp,queries,2);
        for(String s:ans){
            System.out.println(s+ " ");
        }

    }
}
