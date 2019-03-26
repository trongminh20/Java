/*
* Name: Minh Phan
* ID: 300269120
* */

package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

import static javafx.event.Event.ANY;
import static javafx.scene.input.MouseEvent.*;

public class Main extends Application {

    private Mine[][] mines;
    private int numOfCols = 8;
    private int numOfRows = 8;
    private int gameStage;
    private int numOfBombs = 10;
    private Button faceBtn;
    private Label dozen;
    private Label dig ;
    private AnimationTimer timeCounting;
    boolean firstClick;

    public void recursion(int x, int y){
        if(!checkValid(x,y)){
            return;
        }
        if(mines[x][y].getStatus() == 1){
            return;
        }
        if(mines[x][y].getStatus() == 2){
            return;
        }
        if(mines[x][y].getValue() != 9){
            mines[x][y].setGraphic(new ImageView(new Image("file:res/" + mines[x][y].getValue() + ".png")));
            mines[x][y].setStatus(1);
        }
        if(mines[x][y].getValue() == 0) {
            recursion(x + 1, y);
            recursion(x - 1, y);

            recursion(x, y + 1);
            recursion(x, y - 1);

            recursion(x+1,y+1);
            recursion(x-1,y-1);

            recursion(x-1,y+1);
            recursion(x+1,y-1);
        }

    }

    public  boolean checkValid(int r, int c){
        return r >= 0 && r < numOfRows && c >= 0 && c < numOfCols;
    }

