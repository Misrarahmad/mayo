// sp16-bse-119
// Israr Ahmed

import java.util.Scanner;

public class Simpletron 
{
	private int instructionCntr;
	private int operation_Code;	
	private int operand_simpltron;
	private int accumulator_Simpltron;	
	private int instruction_Register;
    private int [] memory_simpltron;		
		
	
	public Simpletron ( ) 
	{
		welcomeMsg ();
		initialVrbl ();
		
	}	

	// method for displaying the welcome message to the user
	public void welcomeMsg ( ) 
	{
		System.out.printf ("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s %s\n%s %s\n", 
			"*** Welcome to Simpletron! ***",
			"*** Please enter your program one instruction ***",
			"*** (or data word) at a time into the input   ***",
			"*** text field. I will display the location   ***",
			"*** number and a question mark (?). You then  ***",
			"*** type the word for that location. Press the***",
			"*** Done button to stop entering your program ***",
			" Loc", " Inst", "****", "*****");
	}	

	
	public void simulator () 
	{
		int submittedInstruction = 0;	
		int memory_simpltronPointer = 0;	

		Scanner input = new Scanner ( System.in );

		do
		{
			System.out.printf ("%d %s  ", memory_simpltronPointer, "?" );
			submittedInstruction = input.nextInt ();
			if ( submittedInstruction != -99999 ) 
				memory_simpltron [ memory_simpltronPointer ] = submittedInstruction;
			memory_simpltronPointer++;	
			
		} while ( submittedInstruction != -99999 );	
		
	        System.out.printf ("\n%s%s", "*** Program loading completed ***\n", 
				"*** Program excecution begins  ***\n");	
		
		
		for ( int code : memory_simpltron ) 
		{
			
			if ( code != 0 )	
			{
				load ();
				execute ( operand_simpltron, operation_Code );
			}
		}

	}	
	
	public void initialVrbl ( )
	{
		memory_simpltron = new int [100];	
		instructionCntr = 0;	

	}
	
	public void load ( ) 
	{
		
		
		operation_Code = memory_simpltron [ instructionCntr ] / 100;
		operand_simpltron = memory_simpltron [ instructionCntr ] % 100;

	}	 	

	
	public void execute (int operand_simpltrons, int operation ) 
	{

		switch ( operation ) 
		{
			case 10: 
				Scanner input = new Scanner ( System.in );
				System.out.print ( "Please Enter a whole number (positive or negative): " );
				memory_simpltron [ operand_simpltrons ] = input.nextInt ();
				break;
			case 11:	
				System.out.println ("The result of the operation is " + memory_simpltron [ operand_simpltrons] );
				break;
			case 20: 
				accumulator_Simpltron = memory_simpltron [ operand_simpltrons ];
				break;
			case 21: 	
				memory_simpltron [ operand_simpltrons ] = accumulator_Simpltron;
				break;
			case 30:
			
				accumulator_Simpltron += memory_simpltron [ operand_simpltrons ];
				break;
			case 31: 
				accumulator_Simpltron -= memory_simpltron [ operand_simpltrons ];
				break;
			case 32:	
				accumulator_Simpltron /=  memory_simpltron [ operand_simpltrons ];
				break;
			case 33: 
				accumulator_Simpltron *= memory_simpltron [ operand_simpltrons ];
				break;
			case 40:	
				instructionCntr = operand_simpltrons;
				break;
			case 41:	
				if ( accumulator_Simpltron < 0 )
					instructionCntr = operand_simpltrons;
				break;
			case 42:	
				if ( accumulator_Simpltron == 0 )
					instructionCntr = operand_simpltrons;
				break;
			case 43: 	
				dumpTheCore ();	
				System.out.printf ("\n%s\n", "The program has ended...");
				System.exit ( 0 );
				break;

		}	

	}	
	public void dumpTheCore ( )
	{
		System.out.printf ("\n%30s\n%30s\t%s%4d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n\n%30s\n", "REGISTERS:", 
				"accumulator_Simpltron", "+", accumulator_Simpltron, "instruction counter", instructionCntr, "instruction register",
			       	instructionCntr, "operation code", operation_Code, "operand_simpltron", operand_simpltron, "memory_simpltron:" );

		
		for ( int i = 0; i < 10; i++ )
		{
			System.out.printf ( "%6d", i);
		}

		System.out.println ();
		int counter = 0;	
		for (int i = 0; i < 10; i++ ) 
		{
			if ( counter %10 == 0 )
				System.out.printf ("%2d ", counter);
			for (int j = 0; j < 10; j++) 
			{	
				
				if ( memory_simpltron [ counter ] == 0 )
					System.out.printf ( "%s%s", "+", "0000 ");
				else 
					System.out.printf ("%s%4d ", "+", memory_simpltron [counter]);
				counter++;

			}	// end inner for
		       
		System.out.println ();	

		}	// end outer for 
	}	// end method dumpTheCore

}	// end class Simpletron
