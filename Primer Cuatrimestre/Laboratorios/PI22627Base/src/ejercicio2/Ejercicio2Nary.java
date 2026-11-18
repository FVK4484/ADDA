package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.tiposrecursivos.TEmpty;
import us.lsi.tiposrecursivos.TLeaf;
import us.lsi.tiposrecursivos.TNary;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio2Nary {

	public static Map<Paridad, List<Integer>> etiquetasPorParidad(Tree<Integer> tree) {
        return etiquetasPorParidad(tree, new HashMap<Paridad, List<Integer>>(), new ArrayList<Integer>(), new ArrayList<Integer>());
    }

	private static Map<Paridad, List<Integer>> etiquetasPorParidad(Tree<Integer> tree, Map<Paridad,List<Integer>> m, List<Integer> lp, List<Integer> li) {
		switch(tree) {
			case TEmpty() -> {}
			case TLeaf(var label) -> {}
			case TNary(var label, var children) -> {
				List<Tree<Integer>> hijos = children;
				List<Tree<Integer>> noVacio = new ArrayList<>();
				for(Tree<Integer> hijo : hijos) {
					if(!hijo.isEmpty()) {
						noVacio.add(hijo);
					}
				}
				if(label > noVacio.getFirst().optionalLabel().get() && label < noVacio.getLast().optionalLabel().get()) {
					if(label % 2 == 0) {
						lp.add(label);
					} else {
						li.add(label);
					}
				
				} for(Tree<Integer> hijo : hijos) {
					etiquetasPorParidad(hijo, m, lp, li);
					m.put(Paridad.Par, lp);
					m.put(Paridad.Impar, li);
				}
			}
		}
		return m;
	}
	
}
