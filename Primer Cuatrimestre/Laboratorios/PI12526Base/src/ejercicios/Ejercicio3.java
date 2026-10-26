package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio3 {

	public static Long iterativo(Integer a, Integer b, Integer c) {
		Map<Tupla, Long> mem = new HashMap<Tupla, Long>();
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				for (int k = 0; k <= c; k++) {
					Tupla t = Tupla.of(i, j, k);
					long res = 0L;
					if (i < 3 || j < 3 || k < 3) {
						res = (long) i + j * j + 2 * k;
					} else if (i % j == 0) {
						res = mem.get(Tupla.of(i - 1, j / 2, k / 2)) 
								+ mem.get(Tupla.of(i - 3, j / 3, k / 3));
					} else {
						res = mem.get(Tupla.of(i / 3, j - 3, k - 3)) 
								+ mem.get(Tupla.of(i / 2, j - 2, k - 2));
					}
					mem.put(t, res);
				}
			}
		}
		return mem.get(Tupla.of(a, b, c));
	}

	public static Long recursivo_sin_memoria(Integer a, Integer b, Integer c) {
		Long res = 0L;
		if (a < 3 || b < 3 || c < 3) {
			res = (long) a + b * b + 2 * c;
		} else if (a % b == 0) {
			res = recursivo_sin_memoria(a - 1, b / 2, c / 2) 
					+ recursivo_sin_memoria(a - 3, b / 3, c / 3);
		} else {
			res = recursivo_sin_memoria(a / 3, b - 3, c - 3) 
					+ recursivo_sin_memoria(a / 2, b - 2, c - 2);
		}
		return res;
	}

	public static Long recursivo_con_memoria(Integer a, Integer b, Integer c) {
		return recursivo_con_memoria(a, b, c, new HashMap<Ejercicio3.Tupla, Long>());
	}
	
	public static Long recursivo_con_memoria(Integer a, Integer b, Integer c, Map<Tupla, Long> mem) {
		Tupla t = Tupla.of(a, b, c);
		if (mem.containsKey(t)) {
			return mem.get(t);
		}
		if (a < 3 || b < 3 || c < 3) {
			mem.put(t, (long) a + b * b + 2 * c);
		} else if (a % b == 0) {
			 mem.put(t, recursivo_con_memoria(a - 1, b / 2, c / 2, mem) 
					 + recursivo_con_memoria(a - 3, b / 3, c / 3, mem));
		} else {
			mem.put(t, recursivo_con_memoria(a / 3, b - 3, c - 3, mem) 
					+ recursivo_con_memoria(a / 2, b - 2, c - 2, mem));
		}
		return mem.get(t);
	}
	
	private record Tupla(Integer a, Integer b, Integer c) {
		public static Tupla of(Integer a, Integer b, Integer c) {
			return new Tupla(a, b, c);
		}
	}

}
