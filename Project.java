package MinProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


class Company // Holds the information of each company used for the game
{
	String Name;
	int year;
	String Founder;
	boolean FavComp;	
}

class Answers // Holds information of each answer for the questions used for the game
{
	String Question1;
	String Question2;
	String Question3;
	String Question4;
	String Question5;
}

public class Project  //Name of class
{

	public static void main(String[] args) throws IOException 
	{
		introduction(); // runs program
	}
	
	public static String inputString (String message) //Called whenever a user needs to input information of type string //Controls String input
	{
		String answer;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(message); //prints out the string message
		answer = scanner.nextLine(); //Allows the user to input a string
		
		return answer;  //returns a string
	}
	
	public static int inputInt (String number) //Called whenever a user needs to input information of type integer
	{
		int answer;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(number); //prints out the string message
		answer = keyboard.nextInt(); //Allows the user to input an integer
	
		return answer; //returns an integer
	}
	
	public static void Bye(String Useranswer)
	{
		if(Useranswer.equals("Bye") || Useranswer.equals("No") || Useranswer.equals("no")) // checks if user says No or bye
		{
			System.out.println("Goodbye talk to you later");
			System.exit(0); //exits program
		}
	}
	
	public static void introduction () throws IOException // Greets user and gives them option on what they would like to do.
	{	
		String [] Questions = {"Question 1: What laptop contains the M1 chip", "Question 2: What phone brand uses exynos processor",
				   "Question 3: When did intel's 12th gen cpus come out", "Question 4: When did Forza Horizon 5 release", 
				   "Question 5: What chip does the Iphone 13 have"}; //Array stores Questions
		
	    String UserName = inputString("Enter you name"); //Asks user their name
	        
	    System.out.println("Hello " + UserName + " nice to meet you, I'm your personal Chatbot"); //Hello message
	    System.out.println();
	    System.out.println("What topic would you like to talk about:"); //Asks what topic they want to do
	    System.out.println();
	    System.out.println("Choice 1: Technology");
	    System.out.println("Choice 2: Subject your studying");
	    System.out.println();
	    String Useranswer = inputString("Type in your answer from the above options.");
	    
	    Bye(Useranswer); //Checks if user says bye or no
	    
	    if(Useranswer.equals("Choice 1"))
	    {
	        System.out.println("Great you want to talk about technology");
	        Technology(Questions); //Runs Technology method
	    }
	    else if(Useranswer.equals("Choice 2"))
	    {
	        System.out.println("Great you want to talk about the subject your studying");
	        Files(Useranswer, Questions); //Runs files method
	    }
	}
	
	public static void Technology (String [] Questions) throws IOException // Gives the user the option on what to do in the subject of technology
	{	
		System.out.println();
		System.out.println("What would you like to do:");
		System.out.println("Choice 1: Learn information on tech companys");
		System.out.println();
		System.out.println("Choice 2: Play a Game");
		System.out.println();
		String Useranswer = inputString("Type in either Choice 1 or Choice 2"); //prompts user input
		
		Bye(Useranswer); //Checks if user says bye or no
		
		if(Useranswer.equals("Choice 1"))
		{
			Techinfo(Questions); //runs tech info method
		}
		else if(Useranswer.equals("Choice 2"))
		{
			choosegame(Useranswer, Questions); //runs choose game method
		}	
		else
		{
			System.out.println("Please enter either Choice 1 or Choice 2"); // Deals with unknown inputs
			Technology(Questions);
		}
	}
	
