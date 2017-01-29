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
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(7) + 1;

            Block block = new Block();
            Double value = pow(2, num);
            block.setSize(value.intValue());
            list.insert(block);
        }
        return list;

    }

    public void randomRequestBlock(BlockList list, int requestTimes) {
        Random random = new Random();
        for (int i = 0; i < requestTimes; i++) {
            int num = random.nextInt(128) + 1;
            System.out.println("-------------" + num);
            Block current = list.head;
            while (current.nextBlock != null) {
                
                if (num <= current.getSize()) {
                    if (current.available) {
                        current.available = false;
                        break;

                    }
                }
                current=current.nextBlock;

            }

        }

    }

}
