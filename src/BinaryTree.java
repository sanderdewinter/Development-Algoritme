public class BinaryTree {

    Klant root;

    public void addKlant(int KlantID, Klant klant) {
        if (root == null){
            root = klant;
        } else {
            Klant LaatsteNode = findLast(KlantID, root);
            if (KlantID < LaatsteNode.getKlantId()){
                LaatsteNode.leftChild = klant;
            } else {
                LaatsteNode.rightChild = klant;
            }
        }
    }

    public Klant findLast(int KlantId, Klant klant) {
        if (KlantId == klant.getKlantId()) {
            return klant;
        } else {
            if (KlantId < klant.getKlantId()) {
                if(klant.leftChild != null){
                    klant = findLast(KlantId, klant.leftChild);
                } else {
                    return klant;
                }
            }

            if (KlantId > klant.getKlantId()) {
                if (klant.rightChild != null) {
                    klant = findLast(KlantId, klant.rightChild);
                } else {
                    return klant;
                }
            }
        }
        return klant;
    }

    public Klant searchKlant(int klantID) {
        Klant selectedKlant = root;
        Klant result;

        if (selectedKlant.getKlantId() == klantID) {
            return selectedKlant;
        } else if (klantID < selectedKlant.getKlantId()) {
            result = searchKlant(klantID, selectedKlant.leftChild);
        } else {
            result = searchKlant(klantID, selectedKlant.rightChild);
        }

        return result;
    }

    public Klant searchKlant(int klantID, Klant selectedKlant) {
        if (selectedKlant.getKlantId() == klantID) {
            return selectedKlant;
        } else if (klantID < selectedKlant.getKlantId()) {
            searchKlant(klantID, selectedKlant.leftChild);
        } else {
            searchKlant(klantID, selectedKlant.rightChild);
        }

        return null;
    }

    public void removeKlant(Klant klant) {

        Klant foundKlant = searchKlant(klant.getKlantId());
        Klant parent = findParent(klant);

        Klant replaceKlant;

        if (foundKlant == null) {
            System.out.println("Klant unknown");
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

    public Klant getRoot() {
        return root.rightChild;
    }

    public int maxId(){
        Klant focusNode = root;

        if(focusNode == null){
            return -1;
        } else {
            while(focusNode.rightChild != null){
                focusNode = focusNode.rightChild;
            }
        }
        return focusNode.getKlantId();
    }
}
