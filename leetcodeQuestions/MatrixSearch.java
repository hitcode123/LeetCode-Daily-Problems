package leetcodeQuestions;

public class MatrixSearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m=matrix.length;
            int n=matrix[0].length;

            int rLow=0;
            int rHigh=m-1;


            while(rLow<=rHigh){
                int rMid=rLow+rHigh/2;

                if(rMid!=m-1&&target>matrix[rMid][0]){
                        if(target<=matrix[rMid+1][0]){
                            if(target==matrix[rMid+1][0]){
                                return true;
                            }else{
                                int low=0;
                                int high=n-1;
                                while(low<high){
                                    int mid=high+low/2;
                                    if(matrix[rMid][mid]==target){
                                        return true;
                                    }else if(matrix[rMid][mid]>target){
                                        high=mid-1;
                                    }else{
                                        low=mid+1;
                                    }
                                }
                                return false;
                            }
                        }else{
                            rLow=rMid+1;
                        }

                }else if(rMid!=0&&target<matrix[rMid][0]){
                        if(target>=matrix[rMid-1][0]){
                            if(target==matrix[rMid-1][0]){
                                return true;
                            }else{
                                int low=0;
                                int high=n-1;
                                while(low<high){
                                    int mid=high+low/2;
                                    if(matrix[rMid-1][mid]==target){
                                        return true;
                                    }else if(matrix[rMid-1][mid]>target){
                                        high=mid-1;
                                    }else{
                                        low=mid+1;
                                    }
                                }
                                return false;
                            }
                        }else{
                            rHigh=rMid-1;
                        }

                }else if(target==matrix[rMid][0]){
                    return true;
                }else if(rMid==0||rMid==m-1){
                    int low=0;
                    int high=n-1;
                    while(low<=high){
                        int mid=(high+low)/2;
                        if(matrix[rMid][mid]==target){
                            return true;
                        }else if(matrix[rMid][mid]>target){
                            high=mid-1;
                        }else{
                            low=mid+1;
                        }
                    }
                    return false;

                }
            }

            return false;


        }


        public static void main(String[] args){
            MatrixSearch matrixSearch=new MatrixSearch();
            matrixSearch.searchMatrix(new int[][]{{1,3}},3);
        }

}
