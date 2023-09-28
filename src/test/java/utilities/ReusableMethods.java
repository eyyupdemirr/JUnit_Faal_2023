package utilities;

public class ReusableMethods {


    public static void bekle(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }






}
