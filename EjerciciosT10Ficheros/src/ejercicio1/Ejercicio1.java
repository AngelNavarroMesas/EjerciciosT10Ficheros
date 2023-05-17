package ejercicio1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		double media=0;
		int i=0;
		try {
			File f = new File(".\\src\\ejercicio1\\NumerosReales.txt");
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			
			while(sc.hasNext()) {
				media +=sc.nextDouble();
				i++;
			}
			System.out.println("La suma total de los numeros es "+media);
			media/=i;
			System.out.println("La media aritmetica de los numeros es "+media);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		}
	}
}
