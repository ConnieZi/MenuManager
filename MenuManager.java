

import java.util.ArrayList;
import java.util.Random;



/**
 * Class MenuManager
 * @author:Kangying Zi
 * created:11/12/2020
 */

public class MenuManager {
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Drink> drinks;
	private ArrayList<Dessert> desserts;
	
	/**
	 * Constructor
	 * @param dishFile a String
	 */
	
	public MenuManager(String dishFile) {
		
		entrees= new ArrayList<Entree>();
		sides = new ArrayList<Side>();
		drinks= new ArrayList<Drink>() ;
		desserts=new ArrayList<Dessert>();
		
		ArrayList<MenuItem> menuItems= FileManager.readItems(dishFile);  
		            //Actually the file here can be dishes.txt. And now menuItems is an arrayList with all kinds of dishes in it.
		            //Now I have to separate them into the arrayList they should belong to (entrees,sides and so on)
		for(int i=0;i<menuItems.size();i++) {
			if(menuItems.get(i) instanceof Entree) {
				entrees.add((Entree) menuItems.get(i));
			}
			if(menuItems.get(i) instanceof Side) {
				sides.add((Side) menuItems.get(i));
			}
			if(menuItems.get(i) instanceof Drink) {
				drinks.add((Drink) menuItems.get(i));
			}
			if(menuItems.get(i) instanceof Dessert) {
				desserts.add((Dessert) menuItems.get(i));
			}
		}
	}

	/**
	 * Method randomMenu
	 * @param name a String
	 * @return a Menu object
	 */
	
	public Menu randomMenu(String name) {
		
		Menu menu=new Menu(name);
		
		Random randomElement1=new Random();
		Random randomElement2=new Random();
		Random randomElement3=new Random();
		Random randomElement4=new Random();
		
		int rand1=randomElement1.nextInt(entrees.size()); //get a random integer
		menu.setEntree(entrees.get(rand1));//use this integer as an index
		
		int rand2=randomElement2.nextInt(sides.size());
		menu.setSide(sides.get(rand2));
		
		int rand3=randomElement3.nextInt(drinks.size());
		menu.setDrink(drinks.get(rand3));
		
		int rand4=randomElement4.nextInt(desserts.size());
		menu.setDessert(desserts.get(rand4));
		
		return menu;
	}
	
	/**
	 * Method minCaloriesMenu
	 * @param name a String
	 * @return a Menu object
	 */
	
	public Menu minCaloriesMenu (String name) {   //Find the dish with lowest calories respectively, create a menu, name the menu
		                                         //and add these menuItems into the menu
		
		Menu minCalMenu = new Menu(name);
		
		
	//iterate the entrees arrayList
		int minCal1=entrees.get(0).getCalories();
		int minIndex1=0;
		for(int i=0;i<entrees.size()-1;i++) {
			if(entrees.get(i+1).getCalories()<minCal1) {
				minCal1=entrees.get(i+1).getCalories();
				minIndex1=i+1;
			}
		}
		minCalMenu.setEntree(entrees.get(minIndex1));
		
		
	//For the side
		int minCal2=sides.get(0).getCalories();
		int minIndex2=0;
		for(int i=0;i<sides.size()-1;i++) {
			if(sides.get(i+1).getCalories()<minCal2) {
				minCal2=sides.get(i+1).getCalories();
				minIndex2=i+1;
			}
		}
		minCalMenu.setSide(sides.get(minIndex2));
		
	//For the drink
		int minCal3=drinks.get(0).getCalories();
		int minIndex3=0;
		for(int i=0;i<drinks.size()-1;i++) {
			if(drinks.get(i+1).getCalories()<minCal3) {
				minCal3=drinks.get(i+1).getCalories();
				minIndex3=i+1;
			}
		}
		minCalMenu.setDrink(drinks.get(minIndex3));
		
	//For the dessert
		int minCal4=desserts.get(0).getCalories();
		int minIndex4=0;
		for(int i=0;i<desserts.size()-1;i++) {
			if(desserts.get(i+1).getCalories()<minCal4) {
				minCal2=desserts.get(i+1).getCalories();
				minIndex4=i+1;
			}
		}
		minCalMenu.setDessert(desserts.get(minIndex4));
		
		return minCalMenu;
	}
	
	
	/**
	 * Method maxProteinMenu
	 * @param name
	 * @return a Menu object
	 */
	
	public Menu maxProteinMenu(String name) {
		
		Menu maxProMenu = new Menu(name);

	//
		int maxPro1=entrees.get(0).getProtein();
		int maxIndex1=0;
		for(int i=0;i<entrees.size()-1;i++) {
			if(entrees.get(i+1).getProtein()>maxPro1) {
				maxPro1=entrees.get(i+1).getProtein();
				maxIndex1=i+1;
			}
		}
		maxProMenu.setEntree(entrees.get(maxIndex1));
		
	//
		int maxPro2=sides.get(0).getProtein();
		int maxIndex2=0;
		for(int i=0;i<sides.size()-1;i++) {
			if(sides.get(i+1).getProtein()>maxPro2) {
				maxPro2=sides.get(i+1).getProtein();
				maxIndex2=i+1;
			}
		}
		maxProMenu.setSide(sides.get(maxIndex2));
		
	//
		int maxPro3=drinks.get(0).getProtein();
		int maxIndex3=0;
		for(int i=0;i<drinks.size()-1;i++) {
			if(drinks.get(i+1).getProtein()>maxPro3) {
				maxPro3=drinks.get(i+1).getProtein();
				maxIndex3=i+1;
			}
		}
		maxProMenu.setDrink(drinks.get(maxIndex3));
		
	//
		int maxPro4=desserts.get(0).getProtein();
		int maxIndex4=0;
		for(int i=0;i<desserts.size()-1;i++) {
			if(desserts.get(i+1).getProtein()>maxPro4) {
				maxPro4=desserts.get(i+1).getProtein();
				maxIndex4=i+1;
			}
		}
		maxProMenu.setDessert(desserts.get(maxIndex4));
		
		return maxProMenu;
	}
	
	
	//Getters and Setters
	public ArrayList<Entree> getEntrees() {
		return entrees;
	}


	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}


	public ArrayList<Side> getSides() {
		return sides;
	}


	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}


	public ArrayList<Drink> getDrinks() {
		return drinks;
	}


	public void setDrinks(ArrayList<Drink> drinks) {
		this.drinks = drinks;
	}


	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}


	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

}
