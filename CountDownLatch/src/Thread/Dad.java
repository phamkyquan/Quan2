package Thread;

import Interface.Impl.BaseGetAgeProcessor;
import OpenFile.OpenFile;
import java.util.ArrayList;

public class Dad extends BaseGetAgeProcessor {

    public Dad(Queue queue) {
        super(queue);
    }

    @Override
    public int getAgeOfQuan() {
        try {
            ArrayList<String> a = OpenFile.openFile("D:\\NetBeans\\FILE\\Quan\\dad.dat");
            return Integer.parseInt(a.get(1));
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
