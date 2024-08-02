import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker
{
    static ArrayList<String> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        final String menu ="A - Add D - Delete I - Insert P - Print Q - Quit";
        boolean done = false;
        String cmd = "";

        do
        {
          //display the list
            displayList();

         //display the menu options
         //get a menu choice
            cmd = SafeInput.getRegExString(in,menu,"[AaDdIiPpQq]");
            cmd = cmd.toUpperCase();

            System.out.println("");

         //execute the choice
           switch(cmd)
            {
                case "A":
                    System.out.println("The command you selected is A. \n");
                    addItem();
                    break;

                case "D":
                    System.out.println("The command you selected is D.\n");
                    deleteItem();
                    break;

                case "I":
                    System.out.println("The command you selected is I.\n");
                    insertItem();
                    break;

                case "P":
                    System.out.println("The command you selected is P.\n");

                    System.out.println("");

                    printList();

                    System.out.println("");

                    break;

                case "Q":

                    System.out.println("The command you selected is Q.\n");

                    boolean finalAnswer = SafeInput.getYNConfirm(in,"Do you wish to continue?");

                    if (!finalAnswer)
                    {
                        System.out.println("Thank you for your input. Goodbye.");
                        System.exit(0);
                    }
                    break;

            }

        }while(!done);
    }

    //Helper Method #1 - Displaying the List.
    private static void displayList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        if(list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%25s\n", i + 1, list.get(i));
            }
        }
        else
        {
            System.out.println("***          List is empty. :(          ***");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

    //Helper Method #2 - Printing the List.
    private static void printList()
    {
        for(int x = 0; x < list.size(); x++)
        {
            System.out.println(list.get(x));
        }
    }

    //Helper Method #3 - Adding Item to the List.
    private static void addItem()
    {
        String choice = SafeInput.getNonZeroLenString(in,"Add your favorite Anime to the list ");
        list.add(choice + "\n");
    }

    //Helper Method #4 - Deleting Item from the List.
    private static int deleteItem()
    {
        int removeChoice = SafeInput.getRangedInt(in,"Select number from the list you would like to remove ",
                1,list.size());
        list.remove(removeChoice - 1); //the array is zero-based so subtract 1.
        return removeChoice;
    }

    //Helper Method #5 - Inserting Item into the List.
        private static void insertItem()
    {
        int indexChoice = SafeInput.getRangedInt(in,"At which number would you like to insert your object? ",
                1,list.size());

        String insertChoice = SafeInput.getNonZeroLenString(in,"Add your favorite Anime to the list ");

        list.add(indexChoice - 1,insertChoice + "\n");
    }
}