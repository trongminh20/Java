 import java.util.*;
 public class book{
 	private String title ;
 	private String author;


 	public book(String title, String author){
 			this.title = title;
 			this.author = author;
 		}

 	// public void setInfo(String ti, String au){
 	// 	title = ti;
 	// 	author = au;
 	// }
 	public String getInfo(){
 		return title + " and "+ author;
 	}
	public String tostring(){
		return title +" and " + author;
	}
 }