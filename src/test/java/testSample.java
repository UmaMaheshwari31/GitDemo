import java.io.IOException;
import java.util.ArrayList;

public class testSample {
	public static void main(String[] args) throws IOException {
		dataDriven d = new dataDriven();
		ArrayList input = d.getData("Add Profile");
		
		System.out.println(input.get(0));
		System.out.println(input.get(1));
		System.out.println(input.get(2));
		System.out.println(input.get(3));
		
	}

}
   