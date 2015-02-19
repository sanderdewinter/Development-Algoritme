public class BinaryTree{
    Klant eerste;

    public void addKlant(int KlantId, Klant klant){
        if(eerste == null){
            eerste = klant;
        } else {
            Klant LaatsteNode = findLast(KlantId, eerste);
            if(KlantId < LaatsteNode.getKlantId()){
                LaatsteNode.leftChild = klant;
            } else {
                LaatsteNode.rightChild = klant;
            }
        }
    }

    public Klant findLast(int KlantId, Klant klant){
        if(KlantId == klant.getKlantId()){
            return klant;
        }else{
            if(KlantId < klant.getKlantId()){
                if(klant.leftChild != null){
                    klant = findLast(KlantId, klant.leftChild);
                } else {
                    return klant;
                }
            }
            if(KlantId > klant.getKlantId()){
                if(klant.rightChild != null){
                    klant = findLast(KlantId, klant.rightChild);
                } else {
                    return klant;
                }
            }
        }
        return klant;
    }


    public Klant search(int klantID) {
        Klant selectedKlant = eerste;
        Klant result;

        if (selectedKlant.getKlantId() == klantID) {
            return selectedKlant;
        } else if (klantID < selectedKlant.getKlantId()) {
            result = search(klantID, selectedKlant.leftChild);
        } else {
            result = search(klantID, selectedKlant.rightChild);
        }

        return result;
    }

    public Klant search(int klantID, Klant selectedKlant) {
        if (selectedKlant.getKlantId() == klantID) {
            return selectedKlant;
        } else if (klantID < selectedKlant.getKlantId()) {
            if(selectedKlant.leftChild != null){
                selectedKlant = search(klantID, selectedKlant.leftChild);
            } else {
                return null;
            }
        } else {
            if(selectedKlant.rightChild != null){
                selectedKlant = search(klantID, selectedKlant.rightChild);
            }else{
                return null;
            }
        }

        return selectedKlant;
    }


    public void removeNode(Klant klant) {
        Klant gevondenKlant = search(klant.getKlantId());
        Klant VorigeNode = findParent(klant);
        if (gevondenKlant == null) {
            System.out.println("Klant not found");
        } else {
            if (gevondenKlant.rightChild == null && gevondenKlant.leftChild == null) {
                if (gevondenKlant.getKlantId() < VorigeNode.getKlantId()) {
                    VorigeNode.leftChild = null;
                } else {
                    VorigeNode.rightChild = null;
                }
            } else if (gevondenKlant.rightChild != null) {
                Klant Tijdelijk = gevondenKlant.rightChild;
                while (Tijdelijk.leftChild != null) {
                    Tijdelijk = Tijdelijk.leftChild;
                }
                removeNode(Tijdelijk);
                Tijdelijk.rightChild = klant.rightChild;
                Tijdelijk.leftChild = klant.leftChild;
                klant.rightChild = null;
                klant.leftChild = null;
                VorigeNode.rightChild = Tijdelijk;
            } else {
                Klant Tijdelijk = gevondenKlant.leftChild;
                while (Tijdelijk.rightChild != null) {
                    Tijdelijk = Tijdelijk.rightChild;
                }
                Tijdelijk.rightChild = klant.rightChild;
                Tijdelijk.leftChild = klant.leftChild;
                klant.rightChild = null;
                klant.leftChild = null;
                VorigeNode.leftChild = Tijdelijk;
                VorigeNode.rightChild = Tijdelijk;
                removeNode(Tijdelijk);
            }
        }
    }

    public Klant findParent(Klant child) {
        Klant dezeNode = eerste;
        if (child == null) {
            System.out.println("Child is null, can't run the function");
        } else {
        }
        while (true) {
            try {
                if (dezeNode.rightChild.getKlantId() == child.getKlantId()) {
                    break;
                } else if (dezeNode.leftChild.getKlantId() == child.getKlantId()) {
                    break;
                } else {
                    if (child.getKlantId() < dezeNode.getKlantId()) {
                        dezeNode = dezeNode.leftChild;
                    } else {
                        dezeNode = dezeNode.rightChild;
                    }
                    if (dezeNode == null)
                        return eerste;
                }
            } catch (NullPointerException e) {
                if (child.getKlantId() < dezeNode.getKlantId()) {
                    dezeNode = dezeNode.leftChild;
                } else {
                    dezeNode = dezeNode.rightChild;
                }
            }
        }
        return dezeNode;
    }




    public Klant getRoot() {
        return eerste;
    }

    public int maxId(){
        Klant dezeNode = eerste;
        if(dezeNode == null){
            return -1;
        }
        else{
            while(dezeNode.rightChild != null){
                dezeNode = dezeNode.rightChild;
            }
        }
        return dezeNode.getKlantId();
    }
}
