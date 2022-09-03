public class node<TYPE>{
    private TYPE value;
    private node<TYPE> left;
    private node<TYPE> right;

    public node(TYPE value)
    {
        this.value = value;
    }
    
    //GET
    public node<TYPE> getLeft(){
        return left;
    }
    public node<TYPE> getRight(){
        return right;
    }
    public TYPE getValue(){
        return this.value;
    }

    //SET
    public void  setValor(TYPE value){
        this.value = value;
    }
    public void setRight(node<TYPE> right){
        this.right = right;
    }
    public void setLeft(node<TYPE> left){
        this.left = left;
    }

    
}