	public static void choosegame(String Useranswer, String [] Questions) throws IOException //Passes array Question and string useranswer
	{
		System.out.println("Options:");
		System.out.println();
		System.out.println("Choice 1: Guess what my favourite colour is");
		System.out.println();
		System.out.println("Choice 2: Quiz on the latest Technology and Games");
		System.out.println();
		
		Useranswer = inputString("Type in either Choice 1 or Choice 2"); //Prompts user input
		
		Bye(Useranswer); //Checks if user says bye or no
		
		if(Useranswer.equals("Choice 1"))
		{
			guessgame(Questions);  //runs guessgame method
		}
		else if(Useranswer.equals("Choice 2"))
		{
			setanswer(Useranswer, Questions); //runs setanswer method
		}
	}
	//each of the fields in the class are stored inside the variables in the parameters thus allowing them to be called from other methods
	public static void setanswer (String Useranswer,String [] Questions) throws IOException //pasess useranswer and questions array (Setter method)
	{
		String Q1A = "Macbook";
		String Q2A = "Samsung";
		String Q3A = "November 4th 2021";
		String Q4A = "November 9th 2021";
		String Q5A = "A15 Bionic Chip";
		
		int score = 0; //initilazes score
		final int arraySize = 4; //intialzies arraySize
		
		TechGame(Questions, Useranswer, Q1A, Q2A, Q3A, Q4A, Q5A); //runs TechGame method
	}
	
	public static Answers SetA(Answers a, String Q1A, String Q2A, String Q3A, String Q4A, String Q5A) //Setter methods
	{
		//sets each fields to the varaibles in set answer method
		a.Question1 = Q1A;  
		a.Question2 = Q2A;
		a.Question3 = Q3A;
		a.Question4 = Q4A;
		a.Question5 = Q5A;
		
		return a; //retuns a
	}
	
	public static Answers CreateA(String Q1A, String Q2A, String Q3A, String Q4A, String Q5A) //method which creates record 
	{
		Answers NewAR = new Answers(); //creates a newAR record
		
		NewAR = SetA(NewAR, Q1A, Q2A, Q3A, Q4A, Q5A);
		
		return NewAR; //Returns record
	}
	
	public static String getQ1(Answers a) //getter method
	{
		return a.Question1; //returns question 1
	}
	
	public static String getQ2(Answers a) //getter method
	{
		return a.Question2;  //returns question 2
	}
	
	public static String getQ3(Answers a) //getter method
	{
		return a.Question3;  //returns question 3
	}
	
	public static String getQ4(Answers a) //getter method
	{
		return a.Question4;  //returns question 4
	}
	
	public static String getQ5(Answers a) //getter method
	{
		return a.Question5;  //returns question 5
	}
	
	public static Company createCompany(String given_Name, int given_year, String given_founder, boolean given_FavComp) //creates new record and sets fields to variables
	{
		Company a = new Company();
		
		a.Name = given_Name;
		a.year = given_year;
		a.Founder = given_founder;
		a.FavComp = given_FavComp;
		
		return a; //returns new record
	}
	
	public static void Samsung() // Holds information about the company samsung
	{
		Company Samsung = createCompany("Samsung", 1938, "Lee Byung-chul", true);
		printCompDetails(Samsung); //Prints info
	}
	public static void Apple()// Holds information about the company Apple
	{
		Company Apple = createCompany("Apple", 1976, "Steve Jobs", false);
		printCompDetails(Apple); //Prints info
	}
	public static void Nvidia() // Holds information about the company nvidia
	{
		Company Nvidia = createCompany("Nvidia", 1963, "Jensen Huang", false);
		printCompDetails(Nvidia); //Prints info
	}
	public static void AMD()//Holds information about the company AMD
	{
		Company AMD = createCompany("AMD", 1969, "Jerry Sanders", true);
		printCompDetails(AMD); //Prints info
	}
	public static void printCompDetails(Company a) // allows for the information for reach field to be printed
	{
		// Prints message concatinated with field in company record
		System.out.println("Name of Company: " + a.Name);
		System.out.println(a.Name + "was founded in " + a.year);
		System.out.println("The founder of " + a.Name + " is " + a.Founder);
		System.out.println("Its my favourite company: " + a.FavComp);
	}
	
