/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import java.util.Random;

/**
 *
 * @author GladysWang
 */
public class MemoryPool {

    public void showMemoryBlocksInPreOrder() {
        BlockBT mp = new BlockBT();
        mp.printTreeInPreOrder();

    }

    public void showRequest() {
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
            int num = random.nextInt(64) + 1;
            System.out.print(num+" ");
        }
    }
    
    
    
    
    
    
    
    
    

}
