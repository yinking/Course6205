/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author GladysWang
 */
public class MemoryPool {

    private static MemoryPool memoryPool;
    private static BlockBT bbt;

    public static MemoryPool getInstance() {
        memoryPool = new MemoryPool();
        return memoryPool;
    }

    public void showMemoryBlocks() {
        bbt = new BlockBT();
        bbt.levelOrderTraversalSetAddress(6);

    }

    public ArrayList<Integer> generateRequest() {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            int num = random.nextInt(64) + 1;
            System.out.print(num + " ");
            list.add(i);
        }
        return list;
    }
    
    public void requestMemoryBlock(ArrayList<Integer> list){
        bbt.depthOrderRequest(list);
        bbt.levelOrderTraversalLayer();
    }
    
    

}
