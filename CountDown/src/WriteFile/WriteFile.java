/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WriteFile;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author PC1
 */
public class WriteFile {
    
    public static void writeFileOutput(String str) {
        FileWriter outFile;
        PrintWriter out;
        try {
            outFile = new FileWriter("D:\\NetBeans\\FILE\\Quan\\result.bin");
            out = new PrintWriter(outFile);
            out.write(str);
            System.out.println("Output result.bin.......");
            out.close();
            outFile.close();
        } catch (Exception e) {
        }
    }
}
