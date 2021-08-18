package Test;

import Thread.*;

public class Test {

    public static void main(String[] args) {

        final Queue queue = new Queue(3);
        Dad dad = new Dad(queue);
        Mom mom = new Mom(queue);
        UBND ubnd = new UBND(queue);

        new Thread(mom).start();
        new Thread(dad).start();
        new Thread(ubnd).start();

    }
}
