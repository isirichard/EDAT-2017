package laboratorio03;

public class TDA_AE {
	int evaluar(NodoAB r){
		if(r==null) return 0;
		if(r.izq==null && r.der==null)
			return Integer.parseInt(r.valor);
		int a=evaluar(r.izq), b=evaluar(r.der), c=0;
		switch(r.valor.charAt(0)){
		case '+': c=a+b; break;
		case '-': c=a-b; break;
		case '*': c=a*b; break;
		case '/': c=a/b; break;
		}
		return c;
	}
}
