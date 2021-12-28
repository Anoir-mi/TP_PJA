import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		DataInputStream input = null;
		DataOutputStream output = null;
		try {
			socket = new Socket("127.0.0.1",1201);
			System.out.println("connected");
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
			
			
			while(true) {
				System.out.println("choose a task from \n nomrep \n nomfichier \n quiter");
				String task;
				
					task = sc.nextLine();
					output.writeUTF(task);
					if (task == "quiter") {
						break;
					}
					switch (task) {
					case "nomrep":{
						System.out.println("enter a folder name");
						String folder = sc.nextLine();
						File Folder = new File(folder);
						if(!Folder.exists()) {
							System.out.println("error"+folder+"doesn't exist");
						} else {
							output.writeUTF(folder);
						}
						break;
					}
					case "nomfichier": {
						System.out.println("enter a file name");
						String file = sc.nextLine();
						File File = new File(file);
						if(!File.exists()) {
							System.out.println("error"+file+"doesn't exist");
						} else {
							output.writeUTF(file);
						}
						break;
					}
					default:
						throw new IllegalArgumentException("unexpected value: " +task);
						
					}
					String data = input.readUTF();
					System.out.println(data);
				
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
