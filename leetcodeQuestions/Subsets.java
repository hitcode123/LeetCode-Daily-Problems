package leetcodeQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionSubsets{
    Set<List<Integer>> ans;
    List<Integer> temp;
    public void pickNotPick(int[] nums,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        pickNotPick(nums,i+1);
        temp.remove(temp.size()-1);
        pickNotPick(nums,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new HashSet<>();
        temp=new ArrayList<Integer>();
        pickNotPick(nums,0);
        List<List<Integer>> real=new ArrayList<>();

        for(List<Integer> l:ans){
            real.add(l);

        }
        return real;



    }
}
public class Subsets {
    public static void main(String[] args){

        int[] arr=new int[]{1,2,3};
        SolutionSubsets solutionSubsets=new SolutionSubsets();
        System.out.println(solutionSubsets.subsets(arr));

    }
}
