package blackjackv2;
import java.io.*;
import java.util.Scanner;

public class WinCounter {

    private static final String fileName = "wins.txt";
    

    public int readWins(){
        File file = new File(fileName);
        if (!file.exists()){
            return 0;
        }

        try (Scanner scanner = new Scanner(file)){
            return scanner.hasNextInt() ? scanner.nextInt() : 0;
        } catch  (FileNotFoundException e){
            return 0;
        }
    }

    public void writeWins(int wins){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))){
            writer.write(String.valueOf(wins));
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    public void addWin(){
        int currentWins = readWins();
        writeWins(currentWins + 1);
    }

    public void resetScore(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))){
            writer.write("0");
        } catch (IOException e){
            e.getStackTrace();
        } 
    }


  

    public static void main(String[] args) {
        WinCounter fileHandler = new WinCounter();

        fileHandler.addWin();
        fileHandler.resetScore();
        System.out.println("total wins: " + fileHandler.readWins());
       // fileHandler.resetScore("score.txt");
        //System.out.println(fileHandler.getWinsFromFile("score.txt"));
    }
}
