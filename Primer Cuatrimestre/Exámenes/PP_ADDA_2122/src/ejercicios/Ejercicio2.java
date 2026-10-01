package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Pair;

public class Ejercicio2 {
	
	// Iterativo
	
	public static Integer T_iterativo(Integer n, Integer m) {
		Map<Pair<Integer, Integer>, Integer> ac = new HashMap<>();
		Integer res = null;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i < 4 && j < 2) {
					res = i + (j * j);
				} else if (i < 4 || j < 2) {
					res = (i * i) + j;
				} else if (i % 2 == 0 && i >= 2 && j >= 2) {
					res = 3 * ac.get(Pair.of(i - 1, j - 1)) + 2;
				} else {
					res = ac.get(Pair.of(i - 1, j - 2)) + 
							ac.get(Pair.of(i - 2, j - 2));
				}
				ac.put(Pair.of(i, j), res);
			}
		}
		return ac.get(Pair.of(n, m));
	}

}
