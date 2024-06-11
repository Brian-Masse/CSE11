import java.math.BigInteger;

public class practice {


    public static void main (String[] args) {
        double t = 3.30e23;

        String s1 = new String("  suck my cock CSE11  ");
        
        String s = s1.trim();

        System.out.println( s );
        

        
        

    }

    public static String modify(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        return modify(str.substring(1)) + str.charAt(0);
    }

}