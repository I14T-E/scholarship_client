import java.util.*;
import java.io.*;
import java.sql.*;

class Scholarships {
	//Stores all information about scholarships
	private String id;
	private String description;
	private String amount;

	//constructors:
	public Scholarships(String id, String description, String amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getAmount() {
		return amount;
	}
}//end Scholarships

class ScholarshipsManager {
		public void scholarshipDisplay() {

		//declarations
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:scholarships.db");

			stmt = conn.createStatement();
			//query to display all students
			query = "select * from scholarships";
			rs = stmt.executeQuery(query);
			System.out.println("Scholarships:\n");

			while (rs.next()) {
				System.out.print("ID: " + rs.getString("id") + "\nDescription: " + rs.getString("description") + "\nAmount: $" + rs.getString("amount") + "\n\n");
			}

		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			try{
				if(conn != null) {
					conn .close();
				}
			}
			catch (SQLException e) {
				System.err.println(e.getMessage());
			}

		}
	}//end scholarshipsDisplay

	public void addScholarships(Scholarships y) {

		//declarations
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:scholarships.db");

			stmt = conn.createStatement();
			//query to add a scholarship to database
			query = "insert into scholarships values ('" + y.getId() + "','" + y.getDescription() + "','" + y.getAmount() + "')";
			rs = stmt.executeQuery(query);

		}
		catch(SQLException e) {
		}
		finally {
			try{
				if(conn != null) {
					conn .close();
				}
			}
			catch (SQLException e) {
			}

		}
	}//end addScholarships

public void delScholarships(String b) {

                //declarations
                Connection conn = null;
                Statement stmt;
                ResultSet rs;
                String query;

                try {
                        conn = DriverManager.getConnection("jdbc:sqlite:scholarships.db");

                        stmt = conn.createStatement();
                        //query to remove a scholarship from the database
                        query = "delete from scholarships where id = '" + b + "'";
                        rs = stmt.executeQuery(query);

                }
                catch(SQLException e) {
                }
                finally {
                        try{
                                if(conn != null) {
                                        conn .close();
                                }
                        }
                        catch (SQLException e) {
                        }
                }
        }//end delScholarships 
}//end ScholarshipsManager

class Student {
	//Stores all information about student
	private String nameFirst;
	private String nameLast;
	private String email;

	//constructors:
	public Student(String nameFirst, String nameLast, String email) {
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.email = email;
	}

	public String getFirstName() {
		return nameFirst;
	}

	public String getLastName() {
		return nameLast;
	}

	public String getEmail() {
		return email;
	}
}//end Student

class StudentManager {
	public void studentDisplay() {

		//declarations
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:students.db");

			stmt = conn.createStatement();
			//query to display all students
			query = "select * from students";
			rs = stmt.executeQuery(query);
			System.out.println("Current Students:\n");

			while (rs.next()) {
				System.out.print("Name: " + rs.getString("namelast") + ", " + rs.getString("namefirst") + "\nEmail: " + rs.getString("email") + "\n\n");
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	       	finally {
			try{
				if(conn != null) {
					conn .close();
				}
			}
			catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}//end studentDisplay

	public void addStudent(Student x) {

		//declarations
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:students.db");

			stmt = conn.createStatement();
			//query to add a student to database
			query = "insert into students values ('" + x.getFirstName() + "','" + x.getLastName() + "','" + x.getEmail() + "')";
			rs = stmt.executeQuery(query);
		}
		catch(SQLException e) {
		}
		
		finally {
			try{
				if(conn != null) {
					conn .close();
				}
			}
			
			catch (SQLException e) {
			}
		}
	}//end addStudent

public void delStudent(String x, String y) {

                //declarations
                Connection conn = null;
                Statement stmt;
                ResultSet rs;
                String query;

                try {
                        conn = DriverManager.getConnection("jdbc:sqlite:students.db");

                        stmt = conn.createStatement();
                        //query to remove student fromt the student database
                        query = "delete from students where namefirst = '" + x + "' and namelast = '" + y + "'";
                        rs = stmt.executeQuery(query);
                }
                catch(SQLException e) {
                }
                finally {
                        try{
                                if(conn != null) {
                                        conn .close();
                                }
                        }
                        catch (SQLException e) {
                        }

                }
        }//end delStudent 
}//end StudentManager

class ScholarshipSystemFacade {
	//create studnetManager and scholarshipsManager objects
	private StudentManager studentManager = new StudentManager();
	private ScholarshipsManager scholarshipsManager = new ScholarshipsManager();

