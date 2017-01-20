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
public class Block {
    
    private Double size;
    private String address;//start with zero,next address should add size of previous one

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
        System.out.println(""+size);
    }
    
    

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
