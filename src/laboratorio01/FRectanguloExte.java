package laboratorio01;

public class FRectanguloExte extends AFigura {
	private double largo;
	private double ancho;
	public FRectanguloExte (double l, double a){
		super("rectangulo");
		largo=1;
		ancho=a;
	}
	@Override
	public double area(){
		return largo*ancho;
	}
}
