import java.util.ArrayDeque;
import java.util.Deque;

//tem q ser um tipo comparavél, n sei como faz pra comparar
public class Tree<TYPE extends Comparable<TYPE>> {
    private Node<TYPE> root;
    private int height;
    private int size;
 
 
    public Tree(){
        this.root=null;
    }
   
    //GET
    public int getHeight(){
        return height;
    }
    public int getSize(){
        return size;
    }
    public Node<TYPE> getRoot(){
        return root;
    }
 
    //Função que insere um objeto na árvore
    public void addNode(TYPE value) {
        Node<TYPE> newNode = new Node<TYPE>(value);
        Node<TYPE> oldNode = this.root;
        int aux=0;
        if (oldNode==null){
            this.root = newNode;
            return;
        }
        boolean added=false;
        while(added!=true){
            //usando metodo doido pra comparar o valor novo com o antigo, pra saber se vai pra esq ou dir
            // -1 igual menor, +1 igual maior, 0 igual igual
            if (newNode.getValue().compareTo(oldNode.getValue())==-1){
                if(oldNode.getLeft()!=null){
                    oldNode=oldNode.getLeft();
                }
                else{
                    oldNode.setLeft(newNode);
                    added=true;
                }
            }
            else{
                if(oldNode.getRight()!=null){
                    oldNode=oldNode.getRight();
                }
                else{
                    oldNode.setRight(newNode);
                    added=true;
                }
            }
            aux++;
        }
        //currentizar altura da arvore
        if(aux>this.height){
            this.height=aux;
        }
        this.size++;
    }
   
       
    //Função de caminhamento em ordem
    public void inOrder(Node<TYPE> current) {
        if (current != null) {
          inOrder(current.left);
          System.out.println(current.getValue().toString());
          inOrder(current.right);
        }
      }
 
    //Função que obtem a altura da arvore recursivamente
    public int height(Node<TYPE> current) {
        if(current == null || (current.left == null && current.right == null)){
          return 0;
        }
        else {
          if (height(current.left) > height(current.right)){
            return ( 1 + height(current.left) );
          }
          else{
            return ( 1 + height(current.right) );
        }
        }
    }
 
    //Função que encontra o menor elemento
    public Node<TYPE> minElement() {
        Node<TYPE> current = root;
        Node<TYPE> previous = null;
        while (current != null) {
            previous = current;
            current = current.left;
        }
        return previous;
      }
   
    //Função que encontra o maior elemento
    public Node<TYPE> maxElement() {
        Node<TYPE> current = root;
        Node<TYPE> previous = null;
        while (current != null) {
            previous = current;
            current = current.right;
        }
        return previous;
    }

    //Função que busca por um objeto na árvore
    public boolean searchNode(TYPE value) {
        Node<TYPE> newNode = new Node<TYPE>(value);
        Node<TYPE> oldNode = this.root;
        if (oldNode==null){
            return false;
        }
        while(oldNode!=null){
            // -1 igual menor, +1 igual maior, 0 igual igual
            if (newNode.getValue().compareTo(oldNode.getValue())==0){
                return true;
            }
            if (newNode.getValue().compareTo(oldNode.getValue())==-1){
                oldNode=oldNode.getLeft();
            }
            else if(newNode.getValue().compareTo(oldNode.getValue())==1){
                oldNode=oldNode.getRight();
            }
        }
        return false;
    }
    //Função que remove um objeto da árvore
    public void removeNode(TYPE value) {
        Node<TYPE> oldNode = this.root;
        if (oldNode==null){
            return;
        }
        Node<TYPE> oldParent = null;
        //Node<TYPE> newNode = new Node<TYPE>(value);
 
        while(oldNode!=null){
            // -1 igual menor, +1 igual maior, 0 igual igual
            if (value.compareTo(oldNode.getValue())==0){
                //achou
                if (oldNode.getRight() != null){ // se tem filho na direita
                    Node<TYPE> newNode = oldNode.getRight();
                    Node<TYPE> newParent = oldNode;
                    while(newNode.getLeft() != null){
                        newParent = newNode;
                        newNode = newNode.getLeft();
                    }
                    newNode.setLeft(oldNode.getLeft());
                    if (oldParent != null){
                        if (oldNode.getValue().compareTo(oldParent.getValue()) == -1){ //oldNode < oldParent
                            oldParent.setLeft(newNode);
                        }else{
                            oldParent.setRight(newNode);
                        }
                    }else{ //se não tem oldParent, então é a root
                        this.root = newNode;
                        newParent.setLeft(null);
                        this.root.setRight(newParent);
                        this.root.setLeft(oldNode.getLeft());
                    }
                    
                    //removeu o Node da árvore
                    if (newNode.getValue().compareTo(newParent.getValue()) == -1){ //newNode < newParent
                        newParent.setLeft(null);
                    }else{
                        newParent.setRight(null);
                    }
                }     
                else if(oldNode.getLeft()!=null){ // se tem filho só na esquerda
                    Node<TYPE> newNode = oldNode.getLeft();
                    Node<TYPE> newParent = oldNode;
                    while(newNode.getRight() != null){
                        newParent = newNode;
                        newNode = newNode.getRight();
                    }
                    if (oldParent != null){
                        if (oldNode.getValue().compareTo(oldParent.getValue()) == -1){ //oldNode < oldParent
                            oldParent.setLeft(newNode);
                        }else{
                            oldParent.setRight(newNode);
                        }
                    }else{ //se for a root
                        this.root = newNode;
                    }
                    
                    //removeu o Node da árvore
                    if (newNode.getValue().compareTo(newParent.getValue()) == -1){ //newNode < newParent
                        newParent.setLeft(null);
                    }else{
                        newParent.setRight(null);
                    }   
                }
                else{ //se nao tem filho
                    if (oldParent != null){
                        if (oldNode.getValue().compareTo(oldParent.getValue())==1){
                            oldParent.setRight(null);
                        }
                        else{
                            oldParent.setLeft(null);
                        }
                    }
                    else{
                        this.root=null;
                    }
                }
            }
            else if (value.compareTo(oldNode.getValue())==-1){//nao achou ent anda pra esq ou dir
                oldParent = oldNode;
                oldNode=oldNode.getLeft();
            }
            else{
                oldParent = oldNode;
                oldNode=oldNode.getRight();
            }
        }
    }
    public void inLevel() {
        Node<TYPE> node= this.root;
        if (node == null){
            return;
        }
        Deque<Node<TYPE>> array = new ArrayDeque<>();
        array.add(node);
        while (!array.isEmpty()) {
            Node<TYPE> current = array.removeFirst();
            System.out.println( current.getValue().toString());
            if (current.getLeft() != null) array.add(current.getLeft());
            if (current.getRight() != null) array.add(current.getRight());
        }
    }
}
