/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:17 PM
 */
package problem1.mybst;

import problem1.node.TreeNode;
// to implement BinarySearchTree
public class MyBinarySearchTree {
    static Queue<TreeNode> q;

    public TreeNode insert(TreeNode root, int x) {
        if (root == null)
            return new TreeNode(x);
        else if (x > root.getData())
            root.setRight(insert(root.getRight(), x));
        else
            root.setLeft(insert(root.getLeft(), x));
        return root;
    }

    void printPostorder(TreeNode node) {

        if (node == null)

            return;

        printPostorder(node.getLeft());

        printPostorder(node.getRight());

        System.out.print(node.getData() + " ");

    }

    void printInorder(TreeNode node) {

        if (node == null)

            return;

        printInorder(node.getLeft());

        System.out.print(node.getData() + " ");

        printInorder(node.getRight());

    }

}

