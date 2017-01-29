/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhou.ziq;

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
        System.out.print("List: \n");
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
    
    public int merge(double requestSize){
        double sum =0;
        Block temp = head;
        while(!temp.nextBlock.available){
            temp = temp.nextBlock;
        }
        temp=temp.nextBlock;
        while(sum<requestSize){
            sum +=temp.getSize();
            temp.setAvailable(false);
            temp=temp.nextBlock;
        }
        return temp.getAddress();
    }

}
