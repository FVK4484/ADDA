package tests;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import ejercicios.Ejercicio5;
import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio5 {
	
	private static Integer nMin = 100; // n mínimo para el cálculo de potencia
	private static Integer nMax = 100000; // n máximo para el cálculo de potencia
	private static Integer razon = 3330; // incremento en los valores de n del cálculo de potencia
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 10000; // número de iteraciones para warmup

	
	public static void genData (Consumer<Integer> algorithm, String file) {
		Function<Integer,Long> f1 = GenData.time(algorithm);
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,razon,nIter,nIterWarmup);
	}
	
	public static void show(Fit pl, String file, String label) {
		List<WeightedObservedPoint> data = DataFile.points(file);
		pl.fit(data);
		MatPlotLib.show(file, pl.getFunction(), String.format("%s = %s",label,pl.getExpression()));
	}
	         
	public static void showCombined() {
		MatPlotLib.showCombined("Comparativa",
				List.of("resources/datos/tmp/PI1Ejercicio5_RecDouble.txt",
						"resources/datos/tmp/PI1Ejercicio5_RecBigInteger.txt",
						"resources/datos/tmp/PI1Ejercicio5_ItDouble.txt",
						"resources/datos/tmp/PI1Ejercicio5_ItBigInteger.txt"), 
				List.of("Recursiva-Double", "Recursiva-BigInteger", "Iterativa-Double", "Iterativa-BigInteger"));
	}
	
	public static void main(String[] args) {
//		genData(t -> Ejercicio5.ejercicio5RecDouble(t),
//				"resources/datos/tmp/PI1Ejercicio5_RecDouble.txt");
//		genData(t -> Ejercicio5.ejercicio5RecBigInteger(t),
//				"resources/datos/tmp/PI1Ejercicio5_RecBigInteger.txt");
//		genData(t -> Ejercicio5.ejercicio5ItDouble(t),
//				"resources/datos/tmp/PI1Ejercicio5_ItDouble.txt");
//		genData(t -> Ejercicio5.ejercicio5ItBigInteger(t),
//				"resources/datos/tmp/PI1Ejercicio5_ItBigInteger.txt");
		
		show(PowerLog.of(List.of(Pair.of(1, 1.),Pair.of(2, 0.))), 
				"resources/datos/tmp/PI1Ejercicio5_RecDouble.txt","Recursiva-Double");
//		show(PowerLog.of(List.of(Pair.of(1, 3.),Pair.of(2, 0.))), 
//				"resources/datos/tmp/PI1Ejercicio5_RecBigInteger.txt","Recursiva-BigInt");
//		show(PowerLog.of(List.of(Pair.of(1, 1.),Pair.of(2, 0.))), 
//				"resources/datos/tmp/PI1Ejercicio5_ItDouble.txt","Iterativa-Double");
//		show(PowerLog.of(List.of(Pair.of(1, 3.),Pair.of(2, 0.))), 
//				"resources/datos/tmp/PI1Ejercicio5_ItBigInteger.txt","Iterativa-BigInt");
		
//		showCombined();
	}
}