package utils;

public class Utils {
    public static String formatToken(String token){
        if(token.startsWith("Bearer ")){
            return token.substring(7,token.length());
        }else return token;
    }
}
