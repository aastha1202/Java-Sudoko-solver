public class Suduko_solver {
    private static int grid_size=9;
   public static void main(String[] args) {

       int [][] board= {
        {7, 0, 2, 0, 5, 0, 6, 0, 0},
        {0, 0, 0, 0, 0, 3, 0, 0, 0},
        {1, 0, 0, 0, 0, 9, 5, 0, 0},
        {8, 0, 0, 0, 0, 0, 0, 9, 0},
        {0, 4, 3, 0, 0, 0, 7, 5, 0},
        {0, 9, 0, 0, 0, 0, 0, 0, 8},
        {0, 0, 9, 7, 0, 0, 0, 0, 5},
        {0, 0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 7, 0, 4, 0, 2, 0, 3} 
      };
      printboard(board);
      if(solveboard(board))
          System.out.println("Solved successfully!");
      else 
      System.out.println("Ehh Unsolved board! ");
      printboard(board);

   } 

private static boolean isNumberinRow(int [][] board, int number, int row)
{   for (int i=0; i<grid_size;i++){
    if (board [row][i]==number)
    return true;
}
return false;
}
private static boolean isNumberinColumn(int [][] board, int number, int column)
{   for (int i=0; i<grid_size;i++){
    if (board [i][column]==number)
    return true;
}
return false;
}
private static boolean isNumberinBox(int [][] board, int number, int column,int row) // to check whether the same number is in 3X3 grid
{   int localboxRow=row -row % 3;       
    int localboxColumn= column-column % 3;

    for (int i=localboxRow; i<localboxRow + 3; i++){
        for(int j=localboxColumn;j<localboxColumn+ 3;j++)
        {
            if (board [i][j]==number)
            return true;

        }
}
return false;
}
private static boolean isValid(int[][]board, int number,int row,int column)
{
    return !isNumberinRow( board,  number, row)&& !isNumberinColumn( board, number, column)&& !isNumberinBox( board, number, column,row);
}
private static boolean solveboard(int[][]board)
{
    for(int row=0; row<grid_size; row++)
    {
        for(int column=0; column<grid_size; column++)
        {
            if(board[row][column]==0)
            {
               for(int i=1; i<=9;i++)
               {
                if (isValid(board,i, row, column))
                {
                  board[row][column]=i;
                  if (solveboard(board)) // calling recursively 
                  {
                    return true;
                   }
                   else 
                    {
                    board[row][column]=0;
                    }
                 }
                }
            return false;
            }
        }  
    } 
return true;
}
 private static void printboard(int [][]board)
{   System.out.println("- - - - -");
    for(int row=0; row<grid_size; row++)
    {
    if(row!=0 && row%3==0)
    System.out.println(" ");
    for(int column=0; column<grid_size; column++)
    {
    if(column!=0 && column%3==0)
    System.out.print("|");
    System.out.print(board[row][column]);
    }
    System.out.println();
    }
    System.out.println("- - - - -");
}
}