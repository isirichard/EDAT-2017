package laboratorio02_DB;

public class NodoDEI {
	public Comparable id;
	public Object id2;
	public Object info;
	public NodoDEI sgte, ant;
	public NodoDEI(Comparable x, Object y, NodoDEI z, NodoDEI w){
		id=x; info=y; sgte=z; ant=w;
	}
	public NodoDEI(Object x, Object y, NodoDEI z, NodoDEI w){
		id2=x; info=y; sgte=z; ant=w;
	}
}
