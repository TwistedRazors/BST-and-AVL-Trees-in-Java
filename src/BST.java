import java.util.Scanner;
import java.io.*;
public class BST {
private static Scanner x;
private static Scanner y;

	public static void openFile() {
		try {
			x = new Scanner(new File("SampleData1.txt"));
			y = new Scanner(new File("SampleData2.txt"));
		}
		catch(Exception e) {
			System.out.println("could not find file");
		}
	}

	public static void readFile() {
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			System.out.printf("%s %s %s \n", a, b, c);
		}
		while(y.hasNext()) {
			String d = y.next();
			String e = y.next();
			String f = y.next();
			
			System.out.printf("%s %s %s \n", d, e, f);
		}
	}
	
	public static void closeFile() {
		x.close();
		y.close();
	}
	public static void main(String[] args) {
		openFile();
		readFile();
		closeFile();
		System.out.println("1. Would you like to search a student?");
		System.out.println("2. Would you like to find student info with minimum id?");
		System.out.println("3. Would you like to find student info with maximum id?");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice) {
		case 1: System.out.println("Which id would you like to search?");
				int id = input.nextInt();
				//find(T,id);
				break;
		case 2: //minID(T);
				System.out.println("min id");
				break;
		case 3: //maxID(T);
				System.out.println("max id");
				break;
		default: System.out.println("Invalid Choice. Try Again.");
				 main(args);
		}
	}

}
