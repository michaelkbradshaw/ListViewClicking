package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import model.ItemData;
import model.ListModel;


public class ClickExampleController implements ShowItemInterface
{
    @FXML
    private TextArea itemDescription;

    @FXML
    private Label itemName;

    @FXML
    private ListView<ItemData> listview;
 
    
    ListModel model;

    
    //naming the interface so I can pass it in anonymous class below
    private final ShowItemInterface itemShower;
    
    
    public ClickExampleController()
    {
    	itemShower=this;
    }
    
    public void setModel(ListModel model)
    {
    	this.model = model;
    	
    	listview.setCellFactory(new Callback<ListView<ItemData>, ListCell<ItemData>>()
		  {

			@Override
			public ListCell<ItemData> call(ListView<ItemData> lv)
			{
				return new ItemListCell(lv,itemShower);
			}
		  });
    	
    	listview.setItems(model.getItems());
    	
    	
    	
    }
    
    
    @Override
	public void showItem(ItemData item)
    {
    	itemName.setText(item.getName());
    	itemDescription.setText(item.getDescription());
    }
    
    
    
    
}