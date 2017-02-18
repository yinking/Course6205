/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import static java.lang.Math.pow;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author GladysWang
 */
public class BlockBT {

    private BTNode root;

    /* Constructor */
    public BlockBT() {
//        root = createMemoryTree(1, 6);
        root = createMemoryTree(1, 6, root);
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;

    }

    /**
     * assuming the smallest size is 4 if the largest size is 64=2^6 2=2^1 the
     * depth is 6
     *
     * @param currentDepth
     * @param depth
     * @return
     */
    public BTNode createMemoryTree(int currentDeep, int depth) {
        BTNode p;
        Double value = pow(2, depth - currentDeep + 1);

        if (currentDeep > depth) {
            return null;

        } else {
            p = new BTNode();
            p.setData(value.intValue());
            currentDeep++;
            p.setlChild(createMemoryTree(currentDeep, depth));
            p.setrChild(createMemoryTree(currentDeep, depth));

            return p;
        }
    }

    public BTNode createMemoryTree(int currentDeep, int depth, BTNode parent) {
        BTNode p;
        Double value = pow(2, depth - currentDeep + 1);

        if (currentDeep > depth) {
            return null;

        } else {
            p = new BTNode();
            p.setData(value.intValue());
            currentDeep++;
            if (currentDeep != 1) {
                p.parent = parent;
            }
            p.setlChild(createMemoryTree(currentDeep, depth, p));
            p.setrChild(createMemoryTree(currentDeep, depth, p));

            return p;
        }
    }

    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<BTNode> stack = new ArrayDeque<BTNode>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            BTNode node = stack.pop(); //每次出来一个都进去两个.
            System.out.print(node.size + "    ");
            if (node.rChild != null) {
                stack.push(node.rChild);
            }
            if (node.lChild != null) {
                stack.push(node.lChild);
            }
        }
        System.out.print("\n");
    }

    public ArrayList<Integer> depthOrderRequest(ArrayList<Integer> requestList) {
        ArrayList<Integer> failedRequest = new ArrayList<>();
        if (root == null) {
            System.out.println("empty tree");
            failedRequest = requestList;
            return failedRequest;
        }
        ArrayDeque<BTNode> stack = new ArrayDeque<BTNode>();
        for (Integer request : requestList) {
            stack.push(root);
            Boolean flag = true;
            while (stack.isEmpty() == false) {
                BTNode node = stack.pop(); //每次出来一个都进去两个.
                int requestBlockSize = getRequestBlockSize(request);
                if (node.size == requestBlockSize) {
                    node.occupied = true;
                    node.used = request;
//                    //need to set all its parents unvailable
//                    BTNode temp = node.parent;
//                    while (temp != null) {
//                        temp.occupied = true;
//                        temp = temp.parent;
//
//                    }
                    flag = false;
                    break;
                }
                if (node.rChild != null && !node.rChild.occupied) {
                    stack.push(node.rChild);
                }
                if (node.lChild != null && !node.lChild.occupied) {
                    stack.push(node.lChild);
                }
            }
            if (flag) {

                failedRequest.add(request);
            }
        }
        System.out.println("**" + failedRequest.toString());
        return failedRequest;

    }

    private int getRequestBlockSize(int requestSize) {

        if (0 < requestSize && requestSize <= 2) {
            return 2;
        } else if (2 < requestSize && requestSize <= 4) {

            return 4;
        } else if (4 < requestSize && requestSize <= 8) {

            return 8;
        } else if (8 < requestSize && requestSize <= 16) {

            return 16;
        } else if (16 < requestSize && requestSize <= 32) {

            return 32;
        } else if (32 < requestSize && requestSize <= 64) {

            return 64;
        }
        return 0;
    }

    public void levelOrderTraversalLayer() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<BTNode> queue = new ArrayDeque<BTNode>();
        queue.add(root);
        int n = 0;
        while (queue.isEmpty() == false) {

            if (queue.size() == pow(2, n)) {
                n++;
                System.out.print("\n");

            }
            BTNode node = queue.remove();
            if (queue.size() == 2) {
                System.out.println("---------parent:--------------" + node.parent.size);

            }
            System.out.print(node + "    ");
            if (node.lChild != null) {
                queue.add(node.lChild);
            }
            if (node.rChild != null) {
                queue.add(node.rChild);
            }
        }
        System.out.print("\n");
    }

    public void levelOrderTraversalSetAddress(int depth) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<BTNode> queue = new ArrayDeque<BTNode>();
        queue.add(root);
        int n = 0;
        //address=p*mod
        int p = 0;
        int mod = 0;
        while (queue.isEmpty() == false) {
            //print "\n"
            if (queue.size() == pow(2, n)) {
                mod = (int) pow(2, depth - n);
                n++;
                p = 0;
                System.out.print("\n");

            }
            BTNode node = queue.remove();
            node.address = p * mod;
            p++;
            System.out.print(node.toStringSizeAddress() + "    ");
            if (node.lChild != null) {
                queue.add(node.lChild);
            }
            if (node.rChild != null) {
                queue.add(node.rChild);
            }
        }
        System.out.print("\n");
    }

//    public ArrayDeque<BTNode> requestLevelNodes(){
//    }
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<BTNode> queue = new ArrayDeque<BTNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            BTNode node = queue.remove();
            System.out.println(node + "    ");
            if (node.lChild != null) {
                queue.add(node.lChild);
            }
            if (node.rChild != null) {
                queue.add(node.rChild);
            }
        }
        System.out.print("\n");
    }

    private void preTraverseBTree(BTNode p) {
        if (p != null) {
            if (p.lChild != null) {
                preTraverseBTree(p.lChild);
            }
            if (p.rChild != null) {
                preTraverseBTree(p.rChild);

            }
        }
    }

    public void printTreeInPreOrder() {
        preTraverseBTree(root);
        System.out.println("");
    }

}
