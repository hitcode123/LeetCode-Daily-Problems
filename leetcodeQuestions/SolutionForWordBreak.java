package leetcodeQuestions;

import java.util.List;

public class SolutionForWordBreak {


        boolean findSequence(String s,int start,int end,List<String> wordDict){
            if(start==end){
                return true;
            }

            for(int i=start;i<end;i++){
                String tempStr=s.substring(start,start+(i-start+1));
                if(wordDict.contains(tempStr)){
                    if(findSequence(s,i+1,end,wordDict)){
                        return true;
                    }
                }

            }
            return false;
        }
        public boolean wordBreak(String s, List<String> wordDict) {
            return  findSequence(s,0,s.length(),wordDict);
        }
    public static void main(String[] args){

            SolutionForWordBreak solutionForWordBreak=new SolutionForWordBreak();
           boolean value= solutionForWordBreak.wordBreak("catsandog", List.of(new String[]{"cats","cat","and","sand","dog"}));
           System.out.println(value);

    }
}
