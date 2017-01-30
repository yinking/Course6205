/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock;

import java.util.ArrayList;
import static java.lang.Math.pow;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author GladysWang
 */
public class MemoryPool {

    private static MemoryPool memoryPool;

    public static MemoryPool getInstance() {
        memoryPool = new MemoryPool();
        return memoryPool;
    }

    public BlockList initBlock() { //ramdom generate different blocks
        //size should be 2, 4, 8, 16 a single power of 2
        BlockList list = new BlockList();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(7) + 3;

            Block block = new Block();
            Double value = pow(2, num);
            block.setSize(value.intValue());
            list.insert(block);
        }
        return list;

    }
//

    public void randomRequestBlockWithoutSplit(BlockList list, int requestTimes) {
        Random random = new Random();
        for (int i = 0; i < requestTimes; i++) {
            int num = random.nextInt(128) + 1;
            System.out.println("-------------" + num);
            Block current = list.head;
            while (current != null) {

                if (num <= current.getSize()) {
                    if (current.available) {
                        current.available = false;
                        current.setUsed(num);
                        break;
                    }
                }
                current = current.nextBlock;
            }

        }
    }

    //split the size to fit the exact size
    public void randomRequestBlockWithSplit(BlockList list) {
        System.out.println("-----randomRequestBlockWithSplit--------");

        Random random = new Random();
        ArrayList<Integer> failedRequest=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int requestMemorySize = random.nextInt(128) + 1;
            System.out.println("-------------" + requestMemorySize);
            Block current = list.head;
            boolean flag = true;
            while (current != null && flag) {
                //exact size
                if (requestMemorySize == current.getSize() && current.available) {
                    current.available = false;
                    current.setUsed(requestMemorySize);
                    flag = false;

                } else if (requestMemorySize < current.getSize() && current.available) {
                    //split the block
                    split(current, requestMemorySize);
                    current.available = false;
                    flag = false;

                } else {
                    current = current.nextBlock;
                }
            }
            //save the failed request
            if(current==null){
                failedRequest.add(requestMemorySize);              
            }

        }
        System.out.println("failedRequest"+failedRequest.toString());
    }
    
    
    
    
    
    
    

    private void split(Block currentBlock, int requestMemorySize) {
        int newNodeSize = currentBlock.getSize() - requestMemorySize;

        Block newBlock = new Block();
        newBlock.setSize(newNodeSize);
        newBlock.nextBlock = currentBlock.nextBlock;
        currentBlock.setSize(requestMemorySize);
        currentBlock.setUsed(requestMemorySize);

        currentBlock.nextBlock = newBlock;
    }

}
