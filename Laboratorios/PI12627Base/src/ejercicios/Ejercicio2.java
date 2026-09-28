package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio2 {
	
	public static List<String> ejercicio2RecursivoNoFinal(Integer a, String s){
		List<String> res = new ArrayList<>();
		if (a <= 2 || s.length() <= 2) {
			res.add(a.toString().concat(s));
			return res;
		} else if (a % 2 == 0) {
			res = ejercicio2RecursivoNoFinal(a / 2, 
					s.substring(0, s.length() - 2));
			res.add(a.toString());
			return res;
		} else {
			res = ejercicio2RecursivoNoFinal(a / 3,
					s.substring(0, s.length() - 1));
			res.add(a.toString() + s.substring(0, a % s.length()));
			return res;
		}
	}
	
	public static List<String> ejercicio2Iterativo(Integer a, String s){
		List<String> res = new ArrayList<>();
		while (a > 2 && s.length() > 2) {
			if (a % 2 == 0) {
				res.add(0, a.toString());
				a = a / 2;
				s = s.substring(0, s.length() - 2);
			} else {
				res.add(0, a.toString() + s.substring(0, a % s.length()));
				a = a / 3;
				s = s.substring(0, s.length() - 1);
			}
		}
		res.add(0, a.toString() + s);
		return res;
	}
	
	public static List<String> ejercicio2RecursivoFinal(Integer a, String s) {
		return ejercicio2RecursivoFinal(a, s, "");
	}
	
	private static List<String> ejercicio2RecursivoFinal(Integer a, String s, String ac) {
		List<String> res = new ArrayList<>();
		if (a <= 2 || s.length() <= 2) {
			ac = ac + a.toString().concat(s);
			res.add(ac);
			return res;
		} else if (a % 2 == 0) {
			res = ejercicio2RecursivoFinal(a / 2, 
					s.substring(0, s.length() - 2));
			ac = ac + a.toString();
			res.add(ac);
			return res;
		} else {
			res = ejercicio2RecursivoFinal(a / 3,
					s.substring(0, s.length() - 1));
			ac = ac + a.toString() + s.substring(0, a % s.length());
			res.add(ac);
			return res;
		}
	}
	
	public static List<String> ejercicio2NotacionFuncional(Integer a, String s){
		Tupla t = Stream.iterate(Tupla.first(a, s), 
				e -> e.next())
				.filter(e -> e.isBaseCase())
				.findFirst()
				.get();
		
		t.ac.add(0, t.a.toString() + t.s);
		return t.ac;
	}
	
	private static record Tupla(List<String> ac, Integer a, String s) {
		
		public static Tupla of(List<String> ac, Integer a, String s) {
			return new Tupla(ac, a, s);
		}
		
		public static Tupla first(Integer a, String s) {
			return of(new ArrayList<>(), a, s);
		}
		
		public Tupla next() {
			if(a % 2 == 0) {
				ac.add(0, a.toString());
				return of(ac, a / 2, s.substring(0, s.length() - 2));
		}
			else {
				ac.add(0, a.toString() + s.substring(0, a % s.length()));
				return of(ac, a / 3, s.substring(0, s.length() - 1));
			}
		}
		public boolean isBaseCase() {
			return a <= 2 || s.length() <= 2;
		}
	}
	
}
