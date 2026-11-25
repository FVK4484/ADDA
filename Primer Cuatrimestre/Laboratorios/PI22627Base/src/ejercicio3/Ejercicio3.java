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
	
	public static List<Persona> getPadres(Graph<Persona, Parentesco> g, Persona p) {
		return g.incomingEdgesOf(p).stream()
				.map(g::getEdgeSource)
				.toList();
	}

    public static Graph<Persona, Parentesco> apartadoA(Graph<Persona, Parentesco> g) {
    	Predicate<Persona> pv = p -> {
    		List<Persona> padres = getPadres(g, p);
    		if (padres.size() != 2) {
    			return false;
    		} 
    		Persona p1 = padres.get(0);
    		Persona p2 = padres.get(1);
    		return p1.ciudad().equals(p2.ciudad()) && p1.nacimiento().equals(p2.nacimiento());
    	};
    	
    	Predicate<Parentesco> pe = e -> true;
    	
    	return SubGraphView.of(g, pv, pe);
    }

    public static void mostrarGrafoApartadoA(Graph<Persona, Parentesco> g, Graph<Persona, Parentesco> vista, String file) {
    	GraphColors.toDot(g, 
    			file,
    			v -> v.toString(),
    			e -> "",
    			v -> GraphColors.colorIf(Color.blue, vista.containsVertex(v)),
    			e -> GraphColors.colorIf(Color.blue, vista.containsEdge(e)));
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
