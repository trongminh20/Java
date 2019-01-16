//Name: Minh Phan
//ID:300269120

public class KenRandom{
    public static String makeGuess(char[][] guesses)
    {
        int row = 0;
        int col = 0;

        
        int[][] hunt = hunting(guesses);
        
        int max = 0;

        for(int r = 0; r < guesses.length;r++){
            for(int c = 0; c < guesses[r].length;c++){
                if(max < hunt[r][c]){
                    max = hunt[r][c];
                    row = r;
                    col =c;
                }
            }
        }
        if(max == 0){
            do{
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*10);
            }while(guesses[row][col]!='.');
        }

        char a = (char)((int)'A' + row);
        String guess = a + Integer.toString(col+1);

        return guess;

    }

    public static boolean checkValid(int r, int c){      
        return (r>=0 && r<10 &&c >=0 && c < 10)? true : false;
    }
  
    public static int[][] hunting(char[][] guesses){
        int[][] hunt = new int[10][10];

        for(int r = 0; r < guesses.length; r++){
            for(int c = 0; c < guesses[r].length; c++){
                if(guesses[r][c] == 'X'){
                    if(checkValid(r,c+1) && guesses[r][c+1] == '.'){
                        hunt[r][c+1] += 10;
                    }
                    if(checkValid(r,c-1) && guesses[r][c-1] == '.'){
                        hunt[r][c-1] +=10;
                    }
                    if(checkValid(r+1, c) && guesses[r+1][c] == '.'){
                        hunt[r+1][c] +=10;
                    }if(checkValid(r-1,c) && guesses[r-1][c] == '.'){
                        hunt[r-1][c] +=10;
                    }     
                }
            } 
        }
        return hunt;   
    }
}