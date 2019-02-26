import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		int gridsize=getsize();
		char[][] matrix=new char[gridsize][gridsize];
		char[] symbols=getsymbols(gridsize);
		getmatrix(gridsize,symbols,matrix);
		Sudoku sd=new Sudoku(matrix,gridsize,symbols);
		boolean solution=sd.sudokusolution();
		if(solution)
		{
			System.out.println("sudoku solution");
			sd.display();
		}
		else
		{
			System.out.println("Unsolvable");
		}
	}

	private static void getmatrix(int gridsize, char[] symbols, char[][] matrix) 
	{
		// TODO Auto-generated method stub
		String grid="";
		int counter=0;
		System.out.println("Enter the sudoku grid to be solved:");
		Scanner input=new Scanner(new BufferedInputStream(System.in));
		while (counter<gridsize && input.hasNext() )
		{
			String line=input.next();
			buildmatrix(line,gridsize,counter,matrix);
			counter++;
		}
	}

	private static void buildmatrix(String line, int gridsize, int counter, char[][] matrix) 
	{
		// TODO Auto-generated method stub
		char[] array = new char[line.length()];
		int i = 0;
		for (char c : line.toCharArray())
		{
			if(c=='.')
			{
				array[i++]='0';
			}
			else
			{
				array[i++] = c;	
			}
		}
		if(array.length==0)
		{
			System.out.println("Input cannot be empty");
		}
		else
		{
			for (int j = 0; j < gridsize; j++)
			{
				matrix[counter][j] = array[j];
			}
		}
	}

	private static char[] getsymbols(int gridsize) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the list of Symbols:");
		Scanner input=new Scanner(System.in);
		String symbols=input.next();
		char[] array = new char[symbols.length()];
		int i = 0;
		for (char c : symbols.toCharArray())
			array[i++] = c;
		if(array.length!=gridsize)
		{
			System.out.println("Number of symbols are not correct");
			getsymbols(gridsize);
		}
		if(array.length!=0)
		{
			for(int j=0;j<=array.length;j++)
			{
				for(int k=j+1;k<array.length;k++)
				{
				  if(array[j]==array[j+1])
				  {
					  System.out.println("Duplicate characters!!!");
					  getsymbols(gridsize);
				  }
				}	  
			  }
		}
		return array;
	}

	private static int getsize()
	{
		boolean intvalue;
		System.out.println("Enter the size of the grid: ");
		Scanner input=new Scanner(System.in);
		int size=input.nextInt();
		if(size==0)
		{
			System.out.println("Size cannot be null!!");
			getsize();
		}
		return size;
	}
}
