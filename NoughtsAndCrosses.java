import java.util.Scanner;

public class NoughtsAndCrosses
{
    public static void main(String[] args)
    {
    	char currPlayer = 'X';
    	String inputString = " ";
    	char currChar1 = ' ';
    	int currInt1 = 1;
    	int currInt2 = 1;
    	NoughtsAndCrosses obj = new NoughtsAndCrosses();
    	char[][] array = new char[3][3];
    	obj.clearBoard(array);
    	obj.printBoard(array);
    	Scanner input = new Scanner(System.in);
		System.out.print("Enter move for "+currPlayer+": ");
    	
    	while(!obj.isBoardFull(array) && obj.winner(array)==' ')
    	{
    		
    		if(input.hasNext())
    		{
    			inputString = input.next();
    			System.out.println(inputString);
    			Scanner stringScanner = new Scanner(inputString);
    			stringScanner.useDelimiter("");
    			currChar1 = (char)stringScanner.next().getBytes()[0];
    			switch(currChar1)
    			{
    			case 'A':
    				currInt1 = 0;
    				break;
    			case 'B':
    				currInt1 = 1;
    				break;
    			case 'C':
    				currInt1 = 2;
    				break;
    			}
    			currInt2 = stringScanner.nextInt();
    			
        		obj.makeMove(array, currPlayer, currInt1, currInt2-1);
        		obj.printBoard(array);
        		currPlayer = (currPlayer=='X' ? 'O' : 'X');
        		stringScanner.close();
    			System.out.print("Enter move for "+currPlayer+": ");
    		}
    	}
    	if(obj.winner(array)!=' ')
    		System.out.println(obj.winner(array)+" wins!");
    	else
    		System.out.println("It's a draw!");
    	
    	input.close();
    }
    
    public void clearBoard(char[][] array)
    {
    	for(int i=0; i<3; i++)
    	{
    		for(int n=0; n<3; n++)
    		{
    			array[i][n] = ' ';
    		}
    	}
    }
	
    public void printBoard(char[][] array)
    {
    	char[] letters = new char[3];
    	letters[0] = 'A';
    	letters[1] = 'B';
    	letters[2] = 'C';
    	
    	for(int i=0; i<3; i++)
    	{
    		if(i>0)
    			System.out.println(" ---|---|---");
    		System.out.print(letters[i]);
    		for(int n=0; n<3; n++)
    		{
    			if(n>0)
    				System.out.print("|");
    			System.out.print(" "+array[i][n]+" ");
    		}
    		System.out.println("");
    	}
    	System.out.println("  1   2   3 ");
    }
	
    public boolean canMakeMove(char[][] array, int i, int n)
    {
    	return (array[i][n] == ' ' ? true : false);
    }
	
    public void makeMove(char[][] array, char a, int i, int n)
    {
    	if(canMakeMove(array, i, n))
    		array[i][n] = a;
    }
	
    public boolean isBoardFull(char[][] array)
    {
    	for(int i=0; i<3; i++)
    	{
    		for(int n=0; n<3; n++)
    		{
    			if(array[i][n]==' ')
    				return false;
    		}
    	}
    	return true;
    }
	
    public char winner(char[][] array)
    {
    	if(checkHorizontal(array)!=' ')
    		return checkHorizontal(array);
    	if(checkVertical(array)!=' ')
    		return checkVertical(array);
    	if(checkDiagonals(array)!=' ')
    		return checkDiagonals(array);
    	return ' ';
    }
    
    public char checkHorizontal(char[][] array)
    {
    	char first;
    	char second;
    	char third;
    	for(int i=0; i<3; i++)
    	{
    		first = array[i][0];
    		second = array[i][1];
    		third = array[i][2];
    		if((first!=' ') && (first==second) && (second==third))
    			return first;
    	}
    	return ' ';
    }
    
    public char checkVertical(char[][] array)
    {
      	char first;
    	char second;
    	char third;
    	for(int i=0; i<3; i++)
    	{
    		first = array[0][i];
    		second = array[1][i];
    		third = array[2][i];
    		if((first!=' ') && (first==second) && (second==third))
    			return first;
    	}
    	return ' ';
    }
    
    public char checkDiagonals(char[][] array)
    {
      	char first;
    	char second;
    	char third;
    	first = array[0][0];
    	second = array[1][1];
   		third = array[2][2];
   		if((first!=' ') && (first==second) && (second==third))
   			return first;
   		first = array[0][2];
   		second = array[1][1];
   		third = array[2][0];
   		if((first!=' ') && (first==second) && (second==third))
   			return first;
    	return ' ';
    }
}