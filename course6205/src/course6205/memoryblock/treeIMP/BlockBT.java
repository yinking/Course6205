/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import static java.lang.Math.pow;
import java.util.Random;

/**
 *
 * @author GladysWang
 */
public class BlockBT {

    private BTNode root;

    /* Constructor */
    public BlockBT() {
        root = createMemoryTree(1, 6);
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

    private void preTraverseBTree(BTNode p) {
        if (p != null) {
            System.out.print(p.data+" ");
            if (p.lChild != null) {
                preTraverseBTree(p.lChild);
            }
            if (p.rChild != null) {
                preTraverseBTree(p.lChild);

            }
        }
    }

    public void printTreeInPreOrder() {
        preTraverseBTree(root);
        System.out.println("");
    }

}
