
public class EmployeeTester3
{
    public static void main(String[] args)
    {	
	Employee emp; // a reference to an Employee 
	char choice;
	String numberEntered, nameEntered; 
	double salaryEntered, payEntered;
	System.out.print("Choose (F)ull-Time or (P)art-Time Employee: ");
        choice = EasyScanner.nextChar();
        
        System.out.print("Enter employee number: ");
        numberEntered = EasyScanner.nextString();  
      
        System.out.print("Enter employee name: ");
        nameEntered = EasyScanner.nextString();
        
        if(choice == 'F' || choice == 'f')
        {
            System.out.print("Enter annual salary: ");
            salaryEntered = EasyScanner.nextDouble();

            // create a FullTimeEmployee object
            emp = new FullTimeEmployee (numberEntered, nameEntered, salaryEntered); 
        }
        else
        {
            System.out.print("Enter hourly pay: ");
            payEntered = EasyScanner.nextDouble();

            // create a PartTimeEmployee object
            emp = new PartTimeEmployee (numberEntered, nameEntered, payEntered);      
        }
      	testMethod(emp); // call tester with the object created
    }

		
    static void testMethod(Employee employeeIn)
    {
	System.out.println(employeeIn.getStatus());
    }
}


