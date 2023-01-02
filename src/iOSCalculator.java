import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;

public class iOSCalculator extends Application 
{
    Scene functionHelp;
    Scene calculator1;
    Scene calculator2;
    private Label numberLabel;
    private Label txf;
    private Button moreLabel;
    private Button lightModeButton;
    private Button clearButton;
    private Button positiveNegativeButton;
    private Button backspaceButton;
    private Button divideButton;
    private Button multipleButton;
    private Button subtractButton;
    private Button additionButton;
    private Button equalButton;
    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button decimalButton;
    private String numbers = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Calculator 1
        // Create Labels, Buttons, and GridPane
        numberLabel = new Label("0");
        moreLabel = new Button("more");
        moreLabel.setStyle("-fx-background-color: transparent; -fx-font-size: 11pt;  -fx-text-fill: rgb(62, 128, 208);");
        moreLabel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setWidth(615);
                primaryStage.setHeight(300);
                primaryStage.setScene(calculator2);
            }
        });
        lightModeButton = new Button("Light mode");
        lightModeButton.setStyle("-fx-background-color: transparent; -fx-font-size: 11pt;  -fx-text-fill: rgb(62, 128, 208);");
        clearButton = new Button("AC");
        positiveNegativeButton = new Button("⁺/₋");
        backspaceButton = new Button("↩");
        divideButton = new Button("÷");
        multipleButton = new Button("x");
        subtractButton = new Button("-");
        additionButton = new Button("+");
        equalButton = new Button("=");
        buttonZero = new Button("0");
        buttonOne = new Button("1");
        buttonTwo = new Button("2");
        buttonThree = new Button("3");
        buttonFour = new Button("4");
        buttonFive = new Button("5");
        buttonSix = new Button("6");
        buttonSeven = new Button("7");
        buttonEight = new Button("8");
        buttonNine = new Button("9");
        decimalButton = new Button(".");
        GridPane gridpane = new GridPane();

        gridpane.add(clearButton, 0, 0); // Column 0, Row 0
        gridpane.add(positiveNegativeButton, 1, 0); // Column 1, Row 0
        gridpane.add(backspaceButton, 2, 0); // Column 2, Row 0
        gridpane.add(divideButton, 3, 0); // Column 3, Row 0

        gridpane.add(buttonSeven, 0, 1); // Column 0, Row 1
        gridpane.add(buttonEight, 1, 1); // Column 1, Row 1
        gridpane.add(buttonNine, 2, 1); // Column 2, Row 1
        gridpane.add(multipleButton, 3, 1); // Column 3, Row 1

        gridpane.add(buttonFour, 0, 2); // Column 0, Row 2
        gridpane.add(buttonFive, 1, 2); // Column 1, Row 2
        gridpane.add(buttonSix, 2, 2); // Column 2, Row 2
        gridpane.add(subtractButton, 3, 2); // Column 3, Row 2

        gridpane.add(buttonOne, 0, 3); // Column 0, Row 3
        gridpane.add(buttonTwo, 1, 3); // Column 1, Row 3
        gridpane.add(buttonThree, 2, 3); // Column 2, Row 3
        gridpane.add(additionButton, 3, 3); // Column 3, Row 3

        buttonZero.setTranslateX(-75);
        buttonZero.setMinWidth(120);
        buttonZero.setTranslateY(-65);
        gridpane.add(decimalButton, 2, 4); // Column 2, Row 4
        gridpane.add(equalButton, 3, 4); // Column 3, Row 4

        // Horizontal and vertical spacing of gridpane
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        // Styling moreLabel
        moreLabel.getStyleClass().add("more-label");

        // Styling lightModeButton
        lightModeButton.getStyleClass().add("light-mode-button");

        // Styling numberLabel
        numberLabel.getStyleClass().add("number-label");

        // Styling clearButton, positiveNegativeButton, and backspaceButton
        clearButton.getStyleClass().add("gray-circle-button");
        positiveNegativeButton.getStyleClass().add("gray-circle-button");
        backspaceButton.getStyleClass().add("gray-circle-button");

        // Styling buttons 1-9 and decimalButton
        buttonZero.getStyleClass().add("dark-gray-circle-button");
        buttonOne.getStyleClass().add("dark-gray-circle-button");
        buttonTwo.getStyleClass().add("dark-gray-circle-button");
        buttonThree.getStyleClass().add("dark-gray-circle-button");
        buttonFour.getStyleClass().add("dark-gray-circle-button");
        buttonFive.getStyleClass().add("dark-gray-circle-button");
        buttonSix.getStyleClass().add("dark-gray-circle-button");
        buttonSeven.getStyleClass().add("dark-gray-circle-button");
        buttonEight.getStyleClass().add("dark-gray-circle-button");
        buttonNine.getStyleClass().add("dark-gray-circle-button");
        decimalButton.getStyleClass().add("dark-gray-circle-button");

        // Styling divideButton, multipleButton, subtractButton, additionButton, and
        // equalButton
        divideButton.getStyleClass().add("orange-circle-button");
        multipleButton.getStyleClass().add("orange-circle-button");
        subtractButton.getStyleClass().add("orange-circle-button");
        additionButton.getStyleClass().add("orange-circle-button");
        equalButton.getStyleClass().add("orange-circle-button");

        // Register event handler of lightModeButton
        lightModeButton.setOnAction(new LightModeButtonHandler());

        // Register event handler of clearButton
        clearButton.setOnAction(new ClearButtonHandler());

        // Register event handler of positiveNegativeButton
        positiveNegativeButton.setOnAction(new PositiveNegativeButtonHandler());

        // Register event handler of backspaceButton
        backspaceButton.setOnAction(new BackSpaceButtonHandler());

        // Register event handler of decimalButton
        decimalButton.setOnAction(new DecimalButtonHandler());

        // Register event handler of buttonZero
        buttonZero.setOnAction(new ButtonDisplayZero());

        // Register event handler of buttonOne
        buttonOne.setOnAction(new ButtonDisplayOne());

        // Register event handler of buttonTwo
        buttonTwo.setOnAction(new ButtonDisplayTwo());

        // Register event handler of buttonThree
        buttonThree.setOnAction(new ButtonDisplayThree());

        // Register event handler of buttonFour
        buttonFour.setOnAction(new ButtonDisplayFour());

        // Register event handler of buttonFive
        buttonFive.setOnAction(new ButtonDisplayFive());

        // Register event handler of buttonSix
        buttonSix.setOnAction(new ButtonDisplaySix());

        // Register event handler of buttonSeven
        buttonSeven.setOnAction(new ButtonDisplaySeven());

        // Register event handler of buttonEight
        buttonEight.setOnAction(new ButtonDisplayEight());

        // Register event handler of buttonNine
        buttonNine.setOnAction(new ButtonDisplayNine());

        // Create HBoxes and VBox
        HBox hbox = new HBox(10, moreLabel, lightModeButton);

        HBox hbox2c1 = new HBox(numberLabel);

        VBox vboxc1 = new VBox(10, hbox, hbox2c1, gridpane, buttonZero);

        // Set alignment of HBoxes and Vbox
        hbox.setAlignment(Pos.TOP_LEFT);

        hbox2c1.setAlignment(Pos.BASELINE_RIGHT);

        vboxc1.setAlignment(Pos.CENTER);

        vboxc1.setPadding(new Insets(10));

        // Create Scene
        calculator1 = new Scene(vboxc1);
        calculator1.getStylesheets().add("ioscalculator.css");

        // Calculator 2
        Label nums = new Label();
        Button less = new Button();
        less.setText("less");
        less.setStyle("-fx-background-color: transparent; -fx-font-size: 11pt;  -fx-text-fill: rgb(62, 128, 208);");
        less.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setWidth(300);
                primaryStage.setHeight(615);
                primaryStage.setScene(calculator1);
            }
        });
        Button i = new Button();
        i.setText("ⓘ");
        i.setStyle("-fx-background-color: transparent; -fx-font-size: 14pt; -fx-text-fill: rgb(255, 255, 255);");
        Button lightMode = new Button("Light Mode");

        lightMode
                .setStyle("-fx-background-color: transparent; -fx-font-size: 10pt;  -fx-text-fill: rgb(62, 128, 208);");
        lightMode.setMinWidth(100);

        txf = new Label("0");
        txf.setAlignment(Pos.TOP_RIGHT);
        txf.setTranslateX(300);
        txf.setTranslateY(30);
        txf.setStyle("-fx-font-size: 25pt; -fx-text-fill : #ffffff;");
        txf.getStyleClass().add("custom");
        VBox extraBox = new VBox(less, i);
        HBox top = new HBox(20, extraBox, lightMode, nums);

        Button button11 = new Button("(");
        Button button12 = new Button(")");
        Button button13 = new Button("mc");
        Button button14 = new Button("m+");
        Button button15 = new Button("m-");
        Button button16 = new Button("mr");
        button11.setStyle(" -fx-background-color: firebrick");
        button12.setStyle(" -fx-background-color: firebrick");
        button13.setStyle(" -fx-background-color: midnightblue");
        button14.setStyle(" -fx-background-color: midnightblue");
        button15.setStyle(" -fx-background-color: midnightblue");
        button16.setStyle(" -fx-background-color: midnightblue");

        Button button21 = new Button("2nd");
        Button button22 = new Button("x\u00b2");
        Button button23 = new Button("x\u00b3");
        Button button24 = new Button("xʸ");
        Button button25 = new Button("eˣ");
        Button button26 = new Button("10ˣ");

        Button button31 = new Button("1/x");
        Button button32 = new Button("\u00b2" + "√x");
        Button button33 = new Button("\u00b3" + "√x");
        Button button34 = new Button("ʸ√x");
        Button button35 = new Button("ln");
        Button button36 = new Button("log10");
        button36.setStyle("-fx-font-size: 8pt;");

        Button button41 = new Button("x!");
        Button button42 = new Button("sin");
        Button button43 = new Button("cos");
        Button button44 = new Button("tan");
        Button button45 = new Button("e");
        Button button46 = new Button("EE");
        button42.setStyle(" -fx-background-color: darksalmon");
        button43.setStyle(" -fx-background-color: darksalmon");
        button44.setStyle(" -fx-background-color: darksalmon");
        button45.setStyle(" -fx-background-color: #063ef7;");
        button46.setStyle(" -fx-background-color: rgb(82,256,0)");

        Button button51 = new Button("Rad");
        Button button52 = new Button("sinh");
        Button button53 = new Button("cosh");
        Button button54 = new Button("tanh");
        Button button55 = new Button("π");
        Button button56 = new Button("Rand");

        button52.setStyle(" -fx-background-color: darksalmon");
        button53.setStyle(" -fx-background-color: darksalmon");
        button54.setStyle(" -fx-background-color: darksalmon");

        Button ACBtn = new Button("AC");
        Button PlusMinusBtn = new Button("⁺/₋");
        Button backBtn = new Button("↩");
        Button divideBtn = new Button("÷");
        ACBtn.setStyle("-fx-background-color: lightgray; -fx-text-fill: Black");
        PlusMinusBtn.setStyle("-fx-background-color: lightgray; -fx-text-fill: Black");
        backBtn.setStyle("-fx-background-color: lightgray; -fx-text-fill: Black");
        divideBtn.setStyle("-fx-background-color: Orange");

        Button sevenBtn = new Button("7");
        Button eightBtn = new Button("8");
        Button nineBtn = new Button("9");
        Button multiplyBtn = new Button("x");
        sevenBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        eightBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        nineBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        multiplyBtn.setStyle("-fx-background-color: Orange");

        Button fourBtn = new Button("4");
        Button fiveBtn = new Button("5");
        Button sixBtn = new Button("6");
        Button subtractBtn = new Button("-");
        fourBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        fiveBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        sixBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        subtractBtn.setStyle("-fx-background-color: Orange");

        Button oneBtn = new Button("1");
        Button twoBtn = new Button("2");
        Button threeBtn = new Button("3");
        Button plusButton = new Button("+");
        oneBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        twoBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        threeBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        plusButton.setStyle("-fx-background-color: Orange");

        Button zeroBtn = new Button("0");
        zeroBtn.setMinWidth(100);
        zeroBtn.setAlignment(Pos.CENTER_LEFT);
        Button dotBtn = new Button(".");
        Button equalsBtn = new Button("=");
        zeroBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        dotBtn.setStyle("-fx-background-color: rgb(80,80,80)");
        equalsBtn.setStyle("-fx-background-color: Orange");

        // Register event handler of clearButton
        ACBtn.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txf.setText("0");
                numbers = "";
            }
        }));

        // Register event handler of positiveNegativeButton
        PlusMinusBtn.setOnAction(new PositiveNegativeButtonHandlerc2());

        // Register event handler of backspaceButton
        backBtn.setOnAction(new BackSpaceButtonHandlerc2());

        // Register event handler of decimalButton
        dotBtn.setOnAction(new DecimalButtonHandlerc2());

        // Register event handler of buttonZero
        zeroBtn.setOnAction(new ButtonDisplayZeroc2());

        // Register event handler of buttonOne
        oneBtn.setOnAction(new ButtonDisplayOnec2());

        // Register event handler of buttonTwo
        twoBtn.setOnAction(new ButtonDisplayTwoc2());

        // Register event handler of buttonThree
        threeBtn.setOnAction(new ButtonDisplayThreec2());

        // Register event handler of buttonFour
        fourBtn.setOnAction(new ButtonDisplayFourc2());

        // Register event handler of buttonFive
        fiveBtn.setOnAction(new ButtonDisplayFivec2());

        // Register event handler of buttonSix
        sixBtn.setOnAction(new ButtonDisplaySixc2());

        // Register event handler of buttonSeven
        sevenBtn.setOnAction(new ButtonDisplaySevenc2());

        // Register event handler of buttonEight
        eightBtn.setOnAction(new ButtonDisplayEightc2());

        // Register event handler of buttonNine
        nineBtn.setOnAction(new ButtonDisplayNinec2());

        HBox hbox1 = new HBox(10, button11, button12, button13, button14, button15, button16, ACBtn, PlusMinusBtn,
                backBtn, divideBtn);
        HBox hbox2 = new HBox(10, button21, button22, button23, button24, button25, button26, sevenBtn, eightBtn,
                nineBtn, multiplyBtn);
        HBox hbox3 = new HBox(10, button31, button32, button33, button34, button35, button36, fourBtn, fiveBtn, sixBtn,
                subtractBtn);
        HBox hbox4 = new HBox(10, button41, button42, button43, button44, button45, button46, oneBtn, twoBtn, threeBtn,
                plusButton);
        HBox hbox5 = new HBox(10, button51, button52, button53, button54, button55, button56, zeroBtn, dotBtn,
                equalsBtn);

        VBox vbox = new VBox(5, top, hbox1, hbox2, hbox3, hbox4, hbox5);
        vbox.setLayoutX(5);

        vbox.setStyle("-fx-background-color : #000000;");
        top.getChildren().addAll(txf);
        calculator2 = new Scene(vbox);
        calculator2.getStylesheets().add(getClass().getResource("ioscalculator2.css").toExternalForm());
        calculator2.setFill(Color.BLACK);
        i.setOnAction(a -> primaryStage.setScene(functionHelp));

        // Function help
        Label function = new Label(" Function Help");
        function.setStyle("-fx-text-fill : #ffffff;");

        Button exit = new Button("X");
        exit.setStyle("-fx-background-color: BLACK; -fx-font-size: 10pt; -fx-text-fill: #ffffff;");
        exit.setOnAction(e -> primaryStage.setScene(calculator2));

        Label mc = new Label(" mc");
        Label mc1 = new Label(": Memory clear - clears the number stored in memory.");
        Label mp = new Label(" m+");
        Label mp1 = new Label(": Memory add - adds the number that is currently displayed to the number in memory and stores the" +
                        "\n result in memory");
        Label mminus = new Label(" m-");
        Label mminus1 = new Label(": Memory subtract - subtracts the number that is currently displayed from the number in memory and"
        + "\n stores the result in memory");
        Label mr = new Label(" mr");
        Label mr1 = new Label(": Memory recall - displays the number saved in memory");
        Label e = new Label(" e");
        Label e1 = new Label(": displays the value of e");
        Label exponent = new Label(" EE");
        Label exponent1 = new Label(": Enter Exponent - represents the equation *10^\n\t" + "example: 2 EE 3 = 2*10³");
        mc.setStyle("-fx-text-fill : midnightblue;");
        mc1.setStyle("-fx-text-fill : #ffffff;");
        mp.setStyle("-fx-text-fill : midnightblue;");
        mp1.setStyle("-fx-text-fill : #ffffff;");
        mminus.setStyle("-fx-text-fill : midnightblue;");
        mminus1.setStyle("-fx-text-fill : #ffffff;");
        mr.setStyle("-fx-text-fill : midnightblue;");
        mr1.setStyle("-fx-text-fill : #ffffff;");
        e.setStyle("-fx-text-fill : #063ef7;");
        exponent.setStyle("-fx-text-fill : #ffffff;");
        e1.setStyle("-fx-text-fill : rgb(82,256,0);");
        exponent1.setStyle("-fx-text-fill : #ffffff;");

        HBox mcline = new HBox(mc, mc1);
        HBox mpline = new HBox(mp, mp1);
        HBox mminusline = new HBox(mminus, mminus1);
        HBox mrline = new HBox(mr, mr1);
        HBox eline = new HBox(e, e1);
        HBox exponentline = new HBox(exponent, exponent1);

        VBox functionh = new VBox(mcline, mpline, mminusline, mrline, eline, exponentline);

        GridPane menu = new GridPane();
        menu.add(function, 0, 0);
        menu.add(exit, 3, 0);
        menu.add(functionh, 0, 1);
        menu.setStyle("-fx-background-color : #000000;");

        functionHelp = new Scene(menu);

        lightMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                less.setStyle(
                        "-fx-background-color: transparent; -fx-font-size: 11pt;  -fx-text-fill: rgb(62, 128, 208);");
                i.setStyle(
                        "-fx-background-color: transparent; -fx-font-size: 14pt; -fx-text-fill: rgb(255, 255, 255);");
                lightMode.setStyle(
                        "-fx-background-color: transparent; -fx-font-size: 10pt;  -fx-text-fill: rgb(62, 128, 208);");
                txf.setStyle("-fx-text-fill : #ffffff;");
                button11.setStyle(" -fx-background-color: firebrick; -fx-text-fill: Black");
                button12.setStyle(" -fx-background-color: firebrick; -fx-text-fill: Black");
                button13.setStyle(" -fx-background-color: midnightblue; -fx-text-fill: Black");
                button14.setStyle(" -fx-background-color: midnightblue; -fx-text-fill: Black");
                button15.setStyle(" -fx-background-color: midnightblue; -fx-text-fill: Black");
                button16.setStyle(" -fx-background-color: midnightblue; -fx-text-fill: Black");
                button21.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button22.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button23.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button24.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button25.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button26.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button31.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button32.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button33.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button34.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button35.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button36.setStyle(" -fx-background-color: C4C4C4; -fx-font-size: 8pt; -fx-text-fill: Black");
                button41.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button42.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button43.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button44.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button45.setStyle(" -fx-background-color: #063ef7; -fx-text-fill: Black");
                button46.setStyle(" -fx-background-color: rgb(82,256,0); -fx-text-fill: Black");
                button51.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button52.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button53.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button54.setStyle(" -fx-background-color: darksalmon; -fx-text-fill: Black");
                button55.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                button56.setStyle(" -fx-background-color: C4C4C4; -fx-text-fill: Black");
                ACBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: White");
                PlusMinusBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: White");
                backBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: White");
                divideBtn.setStyle("-fx-background-color: #FF8A00; -fx-text-fill: Black");
                sevenBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                eightBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                nineBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                multiplyBtn.setStyle("-fx-background-color: #FF8A00; -fx-text-fill: Black");
                fourBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                fiveBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                sixBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                subtractBtn.setStyle("-fx-background-color: #FF8A00; -fx-text-fill: Black");
                oneBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                twoBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                threeBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                plusButton.setStyle("-fx-background-color:  #FF8A00; -fx-text-fill: Black");
                zeroBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                dotBtn.setStyle("-fx-background-color: #767171; -fx-text-fill: Black");
                equalsBtn.setStyle("-fx-background-color:  #FF8A00; -fx-text-fill: Black");
                calculator2.setFill(Color.WHITE);
                extraBox.setStyle("-fx-background-color: #ffffff");
                top.setStyle("-fx-background-color: #ffffff");
                vbox.setStyle("-fx-background-color : #ffffff;");
                txf.setStyle("-fx-text-fill : #000000;");
                i.setStyle("-fx-background-color: transparent; -fx-font-size: 14pt; -fx-text-fill: #000000;");
                calculator2.getStylesheets().add("ioscalculator2.css");
                function.setStyle("-fx-text-fill : #000000;");
                exit.setStyle("-fx-background-color: WHITE; -fx-font-size: 10pt; -fx-text-fill: #000000;");
                mc.setStyle("-fx-text-fill : #midnightblue;");
                mc1.setStyle("-fx-text-fill : #000000;");
                mp.setStyle("-fx-text-fill : #midnightblu;;");
                mp1.setStyle("-fx-text-fill : #000000;");
                mminus.setStyle("-fx-text-fill : #midnightblue;");
                mminus1.setStyle("-fx-text-fill : #000000;");
                mr.setStyle("-fx-text-fill : #midnightblue;");
                mr1.setStyle("-fx-text-fill : #000000;");
                e.setStyle("-fx-text-fill : #063ef7;");
                e1.setStyle("-fx-text-fill : #000000;");
                exponent.setStyle("-fx-text-fill : rgb(82,256,0);");
                exponent1.setStyle("-fx-text-fill : #000000;");
                menu.setStyle("-fx-background-color : #ffffff;");
            }
        });

        primaryStage.setScene(calculator1);
        primaryStage.setWidth(300);
        primaryStage.setHeight(615);
        primaryStage.setTitle("Calculator");

        // Show the window.
        primaryStage.show();
    }

    // Light Mode
    class LightModeButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Styling moreLabel
            moreLabel.getStyleClass().add("more-label2");

            // Styling lightModeButton
            lightModeButton.getStyleClass().add("light-mode-button");

            // Styling numberLabel
            numberLabel.getStyleClass().add("number-label2");

            // Styling clearButton, positiveNegativeButton, and backspaceButton
            clearButton.getStyleClass().add("dark-gray-circle-button2");
            positiveNegativeButton.getStyleClass().add("dark-gray-circle-button2");
            backspaceButton.getStyleClass().add("dark-gray-circle-button2");

            // Styling buttons 1-9 and decimalButton
            buttonZero.getStyleClass().add("gray-circle-button2");
            buttonOne.getStyleClass().add("gray-circle-button2");
            buttonTwo.getStyleClass().add("gray-circle-button2");
            buttonThree.getStyleClass().add("gray-circle-button2");
            buttonFour.getStyleClass().add("gray-circle-button2");
            buttonFive.getStyleClass().add("gray-circle-button2");
            buttonSix.getStyleClass().add("gray-circle-button2");
            buttonSeven.getStyleClass().add("gray-circle-button2");
            buttonEight.getStyleClass().add("gray-circle-button2");
            buttonNine.getStyleClass().add("gray-circle-button2");
            decimalButton.getStyleClass().add("gray-circle-button2");

            // Styling divideButton, multipleButton, subtractButton, additionButton, and
            // equalButton
            divideButton.getStyleClass().add("orange-circle-button2");
            multipleButton.getStyleClass().add("orange-circle-button2");
            subtractButton.getStyleClass().add("orange-circle-button2");
            additionButton.getStyleClass().add("orange-circle-button2");
            equalButton.getStyleClass().add("orange-circle-button2");
            calculator1.getStylesheets().add("ioscalculator2.css");
        }
    }

    // Clears calculator
    class ClearButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText("0");
            numbers = "";
        }
    }

    // Positive numbers turn into negative numbers, negative numbers turn into
    // positive numbers
    class PositiveNegativeButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.contains(".")) {
                if (Double.parseDouble(numbers) > 0) {
                    numberLabel.setText(numbers = "-" + numbers);
                } else {
                    double negativeNumber = Double.parseDouble(numbers);
                    double positiveNumber = negativeNumber * -1;

                    numbers = Double.toString(positiveNumber);
                    numberLabel.setText(numbers);
                }
            } else {
                if (Integer.parseInt(numbers) > 0) {
                    numberLabel.setText(numbers = "-" + numbers);
                } else {
                    int negativeNumber = Integer.parseInt(numbers);
                    int positiveNumber = negativeNumber * -1;

                    numbers = Integer.toString(positiveNumber);
                    numberLabel.setText(numbers);
                }
            }
        }
    }

    // Calculator backspaces a number
    class BackSpaceButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.length() == 1) {
                numbers = "";
                numberLabel.setText("0");
            } else if (numbers.length() == 0) {
                numbers = "";
                numberLabel.setText("0");
            } else {
                numbers = numbers.substring(0, numbers.length() - 1);
                numberLabel.setText(numbers);
            }
        }
    }

    // Adds and displays a decimal
    class DecimalButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (!numbers.contains(".")) {
                if (numbers.equals("")) {
                    numbers = numbers + "0.";
                    numberLabel.setText(numbers);
                } else {
                    numbers = numbers + ".";
                    numberLabel.setText(numbers);
                }
            }
        }
    }

    // Adds and displays zero
    class ButtonDisplayZero implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.equals("")) {
                numberLabel.setText("0");
            } else {
                numberLabel.setText(numbers = numbers + "0");
            }
        }
    }

    // Adds and displays one
    class ButtonDisplayOne implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "1");
        }
    }

    // Adds and displays two
    class ButtonDisplayTwo implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "2");
        }
    }

    // Adds and displays three
    class ButtonDisplayThree implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "3");
        }
    }

    // Adds and displays four
    class ButtonDisplayFour implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "4");
        }
    }

    // Adds and displays five
    class ButtonDisplayFive implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "5");
        }
    }

    // Adds and displays six
    class ButtonDisplaySix implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "6");
        }
    }

    // Adds and displays seven
    class ButtonDisplaySeven implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "7");
        }
    }

    // Adds and displays eight
    class ButtonDisplayEight implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "8");
        }
    }

    // Adds and displays nine
    class ButtonDisplayNine implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            numberLabel.setText(numbers = numbers + "9");
        }
    }

    // Clears calculator
    class ClearButtonHandlerc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText("0");
            numbers = "";
        }
    }

    // Positive numbers turn into negative numbers, negative numbers turn into
    // positive numbers
    class PositiveNegativeButtonHandlerc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.contains(".")) {
                if (Double.parseDouble(numbers) > 0) {
                    txf.setText(numbers = "-" + numbers);
                } else {
                    double negativeNumber = Double.parseDouble(numbers);
                    double positiveNumber = negativeNumber * -1;

                    numbers = Double.toString(positiveNumber);
                    txf.setText(numbers);
                }
            } else {
                if (Integer.parseInt(numbers) > 0) {
                    txf.setText(numbers = "-" + numbers);
                } else {
                    int negativeNumber = Integer.parseInt(numbers);
                    int positiveNumber = negativeNumber * -1;

                    numbers = Integer.toString(positiveNumber);
                    txf.setText(numbers);
                }
            }
        }
    }

    // Calculator backspaces a number
    class BackSpaceButtonHandlerc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.length() == 1) {
                numbers = "";
                txf.setText("0");
            } else if (numbers.length() == 0) {
                numbers = "";
                txf.setText("0");
            } else {
                numbers = numbers.substring(0, numbers.length() - 1);
                txf.setText(numbers);
            }
        }
    }

    // Adds and displays a decimal
    class DecimalButtonHandlerc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (!numbers.contains(".")) {
                if (numbers.equals("")) {
                    numbers = numbers + "0.";
                    txf.setText(numbers);
                } else {
                    numbers = numbers + ".";
                    txf.setText(numbers);
                }
            }
        }
    }

    // Adds and displays zero
    class ButtonDisplayZeroc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (numbers.equals("")) {
                txf.setText("0");
            } else {
                txf.setText(numbers = numbers + "0");
            }
        }
    }

    // Adds and displays one
    class ButtonDisplayOnec2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "1");
        }
    }

    // Adds and displays two
    class ButtonDisplayTwoc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "2");
        }
    }

    // Adds and displays three
    class ButtonDisplayThreec2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "3");
        }
    }

    // Adds and displays four
    class ButtonDisplayFourc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "4");
        }
    }

    // Adds and displays five
    class ButtonDisplayFivec2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "5");
        }
    }

    // Adds and displays six
    class ButtonDisplaySixc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "6");
        }
    }

    // Adds and displays seven
    class ButtonDisplaySevenc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "7");
        }
    }

    // Adds and displays eight
    class ButtonDisplayEightc2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "8");
        }
    }

    // Adds and displays nine
    class ButtonDisplayNinec2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            txf.setText(numbers = numbers + "9");
        }
    }
}