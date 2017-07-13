package presentacion01E;

public class PFraccionExte extends APar{
	public PFraccionExte(int x, int y){
		super(x,y);
	}
	public  PFraccionExte suma(PFraccionExte x){
		return new PFraccionExte(a*x.b+b*x.a,b*x.b);
	}
	@Override
	public String toSgtring() {
		return a+"/"+b;
	}

}
