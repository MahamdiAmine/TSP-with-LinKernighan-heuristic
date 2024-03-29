import TSPFileparser.Parser;
import heuristics.LinKernighan;
import utils.utils;
import java.io.File;
import java.util.Arrays;

/***
 * you can either use .tsp files or simple a Adjacency matrix from file.
 * ***/
public class Main {

    public static void main(String[] args) throws Exception {
        String pathToTspFile = "./src/data/berlin52.tsp";
        double adjMatrixFromFile[][];
        Parser in = new Parser(new File(pathToTspFile));
        double adjMatrixFromTspFile[][] = in.getAdjacencyMatrix();
        System.out.println("Starting...");

        //System.out.println(Arrays.deepToString(adjMatrixFromTspFile));

        String data_path = "./src/data/data4.txt";
        adjMatrixFromFile = utils.readFromFile(data_path);

        LinKernighan lk = new LinKernighan(adjMatrixFromTspFile);

        // Time keeping
        long start;
        start = System.currentTimeMillis();

        // Show the results even if shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.printf("The solution took: %dms\n", System.currentTimeMillis() - start);
            System.out.println("The solution is: ");
            System.out.println(lk);
            //System.out.println(lk.getDistance());
            //System.out.println(Arrays.toString(lk.getTour()));
        }));
        lk.runAlgorithm();
    }
}

