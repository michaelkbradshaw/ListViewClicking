package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.ItemData;

public class ItemListCell extends ListCell<ItemData>
{

	ShowItemInterface showController;
	ListItemCellController itemController;
	Node node;
	
	
	public ItemListCell(ListView<ItemData> list,ShowItemInterface cont)
	{
		showController = cont;
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ItemListCell.class
	        .getResource("ItemCellView.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      itemController = loader.getController(); //store for later
	      itemController.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
		
		
		
		
		
		
	}


	@Override
	protected void updateItem(ItemData item, boolean empty)
	{
		if(!empty)
		{
			itemController.updateView(item);
		}
		else
		{
			itemController.updateView(null);
		}
		super.updateItem(item, empty);
	}

	
	public void showItem()
	{
		showController.showItem(getItem());
	}
	

	
}
