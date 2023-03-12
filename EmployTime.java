import java.util.Scanner;

public class EmployTime {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        // create a 2D array to store employee working hours for each month
        int[][] employeeHours = new int[12][];
        
        for (int i = 0; i < 12; i++) {
            System.out.println("Enter number of employees for " + months[i] + ": ");
            int numEmployees = sc.nextInt();
            
            employeeHours[i] = new int[numEmployees];
            
            for (int j = 0; j < numEmployees; j++) {
                System.out.println("Enter working hours for employee " + (j+1) + " in " + months[i] + " (in minutes): ");
                int hours = sc.nextInt();
                employeeHours[i][j] = hours;
            }
        }
        
        // calculate total working hours for each month
        int[] totalHours = new int[12];
        for (int i = 0; i < 12; i++) {
            int sum = 0;
            for (int j = 0; j < employeeHours[i].length; j++) {
                sum += employeeHours[i][j];
            }
            totalHours[i] = sum;
        }
        
        // calculate average working hours for each month
        double[] avgHours = new double[12];
        for (int i = 0; i < 12; i++) {
            avgHours[i] = (double) totalHours[i] / employeeHours[i].length;
        }
        
        // identify best and worst employees for each month
        int[][] bestEmployees = new int[12][2];
        int[][] worstEmployees = new int[12][2];
        
        for (int i = 0; i < 12; i++) {
            int bestIndex = 0;
            int worstIndex = 0;
            for (int j = 0; j < employeeHours[i].length; j++) {
                if (employeeHours[i][j] > employeeHours[i][bestIndex]) {
                    bestIndex = j;
                }
                if (employeeHours[i][j] < employeeHours[i][worstIndex]) {
                    worstIndex = j;
                }
            }
            bestEmployees[i][0] = bestIndex;
            bestEmployees[i][1] = employeeHours[i][bestIndex];
            worstEmployees[i][0] = worstIndex;
            worstEmployees[i][1] = employeeHours[i][worstIndex];
        }
        
        // display results
        System.out.println("Month\tTotal Hours\tAverage Hours\tBest Employee\tWorst Employee");
        for (int i = 0; i < 12; i++) {
            String bestEmpName = "Employee " + (bestEmployees[i][0]+1);
            String worstEmpName = "Employee " + (worstEmployees[i][0]+1);
            
            System.out.println(months[i] + "\t" + totalHours[i] + "\t\t" + avgHours[i] + "\t\t" + bestEmpName + "\t\t" + worstEmpName);
        }
        
        sc.close();
    }
}
