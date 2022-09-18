//AUTORES: João Pedro Garcia Pereira e Rodrigo Couto Rodrigues
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String meudir = System.getProperty("user.dir");
        ArrayList<Student> alunos= new ArrayList<Student>();
        meudir = meudir + "\\src\\";

        Tree<Student> newTree = new Tree<Student>();
        String ArqConfig = meudir + "teste_10000.txt";
        Arquivo.Read(ArqConfig, alunos);
        for(int i =0;i<alunos.size();i++) {
            Student aluno = alunos.get(i);
            newTree.addNode(aluno);
        }
        //newTree.inOrder(newTree.getRoot());
        newTree.inLevel();
        System.out.println("qtdElem: "+ newTree.getSize());
        newTree.setHeight(newTree.height(newTree.getRoot()));
        System.out.println("Altura: "+ newTree.getHeight());
    }
}
