package fxCalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class fxroot extends Application{
	
	
	Label label1;
	Button addButton;
	Button multButton;
	Button divButton;
	Button subButton;
	Button logButton;
	Button ansButton;
	String realAns;
	boolean somethingCalculated = false;
	int i = 1;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("AdamKlein_GA3");
		stage.show();

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));

		Scene scene = new Scene(grid, 600, 600);
		stage.setScene(scene);

		Text scenetitle = new Text("Adam Klein's\n Amazing\n JavaFX Calculator");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 1, 1);

		Label num1Label = new Label("X value: ");
		grid.add(num1Label, 0, 1);

		TextField num1txt = new TextField();
		grid.add(num1txt , 0, 2);

		Label num2Label = new Label("Y value: ");
		grid.add(num2Label, 3, 1);

		TextField num2txt = new TextField();
		grid.add(num2txt , 3, 2);

		Text ans = new Text();
		grid.add(ans, 3, 3);

		Text errText = new Text("");
		errText.setFill(Color.FIREBRICK);
		grid.add(errText,4,0);



		addButton = new Button("+");
		addButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(num2txt.getText().equals("")){
					errText.setText("input a second number!");
					return;
				}
				if(num1txt.getText().equals("")){
					errText.setText("input a first number!");
					return;
				}
				realAns = Double.toString(Double.parseDouble(num2txt.getText())
						+ Double.parseDouble(num1txt.getText()));
				ans.setText("X + Y = " +
						(Double.parseDouble(num2txt.getText())
								+ Double.parseDouble(num1txt.getText()))
				);
				errText.setText("");
				somethingCalculated = true;

			}
		});
		multButton = new Button("*");
		multButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(num2txt.getText().equals("")){
					errText.setText("input a second number!");
					return;
				}
				if(num1txt.getText().equals("")){
					errText.setText("input a first number!");
					return;
				}
				realAns = Double.toString(Double.parseDouble(num2txt.getText())
						* Double.parseDouble(num1txt.getText()));
				ans.setText("X * Y = " +
						(Double.parseDouble(num2txt.getText())
								* Double.parseDouble(num1txt.getText()))
				);
				errText.setText("");
				somethingCalculated = true;

			}
		});
		divButton = new Button("/");
		divButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(num2txt.getText().equals("") ){
					errText.setText("input a second number!");
					return;
				}
				if(Double.parseDouble(num2txt.getText()) == 0){
					errText.setText("Can't divide by zero!");
					return;
				}
				if(num1txt.getText().equals("")){
					errText.setText("input a first number!");
					return;
				}
				realAns = Double.toString(Double.parseDouble(num2txt.getText())
						/ Double.parseDouble(num1txt.getText()));

				ans.setText("X / Y = " +
						(Double.parseDouble(num1txt.getText())
								/ Double.parseDouble(num2txt.getText()))
				);
				errText.setText("");
				somethingCalculated = true;


			}
		});
		subButton = new Button("-");
		subButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(num2txt.getText().equals("")){
					errText.setText("input a second number!");
					return;
				}
				if(num1txt.getText().equals("")){
					errText.setText("input a first number!");
					return;
				}
				realAns = Double.toString(Double.parseDouble(num2txt.getText())
						- Double.parseDouble(num1txt.getText()));
				ans.setText("X - Y = " +
						(Double.parseDouble(num1txt.getText())
								- Double.parseDouble(num2txt.getText()))
				);
				errText.setText("");
				somethingCalculated = true;

			}
		});

		ansButton = new Button("X <- Result");
		ansButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(!somethingCalculated){
					errText.setText("You have to calculate\nsomething before you can\nretrieve the answer!");
				}
				else{
					num1txt.setText(realAns);
				}



			}
		});
		logButton = new Button("log base x of y");
		logButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				if(num2txt.getText().equals("")){
					errText.setText("input a second number!");
					return;
				}
				if(num1txt.getText().equals("")){
					errText.setText("input a first number!");
					return;
				}
				if(Double.parseDouble(num2txt.getText()) <= 0){
					errText.setText("y must be greater than 0");
					return;
				}
				if(Double.parseDouble(num1txt.getText()) <= 1){
					errText.setText("x must be greater than 1");
					return;
				}
				realAns = Double.toString(
						logFunc(Double.parseDouble(num1txt.getText()),
								Double.parseDouble(num2txt.getText())));
				ans.setText("log base x of y = " +
						logFunc(Double.parseDouble(num1txt.getText()),
								 Double.parseDouble(num2txt.getText())));
				errText.setText("");
				somethingCalculated = true;

			}
		});
		grid.add(addButton, 2, 0);
		grid.add(multButton, 2, 1);
		grid.add(divButton, 2, 2);
		grid.add(subButton, 2, 3);
		grid.add(logButton, 2, 4);
		grid.add(ansButton, 0, 3);

		stage.show();
	}
	private Double logFunc(double base, double val){
		return Math.log(val) / Math.log(base);
	}

}


