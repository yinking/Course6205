/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryblock;

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
        memoryPool.initBlock();
        System.out.println("*****************");

        memoryPool.sortBlock();

    }

}
