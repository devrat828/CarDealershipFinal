/*
Project: Car Design
Purpose Details: Car Dealership Application
Course: IST 242
Team 4
Developed: June 14, 2020
Last date Changed: June 21, 2020
Rev: 1
*/



package edu.psu.abington.ist.ist242;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double subTotal;
        double orderTotal = 0;

        // Main object
        Main main = new Main();
        // Customer obj
        Customer cust = new Customer();
        // Order obj
        Order or = new Order();
        // Inventory object
        Inventory inv = new Inventory();
        // Transaction object
        Transaction trans = new Transaction();

        // ARRAYLISTS -------------------------------------------------------------------------------------------------------------------------------------------------
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Inventory> iList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        // INVENTORY LIST ---------------------------------------------------------------------------------------------------------------------------------------------
        Inventory inv1 = new Inventory("1", "2020", "Honda", "Civic", 26899.99);
        Inventory inv2 = new Inventory("2", "2021", "Ford", "Explorer", 46799.99);
        Inventory inv3 = new Inventory("3", "2021", "Jeep", "Grand Cherokee", 39899.99);
        Inventory inv4 = new Inventory("4", "2021", "Chevrolet", "Pickup", 42699.99);

        iList.add(inv1);
        iList.add(inv2);
        iList.add(inv3);
        iList.add(inv4);

        // SALESPERSON LIST ----------------------------------------------------------------------
        salesPerson sales1 = new salesPerson(1, "Mark Smith");
        salesPerson sales2 = new salesPerson(2, "Jennifer Green");


        System.out.println("---------------------------------------------------------");
        System.out.println("                   Car Dealership                        ");
        System.out.println("                        by:                              ");
        System.out.println("                      Team 4                             ");
        System.out.println("---------------------------------------------------------");

        final char CUST_CODE = '1'; //customer page
        final char PRINT_CUST = '2'; //print cust
        final char INV_CODE = '3'; //inventory page
        //final char SALES_CODE = '4'; //sales person
        final char ORDER_CODE = '4'; //order page
        final char TRANS_CODE = '5'; //transaction page
        final char HELP_CODE = '?';
        final char EXIT_CODE = 'E';
        char userAction;


        final String PROMPT_ACTION = "\nMAIN MENU: \n1 - Add Customer\n2 - Print Customers\n3 - Inventory Page\n4 - Sell Car\n5 - Transaction Page\nE - Exit\n ";

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE: // Customers page
                    cList.add(cust.addCustomer());
                    System.out.println(" ");
                    break;
                case PRINT_CUST:
                    System.out.printf("%-12s | %-20s | %-20s | %-20s\n", "ID", "Name", "Phone Number", "Address");
                    Customer.printCustomer(cList);
                    break;
                case INV_CODE: //Inventory Page
                    Scanner input2 = new Scanner(System.in);
                    String answer = "";
                    System.out.print("What would you like to do: [A]dd in inventory, [B]rowse Inventory, [D]elete an item from Inventory: ");
                    answer = input2.nextLine().toUpperCase() + " ";
                    char firstChar = answer.charAt(0);
                    switch(firstChar){
                        case 'A':
                            iList.add(inv.addInventory());
                            break;
                        case 'B':
                            System.out.println("---------------------------------------------");
                            System.out.println("           Currently in Inventory            ");
                            System.out.println("---------------------------------------------");
                            Inventory.listMenu(iList);
                            break;
                        case 'D':
                            Inventory.removeCar(iList);
                            break;
                    }
                    break;
                    /*System.out.println("------------------------");
                    System.out.println("       Inventory        ");
                    System.out.println("------------------------");
                    inv1.printMenuInfo();
                    inv2.printMenuInfo();
                    inv3.printMenuInfo();
                    inv4.printMenuInfo();
                    break;*/
                case ORDER_CODE: //Order Page
                    // add loop to prompt user to order more items
                    String userInput = "Type 'Y'es to sell a car or type 'N'o to go back to the main menu: "; //TODO: change the naming of this line
                    userAction = getAction(userInput);
                    while (userAction != 'N') {
                        //oList.add(main.addOrder());

                        /*Order o1 = new Order();
                        o1.getorderId();
                        oList.add(main.addOrder());
                        */

                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("                            ORDER - INVENTORY                            ");
                        System.out.println("-------------------------------------------------------------------------");
                        //get input2 menu id
                        Scanner input = new Scanner(System.in); //TODO: delete the cases and input from ilist instead

                        inv1.printMenuInfo();
                        inv2.printMenuInfo();
                        inv3.printMenuInfo();
                        inv4.printMenuInfo();


                        //using order() method
                        //or.order();


                        System.out.println(" ");
                        System.out.println("Enter Car ID: ");
                        int menuId = input.nextInt();
                        /*System.out.println("Enter quantity: ");
                        int qty = or.getQuantity();
                        or.setQuantity(qty);*/

                        oList.add(or.order());

                        switch (menuId) {
                            case 1:
                                subTotal = or.getSubTotal(inv1.getPrice("1")); //subTotal = or.getSubTotal(inv1.getPrice(1), qty);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv1.getPrice("1"), inv1.getMake(), inv1.getModel()); //or.printOrder(subTotal, inv1.getPrice(1), /*qty*/, inv1.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 2:
                                subTotal = or.getSubTotal(inv2.getPrice("2")); //subTotal = or.getSubTotal(inv2.getPrice(2), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv2.getPrice("2"), inv2.getMake(), inv2.getModel()); //or.printOrder(subTotal, inv2.getPrice(2), /*qty*/, inv2.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 3:
                                subTotal = or.getSubTotal(inv3.getPrice("3")); //subTotal = or.getSubTotal(inv3.getPrice(3), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv3.getPrice("3"), inv3.getMake(), inv3.getModel()); //or.printOrder(subTotal, inv3.getPrice(3), /*qty*/, inv3.getMake());
                                userAction = getAction(userInput);
                                break;
                            case 4:
                                subTotal = or.getSubTotal(inv4.getPrice("4")); //subTotal = or.getSubTotal(inv4.getPrice(4), /*qty*/);
                                //System.out.println("$ " + subTotal);
                                orderTotal += subTotal;
                                or.printOrder(subTotal, inv4.getPrice("4"), inv4.getMake(), inv4.getModel()); //or.printOrder(subTotal, inv4.getPrice(4), /*qty*/, inv4.getMake());
                                userAction = getAction(userInput);
                                break;
                        }
                    }


                    //print order

                    //or.listOrder(oList);
                    break;

                case TRANS_CODE: //Transaction Page
                    Transaction transaction = new Transaction();
                    System.out.println("Your order total is: $ " + orderTotal);
                    transaction.sellCar();
                    //                 System.out.println("Enter payment type: " + trans1.setPaymentType());

                    //doesn't work - needs fixing
                    /*System.out.println("Enter Customer ID: "); //TODO: which customer is buying the vehicle
                    Scanner scnr = new Scanner(System.in);
                    int inputID = scnr.nextInt();*/
                    /*String input_cust = "Type 'N' to add a new customer or 'E' for an existing customer";

                    userAction = getAction(input_cust);
                    if (userAction == 'E') {
                        System.out.println("Your order total is: $ " + orderTotal);//System.out.println(cust.getCustomerName(cust.getCust()) + "Your order total is: $ " + orderTotal);
                        //System.out.println(cust.getCustomerName(inputID) + "Your order total is: $ " + orderTotal);
                    }
                    if (userAction == 'N') {
                        cList.add(cust.addCustomer());
                        cust.getCust();
                    }

                    //TODO: after selecting 'N' or 'E' for new or existing customer it jumps to this line to Enter Payment Type
                    Transaction trans1 = new Transaction(1);
                    tList.add(trans1);
                    //System.out.println("Your order total is: $ " + orderTotal);
                    // trans1.selectPayType();
                    trans1.setPaymentType(trans1.selectPayType());

                    System.out.println("TRANSACTION RECORD");
                    trans1.printReceipt(orderTotal, trans1.getPaymentType());
                    trans1.listTransactions(tList);*/

                    break;
                case HELP_CODE: //
                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
    }

    // METHOD TO GET USER CHOICE FOR MENU --------------------------------------------------------------------
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }
}

























        /*
        boolean exit;


        public void runDealership() {
            while(!exit){
                printMenu();
                int choice = getInput();
                performAction(choice);
            }
        }


        public int getInput() {
            Scanner menuInput = new Scanner(System.in);
            int choice = -1;
            while (choice < 0 || choice > 5) {
                try {
                    System.out.print("\nPlease enter your selection: ");
                    choice = Integer.parseInt(menuInput.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            return choice;
        }
        private void performAction(int choice){
            switch (choice) {
                case 0:
                    exit = true;
                    System.out.println("Thank you for visiting!");
                    break;
                case 1:
                    String answer;
                    Scanner input = new Scanner(System.in);
                    System.out.print("Create Customer, Read Customers, Delete Customer: ");
                    answer = input.nextLine();
                    switch (answer) {
                        case "create":
                            Customer.addCustomer();
                            break;
                        case "read":
                            //User.customerRecord(cList);
                            break;
                        default:
                            System.out.println("Invalid please, retry");
                            break;
                    }


                case 2:
                    Inventory.displayCars();
                    break;
                case 3:
                    //salesPerson sales = new salesPerson();
                    //sales.salesPersonsRecord();//(salespersonArray);
                    break;
                case 4:
                    //Order order = new Order();
                    //order.orderRecords();///*orderArray,transactionArray, custArray*);
                    break;
                case 5:
                    //Transaction transaction = new Transaction();
                    //transaction.transactionRecords(/*transactionArray*///);
//break;
//default:
//System.out.println("An unknown error has occurred. ");
//break;
//}
//}









        /*Dealership dealership = new Dealership();//creates the dealership class and calls it to run
        dealership.runDealership();*/

