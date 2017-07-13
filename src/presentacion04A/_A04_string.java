package presentacion04A;
/////////Funciones de hashing para strings
public class _A04_string {
	static public final int m=10;
	public static void main(String[] args) {

	}

	////1. Sumar representaciones internas de caracteres////
	int h(String x){
		int s=0;
		for(int i=0; i<x.length(); ++i)
			s += x.charAt(i);
		return s % m;
	}

	////2. Evaluar polinomio, usando caracteres como coeficientes
	int pol1(String x){
		int s=0, p=1;
		for(int i=x.length()-1; i>=0; --i){
			s += x.charAt(i)*p; p *= 128;
		}
		return s % m;
	}
	int pol2(String x){
		int s=0;
		for(int i=0; i<x.length(); ++i)
		s = s*128 + x.charAt(i);
		return s % m;
	}
	int pol3(String x){
		int s=0;
		for(int i=0; i<x.length(); ++i)
		s = s*37 + x.charAt(i);
		return Math.abs(s % m);
	}
	////3. Con función predefinida de clase String
	int predef(Integer x){
		return Math.abs(x.hashCode() % m);
	}
}
