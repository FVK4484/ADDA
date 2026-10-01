package tests;

import ejercicios.Ejercicio1;
import ejercicios.Monedas;

public class TestEjercicio1 {

	public static void main(String[] args) {
		System.out.println("--- Iniciando pruebas del Ejercicio 1 (Divide y Vencerás) ---\n");
		
		// Prueba 1: Caso normal. 16 monedas, falsa en el índice 5, más pesada
		probarEscenario(16, 5, true);
		
		// Prueba 2: Caso profundo. 32 monedas, falsa en el índice 30, más ligera
		probarEscenario(32, 30, false);
		
		// Prueba 3: Extremo izquierdo. 8 monedas, falsa en el primer índice (0)
		probarEscenario(8, 0, true);
		
		// Prueba 4: Extremo derecho. 64 monedas, falsa en el último índice (63)
		probarEscenario(64, 63, false);
	}
	
	private static void probarEscenario(int numMonedas, int indiceFalsa, boolean esMasPesada) {
		System.out.println("Escenario: N=" + numMonedas + " monedas | Falsa en índice: " + indiceFalsa + " (" + (esMasPesada ? "Más pesada" : "Más ligera") + ")");
		
		Monedas monedas = new Monedas(numMonedas, indiceFalsa, esMasPesada);
		
		// Probamos ambos algoritmos
		int resultadoRecursivo = Ejercicio1.monedaFalsa(monedas);
		int resultadoIterativo = Ejercicio1.monedaFalsaIterativa(monedas);
		
		// Validamos los resultados
		System.out.println(" -> Método Recursivo: " + resultadoRecursivo + (resultadoRecursivo == indiceFalsa ? " [CORRECTO]" : " [FALLO]"));
		System.out.println(" -> Método Iterativo: " + resultadoIterativo + (resultadoIterativo == indiceFalsa ? " [CORRECTO]" : " [FALLO]\n"));
	}

}

