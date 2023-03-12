import java.util.Scanner;

public class Painter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input number of townships
        System.out.print("Enter the number of townships: ");
        int numTownships = input.nextInt();
        
        // Input number of houses in each township
        int[] numHouses = new int[numTownships];
        for (int i = 0; i < numTownships; i++) {
            System.out.print("Enter the number of houses in township " + (i+1) + ": ");
            numHouses[i] = input.nextInt();
        }
        
        // Input size of each house
        int[][] houseSizes = new int[numTownships][];
        for (int i = 0; i < numTownships; i++) {
            houseSizes[i] = new int[numHouses[i]];
            System.out.println("Enter the size of each house in township " + (i+1) + ":");
            for (int j = 0; j < numHouses[i]; j++) {
                System.out.print("House " + (j+1) + ": ");
                houseSizes[i][j] = input.nextInt();
            }
        }
        
        // Calculate time and paint required for each house and township
        double[][] timeRequired = new double[numTownships][];
        double[][] accentPaintRequired = new double[numTownships][];
        double[][] regularPaintRequired = new double[numTownships][];
        for (int i = 0; i < numTownships; i++) {
            timeRequired[i] = new double[numHouses[i]];
            accentPaintRequired[i] = new double[numHouses[i]];
            regularPaintRequired[i] = new double[numHouses[i]];
            for (int j = 0; j < numHouses[i]; j++) {
                int numWalls = 6 + (houseSizes[i][j] - 1) * 4;  // calculate number of walls
                int numAccentWalls = numWalls / 3;  // calculate number of accent walls
                int numRegularWalls = numWalls - numAccentWalls;  // calculate number of regular walls
                accentPaintRequired[i][j] = numAccentWalls * 1.5;  // calculate amount of accent paint required
                regularPaintRequired[i][j] = numRegularWalls * 2.25;  // calculate amount of regular paint required
                timeRequired[i][j] = numAccentWalls * 2.5 + numRegularWalls * 3.25;  // calculate time required
            }
        }
        
        // Output results for each township and house
        for (int i = 0; i < numTownships; i++) {
            System.out.println("Township " + (i+1) + ":");
            for (int j = 0; j < numHouses[i]; j++) {
                System.out.println("House " + (j+1) + ":");
                System.out.printf("Time required: %.2f hours\n", timeRequired[i][j]);
                System.out.printf("Accent paint required: %.2f litres\n", accentPaintRequired[i][j]);
                System.out.printf("Regular paint required: %.2f litres\n", regularPaintRequired[i][j]);
            }
        }
        
        input.close();
    }
}
