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
        System.out.println(palindromosNueva(t));
    }
	
    public static Set<String> palindromos(BinaryTree<Character> tree) {
        return palindromos(tree, new ArrayList<Character>(), new HashSet<String>());
    }

    private static Set<String> palindromos(BinaryTree<Character> tree, List<Character> ls, Set<String> st) {
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
                palindromos(t.left(), ls, st);
                palindromos(t.right(), ls, st);
                ls.removeLast();
            }
        }
        return st;
    }
    
    public static Set<String> palindromosNueva(BinaryTree<Character> tree) {
        return palindromosNueva(tree, new ArrayList<Character>(), new HashSet<String>());
    }

    private static Set<String> palindromosNueva(BinaryTree<Character> tree, List<Character> ls, Set<String> st) {
        switch (tree) {
            case BEmpty() -> {}
            case BLeaf(var label) -> { 
                ls.add(label);
                if (esPalindromo(ls)) {
                    st.add(listaAString(ls));
                }
                ls.removeLast();
            }
            case BTree(var label, var izq, var der) -> { 
                ls.add(label);
                palindromosNueva(izq, ls, st);
                palindromosNueva(der, ls, st);
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
    
    private static String listaAString(List<Character> ls) {
        StringBuilder sb = new StringBuilder();
        for (Character c : ls) {
            sb.append(c);
        }
        return sb.toString();
    }
}