import java.util.*;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a;
        boolean b = false;
        boolean c = false;
        boolean g = true;


        for (int i = 0; n != 0; i++) {

            a = n;
            n = scanner.nextInt();
            if ((a>n) && (b==true) && (n != 0)){
                b = false;
                g = false;
            }

            if ((n==0) && (i!=0)) {

                break;
            }
            if ((n==0) && (i==0)){
                b = true;
                break;
            }

            if ((n >= a) && (g != false))  {
                b = true;
                c = true;

            }
            else if ((n < a) && (c==true)) {
                b = false;

            } else if (n < a)  {
                b = true;

            }

            else {
                b = false;
            }

        } System.out.println(b);

    }
}