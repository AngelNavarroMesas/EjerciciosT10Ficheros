package ejercicio8;

import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {
	
    public static void main(String[] args) {
    	Scanner sc = null;
        File fichero = new File("src/ejercicio8/Tiempo.txt");
        String fecha;
        double max, min;
        String cabecera, linea;
        String[] info;
        double max2 = 0, min2 = 999999999;
        int opc = 0;
        
        
        while (opc != 3){
            sc = new Scanner(System.in);
            System.out.println("1.Registra nueva temperatura");
            System.out.println("2.Mostrar historial de registros");
            System.out.println("3.Salir");
            System.out.println();
            opc = sc.nextInt();
            sc.nextLine();
            
            
            switch (opc){
                case 1:
                	try {
                        if (!fichero.exists()) {
                            fichero.createNewFile();
                        }
                        FileWriter fw = new FileWriter(fichero, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        System.out.println("Introduzca la fecha");
                        fecha = sc.next();
                        sc.nextLine();
                        System.out.println("Introduzca la temperatura máxima");
                        max = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduzca la temperatura mínima");
                        min = sc.nextDouble();
                        sc.nextLine();
                        bw.write(fecha+","+max+","+min);
                        bw.flush();
                        bw.newLine();
                        bw.close();
                        fw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                    
                case 2:
                	try {
                        FileReader fr = new FileReader(fichero);
                        BufferedReader br = new BufferedReader(fr);
                        
                        sc = new Scanner(br);
                        cabecera = sc.nextLine();
                        System.out.println(cabecera);
                        
                        while (sc.hasNext()){
                            linea = sc.nextLine();
                            info = linea.split(",");
                            System.out.println(info[0]+","+info[1]+","+info[2]);
                            System.out.println();
                            if (Double.parseDouble(info[1])>max2)
                                max2 = Double.parseDouble(info[1]);
                            if (Double.parseDouble(info[2])<min2)
                                min2 = Double.parseDouble(info[2]);
                        }
                        
                        System.out.println("Temperatura maxima: "+max2);
                        System.out.println("Temperatura minima: "+min2);
                        System.out.println();
                        br.close();
                        fr.close();
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 3:
                    break;
                default:
                    System.out.println("Elija una de las tres opciones");
            }
        }
        sc.close();
    }
}