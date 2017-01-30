/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course6205.memoryblock;

import java.util.ArrayList;
import java.util.List;

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
        list.sortBlock();
        list.setAddress();
        list.printList();

//        memoryPool.randomRequestBlockWithoutSplit(list, 5);
        ArrayList failedRequest = memoryPool.randomRequestBlockWithSplitReturnByFailedRequest(list);
        list.printList();
        list.sortBlockByAvai();
        list.printList();

        list.mergeFragBlock();
        list.printList();
        System.out.println("failedRequest" + failedRequest.toString());
        failedRequest = memoryPool.requestAfterMerge(list, failedRequest);
        list.setAddress();

        list.printList();

    }

}
