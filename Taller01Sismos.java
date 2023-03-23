import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.DoubleSummaryStatistics;

public class Taller01Sismos {
    public static void main(String[] args) {
        boolean In = true;
        System.out.println("main");
        double[] listaDeSismos = ingresarDatos(5);
        System.out.println(Arrays.toString(listaDeSismos));
        String[] menuString = {"Buscar el mayor sismo.","Contar sismos de magnitud igual o superior a 5.0.","Enviar sismos con cantidad de sismos de magnitud igual o superior a 7.0.", "Salir."};
        while (In) {
            switch (Menu(menuString)) {
                case 0:
                    System.out.println("El sismo mas fuerte registrado en esta sesion ha tenido una intensidad de: " + buscarMayorSismo(listaDeSismos) + " ML.");
                    break;
                case 1:
                    contarSismos(listaDeSismos);
                    break;
                case 2:
                    enviarSMS(listaDeSismos);
                    break;
                case 3:
                    In = salir();
                    break;
            }
        }
    }
    public static double[] ingresarDatos(int cantidad) {
        Random random = new Random();
        System.out.println("ingresarDatos");
        return random.doubles(cantidad).toArray();
    }
    public static double buscarMayorSismo(double[] sismos) {
        DoubleSummaryStatistics stats = Arrays.stream(sismos).summaryStatistics();
        return stats.getMax();
    }
    public static int contarSismos(double[] sismos) { //Retorna cantidad de sismos cuya magnitud es mayor o igual a 5.0.
        int cantidad = 0;
        for (double seism: sismos) {
            if (seism >= 7.0) {
                cantidad++;
            }
        }
        return cantidad;
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
        } while (choice >= choices.length + 1 || choice < 1);
        return choice - 1;
    }
    public static boolean salir(){
        String[] options = {"Si.","No."};
        boolean[] options_ = {false,true};
        return options_[Menu(options)];
    }
}
