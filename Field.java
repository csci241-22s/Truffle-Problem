import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// Class for populating and storeing field information
public class Field {
    private ArrayList<ArrayList<Integer>> truffles; // Truffle fields
    public int row;
    public int columns;
    
    public Field() { // Constructor
        truffles = new ArrayList<ArrayList<Integer>>();
        row = 0;
    }

    // Populate fields from an input file
    public void populate(String fileName) {
        File input = new File(fileName);
        // Row counter
        row = 0;
        String holder;
        String[] splitter;
        try{
            // Arraylist for dynamic allocation
            truffles.add(new ArrayList<Integer>()); 
            Scanner fScanner = new Scanner(input);
            // scan file and save values into appropriate position
            while(fScanner.hasNext()) {
                holder = fScanner.nextLine();
                splitter = holder.split("\\s+");
                for (int i = 0; i < splitter.length; i++) {
                    truffles.get(row).add(Integer.parseInt(splitter[i]));
                }
                truffles.add(new ArrayList<Integer>());
                row++;
            }
            fScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        columns = truffles.size();
    }

    // Print the arraylists in field
    public void printField() {
        System.out.println();
        for (int i = 0; i < truffles.size(); i++) {
            for (int j = 0; j < truffles.get(i).size(); j++) {
                System.out.printf(" %5d ", truffles.get(i).get(j));
            }
            System.out.println();
        }
    }

    // Accessor method for an element in the field
    // returns -1 on out of bounds
    public int get(int x, int y) {
        if (y > truffles.size()-1) {
            return -1;
        }
        if (x  > truffles.get(y).size()-1) {
            return -1;
        }
        return truffles.get(y).get(x);
    }
}
