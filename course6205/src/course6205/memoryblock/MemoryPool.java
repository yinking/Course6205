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
            int num = random.nextInt(5)+1;

           Block block = new Block();
            block.setSize(pow(2, num));
            list.insert(block);
        }
        return list;

    }

    

}
