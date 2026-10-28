package ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import us.lsi.common.IntTrio;

public class EjercicioExamen2 {
	
	public static void main(String[] args) {
		System.out.println(ejercicio3Iterativo(10,20,30));
		System.out.println(ejercicio3SinMem(10,20,30));
		System.out.println(ejercicio3ConMem(10,20,30));
	}
	
	public static Set<Integer> ejercicio3Iterativo (Integer a, Integer b
			, Integer c) {
		Map<IntTrio, Set<Integer>> mem = new HashMap<IntTrio, Set<Integer>>();
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					IntTrio it = IntTrio.of(i, j, k);
					Set<Integer> set = new HashSet<Integer>();
					if (i <= 5 || j <= 3 || k <= 2) {
						set.add(i + 4);
						set.add(j * 2);
						set.add(k);
						set.add(i + k);
					} else {
						set.addAll(mem.get(IntTrio.of(i - 2, j - 3, k / 4)));
						set.addAll(mem.get(IntTrio.of(i - 3, j / 3, k - 2)));
					}
					mem.put(it, set);
				}
			}
		}
		return mem.get(IntTrio.of(a, b, c));
	}
	
	public static Set<Integer> ejercicio3SinMem (Integer a, Integer b
			, Integer c) {
		Set<Integer> set = new HashSet<Integer>();
		if (a <= 5 || b <= 3 || c <= 2) {
			set.add(a + 4);
			set.add(b * 2);
			set.add(c);
			set.add(a + c);
		} else {
			set = ejercicio3SinMem(a - 2, b - 3, c / 4);
			set.addAll(ejercicio3SinMem(a - 3, b / 3, c - 2));
		}
		return set;
	}
	
	private static Set<Integer> ejercicio3ConMem(Integer a, Integer b
			, Integer c) {
		return ejercicio3ConMem(a, b, c, new HashMap<IntTrio, Set<Integer>>());
	}
	
	public static Set<Integer> ejercicio3ConMem (Integer a, Integer b
			, Integer c, HashMap<IntTrio, Set<Integer>> mem) {
		Set<Integer> set = new HashSet<Integer>();
		IntTrio it = IntTrio.of(a, b, c);
		if (mem.containsKey(it)) {
			return mem.get(it);
		}
		if (a <= 5 || b <= 3 || c <= 2) {
			set.add(a + 4);
			set.add(b * 2);
			set.add(c);
			set.add(a + c);
		} else {
			set = ejercicio3ConMem(a - 2, b - 3, c / 4, mem);
			set.addAll(ejercicio3ConMem(a - 3, b / 3, c - 2, mem));
		}
		mem.put(it, set);
		return set;
	}
	
}
