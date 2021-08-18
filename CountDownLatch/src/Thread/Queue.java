package Thread;

import WriteFile.WriteFile;

public class Queue {
    private int count;
    private int countThread;
    
    public Queue(int countThread){
        this.countThread = countThread;
    }

    public synchronized void put() throws InterruptedException {
        count++;
        if(count==2) {
            WriteFile.writeFileOutput("Đúng");
            System.out.println("Đúng");
            countThread++;
        }
    }

    public synchronized void countDown(){
        countThread--;
        if(countThread==0){
            WriteFile.writeFileOutput("Sai");
            System.out.println("Sai");

        }
    }
}
