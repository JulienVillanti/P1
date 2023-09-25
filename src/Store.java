import java.util.Scanner;

public class Store {

    public static boolean checkPassword1(String pass) {
        Scanner kb = new Scanner(System.in);
        int passwordAttempts = 0;

        while (passwordAttempts < 3) {
            System.out.println("Please enter you password: ");
            String userPassword = kb.next();

            if (userPassword.equals(pass)) {
                return true;
            } else {
                System.out.println("Wrong password, please try again! You have " + (2 - passwordAttempts) + " attempts remaining.");
                passwordAttempts++;
            }
        }
        System.out.println("You have no more attempts, back to main menu");
        return false;
    }

    /*-------TRIED A METHOD---------DOES NOT WORK
    public static void updateComputers(Computer[] inventory, Scanner kb) {

        System.out.println("Which computer would you like to update?");
        int computerIndex = kb.nextInt();
        if (computerIndex < 0 || computerIndex >= inventory.length || inventory[computerIndex] == null) {
            System.out.println("This computer cannot be found. Would you like to enter another computer ? (Y/N)");
            String answer = kb.next();
            if (answer.equalsIgnoreCase("N")) {
                return;
            }
        } else {
            Computer computer = inventory[updateComputers()];
            System.out.println("Current information of the computer: \n" +
                    "\tComputer # " + computerIndex + "\n" +
                    "\tBrand: " + computer.getBrand() + "\n" +
                    "\tModel: " + computer.getModel() + "\n" +
                    "\tSN: " + computer.getSerialNumber() + "\n" +
                    "\tPrice: " + computer.getPrice() + "\n");
        }
    }*


     */

    // case 3 public static findComputersBy(String brand){}

    // case 4 public static findCheaperThan(double value){}


    public static void main(String[] args) {
        //Computer c1 = new Computer("Apple", "MacPro", 3000);
        //c1.displayComputer(c1);
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to Pargol Computer Store!");
        int maxComputers = 0;
        final String password = "password";
        boolean returnToMainMenu = false;


        while (maxComputers < 1) {
            System.out.println("Please enter the maximum amount of computers your store can contain: ");
            maxComputers = kb.nextInt();
            if (maxComputers < 1) {
                System.out.println("Invalid, your inventory should be positive");
            }
        }
        Computer[] inventory = new Computer[maxComputers];

        do {
            //menu
            System.out.println("""
                    What do you want to do ?
                    1.\tEnter new computers (password required)
                    2.\tChange information of a computer (password required)
                    3.\tDisplay all computers by a specific brand
                    4.\tDisplay all computers under a certain a price.
                    5.\tQuit
                    """);
            //if (kb.hasNextInt()) {
            int choiceMenu = kb.nextInt();
            if (choiceMenu != 1 && choiceMenu != 2 && choiceMenu != 3 && choiceMenu != 4 && choiceMenu != 5) {
                System.out.println("Your choice is not included in the menu!");
                //
                // ----NEED TO WRITE BLOCK OF CODE WHEN USER ENTER A LETTER OR A STRING-------
                //
                // } else if (choiceMenu != kb.nextInt()) {
                //  System.out.println("Please select an option within the menu (1-5)");
            }
                   /* System.out.println("Please enter a valid choice (1-5)");
                    kb.next();

                */
            switch (choiceMenu) {

                case 1 -> {

                    if (checkPassword1(password)) {
                        System.out.println("How many computers would you like to add?");
                        int numOfComputers = kb.nextInt();

                        if (numOfComputers <= maxComputers) {
                            System.out.println("Please enter your computer's specifications: ");
                            kb.nextLine();
                            for (int i = 0; i < numOfComputers; i++) {
                                System.out.println("Brand: ");
                                String brand = kb.nextLine();
                                System.out.println("Model: ");
                                String model = kb.nextLine();
                                System.out.println("Price: ");
                                double price = kb.nextDouble();
                                kb.nextLine();
                                inventory[i] = new Computer(brand, model, price);
                                // Input computer information (brand, model, price) and add to the array.
                            }
                            System.out.println("Computers added to inventory.");
                            System.out.println("Here is your store: \n");
                            for (Computer computer : inventory) {
                                if (computer != null) {
                                    System.out.println("Brand: " + computer.getBrand());
                                    System.out.println("Model: " + computer.getModel());
                                    System.out.println("Price: " + computer.getPrice() + " $");
                                    System.out.println("Serial Number: " + computer.getSerialNumber());
                                    System.out.println();
                                }
                            }
                        } else {
                            System.out.println("There is not enough space to add that computer. You can only add +" + maxComputers + " computers to the list.");

                        }
                    }
                }

                case 2 -> {
                    if (checkPassword1(password)) {
                        System.out.println("Which computer would you like to update?");
                        int updateComputer = kb.nextInt();

                        if (updateComputer < 0 || updateComputer >= inventory.length || inventory[updateComputer] == null) {
                            System.out.println("This computer cannot be found. Would you like to enter another computer ? (Y/N)");
                            String answer = kb.next();
                            if (answer.equalsIgnoreCase("N")) {
                                return;
                            }
                        } else {
                            Computer computer = inventory[updateComputer];
                            System.out.println("Current information of the computer: \n" +
                                    "\tComputer # " + updateComputer + "\n" +
                                    "\tBrand: " + computer.getBrand() + "\n" +
                                    "\tModel: " + computer.getModel() + "\n" +
                                    "\tSN: " + computer.getSerialNumber() + "\n" +
                                    "\tPrice: " + computer.getPrice() + "\n");

                            do {
                                System.out.println("""
                                        What information would you like to change?
                                        1.\tBrand
                                        2.\tModel
                                        3.\tSerial Number
                                        4.\tPrice
                                        5.\tQuit
                                        Enter your choice:
                                        """);
                                int choiceMenu2 = kb.nextInt();
                                if (choiceMenu2 != 1 && choiceMenu2 != 2 && choiceMenu2 != 3 && choiceMenu2 != 4 && choiceMenu2 != 5) {
                                    System.out.println("Your choice is not included in the menu!");
                                }
                                switch (choiceMenu2) {
                                    case 1:
                                        System.out.println("Enter the updated information of for your computer: ");
                                        kb.nextLine();
                                        System.out.println("Brand: ");
                                        String brand = kb.nextLine();
                                        computer.setBrand(brand);
                                        break;

                                    case 2:
                                        System.out.println("Enter the updated information of for your computer: ");
                                        kb.nextLine();
                                        System.out.println("Model: ");
                                        String model = kb.nextLine();
                                        computer.setModel(model);
                                        break;

                                    case 3:
                                        System.out.println("Enter the updated information of for your computer: ");
                                        kb.nextLine();
                                        System.out.println("SN: ");
                                        Long serialNum = kb.nextLong();
                                        computer.setSerialNumber(serialNum);
                                        break;

                                    case 4:
                                        System.out.println("Enter the updated information of for your computer: ");
                                        kb.nextLine();
                                        System.out.println("Price: ");
                                        double price = kb.nextDouble();
                                        computer.setPrice(price);
                                        break;

                                    case 5:
                                        System.out.println("Thank you !");
                                        return;
                                }
                            } while (true);

                        }
                    }
                }


                case 4 -> {
                }

                case 5 -> {
                    System.out.println("Thank you for using my program! Goodbye!");
                    System.exit(5);
                }

            }


        }
        while (true);


    }
}



