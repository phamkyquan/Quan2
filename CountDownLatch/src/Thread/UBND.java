
package Thread;

import Interface.Impl.BaseGetAgeProcessor;
import OpenFile.OpenFile;
import java.text.ParseException;
import java.util.ArrayList;

public class UBND extends BaseGetAgeProcessor {

    public UBND(Queue queue) {
        super(queue);
    }

    @Override
    public int getAgeOfQuan() {
        try {
            ArrayList<String> a = OpenFile.openFile("D:\\NetBeans\\FILE\\Quan\\UBND.dat");
            return OpenFile.calculateAge(a.get(5));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