	public static void Techinfo(String [] Questions) throws IOException // Controls how many companies the user can input and outputs information for each company through
	//if statements
	{
		
		String Useranswer ="";
		System.out.println();
		int userdigit = inputInt("How many companies would you like to learn about (Max: 4)"); //Input user prompt
		if(userdigit > 4 || userdigit <=0)
		{
			System.out.print("Please enter a digit between 1 and 4");// Handles unkown input
			Techinfo(Questions);// Runs Techinfo method
		}
		else 
		{
			for(int i = 1; i <= userdigit; i++)
			{	
				System.out.println();
				Useranswer = inputString("Type in the name of the tech company you want to know more about");
				System.out.println();
				System.out.println("Information of company " + i);
				System.out.println();
				if(Useranswer.equals("AMD"))
				{
					AMD(); //runs AMD method
				}
				else if(Useranswer.equals("Apple"))
				{
					Apple(); //runs Apple method
				}
				else if(Useranswer.equals("Nvidia"))
				{
					Nvidia(); //runs Nvidia method
				}
				else if(Useranswer.equals("Samsung"))
				{
					Samsung(); //runs Samsung method
				}
				else
				{
					System.out.println("I dont have information on that company"); //Handles unknown input
				}
			}	
		}
		options(Useranswer, Questions);
	}
	
	public static void TechGame(String [] Questions, String Useranswer, String Q1A, String Q2A, String Q3A, String Q4A, String Q5A) throws IOException
	{
		final int arraySize = 4; //initialzes arraysize 4
		int score = 0; //initalizes score to 0
		int i = 0; // initalizes i to 0
		System.out.println("In this game I will give you information on tech products/ games and youll have to guess the name of that product."); //explains game
		
			for(i = 0; i <= arraySize; i++)
			{
				System.out.println(Questions[i]);
				Useranswer = inputString("Enter your answer");
				
				Bye(Useranswer);
				
				if(Useranswer.equals(Q1A))
				{
					score = score + 1; //increases score if user gets questions right
				}
				else if(Useranswer.equals(Q2A))
				{
					score = score + 1; //increases score if user gets questions right
				}
				else if(Useranswer.equals(Q3A))
				{
					score = score + 1; //increases score if user gets questions right
				}
				else if(Useranswer.equals(Q4A))
				{
					score = score + 1; //increases score if user gets questions right
				}
				else if(Useranswer.equals(Q5A))
				{
					score = score + 1; //increases score if user gets questions right
				}
			}
			GameResults(Useranswer, score, arraySize, Questions, Q1A , Q2A, Q3A, Q4A, Q5A); //runs gameresults
			options(Useranswer, Questions);
	}
	
	public static void guessgame(String [] Questions) throws IOException
	{
		final String ans = "blue"; //constant string
		final int chances = 5;
		String Useranswer = "";
		
		//Loops within loops
		for(int i = 0; i <= chances; i++)
		{
			Useranswer = inputString("Guess my favourite colour"); //prompts user input
			Bye(Useranswer); //Checks if user inputs bye or no
			
			while(Useranswer.equals(ans))
			{
				System.out.println("Thats right");
				options(Useranswer, Questions);
			}
		}
		System.out.println("My favourite colour is blue");
		options(Useranswer, Questions);
	}
	
	public static void options(String Useranswer, String [] Questions) throws IOException
	{
		System.out.println();
		System.out.println("What do you want to do next");
		System.out.println();
		System.out.println("Options:");
		System.out.println();
		System.out.println("Choice 1: Play a game");
		System.out.print("Choice 2: Talk about the subject your studying" + "\r\n");
		System.out.println("Choice 3: Learn information on tech companys");
		System.out.println("Choice 4: See if I can sort an array of elements");
		System.out.println();
		Useranswer= inputString("Please enter either Choice 1, Choice 2 or Choice 3 or Choice 4"); //prompts user input
		
		Bye(Useranswer); //checks if user inputted bye or no
		
		if(Useranswer.equals("Choice 1"))
		{
			choosegame(Useranswer, Questions); // runs chooseanswer method
		}
		else if(Useranswer.equals("Choice 2"))
		{
			Files(Useranswer, Questions); //runs files method
		}
		else if(Useranswer.equals("Choice 3"))
		{
			Techinfo(Questions); //runs Techinfo method
		}
		else if(Useranswer.equals("Choice 4"))
		{
			sort(Useranswer, Questions); //runs sort method
		}
		else 
		{
			System.out.println("Enter one of the choices");
			options(Useranswer, Questions);
		}
	}
	
