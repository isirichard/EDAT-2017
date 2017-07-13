package laboratorio03;

public class Morse {
	char letra(String x,NodoAB r){
		if(x.equals("")) return r.valor.charAt(0);
		return letra(x.substring(1), x.charAt(0)=='.'? r.izq: r.der);
	}
}
