package tests;

import java.util.List;

import ejercicios.Ejercicio1;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		testRecursivo(List.of(10, 20, 30, 40, 50), 30, 0, 5);
		testIterativo(List.of(10, 20, 30, 40, 50), 30, 0, 5);
		testFuncional(List.of(10, 20, 30, 40, 50), 30, 0, 5);
		
	}
	
	public static void testRecursivo(List<Integer> lista, Integer a, Integer i, Integer j) {
		System.out.println(" Solución recursivo: " + Ejercicio1.recursivo(lista, a, i, j));			
	}
	
	public static void testIterativo(List<Integer> lista, Integer a, Integer i, Integer j) {
		System.out.println(" Solución iterativo: " + Ejercicio1.iterativo(lista, a, i, j));			
	}
	
	public static void testFuncional(List<Integer> lista, Integer a, Integer i, Integer j) {
		System.out.println(" Solución funcional: " + Ejercicio1.funcional(lista, a, i, j));			
	}

}
