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

    void printPreorder(TreeNode node) {

        if (node == null)

            return;

        System.out.print(node.getData() + " ");

        printPreorder(node.getLeft());

        printPreorder(node.getRight());

    }

    public void countNodeWithOutLeftChild(TreeNode root) {

        if (root == null)

            return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        int count = 0;

        while (queue != null) {

            TreeNode temp = queue.poll();

            if (temp == null) {

                break;

            }
            if (temp.getLeft() == null)

                count++;

            if (temp.getLeft() != null)

                queue.add(temp.getLeft());

            if (temp.getRight() != null)

                queue.add(temp.getRight());

        }

        System.out.println("count of Nodes without left child: " + count);

    }

    public void printLeftTree(TreeNode root) {

        if (root == null)

            return;

        q.add(root);

        q.add(null);


        while (q.size() > 0) {

            TreeNode temp = q.peek();


            if (temp != null) {

                System.out.print(temp.getData() + " ");

                while (q.peek() != null) {


                    if (temp.getLeft() != null)

                        q.add(temp.getLeft());

                    if (temp.getRight() != null)

                        q.add(temp.getRight());



                    q.remove();


                    temp = q.peek();

                }

                q.add(null);

            }

            q.remove();

        }

    }

    public void leftView(TreeNode root) {

        q = new LinkedList<TreeNode>();

        printLeftTree(root);

    }

}

