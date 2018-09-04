package dependency;

import java.util.HashMap;
/**
 * Maintains a map of items <String itemName, Item item>
 * UML : itemMap attributes :  size, name
 *     : itemMap methods : set, get, add, remove
 * 
 * I renamed my class to Map as I am using HashMap 
 * Design is the same - just renamed it
 * @author jaiminipatel
 *
 */
public class ItemMap {

	private static HashMap<String, Item> itemMap = null;

	public ItemMap() {
		this.setItemMap(new HashMap<String, Item>());
	}

	/**
	 * check if item already exists in a map 
	 * @param item
	 * @return
	 */
	public Boolean checkItemExisits(Item item) {
		if (getItemMap().containsKey(item.getName())) {
			return true;
		} 
		return false;
	}	
	/**
	 *  check if Map contains String Name
	 * @param itemName
	 * @return
	 */
	public Boolean checkItemExisits(String itemName) {
		if (getItemMap().containsKey(itemName)) {
			return true;
		} 
		return false;
	}

	/**
	 * adds an item to the HashMap
	 * @param item
	 */
	public void addToMap(Item item) {
		if (checkItemExisits(item) == false) {
			item = new Item(item.getName(), true);
			getItemMap().put(item.getName(), item);
		} else {
			System.out.println("Item already exists");
		}
	}
	
	/**
	 *  remove an item
	 * @param item
	 */
	public void removeItemFromMap(Item item) {
		if (checkItemExisits(item) == true) {
			if (item.getDependencyList() == null) {
				item.setInstalled(false);
				System.out.println("Removing item, no dependency");
			} else {
				System.out.println("Cannot be removed, dependencies :" + item.getDependencyList());
			}
		}
	}

	/**
	 * remove item using itemName
	 * @param itemName
	 */
	public void removeItemFromMapUsingStringName(String itemName) {
		if (getItemMap().containsKey(itemName)) {
			Item item = getItemMap().get((itemName));
			if (item.getDependencyList() == null) {
				System.out.println("Removing item, no dependency");
			} else {
				System.out.println("Cannot be removed, dependencies :" + item.getDependencyList());
			}
		}
	}
	/**
	 * Prints the entire Map 
	 */
	public void printAllItemsInMap() {
		for (String item : getItemMap().keySet()){
	        //iterate over keys
	        System.out.println("this is the map  "+ item+" "+ getItemMap().get(item));
	    }
	}
	
	/**
	 * returns items on a hashMap
	 * @param string
	 * @return
	 */
	public Item getItem(String itemName) {
		return getItemMap().get(itemName);		
	}

	public static HashMap<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(HashMap<String, Item> itemMap) {
		ItemMap.itemMap = itemMap;
	}

	

}
