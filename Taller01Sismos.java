import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.DoubleSummaryStatistics; //a

public class Taller01Sismos {
    public static void main(String[] args) {
        boolean In = true;
        System.out.println("main");
        double[] listaDeSismos = ingresarDatos(100);
        System.out.println(Arrays.toString(listaDeSismos));
        String[] menuString = {"Buscar el mayor sismo.","Contar sismos de magnitud igual o superior a 5.0.","Enviar SMS con cantidad de sismos de magnitud igual o superior a 7.0.", "Salir."};
        while (In) {
            switch (Menu(menuString)) {
                case 0 ->
                        System.out.println("El sismo mas fuerte registrado en esta sesion ha tenido una intensidad de: " + buscarMayorSismo(listaDeSismos) + " ML.\n");
                case 1 ->
                        System.out.println("La cantidad de sismos cuya magnitud ha sido mayor a 5.0 es: " + contarSismos(listaDeSismos) + "\n");
                case 2 -> enviarSMS(listaDeSismos);
                case 3 -> In = salir();
            }
        }
    }
    public static double[] ingresarDatos(int cantidad) {
        Random random = new Random();
        System.out.println("ingresarDatos");
        return random.doubles(cantidad, 0.0, 10.0).toArray();
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
        for (double seism: sismos) {
            if (seism >= 7.0) {
                System.out.println("\033[3mAlerta!!! se debe evacuar zona costera!\033[0m\nSismo de magnitud: \033[1m" + seism + "!\033[0m");
            }
        }
    }

    public static int Menu(String[] choices){
        System.out.println("Elije una opcion:");
        int indX = 1;
        for (String i : choices) {
            System.out.print(indX + ". ");
            indX++;
            System.out.println(i);
        }
        Scanner SCAN = new Scanner(System.in);
        int choice;
        do {
            System.out.print("> ");
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
