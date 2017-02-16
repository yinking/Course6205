/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock.treeIMP;

import course6205.memoryblock.listIMP.*; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GladysWang
 */
public class TreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MemoryPool pool=new MemoryPool();
        pool.showMemoryBlocksInPreOrder();
        pool.showRequest();

    }

}
