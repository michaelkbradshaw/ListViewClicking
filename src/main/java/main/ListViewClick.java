package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ItemData;
import model.ListModel;
import view.ClickExampleController;

public class ListViewClick extends Application
{

	
	
	
	@Override
	public void start(Stage stage) throws Exception
	{
		ListModel model = new ListModel();
		initModel(model);
		Parent node=null;
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ClickExampleController.class
	        .getResource("./clickExample.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      ClickExampleController cont = loader.getController(); //store for later
	      cont.showItem(model.getItems().get(0));
	      cont.setModel(model);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
	    Scene s = new Scene(node);
	    stage.setScene(s);
	    stage.show();
		
		
	}
	
	
	private void initModel(ListModel model)
	{
		model.addItem(new ItemData("Bob","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at arcu accumsan, pulvinar risus in, iaculis neque. In pharetra, justo et convallis varius, purus ex rutrum ligula, nec gravida turpis mi id nunc. Aliquam eu enim eu sem ultrices tempor sollicitudin ac enim. Donec commodo cursus lectus. In tristique ornare ligula, quis tristique justo malesuada nec. In eu elit et massa lacinia volutpat nec eu sem. Etiam ut malesuada odio, ut congue mauris. Aliquam erat volutpat. Phasellus volutpat nisl non aliquet pellentesque. Pellentesque aliquet fermentum neque et vulputate. Donec sed arcu leo. Proin eu nunc iaculis, maximus justo et, efficitur metus. Proin sodales, enim quis commodo ultricies, nisi lorem ullamcorper ligula, ac tincidunt neque tortor vitae lorem."));
		model.addItem(new ItemData("Alice","Nulla at turpis cursus, lacinia lorem sed, interdum diam. Nulla placerat auctor elit, nec varius elit viverra ac. Aenean finibus risus sit amet diam fringilla iaculis et vel enim. Praesent et risus ac purus ullamcorper dictum. Vivamus eget purus id diam sollicitudin vestibulum eu in dui. Nullam rutrum augue nec tellus dapibus semper. Cras lacinia, mauris iaculis pharetra posuere, urna risus congue tortor, nec dignissim nisl justo a enim. Pellentesque lacinia ligula nec sodales eleifend. Donec egestas ut felis vulputate pellentesque. Vestibulum aliquam porttitor velit eu sollicitudin. Sed vestibulum sollicitudin nunc sit amet eleifend."));
		model.addItem(new ItemData("Cobra","Praesent vel tortor feugiat, sodales metus vel, efficitur tellus. Integer convallis tincidunt augue, nec luctus odio ultricies sed. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam vitae dui dapibus, fermentum mi id, consectetur arcu. Donec semper malesuada ipsum sed accumsan. Mauris blandit tortor pellentesque dolor ullamcorper consequat. Curabitur in efficitur sapien, vel aliquam quam. Praesent malesuada elit in imperdiet suscipit. Nunc nec elementum erat, in fermentum mi. Nam iaculis, elit blandit mattis vulputate, arcu dui lobortis lectus, id luctus tellus metus sed neque. Nulla pharetra ligula sit amet purus vehicula, a luctus turpis pretium. Phasellus quam felis, cursus ac ultricies non, feugiat eget mi."));
		model.addItem(new ItemData("Doug","Sed quis orci ante. Nullam dignissim diam mauris, eget condimentum dui porta et. Nunc ut venenatis nunc, eu ornare sem. Aenean suscipit vehicula dolor sit amet accumsan. Fusce sed commodo justo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc lacinia justo eu leo malesuada, vel tempus turpis molestie. Phasellus convallis pharetra neque, quis finibus velit semper vitae."));
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
