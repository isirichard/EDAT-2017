package laboratorio01;
public class FCirculoExte extends AFigura{
	static final private double PI = 3.141592653;
	private double radio;
	
	public FCirculoExte(double r) {
		super("circulo");
		radio=r;
	}

	@Override
	public double area() {
		return PI*radio*radio;
	}

}
