import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Search {

	public static void main(String[] args) {
		System.out.println("TEST");
        String fileName = "test.csv";
        File file = new File(fileName);
        
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNextLine()) {
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				System.out.println(values[0] + ", " + values[1] + ", " + values[5] + " ***");
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       

    }

}
