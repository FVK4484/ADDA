package tests;

import ejercicios.Ejercicio1;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		testFuncional(2, 4, 25);
		testFuncional(2, 10, 60);
		testIterativo(2, 4, 25);
		testIterativo(2, 10, 60);
		testRecFinal(2, 4, 25);
		testRecFinal(2, 10, 60);
		
	}
	
	private static void testFuncional(Integer a, Integer b, Integer c) {
		System.out.println(" Funcional para los valores a=" + a + "; b=" + b + "; c=" + c + ": " + 
				Ejercicio1.funcional(a , b, c));
	}
	
	private static void testIterativo(Integer a, Integer b, Integer c) {
		System.out.println(" Iterativo para los valores a=" + a + "; b=" + b + "; c=" + c + ": " +  
				Ejercicio1.iterativo(a , b, c));
	}
	
	private static void testRecFinal(Integer a, Integer b, Integer c) {
		System.out.println(" Recursivo Final para los valores a=" + a + "; b=" + b + "; c=" + c + ": " +  
				Ejercicio1.recFinal(a , b, c));
	}

}
