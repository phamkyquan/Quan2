package Interface.Impl;

import Interface.IGetAgeProcessor;
import java.util.concurrent.CountDownLatch;

public abstract class BaseGetAgeProcessor implements Runnable, IGetAgeProcessor {

    private final CountDownLatch latch;
    private int ageResult;

    public BaseGetAgeProcessor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            ageResult = getAgeOfQuan();
            for(int i = 0 ; i<200;i++){
                System.out.println(i);
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        finally {
            if(latch.getCount()!=0){
                latch.countDown();
            }
        }



    }

    @Override
    public int getAge() {
        return this.ageResult;
    }

    public abstract int getAgeOfQuan();

}
