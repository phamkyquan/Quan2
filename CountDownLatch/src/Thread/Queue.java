package Thread;

import WriteFile.WriteFile;

public class Queue implements Runnable {
    private int count;
    private int countThread;
    
    public Queue(int countThread){
        this.countThread = countThread;
    }

    public synchronized void put() throws InterruptedException {
        if(count!=2){
            count++;
        }
        else{
            notifyAll();
            wait();
        }
    }
    
    public synchronized void countDown(){
        countThread--;
        if(countThread==0){
            notifyAll();
        }
        
    }

    public synchronized void result(){
        if(count==2){
            WriteFile.writeFileOutput("Đúng");
            System.out.println("Đúng");
        }
        else {
            WriteFile.writeFileOutput("Sai");
            System.out.println("Sai");
        }
        if(countThread!=0){
            notifyAll();
        }
    }

    public synchronized void waiting() throws InterruptedException {
        wait();
    }

    @Override
    public void run() {
        try {
            waiting();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result();

    }
}
