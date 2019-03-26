import java.io.*;
public class test{
	public static void main(String[] args){
		try{
		readFile("text.txt");
	}catch(Exception e)
{
	System.out.println("error!");
}	}

	public static void readFile(String f) throws Exception{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String l = br.readLine();

		while(l != null){
			System.out.println(l);
			l=br.readLine();
		}

		br.close();
		fr.close();

	}

}
