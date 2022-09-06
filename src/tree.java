//tem q ser um tipo comparavél, n sei como faz pra comparar 
public class Tree<TYPE extends Comparable> {
    private Node<TYPE> root;
    private int height;

    public Tree(){
        this.root=null;
    }
    
    //GET
    public int getHeight(){
        return height;
    }
    //method

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
            // -1= menor, +1 igual maior, 0 igual igual
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
        //atualizar altura da arvore
        if(aux>this.height){
            this.height=aux;
        }
    }

    public void inOrder(Node<TYPE> current) {
        if (current != null) {
          inOrder(current.left);
          System.out.print(current.value + " ");
          inOrder(current.right);
        }
      }

    //Descobre altura da arvore recursivamente
    public int height(Node<TYPE> current) {
        if(current == null || (current.left == null && current.right == null))
          return 0;
        else {
          if (height(current.left) > height(current.right))
             return ( 1 + height(current.left) );
          else
          return ( 1 + height(current.right) );
        }
     }

     public Node minElement() {
        Node current = root;
        Node previous = null;
        while (current != null) {
            previous = current;
            current = current.left;
        }
        return previous;
      }
    
      public Node maxElement() {
        Node current = root;
        Node previous = null;
        while (current != null) {
            previous = current;
            current = current.right;
        }
        return previous;
}
