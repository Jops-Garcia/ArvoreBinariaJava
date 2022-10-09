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
    public void addNode (TYPE value){
        Node<TYPE> newNode = new Node<TYPE>(value);
        Node<TYPE> oldNode = this.root;
        int aux=0;
        if (oldNode==null){
            this.root = newNode;
            this.size++;
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
        //optamos por nao inserir um caso onde há matriculas duplicadas pensando no processamento
        //currentizar altura da arvore
        if(aux>this.height){
            this.height=aux;
        }
        this.size++;


        if (this.root.balancingFactor()>1){
            if(this.root.getRight().balancingFactor()>0){
                this.root=this.leftRotation(this.root);
            }
            else{
                this.root=this.rotacaoDireitaEsquerda(this.root);
            }
        }
        else if(this.root.balancingFactor()<-1){
            if(this.root.getLeft().balancingFactor()<0){
                this.root=this.rightRotation(this.root);
            }
            else{
                this.root=this.rotacaoEsquerdaDireita(this.root);
            }
        }
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
