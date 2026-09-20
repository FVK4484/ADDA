package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Pair;

public class Ejercicio1 {
	
	// Recursivo Sin Memoria
	public static Integer T(Integer n, Integer m) {
		Integer res;
		if (n < 4 && m < 2) {
			res = n + (m * m);
		} else if (n < 4 || m < 2) {
			res = (n * n) + m;
		} else if (n % 2 == 0 && n >= 4 && m >= 2) {
			res = 3 * T(n - 1, m - 1) + 2;
		} else {
			res = T(n - 1, m - 2) + T(n - 2, m - 2);
		}
		return res;
	}
	
	// Recursivo Con Memoria
	public static Integer T_memoria(Integer n, Integer m) {
		return T_memoria_aux(n, m, new HashMap<>());
	}

	public static Integer T_memoria_aux(Integer n, Integer m, Map<Pair<Integer, Integer>, Integer> ac) {
		Integer res = ac.get(Pair.of(n, m));
		if (res == null) {
			if (n < 4 && m < 2) {
				res = n + (m * m);
			} else if (n < 4 || m < 2) {
				res = (n * n) + m;
			} else if (n % 2 == 0 && n >= 4 && m >= 2) {
				res = 3 * T_memoria_aux(n - 1, m - 1, ac) + 2;
			} else {
				res = T_memoria_aux(n - 1, m - 2, ac) + T_memoria_aux(n - 2, m - 2, ac);
			}
			ac.put(Pair.of(n, m), res);
		}
		return res;
	}
	
}
