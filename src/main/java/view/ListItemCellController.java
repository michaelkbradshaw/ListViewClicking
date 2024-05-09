package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.ItemData;

public class ListItemCellController implements ChangeListener<Boolean>
{

    @FXML
    private Label itemName;

    
    ItemListCell model;
    
    public void setModel(ItemListCell cell)
    {
    	if(model != null)
    	{
    		model.selectedProperty().removeListener(this);
    	}
    	model = cell;
    	if(model != null)
    	{
    		model.selectedProperty().addListener(this);
    	}
    	
    }
    
    public void updateView(ItemData item)
    {
    	if(item ==null)
    	{
    		itemName.setText("");
    	}
    	else
    	{
    		itemName.setText(item.getName());
    	}
    }
    
    
    @FXML
    void onItemClicked(MouseEvent event) 
    {
    	//model.showItem(); We don't need this anymore as the the selection is a more broad catagory
    }

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
	{
		if(newValue)
		{
			model.showItem();
		}
	}

}

