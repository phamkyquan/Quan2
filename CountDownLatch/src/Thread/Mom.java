package Thread;

import Interface.Impl.BaseGetAgeProcessor;
import OpenFile.OpenFile;
import java.util.ArrayList;

public class Mom extends BaseGetAgeProcessor {

    public Mom(Queue queue) {
        super(queue);
    }

    @Override
    public int getAgeOfQuan() {
        try {
            ArrayList<String> a = OpenFile.openFile("D:\\NetBeans\\FILE\\Quan\\mom.dat");
            return OpenFile.calculateAge(a.get(2));
        } catch (Throwable ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
