package listViewClick;


import org.testfx.assertions.api.Assertions;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.ItemData;
import model.ListModel;

import view.ClickExampleController;

@ExtendWith(ApplicationExtension.class)
class TestListViewClick
{

	@Start  //Before
	  private void start(Stage stage)
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
	
	
	final String bobData = "Bob Data";
	final String aliceData = "Alice Data";
	final String cobraData = "CobraData";
	final String dougData = "Doug Data";
	
	
	private void initModel(ListModel model)
	{
		model.addItem(new ItemData("Bob",bobData));
		model.addItem(new ItemData("Alice",aliceData));
		model.addItem(new ItemData("Cobra",cobraData));
		model.addItem(new ItemData("Doug",dougData));
	}

	
	private void selectItem(FxRobot robot, int index)
	  {
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Platform.runLater(()->{
			  ListView<ItemData> items = getItems(robot);
			  items.scrollTo(index);
			  items.getSelectionModel().clearAndSelect(index);
			 // items.getSelectionModel().
		  });
		  WaitForAsyncUtils.waitForFxEvents();
	}
	
	@SuppressWarnings("unchecked")
	  ListView<ItemData> getItems(FxRobot robot)

	  {
	   return (ListView<ItemData>) robot.lookup("#listview")
	       .queryAll().iterator().next();
	  }
	
	private void checkTextValue(FxRobot robot,String text)
	{
		 Assertions.assertThat(robot.lookup("#desc")
			        .queryAs(TextArea.class)).hasText(text);   
	}
	
	
	
	@Test
	void doTheClickclickOnItem(FxRobot robot)
	{
		selectItem(robot,1);
		checkTextValue(robot,aliceData);
		selectItem(robot,0);
		checkTextValue(robot,bobData);
		selectItem(robot,3);
		checkTextValue(robot,dougData);
		selectItem(robot,2);
		checkTextValue(robot,cobraData);
	}

}
