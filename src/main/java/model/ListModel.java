package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListModel
{
	ObservableList<ItemData> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListModel()
	{}
	
	
	
	public void addItem(ItemData item)
	{
		items.add(item);
	}


	
	
	
	/**
	 * @return the items
	 */
	public ObservableList<ItemData> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<ItemData> items)
	{
		this.items = items;
	}
	

	
	

	
}
