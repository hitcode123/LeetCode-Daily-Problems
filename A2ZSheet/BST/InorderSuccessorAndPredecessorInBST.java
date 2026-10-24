package A2ZSheet.BST;


import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class InorderSuccessorAndPredecessorInBST {

    List<Integer> succPredBST(TreeNode root, int key) {
        int floor = -1;
        int ciel = -1;

        TreeNode current = root;

        while (current != null) {
            if (current.data >= key) {
                current = current.left;
            } else {
                floor = current.data;
                current = current.right;
            }
        }

        current = root;

        while (current != null) {
            if (current.data <= key) {
                current = current.right;
            } else {
                ciel = current.data;
                current = current.left;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(floor);
        ans.add(ciel);

        return ans;
    }

    public static void main(String[] args) {
        InorderSuccessorAndPredecessorInBST solution =
                new InorderSuccessorAndPredecessorInBST();

        // Create sample BST
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(8);
        root.right = new TreeNode(16);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(20);

        int[] testCases = {10, 13, 4, 20, 12, 5};

        for (int key : testCases) {
            System.out.println(
                    "Key = " + key + " -> "
                            + solution.succPredBST(root, key)
            );
        }
    }
}

