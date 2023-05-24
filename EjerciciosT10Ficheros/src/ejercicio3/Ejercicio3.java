package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int cont = 0;
        double altura = 0;
        int edades = 0;
        Scanner sc = null;
        try {
            File fichero = new File(".\\src/ejercicio3/Alumnos.txt");
            FileReader fr = new FileReader(fichero);
            sc = new Scanner(fr);
            while (sc.hasNext()){
                System.out.println(sc.next());
                edades += sc.nextInt();
                System.out.println(edades);
                altura += sc.nextDouble();
                System.out.println(altura);
                cont++;
            }
            edades /= cont;
            System.out.println("Edades =  " + edades);
            altura /= cont ;
            System.out.println("Alturas = " + altura);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}
