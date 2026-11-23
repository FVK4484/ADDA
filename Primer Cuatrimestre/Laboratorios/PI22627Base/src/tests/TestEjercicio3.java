package tests;

import org.jgrapht.Graph;

import ejercicio3.Ejercicio3;
import ejercicio3.Parentesco;
import ejercicio3.Persona;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class TestEjercicio3 {

	public static void main(String[] args) {
		testsEjercicio3("./resources/Ejercicio3/Ejercicio3_1.txt", "Antonio", "Elena", "Pablo");
		testsEjercicio3("./resources/Ejercicio3/Ejercicio3_2.txt", "Antonio", "Elena", "Pablo");
		testsEjercicio3("./resources/Ejercicio3/Ejercicio3_3.txt", "Antonio", "Elena", "Pablo");
	}
	
	public static void testsEjercicio3(String file, String persona, String p2, String parentesco) {
		
		Graph<Persona, Parentesco> g = GraphsReader.newGraph(file, 
    			Persona::ofFormat, 
    			Parentesco::ofFormat, 
    			Graphs2::simpleGraph);
		
		System.out.println("------------------------------------------------------------------");

		System.out.println("Archivo de entrada " + file + ".txt \n" + "Datos de entrada: " + g);

		
		System.out.println("Apartado A):");
		Ejercicio3.apartadoA(g);
		
//		System.out.println("Apartado B):");
//		Ejercicio3.apartadoB(g, Persona.ofFormat(persona.split(",")));
//		
//		System.out.println("Apartado C):");
//		Ejercicio3.apartadoC(g, Persona.ofFormat(persona.split(",")), Persona.ofFormat(p2.split(",")));
//		
//		System.out.println("Apartado D):");
//		Ejercicio3.apartadoD(g);
//		
//		System.out.println("Apartado E):");
//		Ejercicio3.apartadoE(g);
		
		System.out.println("------------------------------------------------------------------");
		
	}

}
