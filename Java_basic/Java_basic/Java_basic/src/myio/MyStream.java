package myio;
import java.io.*;
public class MyStream {

	public static void copy(InputStream in, OutputStream out) throws IOException {
		int c;
		while((c=in.read()) != -1) {
			out.write(c);
		}
	}
	
	public static void copy(Reader in, Writer out) throws IOException {
		int c;
		while((c=in.read()) != -1) {
			out.write(c);
		}
	}
	public static void main(String[] args) {
		try {
			FileReader in1 = new FileReader("file4.txt");
			FileWriter out1 = new FileWriter("file5.txt");
			MyStream.copy(in1, out1);
			in1.close();
			out1.close();
			
			String msg = "Java rulez a lot!";
			StringReader in2 = new StringReader(msg);
			FileWriter out2 = new FileWriter("file6.txt");
			MyStream.copy(in2, out2);
			in2.close();
			out2.close();
			
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
	}
}
