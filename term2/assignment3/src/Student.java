public class Student {
    private String name;
    private int grade;

    Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
    public String toString() {
        return name + " - " + grade;
    }
}
