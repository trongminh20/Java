/*
Name: Minh Phan
ID: 300269120
*/
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
