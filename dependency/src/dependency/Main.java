package dependency;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// read input from stdin
		Scanner scan = new Scanner(System.in);

		while (true) {
			String line = scan.nextLine();

			// System.out.println("this is a line " + line);
			// no action for empty input
			if (line == null || line.length() == 0) {
				continue;
			}
			// the END command to stop the program
			if ("END".equals(line)) {
				System.out.println("END");
				break;
			}

			// create a universal list of all elements
			ItemMap itemMap = new ItemMap();

			// scan the commands and the items
			if (line.startsWith("DEPEND")) {

				String[] itemNames = line.split(" ");
				Item[] items = new Item[itemNames.length - 1];

				// create and add items to the hash Maps
				for (int i = 1; i < itemNames.length; i++) {
					Item item = new Item(itemNames[i], true);
					itemMap.addToMap(item);
					items[i - 1] = item;
				}

				// create an add dependency list for each items // this can also be creatively
				// achieved by cyclic loop % mod
				int next = 1;
				String dependString = "DEPEND ";
				for (int i = 0; i <= items.length - 1; i++) {
					if (next == 4 || next == 2) {
						next = 0;
					}
					items[i].createDependency(items[i], items[next]);
					dependString = dependString + " " + items[i].getName();
					next++;
				}

				System.out.println(dependString);
				// itemMap.printAllItemsInMap();

			} else if (line.startsWith("REMOVE")) {
				String[] itemNames = line.split(" ");
				itemMap.removeItemFromMapUsingStringName(itemNames[1]);

			} else if (line.startsWith("INSTALL")) {
				String[] itemNames = line.split(" ");
				if (itemMap.checkItemExisits(itemNames[1].toString()) == false) {
					Item item = new Item(itemNames[1].toString(), true);
					itemMap.addToMap(item);
					System.out.println("Installing " + itemNames[1]);

				} else
					System.out.println(itemNames[1] + "Already exists");

			} else if (line.startsWith("LIST")) {
				itemMap.printAllItemsInMap();
			}
		}
	}
}
