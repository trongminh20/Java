import java.util.*;
public class Assignment_3{
	public static void main(String[] args){
		ArrayList<Student> list= new ArrayList<Student>();
		Scanner stdin = new Scanner(System.in);
		Student m = new Student("minh", 33);
		Student n = new Student("nn", 32);
		Student o = new Student("00", 45);

		list.add(m);
		list.add(n);
		list.add(o);
		//String name = stdin.next();
		//int grade = stdin.nextInt();
		String warm = "Select one of the following options\n1. Add a student\n2. Edit student grades\n3. Exit";
		// System.out.println("Select one of the following options\n1. Add a student\n2. Edit student grades\n3. Exit");
		System.out.println(warm);
		String name;
		int grade;
		int choice = stdin.nextInt();

		switch(choice){
			case 1:
				try{
				System.out.println("Please enter the students name: ");
				name = stdin.next();
				System.out.println("Please enter a grade for "+name);
				grade = stdin.nextInt();
				Student a = new Student(name, grade);

				list.add(a);
				// while(stdin.hasNext() && list.size() < 5){
				// 	name = stdin.next();
				// 	grade = stdin.nextInt();

				// 	a = new Student(name,grade);
				// 	list.add(a);
				// }
				//break;
				}catch(InputMismatchException e) {
					continue;
				}
			case 2:
				System.out.println("What student would you like to enter a grade for?");
				for(int count = 0; count < list.size(); count++){
					System.out.println((count+1)+") "+list.get(count));
				}

				int inputAgain = stdin.nextInt();
					System.out.println("Please enter a grade for "+list.get(inputAgain-1).getName());
					grade = stdin.nextInt();
					list.get(inputAgain-1).setGrade(grade);
			case 3:
				break;
		}

		for(Student i : list){
			System.out.println(i);
		}

	}
}
class Student{
	private String name;
	private int grade;

	Student(String n, int gr){
		name = n;
		grade = gr;
	}

	void setName(String n){
		name = n;
	}

	void setGrade(int gr){
		grade = gr;
	}

	String getName(){
		return name;
	}

	int getGrade(){
		return grade;
	}

	public String toString(){
		return name+" - "+grade;
	}
}