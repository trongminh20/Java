/*
Name: Minh Phan
ID: 300269120
*/
import java.util.*;

public class arrayList{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();
        Student stu = new Student(input);
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(stu);

        while(stdin.hasNext()) {
            input = stdin.nextLine();
            stu = new Student(input);

            if (input.equals("next")) {
                list.remove(0);
            } else if (input.equals("end")) {
                break;
            } else {
                if (stu.getAge() < list.get(list.size() - 1).getAge() || stu.getGrade() < list.get(list.size() - 1).getGrade()) {
                    list.add(list.size() - 1, stu);
                }else{
                    list.add(stu);
                }
            }
        }
        for(Student i : list){
            System.out.println(i.getName());
        }
    }
}
class Student {
   private String student;

    Student(String student){
        this.student = student;
    }

    //getters
    public String getName(){
        String[] a = student.split(" ");
        return a[0];
    }
    public int getAge(){
        String[] a = student.split(" ");
        return Integer.parseInt(a[1]);
    }
    public int getGrade(){
        String[] a = student.split(" ");
        return Integer.parseInt(a[2]);
    }
    public String toString(){
        return student;
    }
}