public class App {
    public static void main(String[] args) throws Exception {
        Tree<Student> newTree = new Tree<Student>();
        Student teste1 = new Student("Rodrigo",2,0);
        Student teste2 = new Student("jao",1,0);
        Student teste3 = new Student("paulo",3,0);
        Student teste4 = new Student("Rod",4,0);
        //Student teste5 = new Student("jops",5,0);
        newTree.addNode(teste1);
        newTree.addNode(teste2);
        newTree.addNode(teste3);
        newTree.addNode(teste4);
        //newTree.addNode(teste5);
        System.out.println("qtdElem: "+ newTree.getSize());
        System.out.println("Altura: "+ newTree.getHeight());
        // newTree.searchNode(teste1);
        // newTree.searchNode(teste2);
        // newTree.searchNode(teste3);
        // newTree.searchNode(teste4);
        //newTree.deepest(newTree.getRoot());
        newTree.inOrder(newTree.getRoot());
        newTree.inLevel();
        // newTree.removeNode(teste2);
        // System.out.println("removeu \n\n");
        // newTree.inOrder(newTree.getRoot());
        // newTree.inLevel();
    }
}
