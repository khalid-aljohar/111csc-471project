// خالد بن عبدالعزيز الجوهر 446108820
// سعد بن عبدالرحمن الداعج 446105703
// مشاري بن عايض القحطاني 446106034
// GitHub: https://github.com/khalid-aljohar/111csc-471project
package labs;
public class Member {
// line 8-29 for attributes

	// User info
	private int id;
	private String name;
	private int borrowedCount;

	// user Stats (reset each login)
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;


	private static final int MAX_BOOKS = 5;
	private static final double BORROW_FEE = 0.50;

	// Shared stats
	public static double TotalRevenue = 0;
	public static int TotalViewBorrowed = 0;
	public static int TotalBorrows = 0;
	public static int TotalReturns = 0;

// line 31 - 107 for methods

	// initialze constructor for the users
	public Member(int id, String name, int borrowedCount) {
		this.id = id;
		this.name = name;
		this.borrowedCount = borrowedCount;
		reset();
	}

	// checks id user can borrow
	private boolean canBorrow() {
		return borrowedCount < MAX_BOOKS;
	}

	// checks if user can return
	private boolean canReturn() {
		return borrowedCount > 0;
	}

	// displays number of borrowed books and updates counters
	public void viewBorrowedCount() {
		System.out.println("You currently have " + borrowedCount + " book(s).");
		numViewBorrowed++;
		TotalViewBorrowed++;
	}

	// borrows a book if allowed and updates counters
	public boolean borrowOne() {
		if (!canBorrow()) {
			return false;
		}
		borrowedCount++;
		numBorrows++;
		TotalBorrows++;
		sessionFees += BORROW_FEE;
		TotalRevenue += BORROW_FEE;
		return true;
	}

	// returns a book if allowed and updates counters
	public boolean returnOne() {
		if (!canReturn()) {
			return false;
		}
		borrowedCount--;
		numReturns++;
		TotalReturns++;
		return true;
	}

	// prints session stats for this user/member
	public void displayStatistics() {
		System.out.println("========== Session Summary ==========");
		System.out.println("Times viewed borrowed books: " + numViewBorrowed);
		System.out.println("Books borrowed this session: " + numBorrows);
		System.out.println("Books returned this session: " + numReturns);
		System.out.printf("Total fees this session: %.2f%n", sessionFees);
		System.out.println("=====================================");
	}

	// resets the user stats (when user/member logs in)
	public void reset() {
		numViewBorrowed = 0;
		numBorrows = 0;
		numReturns = 0;
		sessionFees = 0;
	}
//setters

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

