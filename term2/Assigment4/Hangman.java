//Name: Minh Phan	
//ID: 300269120

import java.util.*;
import java.io.*;
public class Hangman{
    public static void main(String[] args) throws IOException{
        File f = new File("dictionary.txt");
        String picked = randomChose(f);
        String name;
        char[]  hidden = setGame(picked).toCharArray();
        ArrayList<Character>guessed = new ArrayList<Character>();
        ArrayList<Character> wrongGuess = new ArrayList<Character>();
        System.out.println("Hidden word:" + String.valueOf(hidden));
        int score = 0;

        while(wrongGuess.size() <= 7){
            int guessLeft = 7;
            System.out.print("Enter next guess: ");
            char g = guess();
            System.out.println();
            for(int i = 0; i < picked.length(); i++){
                if(g == picked.charAt(i)&& String.valueOf(guessed).indexOf(g) < 0 ){
                    hidden[i] = g;
                    score+=10;
                }
            }
            guessed.add(g);
            if(picked.indexOf(g) < 0){
                System.out.println("Sorry, there were no "+"'"+g+"'");
                wrongGuess.add(g);
                System.out.println();
            }
             guessLeft-=wrongGuess.size();
            if(String.valueOf(hidden).indexOf("_") < 0){
                score+=(guessLeft*30) +100;
                break;
            }
            Collections.sort(wrongGuess);
            System.out.println("Hidden word:" + String.valueOf(hidden));
            System.out.println("Incorrect guesses: "+wrongGuess.toString().replace("[","").replace("]","").toUpperCase());
            System.out.println("Guesses left: "+ guessLeft);
            System.out.println("Score: "+score);
        }
        System.out.println("Your turn finished!!");
        sortPlayerScore();
        if(score >= highest()){
            Scanner stdin = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            name = stdin.next();
            Player player = new Player(name, score);
            addPlayer(player);
        }
        System.out.println("These are top 5 people: ");
        sortPlayerScore();
        printHeader();
        System.out.println("Thank you, Goodbye!");
    }//end main

    public static int highest() throws IOException{
        FileReader frd = new FileReader("PlayersSorted.txt");

        BufferedReader stdin = new BufferedReader(frd);
        String ln = stdin.readLine();
        int score = 0;
        if(ln!=null){
            String[] plDetail = ln.split(" ");
            score = Integer.valueOf(plDetail[1]);
        }
        return score;
    }
    public static void sortPlayerScore() throws IOException{
        FileReader f = new FileReader("Players.txt");
        BufferedReader input = new BufferedReader(f);
        ArrayList<Player> list = new ArrayList<Player>();
        String current = input.readLine();
        FileWriter PlayerSort = new FileWriter("PlayersSorted.txt");
        BufferedWriter writePlayer = new BufferedWriter(PlayerSort);
        try {
            while (current != null) {
                String[] playerDetail = current.split(" ");
                String name = playerDetail[0];
                int score = Integer.valueOf(playerDetail[1]);
                list.add(new Player(name, score));
                current = input.readLine();
            }

            list.sort(new scoreCompare());

            for (Player p : list) {
                writePlayer.write(p.getName() + " " + p.getScore());
                writePlayer.newLine();
            }
        }catch(Exception e){
            System.out.println("Could not sort data!");
        }

        input.close();
        writePlayer.close();
        PlayerSort.close();

    }//end sortData

    public static void printHeader() throws IOException{
        FileReader f = new FileReader("PlayersSorted.txt");
        BufferedReader input = new BufferedReader(f);
        String line=input.readLine();
        int count = 1;
        try{
            while((line !=null)&& count <=5){
                System.out.println(line);
                count+=1;
                line=input.readLine();
            }
            input.close();
        }catch (Exception e){
            System.out.println("could not read file!!");
        }
    }

    public static void addPlayer(Player a) throws IOException{
        File f = new File("Players.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
        BufferedWriter newPlayer = new BufferedWriter(fw);
        newPlayer.write(a.getName()+" "+a.getScore()+"\n");
        newPlayer.close();
    }

    public static Character guess(){
        Scanner stdin = new Scanner(System.in);
        char ch = Character.toLowerCase(stdin.next().charAt(0));
        return ch;
    }

    public static String setGame(String str){
        String hidden = "";
        for(int i = 0 ; i < str.length(); i++){
            hidden+="_";
        }
        return hidden;
    }

    public static String randomChose(File f ) throws FileNotFoundException{
        Random stdin = new Random();
        int rand = stdin.nextInt(5999)+1;
        int count = 0;
        Scanner input = new Scanner(f);
        String choose = input.nextLine();

         while(input.hasNextLine()){
             if(count == rand){
                 choose = input.next();
                 break;
             }
             count++;
             input.nextLine();
         }
         input.close();
         return choose;
    }
}//end Hangman class

class scoreCompare implements Comparator<Player>
{
    @Override
    public int compare(Player p1, Player p2)
    {
        return p2.getScore() - p1.getScore();
    }
}

class Player{
    private String name;
    private int score ;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}