import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {

	public static String[] nomrep(String folder) {
		File fol = new File(folder);
		return fol.list();
	}

	public static String nomfichier(String file) {
		File fi = new File(file);
		String text = "";
		try {
			Scanner reader = new Scanner(fi);
			if (reader.hasNextLine()) {
				text += reader.nextLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;

	}

	public static void main(String[] args) {
		Socket socket = null;
		try {
			ServerSocket server = new ServerSocket(1201);
			DataInputStream input = null;
			DataOutputStream output = null;
			socket = server.accept();
			System.out.println("Server listening on Port " + socket.getLocalPort());
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());

			while (true) {
				String task = input.readUTF();

				if (task == "quiter") {
					break;
				}

				switch (task) {
				case "nomrep": {
					String folder = input.readUTF();
					String[] t = nomrep(folder);
					String folderlist = "";
					for (int i = 0; i < t.length; i++) {
						folderlist += t[i] + "\n";
					}
					output.writeUTF(folderlist);
					break;
				}
				case "nomfichier": {
					String file = input.readUTF();
					String filetext = nomfichier(file);
					output.writeUTF(filetext);

					break;

				}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
