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
        TreeAVL<Student> avl = new TreeAVL<Student>();
        // ALTERE O NOME DO ARQUIVO AQUI -> |
                                        //  V
        String ArqConfig = meudir + "entradaAleatoria19.txt"; //deixe o txt dentro da pasta src ou altere a variavel "meudir"

        Arquivo.Read(ArqConfig, alunos);
        for(int i =0;i<alunos.size();i++) {
            Student aluno = alunos.get(i);
            newTree.addNode(aluno,newTree.getRoot());
            avl.addNode(aluno,avl.getRoot());
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
                //avl
                avl.setHeight(avl.height(avl.getRoot()));
                System.out.println("\nAltura AVL: "+ avl.getHeight());
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
                newTree.searchNode(new Student(matricula,"",0),newTree.getRoot());
                Long tempoFinal = System. currentTimeMillis();
                System.out.println("\nTempo Total de busca do aluno em ms: " + (tempoFinal - tempoInicial));
                Long tempoInicial1 = System. currentTimeMillis();
                avl.searchNode(new Student(matricula,"",0),avl.getRoot());
                Long tempoFinal1 = System. currentTimeMillis();
                System.out.println("\nTempo Total de busca do aluno em ms(AVL): " + (tempoFinal1 - tempoInicial1));
                lixo = aux.nextLine();
                break;

            case 3:
                System.out.println("\nInforme a matrícula do aluno que deseja apagar:");
                matricula=aux.nextLong();
                newTree.removeNode(new Student(matricula,"",0),newTree.getRoot());
                avl.removeNode(new Student(matricula,"",0),avl.getRoot());
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
                newTree.addNode(new Student(matricula,nome,nota),newTree.getRoot());
                avl.addNode(new Student(matricula,nome,nota),avl.getRoot());
                lixo = aux.nextLine();
                break;

            case 5:
                System.out.print("\nAté logo\n\n");
                 newTree.inOrder(newTree.getRoot());
                newTree.writeInLevel(meudir);
                 System.out.println("\navl: "); //testes apenas
                 avl.inOrder(avl.getRoot());
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