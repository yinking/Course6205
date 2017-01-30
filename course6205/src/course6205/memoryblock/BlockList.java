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

    protected Block head;

    //LinkList constructor
    public BlockList() {
        head = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Inserts a new Link at the head of the list
    public void insert(Block block) {
        block.nextBlock = head;
        head = block;
    }

    //Deletes the link at the head of the list
    public Block delete() {
        Block temp = head;
        head = head.nextBlock;
        return temp;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;

        Block tempBlock = head;
        while (tempBlock.nextBlock != null) {
            tempBlock = tempBlock.nextBlock;
            count++;
        }

        return count;
    }

    //Prints list data
    public void printList() {
        Block currentBlock = head;
        System.out.print("BlockList: \n");
        while (currentBlock != null) {
            currentBlock.printLink();
            currentBlock = currentBlock.nextBlock;
        }
        System.out.println("");
    }

    public void setAddress() {
        Block currentBlock = head;
        int sum = 0;
        while (currentBlock != null) {
            currentBlock.setAddress(sum);

            int size = currentBlock.getSize();
            sum += size;

            currentBlock = currentBlock.nextBlock;

        }
    }

    public void sortBlockByAvai() {
        System.out.println("------Availablity-------");

        Block newHead = null;
        Block current = head;
        Block temp = null;
        while (current != null) {
            if (current.available == false) {
                temp = new Block();
                temp.setSize(current.getSize());
                temp.available = current.available;
                temp.nextBlock = newHead;
                newHead = temp;
            }
            current = current.nextBlock;
        }
        current = head;
        while (current != null) {
            if (current.available) {
                temp = new Block();
                temp.setSize(current.getSize());
                temp.available = current.available;

                temp.nextBlock = newHead;
                newHead = temp;
            }
            current = current.nextBlock;

        }
        head = newHead;
    }

    public void mergeFragBlock() {
        Block current = head;
        int mergeSize = 0;
        while ( (current.available)) {
            mergeSize += current.getSize();
            System.out.println("available:"+mergeSize);
            current=current.nextBlock;
        }
        
        head.nextBlock=current;
        head.setSize(mergeSize);
    }

    public void sortBlock() { //blocksize from lowest to highest
        int i, j;
        Block pre, next;
        int temp;
        for (i = 0, pre = head; i < size() - 1; i++, pre = pre.nextBlock) {
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
