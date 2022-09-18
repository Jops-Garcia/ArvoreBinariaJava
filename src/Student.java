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
    @Override
    public String toString() {
        String value = String.valueOf(getId());
        return "Matricula: "+ value;
    }
   
    //get set
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
 
    }
   
    public float getGrade() {
        return grade;
    }
 
    public void setGrade(float grade) {
        this.grade = grade;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
}
