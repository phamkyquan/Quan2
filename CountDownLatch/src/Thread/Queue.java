/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

/**
 *
 * @author PC1
 */
public class Queue {
    private int count;
    
    public int getCount(){
        return count;
    }
    
    public synchronized void put(){
        count++;
    }
}
