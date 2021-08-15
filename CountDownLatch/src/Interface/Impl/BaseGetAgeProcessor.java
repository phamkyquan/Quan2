package Interface.Impl;

import Interface.IGetAgeProcessor;
import Thread.Queue;
import java.util.concurrent.CountDownLatch;

public abstract class BaseGetAgeProcessor implements Runnable, IGetAgeProcessor {

    private final CountDownLatch latch;
    private final Queue queue;
    private int ageResult;

    public BaseGetAgeProcessor(CountDownLatch latch, Queue queue) {
        this.latch = latch;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            ageResult = getAgeOfQuan();
            if (ageResult == 21) {
                queue.put();
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    @Override
    public int getAge() {
        return ageResult;
    }
    
    public abstract int getAgeOfQuan();

}
