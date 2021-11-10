package Dev_TP2;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Class2 {
	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("indiquer le nombre d'employee :");

		int nepl = sc.nextInt();
		Class1 [] Epl = new Class1[nepl];
		
		for (int i = 0; i<nepl; i++) {
			int j = i+1;
			Epl[i]= new Class1();
			
			System.out.println("Employee Numero " + j + "\nName :");
			Epl[i].name = sc.next();
			
			System.out.println("Address :");
			Epl[i].address = sc.next();
			
			System.out.println("SSN :");
			Epl[i].SSN = sc.nextInt();
			
			System.out.println("Number :");
			Epl[i].number = sc.nextInt();
		}
		sc.close();
		
		// Serialization
		
		FileOutputStream fileOut = new FileOutputStream("emp.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(Epl);
		out.close();
		fileOut.close();
		
	       System.out.printf("donnees serialisees sauvegardees dans emp.dat");
	}
}


