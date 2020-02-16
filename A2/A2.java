//Name:Hanwen Wang       ID:260778557
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Scanner;

	public class A2 {
		
		@SuppressWarnings("resource")
		public static void main(String args[]) {
			System.out.println("Simple File Listing Program");
			Scanner sc = new Scanner(System.in);
			BufferedReader rd = null;
			
			while(rd == null) {
				System.out.print("Enter name of file to list: ");
				String filename = sc.nextLine();
				if (filename.equals("")) {
					System.out.println("Program terminated");
					System.exit(0);							
				}
	// Try to open the specified file
				try {
					rd = new BufferedReader(new FileReader(filename));
				}
				catch (IOException ex) {
					System.out.println("Unable to open file, try again.");
				}
			}
			
			System.out.println("");
			try {
				bTree bt=new bTree();
				while (true) {
					String line = rd.readLine();							
					if (line == null) break;								
					bt.addNode(line);
				}
				System.out.println("File in sort order:");
				System.out.println("");
				bt.inorder();
				System.out.println("");
				System.out.println("File in reverse sort order:");
				System.out.println("");
				//when stack is not empty, pop out names.
				while (bTree.st.isEmpty()!=true)
				{
					System.out.println(bTree.st.pop());
				}
			}
			catch (IOException ex) {
				System.out.println("I/O Error - program terminated");
				System.exit(-1);
			}
						
			System.out.println("\n\nProgram terminated");

		}
	}
