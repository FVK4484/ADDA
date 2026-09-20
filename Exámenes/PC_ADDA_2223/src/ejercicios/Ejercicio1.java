package ejercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	public static Map<String, Long> funcional(Integer a, Integer b, Integer c) {
		return Stream.iterate(a + b, e -> e < c, 
				e -> e + a * b)
		.filter(e -> e % 2 == 0)
		.map(e -> "[" + e % 10 + "]")
		.collect(Collectors.groupingBy(s -> s, 
				Collectors.counting()));
		}
	
	// a) La transformación a un método iterativo.
	public static Map<String, Long> iterativo(Integer a, Integer b, Integer c) {
		Map<String, Long> res = new HashMap<>();
		Integer e = a + b;
		while (e < c) {
			if (e % 2 == 0) {
				String clave = "[" + e % 10 + "]";
				if (!res.containsKey(clave)) {
					res.put(clave, 1L);
				} else {
					res.put(clave, res.get(clave) + 1);
				}
			}
			e = e + a * b;
		} 
		return res;
	}
	
	// b) La transformación a un método recursivo final.
	public static Map<String, Long> recFinal(Integer a, Integer b, Integer c) {
		return recFinal(a + b, a, b, c, new HashMap<>());
	}
	
	public static Map<String, Long> recFinal(Integer e, Integer a, Integer b, 
			Integer c, Map<String, Long> res) {
		if (e < c) {
			if (e % 2 == 0) {
				String clave = "[" + e % 10 + "]";
				if (!res.containsKey(clave)) {
					res.put(clave, 1L);
				} else {
					res.put(clave, res.get(clave) + 1);
				}
			}
			res = recFinal(e + a * b, a, b, c, res);
		}
		return res;

	}
	
}
