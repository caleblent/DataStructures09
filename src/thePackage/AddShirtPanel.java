package thePackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class AddShirtPanel extends AddApparelPanel implements EventHandler<ActionEvent> {
	
	protected TextField sizeTF;       // GUI element
	protected TextField shirtTextTF;  // GUI element
	private Button addShirtB;         // GUI element
	
	private Wardrobe wdrb;            // whom to tell that we're adding stuff
	
	public AddShirtPanel(Wardrobe w) {
		super();
		this.wdrb = w;
		
		sizeTF = new TextField();
		sizeTF.setPrefColumnCount(2);
		
		shirtTextTF = new TextField();
		shirtTextTF.setPrefColumnCount(20);
		
		addShirtB = new Button("Add Shirt");
		addShirtB.setOnAction(this);
		
		// put these items into a pane
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Shirt Size:"));
		temp.getChildren().add(sizeTF);
		temp.getChildren().add(new Label("Shirt Text:"));
		temp.getChildren().add(shirtTextTF);
		
		// now add the pane into the superclass
		getChildren().add(temp);
		getChildren().add(addShirtB);
	}
	
	/**
	 * clear - clear out text fields - though maybe it would be better to leave some
	 * values in place for easier entry of the next item.
	 */
	@Override
	protected void clear() {
		super.clear(); // clear out the parent's fields ("Apparel"), too
		sizeTF.setText("");
		shirtTextTF.setText("");
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == addShirtB) {
			try {
				Shirt a = new Shirt(
					colorTF.getText(),                        // color
					Double.parseDouble(priceTF.getText()),    // price
					conditionCB.getValue(),                   // condition
					sizeTF.getText(),                         // size
					shirtTextTF.getText()                     // shirt text
				);
				wdrb.addApparel(a);
				clear();
			} catch (NumberFormatException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Not a number");
				alert.setContentText("An expected number was: " + ex.getMessage());
				alert.showAndWait();
			} catch (IllegalArgumentException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Illegal Value");
				alert.setContentText(ex.getMessage());
				alert.showAndWait();
			}

		} // addShirtB button was pressed

	} // handle
	
} // class AddShirtPanel
