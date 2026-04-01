import java.util.*;

abstract class Cipher {
    abstract void encrypt(String text);
}

class CaesarCipher extends Cipher {
    void encrypt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result += (char)(ch + 3);
        }

        System.out.println("Encrypted Text = " + result);
    }
}

public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        CaesarCipher obj = new CaesarCipher();
        obj.encrypt(text);
    }
}