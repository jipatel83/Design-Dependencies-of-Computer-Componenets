package dependency;

import java.util.ArrayList;

/**
 * /**
 * 
 * @autor : Jaimini
 * UML Diagram : attributes : a name, boolean flag, arraylist of dependencies
 *               Methods : to modify these properties.
 */

public class Item {

	private String name;
	private Boolean installed = false;
	private ArrayList<Item> dependencyList = null;

	/**
	 * create an item with no dependency
	 * 
	 * @param name
	 * @param flag
	 */
	public Item(String name, Boolean flag) {
		this.setName(name);
		this.setInstalled(true);
		setDependencyList(null);
	}

	/**
	 * add a dependency list to an item
	 * 
	 * @param item1
	 * @param item2
	 */
	public void createDependency(Item item1, Item item2) {
		ArrayList<Item> newDependencyList = new ArrayList<Item>();
		newDependencyList.add(item2);
		item1.setDependencyList(newDependencyList);
		// System.out.println("DEPEND "+ item1.name.toString() + " "+
		// item2.name.toString());
	}

	/**
	 * removes dependent items from an array list
	 * 
	 * @param item
	 */
	public void removeDependencyItem(Item item) {
		if (item.getDependencyList().contains(item)) {
			getDependencyList().remove(item);
			System.out.println(item.getName() + " removed ");
		} else {
			System.out.println("This item is not in the dependency list");
		}
	}

	/**
	 * print a list of dependencies
	 */
	public void printDependencyList() {
		for (int i = 0; i < getDependencyList().size(); i++) {
			System.out.println("Dependency list " + getDependencyList().get(i));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getDependencyList() {
		return dependencyList;
	}

	public void setDependencyList(ArrayList<Item> dependencyList) {
		this.dependencyList = dependencyList;
	}

	public Boolean getInstalled() {
		return installed;
	}

	public void setInstalled(Boolean installed) {
		this.installed = installed;
	}

}
