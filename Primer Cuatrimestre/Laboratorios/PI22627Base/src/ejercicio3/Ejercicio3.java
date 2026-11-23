package ejercicio3;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.views.SubGraphView;

public class Ejercicio3 {

    public static Graph<Persona, Parentesco> apartadoA(Graph<Persona, Parentesco> g) {
    	Predicate<Persona> pv = pv -> {
    		Set<Parentesco> aristas = g.incomingEdgesOf(pv);
    		if (aristas.size() != 2) {
    			return false;
    		}
    		List<Personas> padres = g.
    	};
    	Predicate<Parentesco> pe = pe -> ;
    	Graph<Persona, Parentesco> vista = SubGraphView.of(g, pv, pe);
    	mostrarGrafoApartadoA(g, vista, ".resources/Ejercicio3/Ejercicio3_1.txt");
    	return g;
    }

    public static void mostrarGrafoApartadoA(Graph<Persona, Parentesco> g, Graph<Persona, Parentesco> vista, String file) {
    	System.out.println(vista);
    	return;
    }

    public static Set<Persona> apartadoB(Graph<Persona, Parentesco> g, Persona persona) {
        // TODO: completar.
        return null;
    }

    public static void mostrarGrafoApartadoB(Graph<Persona, Parentesco> g, Persona persona,
            Set<Persona> ancestros, String file) {
        // TODO: completar.
    }

    public static ParentescoEnumerado apartadoC(Graph<Persona, Parentesco> g, Persona p1, Persona p2) {
        // TODO: completar.
        return null;
    }

    public static Set<Persona> apartadoD(Graph<Persona, Parentesco> g) {
        // TODO: completar.
        return null;
    }

    public static void mostrarGrafoApartadoD(Graph<Persona, Parentesco> g, Set<Persona> personas, String file) {
        // TODO: completar.
    }

    public static Set<Persona> apartadoE(Graph<Persona, Parentesco> g) {
        // TODO: completar.
        return null;
    }

    public static void mostrarGrafoApartadoE(Graph<Persona, Parentesco> g, Set<Persona> personas, String file) {
        // TODO: completar.
    }
}
