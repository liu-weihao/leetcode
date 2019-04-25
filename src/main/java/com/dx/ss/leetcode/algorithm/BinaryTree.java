package com.dx.ss.leetcode.algorithm;

import java.util.*;

public class BinaryTree {

    int index;
    /**
     * 节点数组，-1表示填充节点，不是真实存在，需要保证是完整二叉树
     */
    int[] array = new int[]{3, 7, 6, -1, -1, 2, 8, -1, -1, 12, -1, -1, 9, 1, -1, -1, 4, -1, 5, -1, -1};

    /**
     * 以先序创建一棵二叉树
     *
     * @return 二叉树
     */
    public TreeNode genTreeByPreOrder(int[] array) {
        //空
        if (array == null || array.length == 0 || array[0] == -1) return null;
        //只有一个根节点
        if (array.length == 1) return new TreeNode(array[0]);
        return createTree(new TreeNode(), array);
    }

    /**
     * 递归实现
     */
    public TreeNode createTree(TreeNode node, int[] array) {
        int data = array[index++];
        if (data == -1) return null;
        //设置节点数据
        node.setData(data);
        //左节点
        node.setLeft(createTree(new TreeNode(), array));
        //右节点
        node.setRight(createTree(new TreeNode(), array));
        return node;
    }


    /**
     * 以层序创建一棵二叉树，非递归实现
     *
     * @param array 节点数组，-1表示填充节点，不是真实存在，需要保证是完整二叉树
     * @return 二叉树
     */
    public TreeNode genTreeByLevelOrder(int[] array) {
        //空
        if (array == null || array.length == 0 || array[0] == -1) return null;
        //只有一个根节点
        if (array.length == 1) return new TreeNode(array[0]);
        //构造节点列表
        List<TreeNode> nodeList = new ArrayList<>();
        for (int data : array) {
            if (data != -1) {
                nodeList.add(new TreeNode(data));
            } else {
                //-1表示空节点
                nodeList.add(null);
            }
        }
        for (int i = 0; i < array.length / 2; i++) {
            TreeNode parent = nodeList.get(i);
            //忽略空节点
            if (parent == null) continue;
            //left -> i * 2 + 1
            parent.setLeft(nodeList.get(i * 2 + 1));
            //left -> i * 2 + 2
            parent.setRight(nodeList.get(i * 2 + 2));
        }
        return nodeList.get(0);
    }

    /**
     * 前序遍历，非递归实现。
     *
     * @param root 根节点
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print("前序遍历：\t");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || stack.size() > 0) {
            if (treeNode != null) {
                //先访问父节点，然后再从左节点开始访问
                System.out.print(treeNode.getData() + "\t");
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            } else {
                //左节点访问到底了，回溯，访问右节点
                treeNode = stack.pop();
                treeNode = treeNode.getRight();
            }
        }
    }

    /**
     * 前序遍历，递归实现。
     *
     * @param root 根节点
     */
    public void recursivePreOrder(TreeNode root) {
        //递归退出条件：遇到空节点就终止
        if (root == null) return;
        //访问父节点
        System.out.print(root.getData() + "\t");
        //访问左节点
        recursivePreOrder(root.getLeft());
        //访问右节点
        recursivePreOrder(root.getRight());
    }

    /**
     * 中序遍历，非递归实现。
     *
     * @param root 根节点
     */
    public void midOrder(TreeNode root) {
        if (root == null) return;
        System.out.print("中序遍历：\t");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.empty()) {
            if (treeNode != null) {
                //一直访问左节点
                stack.push(treeNode);   //直接压栈
                treeNode = treeNode.getLeft();
            } else {
                //左节点访问到底了，回溯，再访问右节点
                treeNode = stack.pop();
                System.out.print(treeNode.getData() + "\t");
                treeNode = treeNode.getRight();
            }
        }
    }

    /**
     * 中序遍历，递归实现
     *
     * @param root 根节点
     */
    public void recursiveMidOrder(TreeNode root) {
        if (root == null) return;
        //访问左节点
        recursiveMidOrder(root.getLeft());
        //访问父节点
        System.out.print(root.getData() + "\t");
        //访问右节点
        recursiveMidOrder(root.getRight());
    }

    /**
     * 后续遍历，非递归实现。
     *
     * @param root 根节点
     */
    public void postOrder(TreeNode root) {
        if (root == null) return;
        System.out.print("后序遍历：\t");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //构造一个中间栈来存储逆后序遍历的结果
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.empty()) {
            if (treeNode != null) {
                //因为stack是先进后出的数据结构，故而最后被访问的节点最先被压入栈
                //所以从右节点开始，逆向遍历
                output.push(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.getRight();
            } else {
                treeNode = stack.pop();
                treeNode = treeNode.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getData() + "\t");
        }
    }


    /**
     * 后序遍历，递归实现
     *
     * @param root 根节点
     */
    public void recursivePostOrder(TreeNode root) {
        if (root == null) return;
        //访问左节点
        recursivePostOrder(root.getLeft());
        //访问右节点
        recursivePostOrder(root.getRight());
        //访问父节点
        System.out.print(root.getData() + "\t");
    }

    /**
     * 层序遍历，非递归实现
     *
     * @param root 根节点
     */
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        System.out.print("层序遍历：\t");
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        //根节点入队
        q.add(root);
        while (!q.isEmpty()) {
            //出队并访问
            TreeNode node = q.poll();
            System.out.print(node.getData() + "\t");
            //左节点入队
            if (node.getLeft() != null) {
                q.add(node.getLeft());
            }
            //右节点入队
            if (node.getRight() != null) {
                q.add(node.getRight());
            }
        }
    }

    /**
     * 计算高度，非递归实现（基于层序遍历）
     *
     * @param root 根节点
     * @return 二叉树高度
     */
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                n--;
            }
            level++;
        }
        return level;
    }

    /**
     * 计算高度，递归实现
     *
     * @param root 根节点
     * @return 二叉树高度
     */
    public int recursiveDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = recursiveDepth(root.left);
        int rh = recursiveDepth(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrder(A);
        System.out.println();
        System.out.print("【递归】前序遍历：\t");
        binaryTree.recursivePreOrder(A);
        System.out.println();
        binaryTree.midOrder(A);
        System.out.println();
        System.out.print("【递归】中序遍历：\t");
        binaryTree.recursiveMidOrder(A);
        System.out.println();
        binaryTree.postOrder(A);
        System.out.println();
        System.out.print("【递归】后序遍历：\t");
        binaryTree.recursivePostOrder(A);
        System.out.println();
        binaryTree.levelOrder(A);
        System.out.println();
        System.out.println("计算高度：\t" + binaryTree.depth(A));
        System.out.println("【递归】计算高度：\t" + binaryTree.recursiveDepth(A));
        TreeNode tree = binaryTree.genTreeByPreOrder(binaryTree.array);
        binaryTree.preOrder(tree);
        System.out.println();
        TreeNode root = binaryTree.genTreeByLevelOrder(new int[]{3, 7, 9, 6, 2, 1, 4, -1, -1, 8, 12, -1, -1, -1, 5});
        binaryTree.preOrder(root);
    }

    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
