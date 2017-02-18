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
        //address
        bbt.levelOrderTraversalSetAddress();
        //generate request
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        System.out.println("*Requests are:*");
        int totalRquest = 0;
        for (int i = 1; i <= 8; i++) {
            int num = random.nextInt(64) + 1;
            System.out.print(num + " ");
            list.add(num);
            totalRquest += num;
        }
        System.out.println("");
        System.out.println("************************* ");

        System.out.println("totalRequest:" + totalRquest);
        System.out.println("************************* ");
        //request
        ArrayList<Integer> failedOnes = bbt.depthOrderRequest(list);
        for (Integer request : failedOnes) {
            totalRquest -= request;
        }
        System.out.println("total Suceess Request:" + totalRquest);
        bbt.levelOrderTraversalLayer();
        //calculate defragment
        bbt.printTotalUsed();
        System.out.println("");
        bbt.printDefragment();

    }

}
