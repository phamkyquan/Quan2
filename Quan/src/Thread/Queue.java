/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import WriteFile.WriteFile;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author PC1
 */
public class Queue {

    private int dem = 0;
    
    public synchronized void putDem() {
        dem++;
        if (dem == 2) {
            System.out.println("Output result.bin....");
            WriteFile.writeFileOutput();
        }
    }

    public void end(){ 
        if(dem < 2){
            System.out.println("Sai");
        }
    }
}
