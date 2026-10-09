package tests;

import ejercicios.Ejercicio1;

public class TestEjercicio1 {

	public static void main(String[] args) {
		testEjercicio1(2, 4, 4);
		testEjercicio1(6, 5, 6);
		testEjercicio1(6, 8, 6);
		testEjercicio1(5, 8, 6);
	}
	
	public static void testEjercicio1(Integer a, Integer b, Integer c) {
		System.out.println("--- TestEjercicio1 -----------------");
		System.out.println(" Recursiva No Final: " + 
				Ejercicio1.fRecursivaNoFinal(a, b, c));
		System.out.println(" Recursiva Final: " + 
				Ejercicio1.fRecursivaFinal(a, b, c));
		System.out.println(" Iterativa Funcional: " + 
				Ejercicio1.fIterativaFuncional(a, b, c));
		System.out.println(" Iterativa Imperativa: " + 
				Ejercicio1.fIterativaImperativa(a, b, c));
	}

}
