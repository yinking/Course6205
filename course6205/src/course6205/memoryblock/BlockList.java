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
public class BlockList {

    private Block first;

    //LinkList constructor
    public BlockList() {
        first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //Inserts a new Link at the first of the list
    public void insert(Block block) {
        block.nextBlock = first;
        first = block;
    }

    //Deletes the link at the first of the list
    public Block delete() {
        Block temp = first;
        first = first.nextBlock;
        return temp;
    }

    public int size() {
        if (first == null) {
            return 0;
        }
        int count = 1;

        Block tempBlock = first;
        while (tempBlock.nextBlock != null) {
            tempBlock = tempBlock.nextBlock;
            count++;
        }

        return count;
    }

    //Prints list data
    public void printList() {
        Block currentBlock = first;
        System.out.print("List: \n");
        while (currentBlock != null) {
            currentBlock.printLink();
            currentBlock = currentBlock.nextBlock;
        }
        System.out.println("");
    }

    public void setAddress() {
        Block currentBlock = first;
        int sum = 0;
        while (currentBlock != null) {
            currentBlock.setAddress(sum);

            int size = currentBlock.getSize().intValue();
            sum += size;

            currentBlock = currentBlock.nextBlock;

        }
    }

    public void sortBlock() { //blocksize from lowest to highest
        int i, j;
        Block pre, next;
        Double temp;
        for (i = 0, pre = first; i < size() - 1; i++, pre = pre.nextBlock) {
            for (j = i + 1, next = pre.nextBlock; j < size(); j++, next = next.nextBlock) {
                if (pre.getSize() > next.getSize()) {
                    temp = pre.getSize();
                    pre.setSize(next.getSize());
                    next.setSize(temp);
                }
            }
        }

    }

}
