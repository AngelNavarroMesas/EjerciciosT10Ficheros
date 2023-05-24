package ejercicio5;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        String nombre;
        int edad;
        Scanner sc = new Scanner(System.in);
        try {
            File fichero = new File(".\\src/ejercicio5/Datos.txt");
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Introduzca su nombre");
            nombre = sc.nextLine();
            System.out.println("Introduzca su edad");
            edad = sc.nextInt();
            if (!fichero.exists())
                fichero.createNewFile();
            bw.write(nombre + " " + edad);
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}
