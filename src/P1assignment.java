import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P1assignment {
	
	private static Scanner sc;
	private static Scanner scanner;
	private static ArrayList<String> array;
	
	// Main method
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String fileName;
		try {
			System.out.println("Please enter a file name to import your data from:"); // enter "src/test.csv"
			fileName = sc.nextLine();
			input(fileName); // read data & parse, store in array
			output();
			sc.close();
		} catch (Exception e) { // catch any errors here
			System.out.print("Oops! Something went wrong."); // error message
		}
	}
	
	// Read in file data
	public static void input(String input) throws FileNotFoundException {
		File file = new File(input); // create a new file object
		scanner = new Scanner(file); // create scanner to read in data (separate from scanner to not interfere when closing scanner)
		array = new ArrayList<String>();
		
		while (scanner.hasNextLine()) { // while there is a line, continue reading in data
			String line = scanner.nextLine(); // grab the current line to store
			String[] splits = line.split(","); // String array to store parsed line where "," exists for Comma Separated Values (csv)
			
			for (int i = 0; i < splits.length; i++) { // add to class array
				array.add(splits[i]);
			}
		}
		scanner.close();
	}
	
	// Output array data
	public static void output() {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
	}

}