	public static String toStringQA(Answers a)
	{
		String s = "Q1: " + getQ1(a) + "\r\n" + "Q2: " + getQ2(a) + "\r\n" + "Q3: " + getQ3(a) + "\r\n" + "Q4: " + getQ4(a) + "\r\n" + "Q5: " + getQ5(a);  
		return s;
		//Concatinates get methods
		//retuns s
	}
	
	public static void GameResults(String Useranswer, int score, final int arraySize, String [] Questions, String Q1A, String Q2A, String Q3A, String Q4A, String Q5A)
	{
		Answers QA = CreateA(Q1A, Q2A, Q3A, Q4A, Q5A); 
		
		System.out.println("You got " + score + " questions right");
		System.out.println("The questions and answers are:");
		System.out.println();
		
		for(int i = 0; i <= arraySize; i++)
		{
			System.out.println(Questions[i] + "\r\n"); //outputs each question
		}
		
		System.out.println(toStringQA(QA)); //outputs each answer
		System.out.println();
	}
	
    public static void bubbleSort(int[] arr) //sorting algorithm
    {  
    	 final int n = arr.length;  //array length
	     int temp = 0; //temporary variable 
	     
	      for(int i=0; i < n; i++)
	      {
	    	  //loops within loops
	    	  for(int j=1; j < (n-i); j++)
	          {  
	    		  if(arr[j-1] > arr[j])
	              {  
	    			  //swaping elements  
	    			  temp = arr[j-1];  
	    			  arr[j-1] = arr[j];  
	    			  arr[j] = temp;  
	              }
	          }  
	      }  
    }
    
	public static void sort(String Useranswer, String [] Questions) throws IOException 
	{  
		final int ArraySize = 10; //Arraysize
		int [] arr = new int [ArraySize];  //creates new arrya
	    
	    for(int i = 0; i < ArraySize; i++)
	    {
	    	arr [i] = inputInt("Enter 10 random numbers"); //asks user to input 10 numbers
	    }
	    
	    System.out.println("Array Before Sort"); //Shows array before the sort
	    
	    for(int i=0; i < arr.length; i++)
	    {  
	    	System.out.print(arr[i] + " ");  //outputs array
	    }
	    
	    System.out.println();  
	                  
	    bubbleSort(arr);//sorting array elements using bubble sort  
	                 
	    System.out.println("Array After Sort"); 
	    
	    for(int i=0; i < arr.length; i++)
	    {  
	    	System.out.print(arr[i] + " ");  //Outputs array after sort
	    }
	    
	    options(Useranswer, Questions);
	}
	
	public static void Files(String Useranswer, String [] Questions) throws IOException
	{
		String file_name = "FileQuestion.txt"; // Sets file_name to the name of the actual file name
		String answer_file_name = "Fileanswer.txt"; //sets answer_file_name to actual file name
		BufferedReader inputStream = new BufferedReader (new FileReader(file_name));
		String Line = inputStream.readLine(); //reads line 
		System.out.println(Line); //outputs line from tetx file
		inputStream.close();
		
		PrintWriter outputStream = new PrintWriter (new FileWriter(answer_file_name));
		Useranswer = inputString("Enter your answer"); //user  input prompt
		outputStream.println(Useranswer); //outputs users input into a file document
		outputStream.close();
		
		options(Useranswer, Questions);
	}
}  

	

