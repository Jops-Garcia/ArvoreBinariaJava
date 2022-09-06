public class Aluno implements Comparable<Aluno> {
    private String name;
    private int id;
    private float grade;


    public Aluno(String name, int id, float grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    @Override
    public int compareTo(Aluno aluno) {
       if(this.id == aluno.id){
           return 0;
       }
       else if(this.id > aluno.id){
           return 1;
       }
       else{
           return -1;
       }
}
}