	public void displayAllStudents() {
		studentManager.studentDisplay();
	}

	public void enterNewStudent(Student z) {
		studentManager.addStudent(z);
	}

	public void displayAllScholarships() {
		scholarshipsManager.scholarshipDisplay();
	}

	public void enterNewScholarships(Scholarships y) {
		scholarshipsManager.addScholarships(y);
	}

	public void removeStudent(String x, String y) {
		studentManager.delStudent(x, y);
	}

	public void removeScholarship(String a) {
		scholarshipsManager.delScholarships(a);
	}

	}//end ScholarshipSystemFacade

public class ScholarshipClient {
	public static void main(String args[]) throws IOException {
		//create ScholarshipSystemFacade object
		ScholarshipSystemFacade scholarshipSystemFacade = new ScholarshipSystemFacade();

		//instantiate ojbects
		Student student;
		Scholarships scholarships;
		Scanner scan = new Scanner(System.in);

		//to record user selection
		int selection;

		//miscellaneous variables to temporarily store data as neeted
		String input1;
		String input2;
		String input3;

		System.out.println();//for aesthetics
		System.out.println("----------------------------------------");
		System.out.println("   Welcome to the Scholarship Portal");
		System.out.println("----------------------------------------");


		boolean run = true;//set to true so the program runs atleast once
		while(run) {
			System.out.println("\n Plese select from the following options:\n\n 1. Add student information\n 2. View current list of students\n 3. Remove student applicant\n 4. Add scholarship information\n 5. View current list of scholarships\n 6. Remove scholarship\n 7. Save and exit\n");

				selection = scan.nextInt();

				//validate input
				while (selection < 1 | selection > 7) {
					System.out.println();//for aesthetics
					System.out.println("Invalid selection. Please reenter: ");
					selection = scan.nextInt();
				}
			if (selection == 1) {
				scan.nextLine();//flushes buffer
				System.out.println();//for aesthetics
				System.out.println("Please enter first name of applicant:");
				input1 = scan.nextLine();
				System.out.println("Please enter last name of applicant:");
				input2 = scan.nextLine();
				System.out.println("Please enter email of applicant:");
				input3 = scan.nextLine();
				//create and add to student manager (through scholarshipSystemFacade)
				student = new Student(input1, input2, input3);
				scholarshipSystemFacade.enterNewStudent(student);
			}

			if (selection == 2) {
				scholarshipSystemFacade.displayAllStudents();
			}

			if (selection == 3) {
				scan.nextLine();//flushes buffer
				System.out.println();//for aesthetics
				System.out.println("Enter first name of student to remove:");
				input1 = scan.nextLine();
				System.out.println("Enter last name of student to remove:");
				input2 = scan.nextLine();
				scholarshipSystemFacade.removeStudent(input1, input2);
			}

			if (selection == 4) {
				scan.nextLine();//flushes buffer
				System.out.println();//for aesthetics
				System.out.println("Please enter scholarship ID:");
				input1 = scan.nextLine();
				System.out.println("Please enter name and description of scholarship:");
				input2 = scan.nextLine();
				System.out.println("Please enter scholarship amount:");
				input3 = scan.nextLine();
				//create and add to scholarships manager (through scholarshipSystemFacade)
				scholarships = new Scholarships(input1, input2, input3);
				scholarshipSystemFacade.enterNewScholarships(scholarships);
			}

			if (selection == 5) {
				scholarshipSystemFacade.displayAllScholarships();
			}


			if (selection == 6) {
				scan.nextLine();//flushes buffer
                                System.out.println();//for aesthetics
                                System.out.println("Enter the ID for the scholarship you want to remove:");
                                input1 = scan.nextLine();
                                scholarshipSystemFacade.removeScholarship(input1);
			}

			if (selection == 7) {
				System.out.println("Saving and closing program...");
				run = false;
			}
		}//end boolean "run"
	}//end main
}//end public class ScholarshipClient
