/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import WriteFile.WriteFile;

/**
 *
 * @author PC1
 */
public class Queue extends Thread {

    private int dem;
    private int sum;
    
    public void putSum(){
        sum++;
    }

    public synchronized void put() throws InterruptedException {
        if(dem==2){
            wait();
        }
        dem++;
        notifyAll();
    }

    @Override
    public void run() {
        while (dem != 2) {
            try {
                wait();
            } catch (Exception ex) {
            }
            if (sum == 3) {
                break;
            }
        }
        if(dem == 2) {
            System.out.println("Output result.bin....");
            WriteFile.writeFileOutput();
        }
        else System.out.println("Sai");
    }

}