package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Controller {

    private String[] row1 = {"","",""};
    private String[] row2 = {"","",""};
    private String[] row3 = {"","",""};
    private Integer counter = 0;
    private boolean gameOver = false;

    public Button buttonPos1;
    public Button buttonPos2;
    public Button buttonPos3;
    public Button buttonPos4;
    public Button buttonPos5;
    public Button buttonPos6;
    public Button buttonPos7;
    public Button buttonPos8;
    public Button buttonPos9;

    public Label counterIndicator;
    public Label winnerIndicator;
    public Label winnerIndicator2;

    public Rectangle banner;

    public void pos1Clicked(){
        if(row1[0].equals("")) {
            row1[0] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos2Clicked(){
        if(row1[1].equals("")) {
            row1[1] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos3Clicked(){
        if(row1[2].equals("")) {
            row1[2] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos4Clicked(){
        if(row2[0].equals("")) {
            row2[0] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos5Clicked(){
        if(row2[1].equals("")) {
            row2[1] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos6Clicked(){
        if(row2[2].equals("")) {
            row2[2] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos7Clicked(){
        if(row3[0].equals("")) {
            row3[0] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos8Clicked(){
        if(row3[1].equals("")) {
            row3[1] = "X";
            counter++;
            updateGame();
        }
    }

    public void pos9Clicked(){
        if(row3[2].equals("")) {
            row3[2] = "X";
            counter++;
            updateGame();
        }
    }

    public void resetGame(){
        row1[0] = ""; row1[1] = ""; row1[2] = "";
        row2[0] = ""; row2[1] = ""; row2[2] = "";
        row3[0] = ""; row3[1] = ""; row3[2] = "";
        counter = 0;
        counterIndicator.setText(Integer.toString(counter));
        gameOver = false;
        banner.setHeight(0);
        updateBoard();
        winnerIndicator.setText("Winner:");
        winnerIndicator2.setText("");
    }

    private void updateGame(){
        updateBoard();
        checkForWinner();

        if(!gameOver) {
            playComputerTurn();
            updateBoard();
            checkForWinner();
        }
        counterIndicator.setText(Integer.toString(counter));
    }

    private void checkForWinner(){
        if(row1[0].equals("X") && row1[1].equals("X") && row1[2].equals("X")){
            playWinAnimation("Winner : X");
        }else if(row2[0].equals("X") && row2[1].equals("X") && row2[2].equals("X")){
            playWinAnimation("Winner: X");
        }else if(row3[0].equals("X") && row3[1].equals("X") && row3[2].equals("X")){
            playWinAnimation("Winner: X");
        }else if(row1[0].equals("X") && row2[0].equals("X") && row3[0].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[0].equals("X") && row2[0].equals("X") && row3[0].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[1].equals("X") && row2[1].equals("X") && row3[1].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[2].equals("X") && row2[2].equals("X") && row3[2].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[0].equals("X") && row2[1].equals("X") && row3[2].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[2].equals("X") && row2[1].equals("X") && row3[0].equals("X")) {
            playWinAnimation("Winner: X");
        }else if(row1[0].equals("O") && row1[1].equals("O") && row1[2].equals("O")){
            playWinAnimation("Winner : O");
        }else if(row2[0].equals("O") && row2[1].equals("O") && row2[2].equals("O")){
            playWinAnimation("Winner: O");
        }else if(row3[0].equals("O") && row3[1].equals("O") && row3[2].equals("O")){
            playWinAnimation("Winner: O");
        }else if(row1[0].equals("O") && row2[0].equals("O") && row3[0].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(row1[0].equals("O") && row2[0].equals("O") && row3[0].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(row1[1].equals("O") && row2[1].equals("O") && row3[1].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(row1[2].equals("O") && row2[2].equals("O") && row3[2].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(row1[0].equals("O") && row2[1].equals("O") && row3[2].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(row1[2].equals("O") && row2[1].equals("O") && row3[0].equals("O")) {
            playWinAnimation("Winner: O");
        }else if(counter >= 9){
            playWinAnimation("Tie!");
        }
    }

    private void updateBoard(){
        buttonPos1.setText(row1[0]);
        buttonPos2.setText(row1[1]);
        buttonPos3.setText(row1[2]);
        buttonPos4.setText(row2[0]);
        buttonPos5.setText(row2[1]);
        buttonPos6.setText(row2[2]);
        buttonPos7.setText(row3[0]);
        buttonPos8.setText(row3[1]);
        buttonPos9.setText(row3[2]);
    }

    private void playComputerTurn(){
        Random generateNum = new Random();
        boolean madeRandomGuess = false;
        if(row1[0].equals("X") && row1[1].equals("X") && row1[2].equals("")){
            row1[2] = "O";
            buttonPos3.setText(row1[2]);
            counter++;
        }else if(row1[0].equals("") && row1[1].equals("X") && row1[2].equals("X")){
            row1[0] = "O";
            buttonPos1.setText(row1[0]);
            counter++;
        }else if(row2[0].equals("X") && row2[1].equals("X") && row2[2].equals("")) {
            row2[2] = "O";
            buttonPos6.setText(row2[2]);
            counter++;
        }else if(row2[0].equals("") && row2[1].equals("X") && row2[2].equals("X")) {
            row2[0] = "O";
            buttonPos4.setText(row2[0]);
            counter++;
        }else if(row3[0].equals("") && row3[1].equals("X") && row3[2].equals("X")) {
            row3[0] = "O";
            buttonPos7.setText(row3[0]);
            counter++;
        }else if(row3[0].equals("X") && row3[1].equals("X") && row3[2].equals("")) {
            row3[2] = "O";
            buttonPos9.setText(row3[2]);
            counter++;
        }else if(row1[0].equals("X") && row2[0].equals("X") && row3[0].equals("")) {
            row3[0] = "O";
            buttonPos7.setText(row3[0]);
            counter++;
        }else if(row1[0].equals("X") && row2[0].equals("X") && row3[0].equals("")) {
            row3[0] = "O";
            buttonPos7.setText(row3[0]);
            counter++;
        }else if(row1[1].equals("X") && row2[1].equals("X") && row3[1].equals("")) {
            row3[1] = "O";
            buttonPos8.setText(row3[1]);
            counter++;
        }else if(row1[2].equals("X") && row2[2].equals("X") && row3[2].equals("")) {
            row3[2] = "O";
            buttonPos8.setText(row3[2]);
            counter++;
        }else if(row1[0].equals("") && row2[0].equals("X") && row3[0].equals("X")) {
            row1[0] = "O";
            buttonPos1.setText(row1[0]);
            counter++;
        }else if(row1[1].equals("") && row2[1].equals("X") && row3[1].equals("X")) {
            row1[1] = "O";
            buttonPos2.setText(row1[1]);
            counter++;
        }else if(row1[2].equals("") && row2[2].equals("X") && row3[2].equals("X")) {
            row1[2] = "O";
            buttonPos3.setText(row1[2]);
            counter++;
        }else if(row1[2].equals("") && row2[2].equals("X") && row3[2].equals("X")) {
            row1[2] = "O";
            buttonPos3.setText(row1[2]);
            counter++;
        }else if(row1[0].equals("") && row2[1].equals("X") && row3[2].equals("X")) {
            row1[0] = "O";
            buttonPos1.setText(row1[0]);
            counter++;
        }else if(row1[0].equals("X") && row2[1].equals("X") && row3[2].equals("")) {
            row3[2] = "O";
            buttonPos9.setText(row3[2]);
            counter++;
        }else if(row1[2].equals("X") && row2[1].equals("X") && row3[0].equals("")) {
            row3[0] = "O";
            buttonPos7.setText(row3[0]);
            counter++;
        }else if(row1[2].equals("") && row2[1].equals("X") && row3[0].equals("X")) {
            row1[2] = "O";
            buttonPos3.setText(row1[2]);
            counter++;
        }else{
            while(!madeRandomGuess) {
                int randomNum = generateNum.nextInt(3);
                switch (generateNum.nextInt(3)) {
                    case 0:
                        if (row1[randomNum].equals("")) {
                            row1[randomNum] = "O";
                            madeRandomGuess = true;
                            counter++;
                        }
                        break;
                    case 1:
                        if (row2[randomNum].equals("")) {
                            row2[randomNum] = "O";
                            madeRandomGuess = true;

                        }
                        break;
                    case 2:
                        if (row3[randomNum].equals("")) {
                            row3[randomNum] = "O";
                            madeRandomGuess = true;
                            counter++;
                        }
                        break;
                }
                System.out.println(madeRandomGuess);
            }
        }
    }

    private void playWinAnimation(String winner){

        banner.setHeight(100);
        winnerIndicator.setText(winner);
        winnerIndicator2.setText(winner);
        gameOver = true;
    }
}

