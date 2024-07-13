package utils;
import java.util.Random;


// Sau này khi improve sẽ sài stringbuider sau
public class RandomString {

    public static String getRandomString(){
        int length = 5;
        Random random = new Random();
        String format = "ABCDEFGHIJKMNOPWYZQqwertyuiopasdfghjklzxcbvmbn123456789";
        String randomString = "";
        for(int i = 0; i < length; i++){
            randomString = randomString + format.charAt(random.nextInt(format.length()-1));
        }

        return randomString;
    }



}
