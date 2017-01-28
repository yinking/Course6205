/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock;

/**
 *
 * @author GladysWang
 */
public class Block {
    //make it to fit linkedlist
    private Double size;
    private int address;//start with zero,next address should add size of previous one
    protected Block nextBlock=null;
    boolean available=true;

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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
    
    

    

   
    
    public void printLink() {
        System.out.print("{ address:" + address + ", size:" + size + ", available:" + available +"} \n");
    }
}
