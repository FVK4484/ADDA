package ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicio3 {
	public static record Tupla(Integer a, Integer b, Integer c) {
		public static Tupla of(Integer a, Integer b, Integer c) {
			return new Tupla(a, b, c);
		}
	}
	
	public static Set<Integer> ejercicio3RecursivoSinMemoria(Integer a, Integer b, Integer c) { 
		Set<Integer> set = new HashSet<>();
		if (a <= 5 || b <= 3 || c <= 2) {
			set.add(a + 2);
			set.add(b * 3);
			set.add(c);
			return set;
		} else if (a <= 8 || b <= 6 || c <= 4) {
			set.add(a);
			set.add(b + 2);
			set.add(c * 3);
			return set;
		} else {
			Set<Integer> set1 = ejercicio3RecursivoSinMemoria(a / 2, b - 3, c / 4);
			Set<Integer> set2 = ejercicio3RecursivoSinMemoria(a - 3, b / 3, c - 2);
			set1.addAll(set2);
			return set1;
		}
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, Integer c) {
		return ejercicio3RecursivoConMemoria(a, b, c, new HashMap<>());	
	}
	
	public static Set<Integer> ejercicio3RecursivoConMemoria(Integer a, Integer b, 
			Integer c, Map<Tupla, Set<Integer>> mem) {
		Tupla clave = Tupla.of(a, b, c);
		if (mem.containsKey(clave)) {
			return mem.get(clave);
		}
		Set<Integer> set = new HashSet<>();
		if (a <= 5 || b <= 3 || c <= 2) {
			set.add(a + 2);
			set.add(b * 3);
			set.add(c);
		} else if (a <= 8 || b <= 6 || c <= 4) {
			set.add(a);
			set.add(b + 2);
			set.add(c * 3);
		} else {
			Set<Integer> set1 = ejercicio3RecursivoConMemoria(a / 2, b - 3, c / 4, mem);
			Set<Integer> set2 = ejercicio3RecursivoConMemoria(a - 3, b / 3, c - 2, mem);
			set.addAll(set1);
			set.addAll(set2);
		}
		mem.put(clave, set);
		return set;
	}
	
	public static Set<Integer> ejercicio3Iterativo(Integer a, Integer b, Integer c) {
		Map<Tupla, Set<Integer>> mem = new HashMap<>();
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					Set<Integer> res = new HashSet<>();
					if (i <= 5 || j <= 3 || k <= 2) {
						res.add(2 + i);
						res.add(j * 3);
						res.add(k);
					} else if (i <= 8 || j <= 6 || k <= 4) {
						res.add(i);
						res.add(j + 2);
						res.add(3 * k);
					} else {
						res.addAll(mem.get(Tupla.of(i / 2, j - 3, k / 4)));
						res.addAll(mem.get(Tupla.of(i - 3, j / 3, k - 2)));
					}
					mem.put(Tupla.of(i, j, k), res);
				}
			}	
		}
		return mem.get(Tupla.of(a, b, c));
	}
}
