package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	//	a) Proporcione una solución eficiente recursiva no final.
	public static String fRecursivaNoFinal(int a, int b, int c) {
		String res = "";
		if (a < 3 || b < 3 || c < 3) {
			res = (a + b + c) + "y";
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			res = (a * b * c) + "z";
		} else  if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			res = fRecursivaNoFinal(a - 1, b / 2, c - 3) + "+";
		} else {
			res = fRecursivaNoFinal(a - 4, b / 3, c - 4) + "#";
		}
		return res;
	}
	
	//	b) Proporcione una solución eficiente recursiva final.
	public static String fRecursivaFinal(int a, int b, int c) {
		return fRecursivaFinal(a, b, c, new ArrayList<>());
	}
	
	public static String fRecursivaFinal(int a, int b, int c, List<String> ac) {
		if (a < 3 || b < 3 || c < 3) {
			ac.add(0, (a + b + c) + "y");
			return String.join("", ac);
		} else if (a < 5 || (b < a && b < c) || c < 5) {
			ac.add(0, (a * b * c) + "z");
			return String.join("", ac);
		} else  if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			ac.add(0, "+");
			return fRecursivaFinal(a - 1, b / 2, c - 3, ac);
		} else {
			ac.add(0, "#");
			return fRecursivaFinal(a - 4, b / 3, c - 4, ac);
		}
	}
	
	//	c) Solución en notación funcional
	public static String fIterativaFuncional(Integer a, Integer b, Integer c){
		Tupla t = Stream.iterate(Tupla.first(a, b, c), 
				e -> e.next())
				.filter(e -> e.isBaseCase())
				.findFirst()
				.get();
		if (t.a() < 3 || t.b() < 3 || t.c() < 3) {
			t.ac().add(0, (t.a() + t.b() + t.c()) + "y");
			return String.join("", t.ac());
		}
		t.ac().add(0, (t.a() * t.b() * t.c()) + "z");
		return String.join("", t.ac());
	}
	
	private static record Tupla(List<String> ac, Integer a, Integer b, Integer c) {
		
		public static Tupla of(List<String> ac, Integer a, Integer b, Integer c) {
			return new Tupla(ac, a, b, c);
		}
		
		public static Tupla first(Integer a, Integer b, Integer c) {
			return of(new ArrayList<>(), a, b, c);
		}
		
		public Tupla next() {
			if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
				ac.add(0, "+");
				return Tupla.of(ac, a - 1, b / 2, c - 3);
			}
			ac.add(0, "#");
			return Tupla.of(ac, a - 4, b / 3, c - 4);
		}
		
		public boolean isBaseCase() {
			return (a < 3 || b < 3 || c < 3) || (a < 5 || (b < a && b < c) || c < 5);
		}
		
	}
	
	//	d) Solución iterativa con while
	public static String fIterativaImperativa(int a, int b, int c) {
		List<String> res = new ArrayList<>();
		while ((a >= 3 && b >= 3 && c >= 3) && 
				(a >= 5 && (b >= a || b >= c) && c >= 5)) {
			if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
				res.add(0, "+");
				a--;
				b /= 2;
				c -= 3;
			} else {
				res.add(0, "#");
				a -= 4;
				b /= 3;
				c -= 4;	
			}
		}
		if (a < 3 || b < 3 || c < 3) {
			res.add(0, (a + b + c) + "y");
		} else {
			res.add(0, (a * b * c) + "z");
		}
		return String.join("", res);
	}

}
