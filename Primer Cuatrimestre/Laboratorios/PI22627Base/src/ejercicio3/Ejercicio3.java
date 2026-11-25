package ejercicio3;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.VertexCoverAlgorithm;
import org.jgrapht.alg.vertexcover.RecursiveExactVCImpl;
import org.jgrapht.graph.AsUndirectedGraph;

import us.lsi.colors.GraphColors;
import us.lsi.colors.GraphColors.Color;
import us.lsi.graphs.views.SubGraphView;

public class Ejercicio3 {

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
    
    private static List<Persona> getPadres(Graph<Persona, Parentesco> g, Persona p) {
		return g.incomingEdgesOf(p).stream()
				.map(g::getEdgeSource)
				.toList();
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
        Set<Persona> ancestros = new HashSet<>();
        buscarAncestros(g, persona, ancestros);
        return ancestros;
    }

    private static void buscarAncestros(Graph<Persona, Parentesco> g, Persona p, Set<Persona> ancestros) {
        for (Persona padre : getPadres(g, p)) {
            if (ancestros.add(padre)) {
                buscarAncestros(g, padre, ancestros);
            }
        }
    }

    public static void mostrarGrafoApartadoB(Graph<Persona, Parentesco> g, 
    		Persona persona, Set<Persona> ancestros, String file) {
    	GraphColors.toDot(g, 
    			file,
    			v -> v.toString(),
    			e -> "",
    			v -> {
    				if (v.equals(persona)) {
                        return GraphColors.color(Color.red);
                    }
                    if (ancestros.contains(v)) {
                        return GraphColors.color(Color.blue);
                    }
                    return GraphColors.color(Color.black);
                },
    			e -> GraphColors.color(Color.black));
    }

    public static ParentescoEnumerado apartadoC(Graph<Persona, Parentesco> g, Persona p1, Persona p2) {
    	if (p1.equals(p2)) {
            return ParentescoEnumerado.Otras;
        }

        Set<Persona> padresP1 = new HashSet<>(getPadres(g, p1));
        Set<Persona> padresP2 = new HashSet<>(getPadres(g, p2));

        if (!Collections.disjoint(padresP1, padresP2)) {
            return ParentescoEnumerado.Hermanas;
        }

        Set<Persona> abuelosP1 = getAbuelos(g, padresP1);
        Set<Persona> abuelosP2 = getAbuelos(g, padresP2);

        if (!Collections.disjoint(abuelosP1, abuelosP2)) {
            return ParentescoEnumerado.Primas;
        }

        return ParentescoEnumerado.Otras;
    }
    
    private static Set<Persona> getAbuelos(Graph<Persona, Parentesco> g, Set<Persona> padres) {
    	Set<Persona> abuelos = new HashSet<Persona>();
    	for (Persona padre : padres) {
    		abuelos.addAll(getPadres(g, padre));
    	}
    	return abuelos;
    }

    public static Set<Persona> apartadoD(Graph<Persona, Parentesco> g) {
        Set<Persona> resultado = new HashSet<>();

        for (Persona p : g.vertexSet()) {         
            Set<Persona> hijos = g.outgoingEdgesOf(p).stream()
            		.map(g::getEdgeTarget)
                    .collect(Collectors.toSet());
          
            Set<Persona> parejas = new HashSet<>();
            for (Persona hijo : hijos) {
                for (Persona progenitor : getPadres(g, hijo)) {
                    if (!progenitor.equals(p)) {
                        parejas.add(progenitor);
                    }
                }
            }
           
            if (parejas.size() > 1) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static void mostrarGrafoApartadoD(Graph<Persona, Parentesco> g, Set<Persona> personas, String file) {
    	GraphColors.toDot(g, 
    			file,
    			v -> v.toString(),
    			e -> "",
    			v -> GraphColors.colorIf(Color.blue, personas.contains(v)),
    			e -> GraphColors.color(Color.black));
    }

    public static Set<Persona> apartadoE(Graph<Persona, Parentesco> g) {
        Graph<Persona, Parentesco> grafoNoDirigido = new AsUndirectedGraph<>(g);
        VertexCoverAlgorithm<Persona> vc = new RecursiveExactVCImpl<>(grafoNoDirigido);
        return vc.getVertexCover();
    }

    public static void mostrarGrafoApartadoE(Graph<Persona, Parentesco> g, Set<Persona> personas, String file) {
        GraphColors.toDot(g, 
        		file,
        		v -> v.toString(),
        		e -> "",
        		v -> GraphColors.colorIf(Color.blue, personas.contains(v)),
        		e -> GraphColors.color(Color.black));
    }
}
