package ejercicios;

import java.util.ArrayList;
import java.util.List;

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
		return null;
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
			res = ejercicio2RecursivoNoFinal(a / 2, 
					s.substring(0, s.length() - 2));
			ac = ac + a.toString();
			res.add(ac);
			return res;
		} else {
			res = ejercicio2RecursivoNoFinal(a / 3,
					s.substring(0, s.length() - 1));
			ac = ac + a.toString() + s.substring(0, a % s.length());
			res.add(ac);
			return res;
		}
	}

	public static List<String> ejercicio2NotacionFuncional(Integer a, String s){
		return null;
	}
	
}
