import com.javamike.opt.ClientOpt;
import com.javamike.opt.MorphiaOpt;

/**
 * @author huangh
 * @date 2019-07-06 16:45
 * @email huangh@lerongsoft.com
 * @desc
 */
public class Main {

    public static void main(String[] args) {

        try {

//            ClientOpt clientOpt = new ClientOpt();
//
//            //Ôö
//            clientOpt.add();
//
//            //²é
//            clientOpt.query();
//
//            //ÐÞ
//            clientOpt.update();
//
//            //É¾
//            clientOpt.delete();

            MorphiaOpt morphiaOpt = new MorphiaOpt();
            morphiaOpt.query();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
