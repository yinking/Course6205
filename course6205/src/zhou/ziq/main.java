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
        Block mphead = mp.getHead();
        
        for(int i=0;i<(int)(1+(Math.random()*100));i++){
            //随机生成100块
            int j = (int)(1+(Math.random()*10));//大小为[2^1,2^10]
            mp.addBlock(j);
        }
        
        
        System.out.println("*****************************************************");
        Block f;
        while(mphead.next!=null){
            f=mphead.next;
            System.out.println(f.size);
            f=f.next;

        }
    
    }
}
