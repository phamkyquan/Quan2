package Interface.Impl;

import Thread.Queue;

public abstract class BaseGetAgeProcessor implements Runnable {

    private final Queue queue;
    private int ageResult;

    public BaseGetAgeProcessor(Queue queue) {
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
        }finally {
            queue.countDown();
        }
    }
    
    public abstract int getAgeOfQuan();

}
