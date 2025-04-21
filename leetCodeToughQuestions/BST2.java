package leetCodeToughQuestions;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


class SolutionForBST2 {
    List<TreeNode> findAllRecursion(int low,int high){

        List<TreeNode> nodes=new ArrayList<>();
        if(low>high){
            nodes.add(null);
            return nodes;

        }

        for(int i=low;i<=high;i++){
            List<TreeNode> leftTree=  findAllRecursion(low,i-1);
            List<TreeNode> rightTree=  findAllRecursion(i+1,high);

            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode root=new TreeNode(i,left,right);
                    nodes.add(root);
                }
            }

        }

        return nodes;




    }
    public List<TreeNode> generateTrees(int n) {
       if(n==0){
           return new  ArrayList<TreeNode>();
       }
       List<TreeNode> ans= findAllRecursion(1,n);
        return ans;

    }
}
public class BST2 {

   static void printTree(TreeNode node){


        System.out.print(node.val+ " ");

        if(node.left!=null){
            printTree(node.left);
        }

        if(node.right!=null){
            printTree(node.right);
        }

    }
    public static void main(String[] args){
        SolutionForBST2 solution=new SolutionForBST2();
       List<TreeNode> ans= solution.generateTrees(3);
        for(TreeNode node:ans){
            System.out.print("{ ");
            printTree(node);
            System.out.println(" }");
        }

    }


}
