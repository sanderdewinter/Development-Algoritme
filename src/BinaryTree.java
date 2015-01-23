public class BinaryTree {

    Klant root;

    public void addNode(int key, Klant klant) {
        if (root == null) {
            root = klant;
        } else {
            Klant focusNode = root;
            Klant parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKlantId()) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = klant;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = klant;
                        return;
                    }
                }
            }
        }
    }

    public void removeKlant(Klant klant) {

        if (klant == root) {

        }

        Klant foundKlant = findNode(klant.getKlantId());
        Klant parent = findParent(klant);

        Klant replaceKlant;
        if (foundKlant == null) {
            System.out.println("Klant not found");
        } else {
            if (foundKlant.rightChild == null && foundKlant.leftChild == null) {
                if (foundKlant.getKlantId() < parent.getKlantId()) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            } else if (foundKlant.rightChild != null) {
                Klant temp = foundKlant.rightChild;
                while (temp.leftChild != null) {
                    temp = temp.leftChild;
                }

                removeKlant(temp);
                temp.rightChild = klant.rightChild;
                temp.leftChild = klant.leftChild;
                klant.rightChild = null;
                klant.leftChild = null;
                parent.rightChild = temp;


            } else {
                Klant temp = foundKlant.leftChild;
                while (temp.rightChild != null) {
                    temp = temp.rightChild;
                }

                temp.rightChild = klant.rightChild;
                temp.leftChild = klant.leftChild;
                klant.rightChild = null;
                klant.leftChild = null;
                parent.leftChild = temp;
                parent.rightChild = temp;
                removeKlant(temp);
            }
        }





    }



    public Klant findParent(Klant child) {
        Klant currentKlant = root;

        if (child == null) {
            System.out.println("child is null muthafucka");
        } else {
            //System.out.println(child);
        }


        while (true) {
            try {
                if (currentKlant.rightChild.getKlantId() == child.getKlantId()) {
                    break;
                } else if (currentKlant.leftChild.getKlantId() == child.getKlantId()) {
                    break;
                } else {
                    if (child.getKlantId() < currentKlant.getKlantId()) {
                        currentKlant = currentKlant.leftChild;
                    } else {
                        currentKlant = currentKlant.rightChild;
                    }
                    if (currentKlant == null)
                        return root;
                }
            } catch (NullPointerException e) {
                if (child.getKlantId() < currentKlant.getKlantId()) {
                    currentKlant = currentKlant.leftChild;
                } else {
                    currentKlant = currentKlant.rightChild;
                }
            }
        }
        return currentKlant;
    }

    private boolean compare(int key, Klant currentKlant) {
        if (key < currentKlant.getKlantId()) {
            return true;
        } else {
            return false;
        }
    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public void inOrderTraverseTree(Klant currentKlant) {

        if (currentKlant != null) {

            // Traverse the left node

            inOrderTraverseTree(currentKlant.leftChild);

            // Visit the currently focused on node

            System.out.println(currentKlant);

            // Traverse the right node

            inOrderTraverseTree(currentKlant.rightChild);

        }

    }

    public void preorderTraverseTree(Klant focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Klant focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Klant findNode(int key) {
        Klant focusNode = root;
        while (focusNode.getKlantId() != key) {
            if (key < focusNode.getKlantId()) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public Klant getRoot() {
        return root.rightChild;
    }

    public int maxId(){
        Klant focusNode = root;
        if(focusNode == null){
            return -1;
        }
        else{
            while(focusNode.rightChild != null){
                focusNode = focusNode.rightChild;
            }
        }
        return focusNode.getKlantId();
    }
}

