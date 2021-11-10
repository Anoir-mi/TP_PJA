package Dev_TP2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Class3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class1 [] Epl = null;
		FileInputStream fileIn = new FileInputStream("emp.dat");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Epl = (Class1 []) in.readObject();
		in.close();
		fileIn.close();
		
		
		RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
		
		for (int i = 0; i < Epl.length; i++) {
			raf.writeUTF("Name : "+Epl[i].name + "\n"+ Epl[i].address +"\n"+ Epl[i].SSN + "\n"+ Epl[i].number + "\n __________");

			}
		
		raf.seek(0);
		while (raf.getFilePointer() < raf.length()) {
			System.out.println(raf.readUTF());
			}
		raf.close();
		
	}

	}



