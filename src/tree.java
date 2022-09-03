public class tree<TYPE> {
    private node<TYPE> root;

    public tree(){
        this.root=null;
    }
    
    
    //method
    public void addNode(TYPE value){
        node<TYPE> newNode = new node<TYPE>(value);
        node<TYPE> oldNode = root;
        if (oldNode==null){
            this.root = newNode;
        }
    }
}
