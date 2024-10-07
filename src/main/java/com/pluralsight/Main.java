package com.pluralsight;

public class Main {

    //declare a static array name 'Collection' w/objects reference to Book class
    public static Book[] Collection;

    public static void main(String[] args) {

        //assigning the variable Library to the results by calling on the method
        Collection = GetCollectionOfManga();

        char option = PromptMainChoices();

        do  {
            if (option == 'A'){
                System.out.println("\n Here is a list of available titles:");
                System.out.println("---------------------------------------------------------------------------");
                DisplayCollection(Collection);
                break;
            }
            if (option == 'C') {

            }

            if (option == 'X') {

            }
        }
        while (true);



    }

    //declare a method to display elements in the array 'Book'
    public static void DisplayCollection(Book[] books){

        //printf used to format display
        System.out.printf("%7s %35s %15s %20s\n", "ID" , "Title", "ISBN", "CHECKED OUT TO" );
        for(Book book: books){
           // System.out.println(" " +book.getID() + " " + book.getTitle() + " " + book.getISBN());
            //format and display in neat columns; use # to adjust column size
            System.out.printf("%7s %35s %15s %20s\n", book.getID(), book.getTitle(), book.getISBN(), book.getCheckedOutTo());
        }
    }


    //function to display and prompt user for a choice
    public static char PromptMainChoices() {
        System.out.println("\nWelcome to the Neighborhood Library. Please select an option:");
        System.out.println(" Show [A]valable Books");
        System.out.println(" Show [C]heckout out Books");
        System.out.println(" E[x]it the library");

        do {
            System.out.print("Select [A, C, or X]");
            String command = Console.PromptForString();
            if (command.equalsIgnoreCase("A")) {
                return 'A';
            }
            if (command.equalsIgnoreCase("C")) {
                return 'C';
            }
            if (command.equalsIgnoreCase("X")
                    || command.equalsIgnoreCase("EXIT")
                    || command.equalsIgnoreCase("Q")
                    || command.equalsIgnoreCase("QUIT")) {
                return 'X';
            }
        } while (true);

    }

    //define a library using an array as a method
    public static Book[] GetCollectionOfManga(){

        //declare a library with 20 elements
        Book[ ] library = new Book[20];

        //define each element in the array
        library[0] = new Book(1, "1421536250","One Piece: East Blue 1-2-3");
        library[1] = new Book(2, "1591162769", "Death Note Vol. 1");
        library[2] = new Book(3, "1569319014", "Naruto Vol. 1");
        library[3] = new Book(4, "1421525810", "Bleach Vol. 1");
        library[4] = new Book(5, "1421542250", "Attack on Titan Vol. 1");
        library[5] = new Book(6, "1595326338", "Fullmetal Alchemist Vol. 1");
        library[6] = new Book(7, "1591165385", "Dragon Ball Z Vol. 1");
        library[7] = new Book(8, "1421536501", "One Piece: East Blue 4-5-6");
        library[8] = new Book(9, "0316317578", "My Hero Academia Vol. 1");
        library[9] = new Book(10, "1421538172", "One Piece: East Blue 7-8-9");
        library[10] = new Book(11, "1591163510", "Rurouni Kenshin Vol. 1");
        library[11] = new Book(12, "1591164142", "Inuyasha Vol. 1");
        library[12] = new Book(13, "1569319057", "Yu Yu Hakusho Vol. 1");
        library[13] = new Book(14, "1421537035", "One Piece: East Blue 10-11-12");
        library[14] = new Book(15, "1421585189", "Fairy Tail Vol. 1");
        library[15] = new Book(16, "0316350768", "Tokyo Ghoul Vol. 1");
        library[16] = new Book(17, "1974702766", "One Punch Man Vol. 1");
        library[17] = new Book(18, "1421590717", "The Promised Neverland Vol. 1");
        library[18] = new Book(19, "1421537931", "One Piece: Baroque Works 13-14-15");
        library[19] = new Book(20, "1974700747", "Black Clover Vol. 1");

        return library;
    }
}