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

    int data;
    BTNode lChild;
    BTNode rChild;
    Boolean occupied;
    public BTNode(int n) {
        lChild = null;
        rChild = null;
        data = n;
    }

    public BTNode() {
        lChild = null;
        rChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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

}
