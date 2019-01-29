/*
Name: Minh Phan
ID: 300269120
* */
import java.util.*;

public class studentManager{
    public static void main(String[] args) {
         boolean isValid = false;
         int grade;

         String name;
         ArrayList<Student> st = new ArrayList<Student>();

         Scanner stdin = new Scanner(System.in);

         while(!isValid){
             try{
                 switch(makeChoices()){
                     case 1:
                         System.out.println("Please enter the students name: ");
                         name = stdin.next();
                         System.out.println("Please enter a grade for "+name+":");
                         grade = stdin.nextInt();
                         Student a = new Student(name, grade);
                         st.add(a);
                         break;
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
                         isValid = true;
                 }//end switch
             }//end try block
             catch (InputMismatchException e){
                 stdin.nextLine();
                System.out.println("You entered wrong input, please try again!!");
             }catch (IndexOutOfBoundsException ex){
                 stdin.nextLine();
                System.out.println("You entered wrong input, please try again!!");
             }
         }//end while

         System.out.println("Thank you, Goodbye!");

    }//end main method

    public static int makeChoices(){
        Scanner stdin = new Scanner(System.in);
        int choice = 0;
        try {
            String warm = "\nMain menu\n\n\n" +
                    "Select one of the following options\n" +
                    "1. Add a student\n2. Edit student " +
                    "grades\n" +
                    "3. Exit";
            System.out.println(warm);
            choice = stdin.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Your selection should be number(1,2,3), please!");
        }
        return choice;
    }
}