package com.pluralsight;


public class Library {

    //declare a static array w/objects reference to 'Book' class
    static Book[] Catalog;

    public static void main(String[] args) {
    //assign the variable Catalog with elements by calling on a method
    Catalog = InitializeCollectionOfManga();

    char option;
    //create a loop constructor to continue prompting user command
    do{
        option = PromptMainChoices();
        //if user enter A call methods to show available volumes and start check out process
        if(option == 'A'){
            Book[] availableVolumes = ShowAvailableVolumes(Catalog);
            DisplayVolumes(availableVolumes);
            checkOutVolume(availableVolumes);
        }
        //if user enter C call methods to show volumes checked out and start check in process
        else if(option == 'C'){
            Book[] checkedOutVolumes = ShowCheckedOutVolumes(Catalog);
            DisplayVolumes(checkedOutVolumes);
            checkInVolume(checkedOutVolumes);
        }
    } while (option != 'X'); //will loop as long as user does not enter a Quit command
}

//method used to take an array of Book objects and return to the array of available volumes
public static Book[] ShowAvailableVolumes(Book[] volumes){
        //create a temporary array to store available books
    Book[] available = new Book[volumes.length];
    int nextIndex = 0; //track the position in the array
    //loop thru array. if a volume is not checked out add the Available array
    for(Book volume : volumes) {
        if(!volume.isCheckedOut()){
            available[nextIndex++] = volume;
        }
    }
    //create a final array to hold available volumes
    Book[] results = new Book[nextIndex];
    System.arraycopy(available,0,results,0,nextIndex);
    return results;
}

public static Book[] ShowCheckedOutVolumes(Book[] volumes){
        //create a temporary array to hold
    Book[] checkedOut = new Book[volumes.length];

    int nextIndex = 0;
    //loop thru array. if a volume is check out add the Unavailable array
    for(Book volume : volumes){
        if(volume.isCheckedOut()){
            checkedOut[nextIndex++] = volume;
        }
    }
    //create a final array to hold unavailable volumes
    Book[] results = new Book[nextIndex];
    System.arraycopy(checkedOut,0,results,0,nextIndex);
    return results;
}

//create a method that gives user several options
public static char PromptMainChoices(){
    System.out.println("\nWelcome to \"Manga Catalog,\" a sub-session of the Library! How can I help you?");
    System.out.println("\t\tShow [A]vailable Manga \n\t\tShow [C]hecked Out Manga \n\t\tE[X]it Manga catalog");

    //use a 'do' to execute different blocks of code (if statements)
    do{
        //prompt and display user commands
        System.out.print("Enter [A, C, X] to access a window ");
        String userSelect = Console.PromptForString();
        //conditions based on the user input
        if ( userSelect.equalsIgnoreCase("A")){
            return 'A';
        }
        if (userSelect.equalsIgnoreCase("C")){
            return 'C';
        }
        if (userSelect.equalsIgnoreCase("X")
                || userSelect.equalsIgnoreCase("EXIT")
                || userSelect.equalsIgnoreCase("Q")
                || userSelect.equalsIgnoreCase("QUIT")){
            return 'X';
        }
    }  while (true); //will loop infinitely as long as the condition is 'true'

}

//create a method to handle the process of returning a volume by calling elements from an array of volumes unavailable
public static void checkInVolume(Book[] unavailableVolumes){
    //prompt user and store response in a boolean variable
    boolean want = Console.PromptForYesNo("Checking in a book today?");
    String userInput;
    //if want is 'true' enter do-while loop
    if (want) {
        do {
            userInput = Console.PromptForString("Enter ID # of the manga you wish to check in or X to exit: ");
            //user entered quit therefore return to main window
            if (userInput.equalsIgnoreCase("X")
                    || userInput.equalsIgnoreCase("EXIT")
                    || userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("QUIT")) {
                break;
            }

            //user entered ID therefore start check in process
            else {
                int idNumber = Integer.parseInt(userInput); //convert # String to integer
                boolean isVolumeCheckedIn = false; //is manga checked in? Set to false
                //loop thru each element in array and find a match
                for (Book volume : unavailableVolumes) {
                    if (volume.getID() == idNumber) {
                        volume.checkIn(); //call 'checkIn()' method to mark as checked in
                        isVolumeCheckedIn = true; //indicate check in was successful
                    }
                }
                //display feedback with
                if (isVolumeCheckedIn){ System.out.println("Manga return successfully"); }
                else { System.out.println("Can not check in this manga."); }
            }
        }
        while (true);
    }
}

//create a method to handle the process of checking out a volume by calling elements from an array of volumes available.
public static void checkOutVolume(Book[] availableVolumes){
    //declare variables to store user input data
    boolean want = Console.PromptForYesNo("Checking out a volume today?");
    String name;
    String userInput;
    //if user input is true 'Yes' enter do-while loop
    if (want) {
        //prompt user for name
        name = Console.PromptForString("What is your name?");
        do {
            //prompt user for ID number
            userInput = Console.PromptForString("Enter ID # of the volume you wish to check out or X to exit: ");
            //exit loop if user enter one of these commands
            if (userInput.equalsIgnoreCase("X")
                    || userInput.equalsIgnoreCase("EXIT")
                    || userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("QUIT")) {
                break;
            }
            //otherwise proceed to check out volume
            else {
                int idNumber = Integer.parseInt(userInput); //convert String # to integer
                boolean volumeCheckedOut = false; //is manga selected in catalog? set to false
                for (Book volume : availableVolumes) {
                    if (volume.getID() == idNumber) {
                        volume.checkOut(name); //check out manga checked out
                        volumeCheckedOut = true; //manga check out is now true
                    }
                }
                //display message if volume is unavailable
                if (!volumeCheckedOut) { System.out.println("Volume unavailable"); }
            }
        } while (true);
    }
}
//method created to display array of Volumes using a 'for-each' loop and format column size
public static void DisplayVolumes(Book[] volumes){
    System.out.printf("%5s %55s %20s %24s\n" , "ID", "TITLE", "ISBN", "CHECKOUT OUT TO" );
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    for(Book volume : volumes) {
        System.out.printf("%5s %55s %20s %24s\n", volume.getID(), volume.getTitle(), volume.getISBN(), volume.getCheckedOutTo());
    }
}
//method created to initialize a collection of Manga as an array
public static Book[] InitializeCollectionOfManga(){
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

