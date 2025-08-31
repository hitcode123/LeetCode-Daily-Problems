package leetcodeQuestions.BitManipulation;

public class DivideAndConquer {
        public int divide(int dividend, int divisor) {
            if(dividend>Math.pow(2,32)-1){
                return (int)Math.pow(2,32)-1;
            }else if(dividend<-Math.pow(2,31)){
                return (int)Math.pow(2,31);
            }
            int total=dividend;
            int totalDivisor=divisor;
            int count=1;
            int ans=0;
            if(divisor<0||dividend<0){
                if(divisor<0){
                    totalDivisor*=-1;
                }else{
                    total*=-1;
                }
            }
            while(total>=totalDivisor){
                int value=totalDivisor;
                count=1;
                while(value<=total){
                    value<<=1;
                    count*=2;
                }
                value>>=1;
                total-=value;
                count/=2;
                ans+=count;
            }

            if(divisor<0||dividend<0){return ans*=-1;}
            return ans;
        }

        public static void main(String[] args){
            DivideAndConquer bitManipulation=new DivideAndConquer();
            bitManipulation.divide(-1,1);
        }

}
