// خالد بن عبدالعزيز الجوهر 446108820
// سعد بن عبدالرحمن الداعج 446105703
// مشاري بن عايض القحطاني 446106034
// GitHub: https://github.com/khalid-aljohar/111csc-471project

//import scanner for user input
import java.util.Scanner;

public class LibrarySimulator {

	//main class identifier
	public static void main(String[] args) {
		
		// declearing scanner with varible keyboard 
		Scanner keyboard = new Scanner(System.in);
		// creates 3 memebers
		Member m1 = new Member(1001, "Ali", 0);
		Member m2 = new Member(1002, "Sara", 0);
		Member m3 = new Member(1003, "Omar", 0);

		boolean running = true;
		// main menu loop
		while (running) {
			System.out.println();
			System.out.println("===========================================");
			System.out.println("       Welcome to the Public Library");
			System.out.println("===========================================");
			System.out.println("1) 1001 - Ali");
			System.out.println("2) 1002 - Sara");
			System.out.println("3) 1003 - Omar");
			System.out.println("4) Administrator");
			System.out.println("5) Exit");
			System.out.print("Select an option (1-5): ");

			String mainchoice = keyboard.nextLine().trim();

			Member current = null;
			// determine which member was selected
			if (mainchoice.equals("1"))
				current = m1;
			else if (mainchoice.equals("2"))
				current = m2;
			else if (mainchoice.equals("3"))
				current = m3;
			// if a valid member was chosen
			if (current != null) {
				// resets session stats each login
				current.reset();

				boolean inMenu = true;
				// user session menu
				while (inMenu) {

					System.out.println();
					System.out.println("-------------------------------------------");
					System.out.println("User: " + current.getName() + " (ID " + current.getId() + ")");
					System.out.println("-------------------------------------------");
					System.out.println("1) View Borrowed Books Count");
					System.out.println("2) Borrow Book");
					System.out.println("3) Return Book");
					System.out.println("4) View Session Summary");
					System.out.println("5) Exit to Main Menu");
					System.out.print("Choose (1-5): ");

					String uChoice = keyboard.nextLine().trim();
					// option 1; show current book count
					if (uChoice.equals("1")) {
						current.viewBorrowedCount();
						// option 2; borrow one book
					} else if (uChoice.equals("2")) {

						if (current.borrowOne()) {
							System.out.println("Borrow successful.");
							System.out.println("A fee of 0.50 was recorded.");
						} else {
							System.out.println("Error: Cannot borrow more than 5 books.");
						}
						// option 3; return one book
					} else if (uChoice.equals("3")) {

						if (current.returnOne()) {
							System.out.println("Return successful.");
						} else {
							System.out.println("Error: No books to return.");
						}
						// display session stats
					} else if (uChoice.equals("4")) {
						current.displayStatistics();
						// option 5; exits to main menu
					} else if (uChoice.equals("5")) {
						inMenu = false;

					} else {
						System.out.println("Invalid choice.");
					}
				}

			}

			else if (mainchoice.equals("4")) {

				boolean admin = true;
				// admin menu
				while (admin) {
					System.out.println();
					System.out.println("============= Administrator =============");
					System.out.println("1) View Total Revenue");
					System.out.println("2) Most Frequent Operation");
					System.out.println("3) Exit to Main Menu");
					System.out.print("Choose (1-3): ");

					String achoice = keyboard.nextLine().trim();
					// view total revenue collected from all users
					if (achoice.equals("1")) {
						System.out.printf("Total revenue: %.2f%n", Member.TotalRevenue);
						// determine which operation is most frequent overall
					} else if (achoice.equals("2")) {

						if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {
							System.out.println("No operations performed.");
						} else if (Member.TotalBorrows > Member.TotalReturns) {
							System.out.println("Most frequent operation: BORROW (" + Member.TotalBorrows + ")");
						} else if (Member.TotalReturns > Member.TotalBorrows) {
							System.out.println("Most frequent operation: RETURN (" + Member.TotalReturns + ")");
						} else {
							System.out.println("Tie between BORROW and RETURN. ( " + Member.TotalBorrows + " - " + Member.TotalReturns + " )");
						}
						// exit admin menu
					} else if (achoice.equals("3")) {
						admin = false;

					} else {
						System.out.println("Invalid choice.");
					}
				}

			}
			// exit whole program
			else if (mainchoice.equals("5")) {
				running = false;
			}

			else {
				System.out.println("Invalid choice.");
			}
		}

		System.out.println("thank you goodbye");
		keyboard.close();
	}

}


