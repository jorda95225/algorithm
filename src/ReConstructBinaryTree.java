import java.util.Arrays;

/**
 * @autheor masheng
 * @description 重建二叉树
 * @date 2020/4/16
 */
//题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果
// 中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //分析：在前序遍历中，第一个数字是根节点，中序遍历中，根节点在序列的中间，
        //前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        //根节点是1，在中序序列中，1左边的都是左子树节点的值，右边的都是右子树节点的值
        //然后递归去做
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        //1.确定根节点
        TreeNode root = new TreeNode(pre[0]);
        //2.在中序序列中，找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                //左子树,copyOfRange函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1,
                        i + 1), Arrays.copyOfRange(in, 0, i));
                //右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1
                        , pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}