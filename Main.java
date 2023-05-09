// Alex Sitzman CSCI405 Truffle Problem
// Driver class
public class Main{

    /*
     * 1. Populate field from file
     * 2. create finder object with field
     * 3. evaluate
     */
    public static void main(String[] args) {
        String fileName = args[0];
        Field field = new Field();
        field.populate(fileName);
        field.printField();
        PathFinder finder = new PathFinder(field);
        finder.evaluate();
    }
}