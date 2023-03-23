import java.util.Random;
import java.util.stream.DoubleStream;

public class Taller01Sismos {
    public static void main(String[] args) {
        System.out.println("main");
    }
    public static DoubleStream ingresarDatos(int cantidad) {
        Random random = new Random();
        System.out.println("ingresarDatos");
        return random.doubles(2);
    }
    public static int buscarMayorSismo(DoubleStream sismos) {
        System.out.println("buscarMayorSismo");
        return 2;
    }
    public static int contarSismos(DoubleStream sismos) { //Retorna cantidad de sismos cuya magnitud es mayor o igual a 5.0.
        System.out.println("contarSismos");
        return 2;
    }
    public static void enviarSMS(DoubleStream sismos){
        System.out.println("enviarSMS");
    }
    public static void salir(){
        System.out.println("salir");
    }
}
