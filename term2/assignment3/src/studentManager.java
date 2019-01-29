import java.util.*;

public class studentManager{
    public static void main(String[] args) {
         boolean isValid = false;
         Scanner stdin = new Scanner(System.in);
         String name;
         ArrayList<Student> st = new ArrayList<Student>();
         int grade;
         while(!isValid){
             switch(makechoice()){
                 case 1:
                     try{
                         System.out.println("Please enter the students name: ");
                         name = stdin.next();
                         System.out.println("Please enter a grade for "+name+":");
                         grade = stdin.nextInt();
                         Student a = new Student(name, grade);
                         st.add(a);
                     }catch (InputMismatchException e){
                         System.out.println("You entered wrong input!!");
                     }catch (IndexOutOfBoundsException ex){
                         System.out.println("You entered wrong input!!");
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
                     System.out.println("Thank you, Goodbye!");
                     isValid = true;
             }//end switch
         }//end while

         //System.out.println(st.toString());

    }//end main

    public static int makechoice(){
        Scanner stdin = new Scanner(System.in);
        int choice = 0;
        try {
            String warm = "Main menu\n\n\nSelect one of the following options\n1. Add a student\n2. Edit student " +
                    "grades\n3. Exit";
            System.out.println(warm);
            choice = stdin.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Your selection should be number(1,2,3), please!");
        }
        return choice;
    }
}