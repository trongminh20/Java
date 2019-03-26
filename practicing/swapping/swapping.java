import java.util.*;

public class swapping{
	public static void main(String[] args){
		pp a = new pp("minh", 48, 45);
		pp b = new pp("hong", 22, 50);
		pp c = new pp("yen",31,100);
		pp d = new pp("tam",30,100);
		ArrayList<pp> list = new ArrayList<pp>();

		list.add(b);
		list.add(a);
		list.add(c);
		list.add(2,d);

		// System.out.println(list.toString());
		for(pp i : list){
			System.out.println(i);
		}
		System.out.println("________");
		for(int i = list.size()-1; i >= 0; i--){
			if(list.get(i).getAge() < list.get(i-1).getAge() || list.get(i).getScore() < list.get(i-1).getScore()){
				pp temp = list.get(i-1);
				list.set(i-1, list.get(i));
				list.set(i, list.get(i-1));
			}
		
			for(pp x : list){
				System.out.println(i+ " : "+x);
			}
			System.out.println();
		}

		
	}

}

class pp{
	private String name;
	private int age;
	private int score;

	pp(String name, int age, int score){
		this.name = name;
		this.age = age;
		this.score = score;
	}
	int getScore(){
		return score;
	}
	int getAge(){
		return age;
	}
	public String toString(){
		return name + " " + age + " " + score;
	}
}