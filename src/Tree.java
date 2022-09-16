//tem q ser um tipo comparavél, n sei como faz pra comparar 
public class Tree<TYPE extends Comparable> {
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

    //Função que insere um objeto na árvore
    public void addNode(TYPE value) {
        Node<TYPE> newNode = new Node<TYPE>(value);
        Node<TYPE> oldNode = this.root;
        int aux=0;
        if (oldNode==null){
            this.root = newNode;
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
        //Atualizar altura da arvore
        if(aux>this.height){
            this.height=aux;
        }
        this.size++;
    }
   
    
    //Função de caminhamento em ordem
    public void inOrder(Node<TYPE> current) {
        if (current != null) {
          inOrder(current.left);
          System.out.print(current.value+ ", ");
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
        Node<TYPE> parent = null;
        Node<TYPE> newNode = new Node<TYPE>(value);

        while(oldNode!=null){
            // -1 igual menor, +1 igual maior, 0 igual igual
            if (newNode.getValue().compareTo(oldNode.getValue())==0){
                //found
                //remove
                if(oldNode.getRight()!=null && oldNode.getLeft()!=null){

                }
                else if(oldNode.getRight()!=null){

                }
                else if(oldNode.getLeft()!=null){
                    //parent.setRight
                }
                else{
                    if (oldNode.getValue().compareTo(parent.getValue())==1){
                        parent.setRight(null);
                    }
                    else{
                        parent.setLeft(null);
                    }
                }
                return;
            }
            else if (newNode.getValue().compareTo(oldNode.getValue())==-1){
                parent = oldNode;
                oldNode=oldNode.getLeft();
            }
            else if(newNode.getValue().compareTo(oldNode.getValue())==1){
                parent = oldNode;
                oldNode=oldNode.getRight();
            }
        }
    }
}
