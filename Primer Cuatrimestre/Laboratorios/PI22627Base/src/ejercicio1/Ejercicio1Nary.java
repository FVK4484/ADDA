package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.tiposrecursivos.TEmpty;
import us.lsi.tiposrecursivos.TLeaf;
import us.lsi.tiposrecursivos.TNary;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1Nary {

    public static Set<String> palindromos(Tree<Character> t) {
        return palindromos(t, new ArrayList<Character>(), new HashSet<String>());
    }
    
    private static Set<String> palindromos(Tree<Character> t, List<Character> l, Set<String> s) {
        switch (t) {
        	case TEmpty() -> {}
        	case TLeaf<Character>(var lb) -> {
        		l.add(lb);
        		if (esPalindromo(l)) {
        			s.add(listaAString(l));
        		}
        		l.removeLast();
        	}
        	case TNary<Character>(var lb, var chd) -> {
        		l.add(lb);
        		chd.forEach(tc -> palindromos(tc, l, s));
        		l.removeLast();
        	}
        }
        return s;
    }
    
    private static Boolean esPalindromo(List<Character> l) {
    	int i = 0;
    	int j = l.size() - 1;
    	while (i < j) {
    		if (!(l.get(i).equals(l.get(j)))) {
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
