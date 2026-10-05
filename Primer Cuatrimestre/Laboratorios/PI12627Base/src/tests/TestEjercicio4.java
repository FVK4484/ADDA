package tests;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import ejercicios.Ejercicio4;
import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio4 {
	
	private static Integer nMin = 100; 
	private static Integer nMax = 50000; // Ajustado al tamaño de las gráficas del resultado
	private static Integer razon = 3330; 
	private static Integer nIter = 50; // Reducido drásticamente para evitar bloqueos
	private static Integer nIterWarmup = 10000 ; // Calentamiento mínimo para que sea casi instantáneo
	
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
		MatPlotLib.showCombined("Tiempos",
				List.of("resources/datos/tmp/PI1Ejercicio4_RecDouble.txt",
						"resources/datos/tmp/PI1Ejercicio4_ItDouble.txt",
						"resources/datos/tmp/PI1Ejercicio4_RecBig.txt",
						"resources/datos/tmp/PI1Ejercicio4_ItBig.txt"), 
				List.of("Recursiva-Double", "Iterativa-Double", "Recursiva-BigInteger", "Iterativa-BigInteger"));
	}
	
	public static void main(String[] args) {
		// Pasamos la variable 't' para que los tamaños vayan de 100 a 50.000
//		genData(t -> Ejercicio4.funcRecBig(t),"resources/datos/tmp/PI1Ejercicio4_RecBig.txt");
		genData(t -> Ejercicio4.funcRecDouble(t),"resources/datos/tmp/PI1Ejercicio4_RecDouble.txt");
//		genData(t -> Ejercicio4.funcItBig(t),"resources/datos/tmp/PI1Ejercicio4_ItBig.txt");
		genData(t -> Ejercicio4.funcItDouble(t),"resources/datos/tmp/PI1Ejercicio4_ItDouble.txt");
		
//		show(PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.))),"resources/datos/tmp/PI1Ejercicio4_RecBig.txt","RecursivaBigInt");
//		show(PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.))), "resources/datos/tmp/PI1Ejercicio4_ItBig.txt","IterativaBigInt");
		show(PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.))), "resources/datos/tmp/PI1Ejercicio4_RecDouble.txt","RecursivaDouble");
		show(PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.))), "resources/datos/tmp/PI1Ejercicio4_ItDouble.txt","IterativaDouble");
		
		showCombined();
	}
}