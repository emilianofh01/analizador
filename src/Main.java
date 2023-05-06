import java.util.Arrays;
import java.util.List;

public class Main {
    static String cadena = "(i+i+i)";
    static int pos = 0;
    static boolean onError = false;

    public static void main(String[] args) {

        E();
        if (!onError && pos == cadena.length()) {
            System.out.println("La cadena es valida");
        } else {
            System.out.println("La cadena es invalida");
        }
    }

    static void E() {
        T();
        while (pos < cadena.length() && cadena.charAt(pos) == '+') {
            pos++;
            T();
        }
    }

    static void T() {
        F();
        while (pos < cadena.length() && cadena.charAt(pos) == '*') {
            pos++;
            F();
        }
    }

    static void F() {
        if (pos < cadena.length() && cadena.charAt(pos) == '(') {
            pos++;
            E();
            if (pos < cadena.length() && cadena.charAt(pos) == ')') {
                pos++;
            } else {
                onError = true;
            }
        } else if (pos < cadena.length() && cadena.charAt(pos) == 'i') {
            pos++;
        } else {
            onError = true;
        }
    }
}
