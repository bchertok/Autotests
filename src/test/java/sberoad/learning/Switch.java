package sberoad.learning;

import java.io.IOException;

public class Switch {
    public static void main(String[] args) throws IOException {
        char choice = (char) System.in.read();
do {
    System.out.println("vvedite drugoe znacheniye");
}
while (choice<25);


        for ( int i=0 ; i<13 ; i++ )
                     switch (i) {
             case 0:
             case 1:
             case 2:
                 break;
             case 3:
             case 4 :
                 System.out . println ( " i меньше 5") ;
                 break;
             case 5:
             case 6:
             case 7:
             case 8:
             case 9:
                 System.out . println ( " i меньше 10") ;
                 break;
             default :
             System.out . println ( " i равно или больше 10") ;

         }

        String str = "два";
        switch (str) {
            case "один" :
                System.out . println ( "oдин" );
                break;
            case "два" :
                System.out . println ( "двa" );
                break;
            case  "три" :
                System.out . println ( " тpи" );
                break;
            default:
            System.out.println( " нe совпало ) " );
            break;

        }

            int i;
            boolean done = false;
            i = 0;
            for ( ; ! done; ) {
                System.out.println ( " i равно " + i ) ;
                if ( i == 10) done = true ;
                i++ ;

            }}}
