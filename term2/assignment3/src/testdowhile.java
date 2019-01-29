import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testdowhile {
    public static void main(String[] args) {
        //boolean isValid = false;
        Scanner stdin = new Scanner(System.in);
        String name;
        ArrayList<Student> st = new ArrayList<Student>();
        int grade;
        int c = 0;
        do{
            switch(makechoice()){
                case 1:
                    try{
                        System.out.println("name: ");
                        name = stdin.next();
                        System.out.println("grade: ");
                        grade = stdin.nextInt();
                        Student a = new Student(name, grade);
                        st.add(a);
                        System.out.println("Main menu");

                    }catch (InputMismatchException e){
                        System.out.println("try again 1!");
                        //st.remove(st.size() -1);
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println("try again 2!");
                        //st.remove(st.size() -1);
                    }
                    finally {
                        stdin.nextLine();
                        break;
                    }
                case 2:
                    System.out.println("What student would you like to enter a grade for?");
                    for(int count = 0; count < st.size(); count++){
                        System.out.println((count+1)+") "+st.get(count));
                    }

                    int inputAgain = stdin.nextInt();
                    System.out.println("Please enter a grade for "+st.get(inputAgain-1).getName());
                    grade = stdin.nextInt();
                    st.get(inputAgain-1).setGrade(grade);
                    break;
                case 3:
                    c+=1;
            }
        }while(c == 0);

        System.out.println(st.toString());

    }//end main

    public static int makechoice(){
        Scanner stdin = new Scanner(System.in);
        String warm = "Select one of the following options\n1. Add a student\n2. Edit student grades\n3. Exit";
        System.out.println(warm);
        int choice = stdin.nextInt();
        return choice;
    }

}
