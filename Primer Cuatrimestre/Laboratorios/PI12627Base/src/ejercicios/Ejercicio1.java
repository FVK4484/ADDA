package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Ejercicio1 {
	
	public static void tests(List<ParEnteros> ls) {
		ls.forEach(t -> {
			System.out.println("1) Solucion Funcional: " + funcional(t.a(), t.b()));
			System.out.println("2) Solucion Iterativo: " + iterativo(t.a(), t.b()));
			System.out.println("3) Solucion Rec. Final: " + recFinal(t.a(), t.b()));
		});
		
	}
	
	public static String funcional(Integer varA, Integer varB) {
		UnaryOperator<EnteroCadena> nx = elem -> { 
			return EnteroCadena.of(elem.a() + 3, elem.a() % 2 == 0 ? elem.a() + "*" : elem.a() + "!");	
		};
		return Stream.iterate(EnteroCadena.of(varA,"A"), 
				elem -> elem.a() < varB, nx)
				.filter(elem -> elem.a() % 10 != 0)
				.map(elem -> elem.s())
				.collect(Collectors.joining("-"));
		} 
	
	public static String iterativo(Integer varA, Integer varB) {	
		EnteroCadena ec = EnteroCadena.of(varA, "A");
		List<String> ac = new ArrayList<String>();
		while (ec.a() < varB) {
			if (ec.a() % 10 != 0) {
				ac.add(ec.s());
			}
			int nextA = ec.a() + 3;
			String nextS = ec.a() + "!";
			if (ec.a() % 2 == 0) {
				nextS = ec.a() + "*";
			}
			ec = EnteroCadena.of(nextA, nextS);
		}
		return String.join("-", ac);
	}
	
	public static String recFinal(Integer varA, Integer varB) {	
		return recFinal(varA, varB, EnteroCadena.of(varA, "A"), new ArrayList<String>());
	}
	
	public static String recFinal(Integer varA, Integer varB, EnteroCadena ec, List<String> ac) {	
		if (ec.a() < varB) {
			if (ec.a() % 10 != 0) {
				ac.add(ec.s());
			}
			int nextA = ec.a() + 3;
			String nextS = ec.a() + "!";
			if (ec.a() % 2 == 0) {
				nextS = ec.a() + "*";
			}
			return recFinal(varA, varB, EnteroCadena.of(nextA, nextS), ac);
		}
		return String.join("-", ac);
	}

}
