import java.util.Stack;

public class PathFinder {
    
    private Field field;
    private int rows;
    private int columns;
    private Node[][] map;
    public PathFinder(Field field) {
        this.field = field;
        this.rows = field.row;
        this.columns = field.columns;
        this.map = new Node[columns][rows];
    }

    //O(n*m) + O(n) + O(2m) = O(n*m) polynomial time
    public void evaluate() {
        // populate 2d array and 
        // set appropriate parent child relationships
        makeNodes();
        int currentMax = 0;
        // Find the node that is the termination of the longest path
        for (int i = 1; i < columns; i++) { // O(n)
            if (map[i][rows-1].pathLength > (
                map[currentMax][rows-1].pathLength)) {
                currentMax = i;
            }
        }
        // throw the node and its parents onto a stack to reverse order
        Stack<Node> nodeStack = new Stack<Node>();
        Node holder = map[currentMax][rows-1];
        for (int j = rows-1; j >= 0; j--) { // O(m)
            nodeStack.add(holder);
            holder = holder.parent;
        }
        // pop the stack to recreate the optimal path
        while (!nodeStack.isEmpty()) { //O(m)
            holder = nodeStack.pop();
            printNode(holder.x, holder.y);
            System.out.println();
        }
        // print out total from path
        System.out.printf("Trufles: %d\n", holder.pathLength);
    }

    // helper function performs format print
    private void printNode(int x, int y) {
        System.out.printf("[%d,%d] - %d", x+1,y+1,field.get(x, y));
    }

    // populate array and set parent child relationships O(n*m)
    private void makeNodes() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                map[i][j] = new Node(field.get(i, j), i, j);
            }
        }
        for (int j = 0; j < rows-1; j++) {
            for (int i = 0; i < columns - 1; i++) {
                if (i != 0) {
                    map[i][j].setLeft(map[i-1][j+1]);
                    map[i-1][j+1].setParent(map[i][j]);
                }
                map[i][j].setCenter(map[i][j+1]);
                map[i][j+1].setParent(map[i][j]);
                if (i != columns-1) {
                    map[i][j].setRight(map[i+1][j+1]);
                    map[i+1][j+1].setParent(map[i][j]);
                }
            }
        }
    }
}
