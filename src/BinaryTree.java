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

    public void removeNode(Klant klant) {
        Klant foundKlant = findNode(klant.getKlantId());
        Klant parent = findParent(klant);
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
                removeNode(temp);
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
                removeNode(temp);
            }
        }
    }

    public Klant findParent(Klant child) {
        Klant currentKlant = root;
        if (child == null) {
            System.out.println("Child is null, can't run the function");
        } else {
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

    public int compare(Object firstObject, Object secondObject) {
        int  first = ((Klant) firstObject).getKlantId();
        int  second = ((Klant) secondObject).getKlantId();

        if (first > second) {
            return 1;
        } else if (first < second) {
            return -1;
        } else {
            return 0;
        }
    }

    public void inOrderTraverseTree(Klant currentKlant) {
        if (currentKlant != null) {
            inOrderTraverseTree(currentKlant.leftChild);
            System.out.println(currentKlant);
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

    //key = klantenId
    public Klant findNode(int key) {
        //focusNode = hoogste waarde, bovenaan de tree
        Klant focusNode = root;
        // Zolang de id in focusnode niet gelijk is aan de te zoeken id:
        while (focusNode.getKlantId() != key) {
            // Als de waarde die je zoekt kleiner is als de id van de focusNode
            if (key < focusNode.getKlantId()) {
                // zet in focusNode de node die links onder staat
                focusNode = focusNode.leftChild;
            // Als de waarde die je zoekt groter is als de id van de focusNode
            } else {
                // zet in focusNode de node die rechts onder staat
                focusNode = focusNode.rightChild;
            }
            // als de waarde van de focusNode niet bestaat
            if (focusNode == null)
                // Geef een null waarde terug
                return null;
        }
        // Geef de focusNode terug
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

