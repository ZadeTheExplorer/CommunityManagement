package Movie;

public class BinarySearchTree {

    private static MovieNode root;
    String[] node = new String[20];
    public BinarySearchTree() {
        root = null;
    }

    public void addNode(String title, Movie newMovie){

        MovieNode newNode = new MovieNode(title,newMovie);

        if(root == null) {
            root = newNode;
            return;
        }

        MovieNode currentNode = root;
        MovieNode parent;

        while(true) {
            parent = currentNode;

            if(currentNode.getMovie().getTitle().compareTo(title) > 0){

                currentNode = currentNode.getLeftNode();

                if(currentNode == null){
                    parent.setLeftNode(newNode);
                    return;
                }

            }else{
                currentNode = currentNode.getRightNode();
                if(currentNode == null){
                    parent.setRightNode(newNode);
                    return;
                }
            }
        }

    }

    public MovieNode search(String title){

        MovieNode currentNode = root;

        while(currentNode != null){

            if(currentNode.getMovie().getTitle().toLowerCase().compareTo(title.toLowerCase()) == 0) return currentNode;

            if(currentNode.getMovie().getTitle().toLowerCase().compareTo(title.toLowerCase()) > 0){
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return null;
    }

    // Helper function for deleteNode
    private MovieNode getReplaceNode(MovieNode replacedNode){

        MovieNode replace = replacedNode;
        MovieNode parent = replacedNode;
        MovieNode currentNode = replacedNode.getRightNode();

        while(currentNode != null){
            parent = replace;
            replace = currentNode;
            currentNode = currentNode.getLeftNode();
        }

        if (replace != replacedNode.getRightNode()){
            parent.setLeftNode(replace.getRightNode());
            replace.setRightNode(replacedNode.getRightNode());

        }

        return replace;

    }

    public boolean deleteNode(String title){
        MovieNode currentNode = root;
        MovieNode parent = root;

        boolean isLeft = true;

        while(currentNode.getMovie().getTitle().toLowerCase().compareTo(title.toLowerCase()) != 0){

            parent = currentNode;

            if(currentNode.getMovie().getTitle().toLowerCase().compareTo(title.toLowerCase()) > 0){
                currentNode = currentNode.getLeftNode();
                isLeft = true;
            }
            else{
                currentNode = currentNode.getRightNode();
                isLeft = false;
            }

            if(currentNode == null){
                return false;
            }
        }

        if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null){
            if(currentNode == root){
                root = null;
            }
            if(isLeft){
                parent.setLeftNode(null);
            }else{
                parent.setRightNode(null);
            }
        }
        else if(currentNode.getRightNode() == null) {
            if(currentNode == root){
                root = currentNode.getLeftNode();
            }else if(isLeft){
                parent.setLeftNode(currentNode.getLeftNode());
            }else {
                parent.setRightNode(currentNode.getLeftNode());
            }
        }else if(currentNode.getLeftNode() == null) {
            if(currentNode == root){
                root = currentNode.getRightNode();
            }else if(isLeft){
                parent.setLeftNode(currentNode.getRightNode());
            }else{
                parent.setRightNode(currentNode.getRightNode());
            }
        }else {
            MovieNode replacement = getReplaceNode(currentNode);
            if(currentNode == root){
                root = replacement;
            }else if(isLeft){
                parent.setLeftNode(replacement);
            }else{
                parent.setRightNode(replacement);
            }
            replacement.setLeftNode(currentNode.getLeftNode());
        }
        return true;
    }

    private void addToStringARR(String string) {
        int i=0;

        while (i<node.length){
            if (node[i] == null){
                node[i] = string;
                return;
            }
            else if (node[i].compareTo(string) == 0) {
                break;
            }
            i++;
        }
    }

    public void innerTraverse(MovieNode node){
        if(node != null){
            innerTraverse(node.getLeftNode());
            addToStringARR(node.getMovie().toString());
            innerTraverse(node.getRightNode());
        }
    }
    public String[] getAllNode() {
        innerTraverse(root);
        return node;
    }

    public static MovieNode getRoot() {
        return root;
    }
}

