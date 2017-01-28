/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock;

/**
 *
 * @author GladysWang
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MemoryPool memoryPool = MemoryPool.getInstance();
        BlockList list = memoryPool.initBlock();
        list.printList();
        list.size();
//        memoryPool.sortBlock();
        list.sortBlock();
        list.setAddress();

        list.printList();

    }

}
