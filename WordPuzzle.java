/* daily coding problem #98 */

/* Given a 2D board of characters and a word,
* find if the word exists in the grid.
*
* The word can be constructed from letters of sequentially adjacent cell,
* where "adjacent" cells are those horizontally or vertically neighboring.
* The same letter cell may not be used more than once.
*
* For example, given the following board:
*
* [
*  ['A','B','C','E'],
*  ['S','F','C','S'],
*  ['A','D','E','E']
* ]

* exists(board, "ABCCED") returns true, 
* exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
*/

public class WordPuzzle
{
	public static void main(String[] args)
	{
		char[][] board = new char[][]{{'A','B','C','E','O'},{'S','F','C','S','P'},{'A','D','E','E','S'}};

		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j] + " ");	
			}
			System.out.println();
		}

		String word = "ABCCED";
	
		// algorithm requires that word is in uppercase if matrix contains upper case characters, vice versa
		word = word.toUpperCase();

		boolean exists = wordExists(board, word);

		System.out.println(word + " exists : " + exists);
	}

	public static boolean wordExists(char[][] board, String word)
	{
		boolean exists = false;

		// look for the first character of word in the matrix
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				if(board[i][j] == word.charAt(0))
				{
					int stringIndex = 1;

					// update character to lower case so that we do not
					// use the same character twice
					board[i][j] = Character.toLowerCase(board[i][j]);

					exists = wordExistsHelper(i, j, board, word, stringIndex);

					// set character back to upper case to we can continue searching
					board[i][j] = Character.toUpperCase(board[i][j]);
			
					if(exists)
					{
						return true;
					}
				}
			}
		}	
		return exists;
	}

	public static boolean wordExistsHelper(int row, int col, char[][] board, String word, int stringIndex)
	{
		boolean exists = false;
		int numRows = board.length;
		int numColumns = board[0].length;

		if(stringIndex < word.length())
		{
			// look left
			if(col-1 >= 0 && board[row][col-1] == word.charAt(stringIndex))
			{
				// mark character so that we do not visit it twice
				board[row][col-1] = Character.toLowerCase(board[row][col-1]);
				exists = wordExistsHelper(row, col-1, board, word, stringIndex+1); 
				board[row][col-1] = Character.toUpperCase(board[row][col-1]);
			}

			// look right if the word does not exist
			if(!exists && col+1 < numColumns && board[row][col+1] == word.charAt(stringIndex))
			{
				board[row][col+1] = Character.toLowerCase(board[row][col+1]);
				exists = wordExistsHelper(row, col+1, board, word, stringIndex+1); 
				board[row][col+1] = Character.toUpperCase(board[row][col+1]);
			}

			// look up if word does not exist
			if(!exists && row-1 >= 0 && board[row-1][col] == word.charAt(stringIndex))
			{
				board[row-1][col] = Character.toLowerCase(board[row-1][col]);
				exists = wordExistsHelper(row-1, col, board, word, stringIndex+1); 
				board[row-1][col] = Character.toUpperCase(board[row-1][col]);
			}

			// look down if word does not exist
			if(!exists && row+1 < numRows && board[row+1][col] == word.charAt(stringIndex))
			{
				board[row+1][col] = Character.toLowerCase(board[row+1][col]);
				exists = wordExistsHelper(row+1, col, board, word, stringIndex+1); 
				board[row+1][col] = Character.toUpperCase(board[row+1][col]);
			}

			// at this point we can confirm that word does not exist
		}

		// return true if every single character in the word has been evaluated
		else
		{
			exists = true;
		}

		return exists;
	}
}
