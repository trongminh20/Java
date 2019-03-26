/*
Name: Minh Phan
ID: 300269120
*/
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Mine[][] mines;
    private Button faceBtn;
    private int gameStage;
    private int numOfCols = 5;
    private int numOfRows =5;
    private int numOfBombs =3;
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pn = new BorderPane();
        pn.setTop(topMenu());
        pn.setCenter(createMap());

        Scene scene = new Scene(pn);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public int[][] setBoard(){
        int[][] board = {{1,1,1,0,0},{1,9,2,1,1},{1,1,3,9,2},{0,0,2,9,2},{0,0,1,1,1}};
        return board;
    }
    public Mine[][] setValue(GridPane grid){
        Mine[][] values = new Mine[numOfRows][numOfCols];

        int[][] board = setBoard();

        for(int r = 0; r < values.length; r++){
            for(int c = 0; c < values[r].length; c++){
                values[r][c] = new Mine(r,c,board[r][c]);
            }
        }
        return values;
    }
    public HBox topMenu(){
        HBox top = new HBox();
        faceBtn = new Button();
        faceBtn.setGraphic(new ImageView(
                new Image(
                        "file:res/face-smile.png"
                )
        ));
        Label score = new Label("000");
        Label bombLeft = new Label(Integer.toString(numOfBombs));
        top.getChildren().addAll(score,faceBtn,bombLeft);
        top.setSpacing(10);
        top.setAlignment(Pos.CENTER);
        return top;
    }
    public void isWon(){
        int minesLeft = numOfBombs;
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                if(mines[i][j].getStatus() == 1 && mines[i][j].getValue() == 9)
                    minesLeft--;
            }
        }
        if(minesLeft > 0){
            faceBtn.setGraphic(new ImageView(new Image("file:res/face-win.png")));
        }
    }
    public VBox createMap(){
        VBox map = new VBox();
        GridPane grid = new GridPane();
        mines = setValue(grid);
        gameStage = 1;
        for(int r = 0; r < mines.length; r++){
            for(int c = 0; c < mines[r].length; c++){
                Mine btn = mines[r][c];
                btn.setOnMouseClicked(e->{
                    if(gameStage ==1) {
                        if (btn.getValue() != 9) {
                            btn.setStatus(1);
                            btn.setGraphic(new ImageView(
                                    new Image(
                                            "file:res/" + btn.getValue() + ".png"
                                    )
                            ));

                            isWon();
                        } else {
                            btn.setGraphic(new ImageView(
                                    new Image(
                                            "file:res/mine-red.png"
                                    )
                            ));
                            faceBtn.setGraphic(new ImageView(
                                    new Image(
                                            "file:res/face-dead.png"
                                    )
                            ));
                            gameStage = 3;

                        }
                    }
                });
                grid.add(btn,r,c);
            }
        }
        map.getChildren().addAll(grid);
        return map;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Mine extends Button {
    private int col;
    private int row;
    private int value;
    private int status;

    Mine(int r, int c, int val){
        value = val;
        col = c;
        row = r;
        status = 0;
        setGraphic(new ImageView(new Image("file:res/cover.png")));
        prefWidth(32);
        prefHeight(32);
        setOnMouseClicked(e->{
            setVisible(false);
        });
    }
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}