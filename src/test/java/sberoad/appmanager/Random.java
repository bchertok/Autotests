package sberoad.appmanager;

public class Random {

    public char randomchar()
    {
        char rc = (char) ((char)('A' + new java.util.Random().nextInt(26))+(char)('A' + new java.util.Random().nextInt(26)));
        return rc;
    }
}
