package ejercicios;

import java.util.List;



public class Ejercicio1 {
	
	public static void tests(List<ParEnteros> ls) {
		ls.forEach(t -> {
			System.out.println();
			System.out.println("1) Solucion Funcional: " + funcional(t.a(), t.b()));
			System.out.println("2) Solucion Iterativo: " + iterativo(t.a(), t.b()));
			System.out.println("3) Solucion Rec. Final: " + recFinal(t.a(), t.b()));
		});
		
	}
	
	
	public static String funcional(Integer varA, Integer varB) {	
		return null;
	} 

	
	public static String iterativo(Integer varA, Integer varB) { 
		return null;
	}
	
	public static String recFinal(Integer varA, Integer varB) {
		return null;
	}
	


}
