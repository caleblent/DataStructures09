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
//import thePackage.Apparel;
//import thePackage.AddPantsPanel;
// added:
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * COS212 Project 9 Template
 * 
 * Some elements are already written for you.
 * 
 * Some elements we will write together, 
 * including AddApparelPanel and AddPantsPanel classes 
 * (see code-along videos)
 * 
 * You will need to write the AddShirtPanel class as homework.
 * 
 * @author Gossett, revised
 * @version 21.4.c
 *
 */

public class Wardrobe extends Application {

	/** Store the list of clothes in the wardrobe */
	private ArrayList<Apparel> myClothes;
	
	/** A place to print the list of apparel */
	private TextArea apparelList;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 625, 500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("My Wardrobe GUI");

			// create GUI elements and place on screen
			apparelList = new TextArea();
			apparelList.setPrefSize(625,325);
			apparelList.setWrapText(true);
			apparelList.setEditable(false);
			
			ScrollPane listP = new ScrollPane(apparelList);
			root.setTop(listP);
			
			// my clothes closet -- for holding the clothing
			myClothes = new ArrayList<Apparel>();
			populate();		// put some clothes in the closet
			
			// add the bottom half
			
			// was: (just generic apparel, single panel)
			// AddApparelPanel addApparelP = new AddApparelPanel();
			// root.setBottom(addApparelP);
			
			// create a tab pane to hold multiple panes, one per tab
	        TabPane addPane = new TabPane();
	        root.setBottom(addPane);	// add it to the BorderPane

	        // create a panel for adding pants
	        AddPantsPanel aPantsPanel = new AddPantsPanel(this);
	        aPantsPanel.setPrefSize(625, 175);
	        // add it as one of the tabs
	        addPane.getTabs().add(new Tab("Add Pants", aPantsPanel));
	        
	        // TODO: add a tab for a ShirtPanel
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} // start
    
    /**
     * Update the text area with the current apparel
     */
    private void redoList(){
        apparelList.setText(this.toString());
    }

    /** 
     * Add the provided piece of clothing to the list
     * @param item
     */
    protected void addApparel(Apparel item){
        myClothes.add(item);
        Collections.sort(myClothes);
        redoList();
    }

	/**
	 * A method to hard-code some example clothes
	 */
	private void populate(){
		addApparel(new Shirt("red", 12.99, Apparel.Condition.GOOD, Shirt.Size.L, "I\'m with the band"));
		addApparel(new Shirt("white", 9.99, Apparel.Condition.POOR, Shirt.Size.M, null));
		addApparel(new Pants("blue", 29.99, Apparel.Condition.NEW, 30, 32));
	}
	
	/**
	 * Override the default toString to print a list of the clothes
	 * in the wardrobe
	 */
	public String toString(){
		String myString = "";
		for(Apparel a : myClothes){
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
