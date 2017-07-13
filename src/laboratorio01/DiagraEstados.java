package laboratorio01;

public class DiagraEstados {
	public enum estad{
		FUERA,DENTRO;
	}
	public static void main(String[]args){
		String s = "Este es un ejemplo.";
		int np = 0;
		char c=' ';
		estad estado=estad.FUERA;
		//boolean estado=false;//estad estado= estad.FUERA;
		for(int k=0; (c=s.charAt(k))!='.';++k){
			if(estado==estad.FUERA){
				if(c!=' '){
					++np;
					estado = estad.DENTRO;
				}
			}
			else // estado==DENTRO
				if(c==' ')
					estado=estad.FUERA;
		}
		System.out.println("El Nro de palabras en la frase es "+np);
	}
}
//recursividad, diagrama de estados.
