/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.listIMP;

/**
 *
 * @author GladysWang
 */
public class Block {

    //make it to fit linkedlist
    private int size;
    private int address;//start with zero,next address should add size of previous one
    protected Block nextBlock = null;
    boolean available = true;
    private int used;

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Block() {
    }

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void printLink() {
        System.out.print("{ address:" + address + ", size:" + size + ", available:" + available + "} \n");

    }

    public void printLinkWithUsed() {
        System.out.print("{ address:" + address + ", size:" + size + ", available:" + available + ", used:" + used + "} \n");

    }
}
