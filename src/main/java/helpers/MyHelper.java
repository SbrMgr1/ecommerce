package helpers;

public class MyHelper {

    public static long getRandomInt(){
        long leftLimit = 1L;
        long rightLimit = 10L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

}
