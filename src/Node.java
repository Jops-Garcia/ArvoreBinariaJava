/**
 *
 * @author João Pedro Garcia & Rodrigo Couto Rodrigues
 */
public class Node<TYPE>{
    //value == Aluno
    TYPE value;
    Node<TYPE> left;
    Node<TYPE> right;

 


    public Node(TYPE value)
    {
        this.value = value;
    }
   
    //GET
    public Node<TYPE> getLeft(){
        return left;
    }
    public Node<TYPE> getRight(){
        return right;
    }
    public TYPE getValue(){
        return this.value;
    }
    


    //SET
    public void  setValor(TYPE value){
        this.value = value;
    }
    public void setRight(Node<TYPE> right){
        this.right = right;
    }
    public void setLeft(Node<TYPE> left){
        this.left = left;
    }

    public int getSideHeight(Node<TYPE> r){
        if (r==null){
            return -1;
        }
        else{
            int hd = getSideHeight(r.getRight());
            int he = getSideHeight(r.getLeft());
            if(hd>he){
                return hd+1;
            }
            else{
                return he+1;
            }
        }
    }
    public int balancingFactor(){
        return getSideHeight(this.right) - getSideHeight(this.left);
    }
   
}
 
