import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        Integer obj = Integer.valueOf(number);
        System.out.println("Wrapper Object = " + obj);

        sc.nextLine();

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String str = text;
        str.concat(" Java");

        StringBuffer sb = new StringBuffer(text);
        sb.append(" Java");

        System.out.println("String Output = " + str);
        System.out.println("StringBuffer Output = " + sb);
    }
}