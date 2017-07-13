package laboratorio02;
/*
 * 6. Stack genérico con Excepciones
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A06_StackGE {
	public static void main(String[] args) throws StackEmpty, IOException {
		StackGE pil= new StackGE();
		//pil.pop();

		try {
			pil.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		StackGE s = new StackGE();
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			while( (linea=in.readLine()) != null )
				s.push(linea);
		}catch(StackFull x){
			System.out.println("capacidad excedida");
		}
		try{
			while(true)
				System.out.println( (String)s.pop() );
		}catch(StackEmpty x){
			System.out.println("fin");
		}

	}

}
