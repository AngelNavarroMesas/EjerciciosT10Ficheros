package ejercicio4;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        String linea;
        Scanner sc = new Scanner(System.in);
        try {
            File fichero = new File(".\\src/ejercicio4/TextoEscrito.txt");
            FileWriter fr = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fr);
            linea = sc.nextLine();
            while (!linea.equals("fin")){
                bw.write(linea);
                bw.flush();
                bw.newLine();
                linea = sc.nextLine();
            }
            bw.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}