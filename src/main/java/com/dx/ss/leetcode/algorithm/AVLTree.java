package com.dx.ss.leetcode.algorithm;

/**
 * 平衡二叉树相关操作。
 * https://www.cnblogs.com/skywang12345/p/3577479.html
 */
public class AVLTree {

    /**
     * 左左旋转
     *
     * @param k2 失衡的子树
     * @return 新的根节点
     */
    public AVLTreeNode LLRotation(AVLTreeNode k2) {
        AVLTreeNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k2)) + 1;
        return k1;
    }

    /**
     * 右右旋转
     *
     * @param k1 失衡的子树
     * @return 新的根节点
     */
    public AVLTreeNode RRRotation(AVLTreeNode k1) {
        AVLTreeNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), height(k1)) + 1;
        return k2;
    }

    /**
     * 左右旋转
     *
     * @param k3
     * @return
     */
    public AVLTreeNode LRRotation(AVLTreeNode k3) {
        k3.left = RRRotation(k3.left);
        return LLRotation(k3);
    }

    /**
     * 右左旋转
     * <p>
     * 返回值：旋转后的根节点
     */
    private AVLTreeNode RLRotation(AVLTreeNode k1) {
        k1.right = LLRotation(k1.right);
        return RRRotation(k1);
    }

    /**
     * 将结点插入到AVL树中，并返回根节点
     * <p>
     * 参数说明：
     * tree AVL树的根结点
     * key 插入的结点的键值
     * 返回值：
     * 根节点
     */
    private AVLTreeNode insertNode(AVLTreeNode tree, int data) {
        if (tree == null) {
            // 新建节点
            tree = new AVLTreeNode(data);
        } else {
            if (data < tree.data) {    // 应该将key插入到"tree的左子树"的情况
                tree.left = insertNode(tree.left, data);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (data < tree.left.data)
                        tree = LLRotation(tree);
                    else
                        tree = LRRotation(tree);
                }
            } else if (data > tree.data) {    // 应该将key插入到"tree的右子树"的情况
                tree.right = insertNode(tree.right, data);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (data > tree.right.data)
                        tree = RRRotation(tree);
                    else
                        tree = RLRotation(tree);
                }
            } else {    // cmp==0
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    /**
     * 删除树节点
     *
     * @param tree   AVL树
     * @param target 需要删除的树节点
     * @return 新的根节点
     */
    private AVLTreeNode remove(AVLTreeNode tree, AVLTreeNode target) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || target == null) return tree;

        if (target.data < tree.data) {        // 待删除的节点在"tree的左子树"中
            tree.left = remove(tree.left, target);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode r = tree.right;
                if (height(r.left) > height(r.right))
                    tree = RLRotation(tree);
                else
                    tree = RRRotation(tree);
            }
        } else if (target.data > tree.data) {    // 待删除的节点在"tree的右子树"中
            tree.right = remove(tree.right, target);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode l = tree.left;
                if (height(l.right) > height(l.left))
                    tree = LRRotation(tree);
                else
                    tree = LLRotation(tree);
            }
        } else {    // tree是对应要删除的节点。
            // tree的左右孩子都非空
            if (tree.left != null && tree.right != null) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode max = maximum(tree.left);
                    tree.data = max.data;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode min = minimum(tree.right);
                    tree.data = min.data;
                    tree.right = remove(tree.right, min);
                }
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
            }
        }
        return tree;
    }

    /**
     * 找AVL树的最小值
     *
     * @param tree AVL树
     * @return 最小值
     */
    private AVLTreeNode minimum(AVLTreeNode tree) {
        if (tree == null) return null;
        AVLTreeNode minNode = tree;
        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }

    /**
     * 找AVL树的最大值
     *
     * @param tree AVL树
     * @return 最大值
     */
    private AVLTreeNode maximum(AVLTreeNode tree) {
        if (tree == null) return null;
        AVLTreeNode maxNode = tree;
        while (maxNode.right != null) {
            maxNode = maxNode.right;
        }
        return maxNode;
    }

    /**
     * 查找节点数据
     *
     * @param root   AVL数
     * @param target 目标节点数据
     * @return 树节点
     */
    public AVLTreeNode search(AVLTreeNode root, int target) {
        if (root == null) return null;
        if (root.data > target) {
            return search(root.left, target);
        }
        if (root.data < target) {
            return search(root.right, target);
        }
        return root;
    }


    /**
     * 获取树的高度
     */
    private int height(AVLTreeNode tree) {
        return tree != null ? tree.height : 0;
    }

    /**
     * 中序遍历，打印AVL树（从小到大顺序输出）
     *
     * @param root AVL树根节点
     */
    public void print(AVLTreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + "\t");
        print(root.right);
    }

    public static class AVLTreeNode {
        int data;           // 节点数据值
        int height;         // 高度
        AVLTreeNode left;   // 左孩子
        AVLTreeNode right;  // 右孩子

        public AVLTreeNode() {
        }

        public AVLTreeNode(int data) {
            this.data = data;
        }

        public AVLTreeNode(int data, AVLTreeNode left, AVLTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        AVLTreeNode root = new AVLTreeNode(7);
        avlTree.insertNode(root, 5);
        avlTree.insertNode(root, 8);
        avlTree.insertNode(root, 7);
        avlTree.insertNode(root, 9);
        avlTree.insertNode(root, 2);
        avlTree.insertNode(root, 21);
        avlTree.insertNode(root, 3);
        avlTree.insertNode(root, 15);
        System.out.println("二叉平衡树：");
        avlTree.print(root);
        System.out.println();
        System.out.println("最小值：" + avlTree.minimum(root).data);
        System.out.println("最大值：" + avlTree.maximum(root).data);
        AVLTreeNode node = avlTree.search(root, 3);
        if (node == null) {
            System.out.println("没有找到该节点");
        } else {
            System.out.println("找到节点：" + node.data);
        }
    }
}
