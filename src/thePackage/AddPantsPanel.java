package thePackage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
public class AddPantsPanel extends AddApparelPanel {

	protected TextField waistTF;
	protected TextField inseamTF;
	private Button addPantsB;
	
	public AddPantsPanel(Pants pants) {
		super(pants);
		waistTF = new TextField(Integer.toString(pants.getWaist()));
		inseamTF = new TextField(Integer.toString(pants.getInseam()));
		
		FlowPane temp = new FlowPane();
		temp.getChildren().add(new Label("Waist Size:"));
		temp.getChildren().add(waistTF);
		getChildren().add(temp);
		
		temp = new FlowPane();
		temp.getChildren().add(new Label("Inseam Length:"));
		temp.getChildren().add(inseamTF);
		getChildren().add(temp);
		
		temp = new FlowPane();
		addPantsB = new Button("Pants Button!!!");
		temp.getChildren().add(addPantsB);
		getChildren().add(temp);
	}
}
