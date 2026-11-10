package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.tiposrecursivos.BEmpty;
import us.lsi.tiposrecursivos.BLeaf;
import us.lsi.tiposrecursivos.BTree;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1Binary {
	
    public static void main(String[] args) {
        BinaryTree<Character> t = BinaryTree.parse("A(B(A,D),A)", s -> s.charAt(0));
        System.out.println(palindromos(t));
        System.out.println(palindromos2(t));
    }
    
    public static Set<String> palindromos(BinaryTree<Character> tree) {
        return palindromos(tree, new ArrayList<Character>(), new HashSet<String>());
    }

    private static Set<String> palindromos(BinaryTree<Character> tree, List<Character> ls, Set<String> st) {
        switch (tree) { // Evalúa el tipo de nodo actual.
            case BEmpty() -> {} // Caso árbol vacío.
            case BLeaf(var label) -> {  // En el caso de que sea una hoja.
                ls.add(label); // Añade el caracter del nodo actual a la lista.
                if (esPalindromo(ls)) { // Compruebo de que la lista sea un palíndromo.
                    st.add(listaAString(ls)); // Si es un palíndromo  añado al conjunto las letras en en modo String.
                }
                ls.removeLast(); // Elimino el nodo de la lista.
            }
            case BTree(var label, var izq, var der) -> { // Si es un nodo intermedio con hijos.
                ls.add(label); // Añade el caracter del nodo a la lista.
                palindromos(izq, ls, st); // Llamada recursiva para aplicar la función al subárbol izquierdo.
                palindromos(der, ls, st); // Llamada recursiva para aplicar la función al subárbol derecho.
                ls.removeLast(); // Elimina el nodo tras explorar ambas ramas.
            }
        }
        return st;
    }
    
    public static Set<String> palindromos2(BinaryTree<Character> tree) {
        return palindromos2(tree, new ArrayList<Character>(), new HashSet<String>());
    }

    private static Set<String> palindromos2(BinaryTree<Character> tree, List<Character> ls, Set<String> st) {
        switch (tree) {
            case BEmpty<Character> t -> {}
            case BLeaf<Character> t -> { 
                ls.add(t.label());
                if (esPalindromo(ls)) {
                    st.add(listaAString(ls));
                }
                ls.removeLast();
            }
            case BTree<Character> t -> { 
                ls.add(t.label());
                palindromos2(t.left(), ls, st);
                palindromos2(t.right(), ls, st);
                ls.removeLast();
            }
        }
        return st;
    }
    
    private static boolean esPalindromo(List<Character> ls) {
        int i = 0;
        int j = ls.size() - 1;
        while (i < j) {
            if (!ls.get(i).equals(ls.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private static String listaAString(List<Character> l) {
    	StringBuilder res = new StringBuilder();
    	for (Character c : l) {
    		res.append(c);
    	}
    	return res.toString();
    }
    
}