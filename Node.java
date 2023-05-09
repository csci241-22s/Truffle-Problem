// Node class for Truffle problem
/*
 * Holds value, position, pathlength, parent, and child information
 */
public class Node {
    public Node parent;
    public Node left;
    public Node center;
    public Node right;
    public int value;
    public int pathLength;
    public int x;
    public int y;

    public Node(int value, int x, int y) {
        this.value = value;
        this.pathLength = value;
        this.x = x;
        this.y = y;
    }

    /*
     * Setter functions for fields
     */
    // Try to set parent, if parent is from a shorter path then do not update
    public void setParent(Node newparent) {
        if (this.parent == null) {
            this.parent = newparent;
            this.pathLength = parent.pathLength + value;
        } else if(this.parent.pathLength < newparent.pathLength){
            this.parent = newparent;
            this.pathLength = newparent.pathLength + value;
        }

    }

    public void setLeft(Node left) {
        this.left = left;
    }  

    public void setCenter(Node center) {
        this.center = center;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
