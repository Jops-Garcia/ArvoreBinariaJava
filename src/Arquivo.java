//AUTORES: João Pedro Garcia Pereira e Rodrigo Couto Rodrigues
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
public static void Read(String Caminho, ArrayList<Student> alunos) {

    try {
        FileReader arq = new FileReader(Caminho);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = "";

        try {

            linha = lerArq.readLine();

            while (linha != null) {
                String[] linhaSplit = linha.split(";");

                Student aluno = new Student(Long.parseLong(linhaSplit[0]), linhaSplit[1], Float.parseFloat(linhaSplit[2]));

                alunos.add(aluno);

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException ex) {
            System.out.println("Erro: Não leu o arquivo");
        }
    } catch (FileNotFoundException ex) {
        System.out.println("Erro: Arquivo não encontrado");
    }

}
}