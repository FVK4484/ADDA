package ejercicios;

import java.util.List;
import java.util.stream.Stream;

public class Ejercicio1 {
	//	b. Proporcione una solución recursiva.
	public static Integer recursivo(List<Integer> lista, Integer a, Integer i, Integer j) {
		int pos = -1;
		if (i == j) {
			pos = j;
		} else {
			int mitad = (i + j) / 2;
			if (lista.get(mitad) < a) {
				pos = recursivo(lista, a, mitad + 1, j);
			} else {
				pos = recursivo(lista, a, i, mitad);
			}
		}
		return pos;
	}
	// c. Proporcione una solución iterativa usando while.
	public static Integer iterativo(List<Integer> lista, Integer a, Integer i, Integer j) {
		while (i != j) {
			int mitad = (i + j) / 2;
			if (lista.get(mitad) < a) {
				i = mitad + 1;
			} else {
				j = mitad;
			}
		}
		return j;
	}
	// d. Proporcione una solución en notación funcional.
	private static record Tupla(List<Integer> lista, Integer a, int i, int j) { 
		public static Tupla of(List<Integer> lista, Integer a, int i, int j){ 
			return new Tupla(lista, a, i, j); 
		} 
		public static Tupla first(List<Integer> lista, Integer a) { 
			return of(lista, a, 0, lista.size()); 
		} 
		public Tupla next() { 
			Tupla t = null; 
			int k = (i + j) / 2; 
			if (lista.get(k) < a) { 
				t = of(lista, a, k + 1, j); 
			} else { 
				t = of(lista, a, i, k); 
			} 
			return t; 
		} 
	} 
	public static int funcional(List<Integer> lista, Integer a, int i, int j) { 
		Tupla t = Stream.iterate(Tupla.first(lista, a), 
				e -> e.next())
				.filter(e -> e.i() == e.j())
				.findFirst()
				.get();
		return t.j(); 
	}
}
