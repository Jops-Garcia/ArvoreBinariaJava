/**
 *
 * @author João Pedro Garcia & Rodrigo Couto Rodrigues
 */
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String meudir = System.getProperty("user.dir");
        ArrayList<Student> alunos= new ArrayList<Student>();
        meudir = meudir + "\\src\\";

        Tree<Student> newTree = new Tree<Student>();
        // ALTERE O NOME DO ARQUIVO AQUI -> |
                                        //  V
        String ArqConfig = meudir + "entradaBalanceada100000.txt"; //deixe o txt dentro da pasta src ou altere a variavel "meudir"

        Arquivo.Read(ArqConfig, alunos);
        for(int i =0;i<alunos.size();i++) {
            Student aluno = alunos.get(i);
            newTree.addNode(aluno);
        }
    
        Scanner menu = new Scanner (System.in);
        Scanner aux = new Scanner (System.in);
        long matricula=0;
        int opcao = 0;
        String lixo;
        float nota;
        String nome;
        while (opcao!=5) {            
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
            System.out.print("##---------------------Menu-------------------##\n\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("| Opção 1 - Exibir estatísticas                  |\n");
            System.out.print("| Opção 2 - Efetuar busca por matrícula          |\n");
            System.out.print("| Opção 3 - Excluir por matrícula                |\n");
            System.out.print("| Opção 4 - Incluir aluno                        |\n");
            System.out.print("| Opção 5 - Sair                                 |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = menu.nextInt();

             if (opcao == 5) {
                 menu.close();
                 aux.close();
             }

            switch (opcao) {
            case 1:
                //quantidade de elementos
                System.out.println("\nqtdElem: "+ newTree.getSize());
                //Altura
                newTree.setHeight(newTree.height(newTree.getRoot()));
                System.out.println("\nAltura: "+ newTree.getHeight());
                //menor elem

                System.out.println("\nMenor Elemento: "+ (newTree.minElement().getValue().toString()));
                //maior elem
                System.out.println("\nMaior Elemento: "+ (newTree.maxElement().getValue().toString()));
                //pior caso
                System.out.println("\npior caso: "+ (newTree.worstNode().getValue().toString()));
                break;

            case 2:
                System.out.println("\nInforme a matrícula do aluno procurado:");
                matricula=aux.nextLong();
                Long tempoInicial = System. currentTimeMillis();
                newTree.searchNode(new Student(matricula,"",0));
                Long tempoFinal = System. currentTimeMillis();
                System.out.println("\nTempo Total de busca do aluno em ms: " + (tempoFinal - tempoInicial));
                lixo = aux.nextLine();
                break;

            case 3:
                System.out.println("\nInforme a matrícula do aluno que deseja apagar:");
                matricula=aux.nextLong();
                newTree.removeNode(new Student(matricula,"",0));
                lixo = aux.nextLine();
                break;

            case 4:
                System.out.println("\nInforme a matrícula do aluno que deseja inserir:");
                matricula=aux.nextLong();
                System.out.println("\nInforme a nome do aluno que deseja inserir:");
                lixo=aux.nextLine();
                nome=aux.next();
                System.out.println("\nInforme a nota do aluno que deseja inserir:");
                nota=aux.nextFloat();
                newTree.addNode(new Student(matricula,nome,nota));
                lixo = aux.nextLine();
                break;

            case 5:
                System.out.print("\nAté logo\n");
                newTree.inOrder(newTree.getRoot());
                newTree.writeInLevel(meudir);
                break;
            default:
                System.out.print("\nOpção Inválida!");

                break;
            }
            if(opcao!=5){
            System.out.print("\nPressione Enter para continuar...");
            lixo=aux.nextLine();
            }
        }
    }
}