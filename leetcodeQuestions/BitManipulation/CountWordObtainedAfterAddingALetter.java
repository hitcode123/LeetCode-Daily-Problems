package leetcodeQuestions.BitManipulation;

import leetCodeContestQuestions.CountEqualOperation;

public class CountWordObtainedAfterAddingALetter {

        public int wordCount(String[] startWords, String[] targetWords) {

            int[] maskStart=new int[26];
            for(int i=0;i<startWords.length;i++){
                int curMask=0;
                String curString=startWords[i];
                for(int j=0;j<curString.length();j++){
                    int tempShift=curString.charAt(j)-'a'+1;
                    curMask|=1<<tempShift;
                }
                maskStart[i]=curMask;
            }

            int[] maskEnd=new int[26];
            for(int i=0;i<targetWords.length;i++){
                int curMask=0;
                String curString=targetWords[i];
                for(int j=0;j<curString.length();j++){
                    int tempShift=curString.charAt(j)-'a'+1;
                    curMask|=1<<tempShift;
                }
                 maskEnd[i]=curMask;
            }
            int ans=0;
            for(int i=0;i<startWords.length;i++){
                int curMask=maskStart[i];
                for(int j=0;j<targetWords.length;j++){
                    if(((curMask^maskEnd[j]&curMask)==0)){
                        ans++;
                        break;
                    }
                }

            }

            return ans;


        }

        public static void main(String[] args){
            CountWordObtainedAfterAddingALetter countWordObtainedAfterAddingALetter=new CountWordObtainedAfterAddingALetter();
            countWordObtainedAfterAddingALetter.wordCount(new String[]{"ab", "a"},new String[]{"abc","abcd"});
        }

}
