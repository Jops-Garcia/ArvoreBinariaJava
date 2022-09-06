public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private float grade;


    public Student(String name, int id, float grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student Student) {
       if(this.id == Student.id){
           return 0;
       }
       else if(this.id > Student.id){
           return 1;
       }
       else{
           return -1;
       }
}
}
