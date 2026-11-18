package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.lsi.tiposrecursivos.BEmpty;
import us.lsi.tiposrecursivos.BLeaf;
import us.lsi.tiposrecursivos.BTree;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio2Binary {

	public static Map<Paridad, List<Integer>> etiquetasPorParidad(BinaryTree<Integer> tree) {
        return etiquetasPorParidad(tree, new HashMap<Paridad,List<Integer>>(), new ArrayList<Integer>(), new ArrayList<Integer>());
    }

	private static Map<Paridad, List<Integer>> etiquetasPorParidad(BinaryTree<Integer> tree, Map<Paridad,List<Integer>> m, List<Integer> lp, List<Integer> li) {
		switch(tree) {
			case BEmpty() -> {}
			case BLeaf(var label) -> {}
			case BTree(var label, var izq, var der) -> { 
				if(!izq.isEmpty() && !der.isEmpty()) {
					if(label > izq.optionalLabel().get() && label < der.optionalLabel().get()) {
						if(label % 2 == 0) {
							lp.add(label);
						} else {	
							li.add(label);
						}
					}
				}
				etiquetasPorParidad(izq ,m, lp, li);
				etiquetasPorParidad(der ,m, lp, li);
				m.put(Paridad.Par, lp);
				m.put(Paridad.Impar, li);
			}
		}
		return m;
	}
    
}
