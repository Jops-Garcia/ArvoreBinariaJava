//tem q ser um tipo comparavél, n sei como faz pra comparar 
public class tree<TYPE extends Comparable> {
    private node<TYPE> root;
    private int height;

    public tree(){
        this.root=null;
    }
    
    //GET
    public int getHeight(){
        return height;
    }
    //method

    public void addNode(TYPE value) {
        node<TYPE> newNode = new node<TYPE>(value);
        node<TYPE> oldNode = this.root;
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
}
