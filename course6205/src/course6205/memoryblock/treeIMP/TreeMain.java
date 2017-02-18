/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author GladysWang
 */
public class TreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        MemoryPool pool = MemoryPool.getInstance();
//        pool.showMemoryBlocks();
//        pool.requestMemoryBlock(pool.generateRequest());
        BlockBT bbt = new BlockBT();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            int num = random.nextInt(64) + 1;
            System.out.print(num + " ");
            list.add(num);
        }
        System.out.println("************************* ");
        bbt.depthOrderRequest(list);
        bbt.levelOrderTraversalLayer();
        System.out.println("");

    }

}
