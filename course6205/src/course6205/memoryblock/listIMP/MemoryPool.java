/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.listIMP;

import java.util.ArrayList;
import static java.lang.Math.pow;
import java.util.List;
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
        for (int i = 0; i < 400; i++) {
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
    public ArrayList<Integer> randomRequestBlockWithSplitReturnByFailedRequest(BlockList list) {
        System.out.println("-----randomRequestBlockWithSplit--------");

        Random random = new Random();
        ArrayList<Integer> failedRequest = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int requestMemorySize = random.nextInt(128) + 1;
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
            if (current == null) {
                failedRequest.add(requestMemorySize);
            }

        }
        System.out.println("failedRequest" + failedRequest.toString());
        return failedRequest;
    }

    public ArrayList<Integer> requestAfterMerge(BlockList list, ArrayList<Integer> failedList) {
        System.out.println("-----randomRequestBlockWithSplit--------");

        Random random = new Random();
        for (Integer requestMemorySize : failedList) {
            Block current = list.head;

            if (requestMemorySize == current.getSize() && current.available) {//exact size
                current.available = false;
                current.setUsed(requestMemorySize);
                failedList.remove(requestMemorySize);
                System.out.println("success of requset---"+requestMemorySize);
                break;

            } else if (requestMemorySize < current.getSize() && current.available) {//need split
                //split the block
                split(current, requestMemorySize);
                current.available = false;
                failedList.remove(requestMemorySize);
                System.out.println("success of requset---"+requestMemorySize);
                break;

            } else {
                System.out.println("failed even after merge----"+requestMemorySize);
            }

        }
        System.out.println("LeftFailedRequest" + failedList.toString());
        return failedList;
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
