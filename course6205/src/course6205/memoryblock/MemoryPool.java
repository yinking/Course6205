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
    private ArrayList<Block> listBlock;

    public void initBlock() { //ramdom generate different blocks
        //size should be 2, 4, 8, 16 a single power of 2
        listBlock = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(5) + 5;

            Block block = new Block();
            block.setSize(pow(2, num) );
            listBlock.add(block);
        }

    }

    public void sortBlock() { //blocksize from lowest to highest
        // Sorting
        Collections.sort(listBlock, new Comparator<Block>() {
            @Override
            public int compare(Block block1, Block block2) {

                return (int) (block1.getSize()- block2.getSize());
            }
        });
        
        for(Block b:listBlock){
            System.out.println(""+b.getSize());
        }
    }

}
