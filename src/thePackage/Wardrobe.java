package thePackage;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * COS212 Project 9 Template
 * 
 * Some elements are already written for you.
 * 
 * Some elements we will write together, including AddApparelPanel and
 * AddPantsPanel classes (see code-along videos)
 * 
 * You will need to write the AddShirtPanel class as homework.
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 */

public class Wardrobe extends Application {
	/** Store the list of clothes in the wardrobe */
	private ArrayList<Apparel> myClothes;

	/** A place to print the list of games */
	private TextArea apparelList;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 625, 500);
			primaryStage.setScene(scene);

			// create GUI elements and place on screen

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * A method to hard-code some example clothes
	 */
	private void populate() {
		// TODO once we write the addApparel() method, uncomment these
//		addApparel(new Shirt("red", 12.99, Apparel.Condition.GOOD, Shirt.Size.L, "I\'m with the band"));
//		addApparel(new Shirt("white", 9.99, Apparel.Condition.POOR, Shirt.Size.M, null));
//		addApparel(new Pants("blue", 29.99, Apparel.Condition.NEW, 30, 32));
	}

	/**
	 * Override the default toString to print a list of the clothes in the wardrobe
	 */
	public String toString() {
		String myString = "";
		for (Apparel a : myClothes) {
			myString += a + "\n\n";
		}
		return myString;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
