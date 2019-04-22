import java.util.Scanner;

public class sort {

    public static void main(String args[])
    {
        System.out.println("Enter numbers: ");
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        int[] inputArray = new int[inputString.length()];

        //convert string to int array

        for(int i = 0; i < inputString.length(); i++)
        {
            try
            {
                inputArray[i] = Integer.parseInt(String.valueOf(inputString.charAt(i)));
            }
            catch (Exception e)
            {
               System.out.println("Error, enter only numbers as input!");
            }
        }

        //confirm
        System.out.print("You entered: ");
        for(int i = 0; i < inputArray.length; i++)
        {
            System.out.print(inputArray[i]);
        }

        System.out.println();

        System.out.println("Sorting...");

        //call mergesort method on array
        int[] sortedArray = mergesort.mergesort(inputArray);

        System.out.print("The sorted array is: ");

        //print sorted array
        for(int i = 0; i < sortedArray.length; i++)
        {
            System.out.print(sortedArray[i]);
        }
    }
}
