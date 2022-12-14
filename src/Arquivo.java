/**
 *
 * @author João Pedro Garcia & Rodrigo Couto Rodrigues
 */
//import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
public static void Read(String Caminho, ArrayList<Student> alunos) {

    try {
        FileReader arq = new FileReader(Caminho);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = "";

        try {
            //pula primeira linha
            linha = lerArq.readLine();
            linha = lerArq.readLine();

            while (linha != null) {
                String[] linhaSplit = linha.split(";");

                Student aluno = new Student(Long.parseLong(linhaSplit[0]), linhaSplit[1], Float.parseFloat(linhaSplit[2]));

                alunos.add(aluno);

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException ex) {
            System.out.println("Erro: Não leu o arquivo"); //adicionando comentario
        }
    } catch (FileNotFoundException ex) {
        System.out.println("Erro: Arquivo não encontrado");
    }

}
public static boolean Write(String caminho, String texto) {
    try {
        //remover da pasta após o uso para testes pois irá append em no mesmo arquivo
        FileWriter arq = new FileWriter(caminho,true);
        arq.write(texto + "\n");
        arq.close();
        return true;
    } catch (IOException e) {
        System.out.println(e.getMessage());
        return false;
    }
}
}
