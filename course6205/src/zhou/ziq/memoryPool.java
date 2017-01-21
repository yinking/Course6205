/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhou.ziq;

/**
 *
 * @author Chau_
 */
public class memoryPool {

    private Block head;//head node 

    /**
     * constructor:insert at rear,return head node
     */
    public memoryPool() {
        head = new Block();
        head.next=null;
    }

    public Block getHead() {
        return head;
    }

    public void setHead(Block head) {
        this.head = head;
    }

    public void addBlock(int size) {
        Block p, t;//p is inserted node
        t=head;//t is trailer
        while(t.next!=null){
            t=t.next;
        }
        p = new Block();
        p.size = size;//set size
        p.next = null;
        t.next = p;//t ref h,so t.next = h.next = p
        t = p;//move t to the rear of the list
    }

}
