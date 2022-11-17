package thePackage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class AddShirtPanel extends AddApparelPanel {
	
	protected TextField sizeTF;
	protected TextField shirtTextTF;
	private Button addShirtB;
	
	public AddShirtPanel(Shirt shirt) {
		super(shirt);
		sizeTF = new TextField(shirt.getSizeString());
		shirtTextTF = new TextField(shirt.getShirtText());
		
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Shirt Size:"));
		temp.getChildren().add(sizeTF);
		getChildren().add(temp);
		
		temp = new FlowPane();
		temp.getChildren().add(new Label("Shirt Text:"));
		temp.getChildren().add(shirtTextTF);
		getChildren().add(temp);
		
		temp = new FlowPane();
		addShirtB = new Button("Shirt Button :)");
		temp.getChildren().add(addShirtB);
		getChildren().add(temp);
	}
}
