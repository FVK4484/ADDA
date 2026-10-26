package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio2 {
	
	public static List<Integer> f_RNF (Integer a, Integer b) {
		List<Integer> res = new ArrayList<Integer>();
		if (a < 2 || b < 2) {
			res.add(a * b);
		} else if (a > b) {
			res = f_RNF(a % b, b - 1);
			res.add(a);
		} else {
			res = f_RNF(a - 2, b / 2);
			res.add(b);
		}
		return res;
	}
	
	public static List<Integer> f_it (Integer a, Integer b) {
		List<Integer> ac = new ArrayList<Integer>();
		while (!(a < 2 || b < 2)) {
			if (a > b) {
				ac.add(0, a);
				a %= b;
				b -= 1;
			} else {
				ac.add(0, b);
				a -= 2;
				b /= 2;
			}
		}
		ac.add(0, a * b);
		return ac;
	}
	
	public static List<Integer> f_RF (Integer a, Integer b) {
		return f_RF(a, b, new ArrayList<Integer>());
	}
	
	public static List<Integer> f_RF (Integer a, Integer b, List<Integer> res) {
		if (a < 2 || b < 2) {
			res.add(0, a * b);
		} else if (a > b) {
			res.add(0, a);
			res = f_RF(a % b, b - 1, res);
		} else {
			res.add(0, b);
			res = f_RF(a - 2, b / 2, res);
		}
		return res;
	}
	
	public static List<Integer> f_funcional (Integer a, Integer b) {
		Tupla t = Stream.iterate(Tupla.first(a, b), e -> e.next())
				.filter(e -> e.isBaseCase())
				.findFirst()
				.get();
		t.ac().add(0, t.a() * t.b());
		return t.ac();
	}
	
	private static record Tupla(List<Integer> ac, Integer a, Integer b) {
		public static Tupla of(List<Integer> ac, Integer a, Integer b) {
			return new Tupla(ac, a, b);
		}
		
		public static Tupla first(Integer a, Integer b) {
			return of(new ArrayList<Integer>(), a, b);
		}
		
		public Tupla next() {
			Tupla t = of(null, null, null);
			if (a > b) {
				ac.add(0, a);
				t = of(ac, a % b, b - 1); 
			} else {
				ac.add(0, b);
				t = of(ac, a - 2, b / 2);
			}
			return t;
		}
		
		public Boolean isBaseCase() {
			return a < 2 || b < 2;
		}
	}

}
