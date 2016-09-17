import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        Node root = null;

        for (int i = 0; i < size; i++) {
            int val = in.nextInt();
            if (root == null) {
                root = new Node(val);
            } else {
                Node curr = root;

                while (true) {
                    if (val < curr.val) {
                        if (curr.left == null) {
                            curr.left = new Node(val);
                            break;
                        }
                        curr = curr.left;
                    } else {
                        if (curr.right == null) {
                            curr.right = new Node(val);
                            break;
                        }
                        curr = curr.right;
                    }
                }
            }
        }

        ArrayList<Node> currNodes = new ArrayList<Node>();
        currNodes.add(root);

        int height = 0;
        int sum = 0;

        while (!currNodes.isEmpty()) {
            ArrayList<Node> nextNodes = new ArrayList<Node>();

            for (Node n : currNodes) {
                if (n.left != null) {
                    nextNodes.add(n.left);
                }

                if (n.right != null) {
                    nextNodes.add(n.right);
                }
            }

            sum += currNodes.size() * height;

            currNodes = nextNodes;

            height++;
        }

        System.out.println(sum);
    }
}
