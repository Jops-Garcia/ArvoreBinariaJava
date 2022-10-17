public class TreeAVL<TYPE extends Comparable> extends Tree<TYPE>{
    private Node<TYPE> root;
    private int height;
    private int size;

    public Node<TYPE> getRoot() {
        return root;
    }

    public void setRoot(Node<TYPE> root) {
        this.root = root;
    }




    @Override
    public void addNode (TYPE value,Node<TYPE> raiz){
        Node<TYPE> newNode = new Node<TYPE>(value);
        if(this.root != null){
            this.root=addRecursao(this.root,newNode);
            if (this.root.balancingFactor()>1){
                if(this.root.getRight().balancingFactor()>0){
                    this.root=leftRotation(this.root);
                }
                else{
                    this.root=rotacaoDireitaEsquerda(this.root);
                }
            }
            else if(this.root.balancingFactor()<-1){
                if(this.root.getLeft().balancingFactor()<0){
                    this.root=rightRotation(this.root);
                }
                else{
                    this.root=rotacaoEsquerdaDireita(this.root);
                }
            }
        }else{
             this.root=newNode;
            }
    }
    
    protected Node<TYPE> addRecursao(Node<TYPE> atual,Node<TYPE> novo) {
        if (novo.getValue().compareTo(atual.getValue())<0){
            if(atual.getLeft()==null){
                atual.setLeft(novo);
            }else{
                atual.setLeft(addRecursao(atual.getLeft(),novo));
            }
        }else{
            if(atual.getRight()==null){
                atual.setRight(novo);
            }else{
                atual.setRight(addRecursao(atual.getRight(),novo));
            }
        }
        
        
        return atual;
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
        r.setRight(rightRotation(r.getRight()));

        return leftRotation(r);
    }

    // Node<TYPE> balancing(Node<TYPE> r){
    //     if(balancingFactor(r) == 2){
    //         if(balancingFactor(r.getLeft())>0){
    //             r = rightRotation(r);
    //         }else{
    //             r = rotacaoDireitaEsquerda(r);
    //         }
    //     }else if(balancingFactor(r) == -2){
    //         if(balancingFactor(r.getRight())<0){
    //             r = leftRotation(r);
    //         } else{
    //             r = rotacaoEsquerdaDireita(r);
    //         }
    //     }
    //     return r;

    // }
}
