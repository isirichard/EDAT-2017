package laboratorio01;

public class Fecha {
	private int a;
	private int m;
	private int d;
	//Constructor con parámetros
	public Fecha(int aa, int mm, int dd){
		a=aa;
		m=mm;
		d=dd;
	}
	//Constructor sin parámetros
	public Fecha(){
		m=1; 
		d=1;
	}
	@Override
	public String toString() {
		return "Fecha [a=" + a + ", m=" + m + ", d=" + d + "]";
	}
	
}
