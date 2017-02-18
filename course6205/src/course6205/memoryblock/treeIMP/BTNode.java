/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

/**
 *
 * @author GladysWang
 */
public class BTNode {

    int size;
    int address;
    BTNode lChild;
    BTNode rChild;
    BTNode parent;
    Boolean occupied = false;
    int used;

    public BTNode(int n) {
        lChild = null;
        rChild = null;
        parent = null;
        size = n;
    }

    public BTNode() {
        lChild = null;
        rChild = null;
    }

    public int getData() {
        return size;
    }

    public void setData(int data) {
        this.size = data;
    }

    public BTNode getlChild() {
        return lChild;
    }

    public void setlChild(BTNode lChild) {
        this.lChild = lChild;
    }

    public BTNode getrChild() {
        return rChild;
    }

    public void setrChild(BTNode rChild) {
        this.rChild = rChild;
    }

    @Override
    public String toString() {
        return "BTNode{" + "size=" + size + ", address=" + address + ", occupied=" + occupied + ", used=" + used + '}';
//        return "BTNode{" + size   + '}';
//        return "BTNode{" + "data=" + size + ", address=" + address + '}';
    }

    public String toStringSizeAddress() {
        return "BTNode{" + "size=" + size + ", address=" + address + '}';
    }

}
