/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhou.ziq;

/**
 *
 * @author GladysWang
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pool memoryPool = Pool.getInstance();
        BlockList list = memoryPool.initBlock();
        list.printList();
        list.size();
        list.sortBlock();
        list.setAddress();
        list.printList();
        
        memoryPool.randomRequestBlock(list, 5);

        list.printList();
        
        System.out.println("zhou.ziq.main.main()");
    }

}
