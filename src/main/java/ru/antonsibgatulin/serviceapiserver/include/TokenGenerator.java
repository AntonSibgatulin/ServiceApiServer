package ru.antonsibgatulin.serviceapiserver.include;

import ru.antonsibgatulin.serviceapiserver.user.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class TokenGenerator {

    public static String generateTokenBy(User user){
        String src = time()+"ARAARASAOYNARA"+(time() / rand(0, 10000))+"SATESATESATE"+ (time())+user.getLogin()+"OMAI"+user.getUserId();
        byte[] array = Base64.getEncoder().encode(src.getBytes(StandardCharsets.UTF_8));

        return new String (array);
    }


    public static long time(){
        return System.currentTimeMillis();
    }
    public static int rand(int min,int max){

        if(max<min)
        {
            int j = max;
            max = min;
            min = j;

        }else if(max==min){
            min-=1;
        }
        return min+new Random().nextInt(max-min);
    }

}
