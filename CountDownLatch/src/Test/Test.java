package Test;

import Interface.IGetAgeProcessor;
import Interface.Impl.BaseGetAgeProcessor;
import Thread.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import WriteFile.WriteFile;

public class Test {

    public static void main(String[] args) {

        boolean check = false;

        final CountDownLatch latch = new CountDownLatch(3);
        final Queue queue = new Queue();
        Dad dad = new Dad(latch,queue);
        Mom mom = new Mom(latch,queue);
        UBND ubnd = new UBND(latch,queue);

        List<IGetAgeProcessor> arr = new ArrayList<>();
        arr.add(ubnd);
        arr.add(mom);
        arr.add(dad);

        new Thread(mom).start();
        new Thread(dad).start();
        new Thread(ubnd).start();

        while (latch.getCount()!=0) {
            if(queue.getCount()==2){
                check = true;
                while(latch.getCount()!=0){
                    latch.countDown();
                }
            }
        }
        
        // wait
        try {
            latch.await();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Output result.bin.......");
        if (check) {
            WriteFile.writeFileOutput("Đúng");
        } else {
            WriteFile.writeFileOutput("Sai");
        }

    }

}
