public class TreeAVL<TYPE extends Comparable<TYPE>> extends Tree<TYPE>{
    private Node<TYPE> root;


    public Node<TYPE> getRoot() {
        return root;
    }

    public void setRoot(Node<TYPE> root) {
        this.root = root;
    }




    
    
    int balancingFactor(Node<TYPE> element){
        int factor;
        System.out.println("ESQ" + height(element.getLeft()));
        System.out.println("DIR" + height(element.getRight()));
        factor = (height(element.getLeft()) - height(element.getRight()));
        return factor;
    }

    private Node<TYPE> leftRotation(Node<TYPE> r){
        Node<TYPE> f = r.getRight();
        r.setRight(f.getLeft());
        f.setLeft(r);

        return f;
    }

    private Node<TYPE> rightRotation(Node<TYPE> r){
        Node<TYPE> f = r.getLeft();
        r.setLeft(f.getRight());
        f.setRight(r);

        return f;
    }

    private Node<TYPE> rotacaoEsquerdaDireita(Node<TYPE> r){
        r.setLeft(leftRotation(r.getLeft()));

        return rightRotation(r);
    }

    private Node<TYPE> rotacaoDireitaEsquerda(Node<TYPE> r){
        r.setLeft(leftRotation(r.getLeft()));

        return rightRotation(r);
    }

    Node<TYPE> balancing(Node<TYPE> r){
        if(balancingFactor(r) == 2){
            if(balancingFactor(r.getLeft())>0){
                r = rightRotation(r);
            }else{
                r = rotacaoDireitaEsquerda(r);
            }
        }else if(balancingFactor(r) == -2){
            if(balancingFactor(r.getRight())<0){
                r = leftRotation(r);
            } else{
                r = rotacaoEsquerdaDireita(r);
            }
        }
        return r;

    }
}
