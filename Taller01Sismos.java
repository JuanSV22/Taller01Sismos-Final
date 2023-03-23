import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Taller01Sismos {
    public static void main(String[] args) {
        System.out.println("main");
        double[] listaDeSismos = ingresarDatos(5);
        System.out.println(Arrays.toString(listaDeSismos));
        String[] testString = {"aea","vdd","tht"};
        System.out.println(Menu(testString));
    }
    public static double[] ingresarDatos(int cantidad) {
        Random random = new Random();
        System.out.println("ingresarDatos");
        return random.doubles(cantidad).toArray();
    }
    public static int buscarMayorSismo(double[] sismos) {
        System.out.println("buscarMayorSismo");
        return 2;
    }
    public static int contarSismos(double[] sismos) { //Retorna cantidad de sismos cuya magnitud es mayor o igual a 5.0.
        System.out.println("contarSismos");
        return 2;
    }
    public static void enviarSMS(double[] sismos){ //Enviar SMS por cada sismo mayor a 7.0.
        System.out.println("enviarSMS");
    }

    public static int Menu(String[] choices){
        System.out.println("Elije una opcion:");
        int indX = 1;
        for (String i : choices) {
            System.out.print(indX + ". ");
            indX++;
            System.out.println(i.toString());
        }
        Scanner SCAN = new Scanner(System.in);
        int choice = -1;
        do {
            choice = SCAN.nextInt();
        } while (choice >= choices.length || choice < 1);
        return choice - 1;
    }
    public static void salir(){
        System.out.println("salir");
    }
}