    private HBox timeCountBox(){
        HBox time = new HBox();
        long beginningTime = System.currentTimeMillis();
        Label timeOver = new Label("");
        Label timeMinute = new Label("");
        Label timeSecond = new Label("");

        timeCounting = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long diff = System.currentTimeMillis() - beginningTime ;
                timeOver.setGraphic(new ImageView(new Image("file:digits/"+(diff /1000)/100+".png")));
                if((diff /1000) <= 99) {
                    timeMinute.setGraphic(new ImageView(new Image("file:digits/"+((diff) /1000)/10+".png")));
                }
                if((diff /1000)>99) {
                    timeMinute.setGraphic(new ImageView(new Image("file:digits/"+((diff) /10000)%10+".png")));
                }
                timeSecond.setGraphic(new ImageView(new Image("file:digits/"+(diff /1000)%10+".png")));
            }
        };

        timeCounting.start();

        time.getChildren().addAll(
                timeOver,
                timeMinute,
                timeSecond
        );
        time.setAlignment(Pos.CENTER_LEFT);
        return time;
    }

    private HBox bombsCountBox(){
        HBox c = new HBox();

        dozen =new Label("");
        dig = new Label("");

        dozen.setGraphic(new ImageView(new Image("file:digits/"+(numOfBombs)/10+".png")));
        dig.setGraphic(new ImageView(new Image("file:digits/"+(numOfBombs)%10+".png")));
        c.getChildren().addAll(dozen,dig);
        c.setAlignment(Pos.CENTER_LEFT);
        return c;
    }

    private Button setStartingFace(Stage stage){
        faceBtn = new Button();
        faceBtn.setGraphic(new ImageView(new Image("file:res/face-smile.png")));
        faceBtn.setOnMouseClicked(reset -> {
            try {
                resetGame(stage);
            }catch(Exception a){
                System.out.println(a.getMessage());
            }
        });
        return faceBtn;
    }

    private HBox topMenu(Stage stage) {
        HBox topMenu = new HBox();

        Button face = setStartingFace(stage);
        face.setStyle("-fx-margin: auto; " +
                "-fx-width: 25px;" +
                "-fx-height: 25px;" +
                "-fx-border: 1px;" +
                "");
        HBox timeLabelBox = timeCountBox();
        HBox bombsCountLabelBox = bombsCountBox();

        topMenu.getChildren().addAll(
                timeLabelBox,
                face,
                bombsCountLabelBox
        );

        topMenu.setAlignment(Pos.CENTER);
        topMenu.setSpacing(10);
        return topMenu;
    }

    private Mine[][] setValue(GridPane grid){
        Mine[][] values = new Mine[numOfRows][numOfCols];

        int[][] board = setBoard();

        for(int r = 0; r < values.length; r++){
            for(int c = 0; c < values[r].length; c++){
                values[r][c] = new Mine(r,c,board[r][c]);
            }
        }
        return values;
    }

    private GridPane creatingMap(){
        gameStage = 1;
        GridPane map = new GridPane();
        map.setPadding(new Insets(10));

        mines = setValue(map);
        for(int r = 0; r < mines.length; r++){
            for(int c = 0; c < mines[r].length; c++) {
                Mine btn = mines[r][c];
                mouseEvents(btn);
                map.add(btn,r,c);
            }
        }

        return map;
    }

    private int[][] setToZero(int[][] board){
        for(int r = 0; r < board.length; r++ ){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = 0;
            }
        }
        return board;
    }

    private void setBombs(int[][] board){
        Random stdin = new Random();

        int ranC = stdin.nextInt(numOfCols)+1;
        int ranR = stdin.nextInt(numOfRows)+1;

        int count = 0;

        while( count < numOfBombs){
            ranC = stdin.nextInt(numOfCols)+1;
            ranR = stdin.nextInt(numOfRows)+1;
            if(checkValid(ranR,ranC) && board[ranC][ranR] != 9) {
                board[ranR][ranC] = 9;
                count++;
            }

        }
        System.out.println("set " + count + " bombs out of " + numOfBombs);
    }

    private int[][] setBoard(){
        int[][] board = new int[numOfRows][numOfCols];
        setToZero(board);
        setBombs(board);

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] == 9){
                    if(checkValid(r+1, c+1) && board[r+1][c+1] != 9){
                        board[r+1][c+1]+=1;
                    }
                    if(checkValid(r-1, c-1) && board[r-1][c-1] != 9){
                        board[r-1][c-1]+=1;
                    }
                    if(checkValid(r+1, c-1) && board[r+1][c-1] != 9){
                        board[r+1][c-1]+=1;
                    }
                    if(checkValid(r-1, c+1) && board[r-1][c+1] != 9){
                        board[r-1][c+1]+=1;
                    }
                    if(checkValid(r, c+1) && board[r][c+1] != 9){
                        board[r][c+1]+=1;
                    }
                    if(checkValid(r, c-1) && board[r][c-1] != 9){
                        board[r][c-1]+=1;
                    }
                    if(checkValid(r+1, c) && board[r+1][c] != 9){
                        board[r+1][c]+=1;
                    }
                    if(checkValid(r-1, c) && board[r-1][c] != 9){
                        board[r-1][c]+=1;
                    }
                }
            }
        }
        return board;
    }

    private MenuBar menuBar(Stage stage){
        MenuBar menuBar = new MenuBar();
        Menu menuOptions = new Menu("Game Options");

        MenuItem beginner = new MenuItem("Beginner");
        MenuItem medium = new MenuItem("Medium");
        MenuItem expert = new MenuItem("Expert");

        beginner.setOnAction(e->{
            numOfCols = 8;
            numOfRows = 8;
            numOfBombs = 10;
            try {
                start(stage);
            }catch(Exception error){
                System.out.println(error.getMessage());
            }
        });

        medium.setOnAction(e->{
            numOfCols = 16;
            numOfRows = 16;
            numOfBombs = 40;
            try {
                start(stage);
            }catch(Exception error){
                System.out.println(error.getMessage());
            }
        });

        expert.setOnAction(e->{
            numOfCols = 32;
            numOfRows = 16;
            numOfBombs = 99;
            try {
                start(stage);
            }catch(Exception error){
                System.out.println(error.getMessage());
            }
        });
        menuOptions.getItems().addAll(beginner, medium, expert);
        menuBar.getMenus().add(menuOptions);

        return menuBar;
    }

    private void openMines(Mine[][] m){
        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[r].length; c++){
                if(m[r][c].getValue() == 9){
                    if(m[r][c].getStatus() == 2){
                        m[r][c].setGraphic(new ImageView(
                                new Image(
                                        "file:res/mine-misflagged.png"
                                )
                        ));
                    }else {
                        m[r][c].setGraphic(new ImageView(
                                new Image(
                                        "file:res/mine-grey.png"
                                )
                        ));
                    }
                }
            }
        }
    }

    private void isWon(){
        int nonMinesUnOpened = 0;
        for(int i = 0; i < numOfCols; i++){
            for(int j = 0; j < numOfRows; j++){
                if(mines[i][j].getStatus() == 0 && mines[i][j].getValue() != 9)
                    nonMinesUnOpened++;
            }
        }
        if(nonMinesUnOpened == 0){
            faceBtn.setGraphic(new ImageView(new Image("file:res/face-win.png")));
            gameStage = 3;
            timeCounting.stop();
        }
    }

    private void resetGame(Stage newStage) throws Exception{
        faceBtn.setGraphic(new ImageView(
                new Image(
                        "file:res/face-smile.png")
        ));
        gameStage = 1;
        start(newStage);
    }

    private int countBombsFlagged(){
        int countB = 0;
        for(int r = 0; r < mines.length; r++){
            for(int c = 0; c < mines[r].length;c++){
                if(mines[r][c].getStatus() == 2){
                    countB++;
                }
            }
        }
        return countB;
    }

    private void shiftingValue(Mine[][] m, int x, int y){
        if(m[x][y].getValue() != 0 && firstClick == true){
            for(int r = x ; r < m.length; r++){
                for(int c = y; c < m[r].length; c++){
                    if(m[r][c].getValue() == 0){
                        m[x][y].setValue(m[r][c].getValue());
                    }
                }
            }
        }
    }
    private void mouseEvents(Mine btn){
        btn.setOnMousePressed(e -> {
            if (gameStage == 1) {
                faceBtn.setGraphic(new ImageView(new Image("file:res/face-O.png")));
            }
        });
        btn.setOnMouseReleased(e -> {
            if (gameStage == 1) {
                faceBtn.setGraphic(new ImageView(new Image("file:res/face-smile.png")));
            }
        });
        btn.setOnMouseClicked(e-> {

            if (gameStage == 1) {

                if(e.getButton() == MouseButton.PRIMARY) {
                    if(firstClick){
                        shiftingValue(mines, btn.getRow(), btn.getCol());
                        firstClick = false;
                    }
                    if (btn.getValue() != 9 && btn.getStatus() !=2) {
                        if(btn.getValue() ==0) {

                            recursion(btn.getRow(),btn.getCol());
                        }
                        btn.setGraphic(new ImageView(new Image("file:res/" + btn.getValue() + ".png")));
                        btn.setStatus(1);
                        isWon();
                    } else if(btn.getValue() == 9) {
                        openMines(mines);
                        btn.setGraphic(new ImageView(new Image("file:res/mine-red.png")));
                        faceBtn.setGraphic(new ImageView(new Image("file:res/face-dead.png")));
                        gameStage = 3;
                        timeCounting.stop();
                    }
                }else{
                    if(btn.getStatus() == 0) {
                        btn.setGraphic(new ImageView(new Image("file:res/flag.png")));
                        btn.setStatus(2);
                    }else{
                        btn.setGraphic(new ImageView(new Image("file:res/cover.png")));
                        btn.setStatus(0);
                    }
                }
                dozen.setGraphic(new ImageView(new Image("file:digits/"+(numOfBombs-countBombsFlagged())/10+".png")));
                dig.setGraphic(new ImageView(new Image("file:digits/"+(numOfBombs-countBombsFlagged())%10+".png")));
            }
        });

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pn = new BorderPane();
        Scene scene = new Scene(pn);
        StackPane mapVbox = new StackPane();
        firstClick = true;

        mapVbox.getChildren().addAll(creatingMap());
        mapVbox.setPadding(new Insets(10));

        pn.setBottom(mapVbox);
        pn.setCenter(topMenu(primaryStage));
        pn.setTop(menuBar(primaryStage));

        primaryStage.setTitle("Mines Weeper");
        primaryStage.setScene(scene);
        primaryStage.show();
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

    Mine(int c, int r, int val){
        value = val;
        col = c;
        row = r;
        status = 0;
        setGraphic(new ImageView(new Image("file:res/cover.png")));
        setPadding(new Insets(2.5));

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





