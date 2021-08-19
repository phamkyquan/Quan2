package Test;

import Interface.IGetAgeProcessor;
import Thread.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import WriteFile.WriteFile;
import WriteFile.WriteFile;
import com.sun.source.tree.WhileLoopTree;

public class Test {

    public static void main(String[] args) {

        int count = 0;
        boolean check = false;

        final CountDownLatch latch = new CountDownLatch(3);
        Dad dad = new Dad(latch);
        Mom mom = new Mom(latch);
        UBND ubnd = new UBND(latch);

        List<IGetAgeProcessor> arr = new ArrayList<>();
        arr.add(dad);
        arr.add(mom);
        arr.add(mom);

        new Thread(dad).start();
        new Thread(mom).start();
        new Thread(ubnd).start();


        // Kiem tra xem co 2 ket qua dung thi countDown ve 0 de chay tiep luong main in ra ket qua
        while (latch.getCount()!=0){
            count = 0;
            for (IGetAgeProcessor processor : arr) {
                if (processor.getAge() == 21) {
                    count++;
                    if(count==2) {
                        check = true;
                        while (latch.getCount() != 0) { // Lap lai lien tuc de count ve 0
                            latch.countDown();
                        }
                    }
                }
            }
        }

        // wait
        try {
            latch.await();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }


        // In ket qua ra file result.bin
        if(check){
            WriteFile.writeFileOutput("Đúng");
        }
        else{
            WriteFile.writeFileOutput("Sai");
        }

    }

}
