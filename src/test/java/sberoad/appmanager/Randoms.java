package sberoad.appmanager;

import java.security.SecureRandom;


public class Randoms {


    private static final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static SecureRandom rnd = new SecureRandom();
    private static final String number = "0123456789";

  public String randomString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( character.charAt( rnd.nextInt(character.length()) ) );
        return sb.toString();
    }
    public String randomBarcodeCrash () {
       int len1= rnd.nextInt(80);
        StringBuilder sb = new StringBuilder( len1 );
        for( int i = 0; i < len1; i++ )
            sb.append( number.charAt( rnd.nextInt(number.length()) ) );
        return sb.toString();
    }

   public String randomNumber (int len) {

        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( number.charAt( rnd.nextInt(number.length()) ) );
        return sb.toString();
    }

}
