package tests;

import java.util.Set;
import org.jgrapht.Graph;

import ejercicio3.Ejercicio3;
import ejercicio3.Parentesco;
import ejercicio3.ParentescoEnumerado;
import ejercicio3.Persona;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class TestEjercicio3 {

    public static void main(String[] args) {
    	
        testsEjercicio3("resources/Ejercicio3/Ejercicio3_1.txt", "1", "Javier", "Lucía", "Pablo");
        testsEjercicio3("resources/Ejercicio3/Ejercicio3_2.txt", "2", "Diego", "Lucía", "Diego");
        testsEjercicio3("resources/Ejercicio3/Ejercicio3_3.txt", "3", "Daniel", "Javier", "José");
        
    }
    
    private static Persona buscarPersona(Graph<Persona, Parentesco> g, String nombre) {
        return g.vertexSet().stream()
                .filter(p -> p.nombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe la persona: " + nombre));
    }

    public static void testsEjercicio3(String file, String sufijo, String nombreB, String nombreC1, String nombreC2) {
 
        Graph<Persona, Parentesco> g = GraphsReader.newGraph(
                file,
                Persona::ofFormat,
                Parentesco::ofFormat,
                Graphs2::simpleDirectedGraph);

        System.out.println("==================================================================");
        System.out.println("Archivo de entrada: " + file);

        // --- APARTADO A ---
        System.out.println("\nApartado A):");
        Graph<Persona, Parentesco> vistaA = Ejercicio3.apartadoA(g);
        System.out.println("Personas de la vista: " + vistaA.vertexSet());
        Ejercicio3.mostrarGrafoApartadoA(g, vistaA, "out/Ejercicio3_" + sufijo + "_A.gv");

        // --- APARTADO B ---
        System.out.println("\nApartado B):");
        Persona pB = buscarPersona(g, nombreB);
        Set<Persona> ancestros = Ejercicio3.apartadoB(g, pB);
        System.out.println("Ancestros de " + pB + ": " + ancestros);
        Ejercicio3.mostrarGrafoApartadoB(g, pB, ancestros, "out/Ejercicio3_" + sufijo + "_B.gv");

        // --- APARTADO C ---
        System.out.println("\nApartado C):");
        Persona p1 = buscarPersona(g, nombreC1);
        Persona p2 = buscarPersona(g, nombreC2);
        ParentescoEnumerado rel = Ejercicio3.apartadoC(g, p1, p2);
        System.out.println(p1 + " y " + p2 + ": " + rel);

        // --- APARTADO D ---
        System.out.println("\nApartado D):");
        Set<Persona> d = Ejercicio3.apartadoD(g);
        System.out.println("Personas con hijos con distintas personas: " + (d.isEmpty() ? "No hay" : d));
        Ejercicio3.mostrarGrafoApartadoD(g, d, "out/Ejercicio3_" + sufijo + "_D.gv");

        // --- APARTADO E ---
        System.out.println("\nApartado E):");
        Set<Persona> e = Ejercicio3.apartadoE(g);
        System.out.println("Conjunto mínimo (" + e.size() + "): " + e);
        Ejercicio3.mostrarGrafoApartadoE(g, e, "out/Ejercicio3_" + sufijo + "_E.gv");

        System.out.println("==================================================================\n");
    }
}