/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import WriteFile.WriteFile;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC1
 */
public class Queue extends Thread {

    private int dem;

    public synchronized void put() {
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
        }
        if (dem == 2) {
            System.out.println("Output result.bin....");
            WriteFile.writeFileOutput();
        }
    }

}
