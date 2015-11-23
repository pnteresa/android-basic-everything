// github.com/pnteresa/android-basic-everything
// howto: paste properties you want to convert to item to inputfile.in (see testinput.in for example)
// > javac XmlLayoutPropertiesToStyle.java
// > java XmlLayoutPropoertiesToStyle < inputfile.in > outputfile.out
// see the result in outputfile.out
// sorry for bad practice! 
import java.io.*;
import java.util.*;
public class XmlLayoutPropertiesToStyle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			line = line.replace(" ","");
			try {
				String[] arg = line.substring(0,line.length()-1).split( "=\"");
				System.out.println("<item name=\"" + arg[0]+ "\">" + arg[1] +  "</item>");
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Wrong Format!");
			}
		}
	}
}