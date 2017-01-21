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
public class main {
    public static void main(String[] args){
        memoryPool mp = new memoryPool();
        
        
        for(int i=0;i<(int)(1+(Math.random()*100));i++){
            //随机生成100块
            int j = (int)(1+(Math.random()*10));//大小为[2^1,2^10]
            mp.addBlock(i);
        }
        
        Block mphead = mp.getHead();
        System.out.println("*****************************************************");
        System.out.println(mphead.next.size);
        System.out.println(mphead.next.next.size);
    }
}
