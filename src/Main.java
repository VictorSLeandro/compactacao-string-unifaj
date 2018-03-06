import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
		String linha = "";
		while(br.ready()){ 
   		 linha += br.readLine(); 
		}
		br.close();
		UtilComp c = new UtilComp();
		byte cod[] = c.compactar(linha,5);
		OutputStream out;
		out = new FileOutputStream(new File("texto.paulo"));
		out.write(cod, 0 , cod.length);
		out.flush();
		out.close();
		RandomAccessFile f = new RandomAccessFile("texto.paulo", "r");
		byte[] b = new byte[(int)f.length()];
		f.readFully(b);	
		String x = c.descompactar(b, 5);
		System.out.println(x);
	}

}
