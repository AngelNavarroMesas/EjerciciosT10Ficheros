package ejercicio7;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio7 {
    public static void main(String[] args) {
        int opc = 0;
        String nombre;
        int telefono;
        TreeMap<String, Integer> agenda = new TreeMap<>();
        Scanner sc = null;
        
        try {
            File fichero = new File("src/ejercicio7/Agenda.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            sc = new Scanner(br);
            
            if (fichero.exists()) {
                while (sc.hasNext()){
                    nombre = sc.next();
                    telefono = sc.nextInt();
                    agenda.put(nombre, telefono);
                }
            } else {
            	fichero.createNewFile();
            }
            
            sc = new Scanner(System.in);
            while (opc != 4) {
                System.out.println("1.Nuevo contacto");
                System.out.println("2.Buscar por nombre");
                System.out.println("3.Mostrar todos");
                System.out.println("4.Salir");
                opc = sc.nextInt();
                
                switch (opc) {
                    case 1:
                        int cont = 0;
                        boolean encontrado = false;
                        
                        for (int i = 0; i < agenda.size(); i++) {
                            cont++;
                        }
                        
                        if (cont == 20) {
                            System.out.println("No queda espacio en la agenda");
                        } else {
                            System.out.println("Introduzca el nombre del nuevo contacto");
                            sc.nextLine();
                            nombre = sc.nextLine();
                            System.out.println("Introduzca el número de telefono del nuevo contacto");
                            telefono = sc.nextInt();
                            sc.nextLine();
                            if (agenda.containsValue(nombre)) {
                            	encontrado = true;
                            }
                            if (!encontrado && cont < 20) {
                                agenda.put(nombre, telefono);
                            }
                        }
                        
                        break;
                        
                    case 2:
                        System.out.println("Introduzca el nombre del contacto a buscar");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        
                        if (agenda.containsKey(nombre)) {
                            System.out.println("Su telefono es: "+agenda.get(nombre));
                        }
                        
                        break;
                    case 3:
                    	
                        if (agenda.isEmpty()) {
                            System.out.println("La agenda esta vacia");
                        } else {
                            for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
                                System.out.println("" + entry.getKey()+" "+entry.getValue());
                            }
                        }
                        
                        break;
                    case 4:
                    	
                        FileWriter fw = new FileWriter(fichero, false);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
                            bw.write(("" + entry.getKey()+" "+entry.getValue()));
                            bw.newLine();
                        }
                        
                        bw.flush();
                        bw.close();
                        fw.close();
                        break;
                        
                    default:
                        System.out.println("Elija una de las cuatro opciones");
                }
            }
            br.close();
            fr.close();
            sc.close();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        	
        }
    }

}