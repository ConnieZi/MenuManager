

/**
 * Class Menu
 * @author:Kangying Zi
 * created:9/27/2020
 */

public class Menu {
	private String name;
	private Entree entree;
	private Side side;
	private Drink drink;
	private Dessert dessert;

	/**
	 * Constructor
	 * @param name The name of the menu
	 */

	public Menu(String name) {
		this.name=name;
		entree=null;
		side=null;
		drink=null;
		dessert=null;
	}

	/**
	 * Constructor
	 * @param name The name of the menu
	 * @param entree The entree of the menu
	 * @param side The side of the menu
	 */

	public Menu(String name,Entree entree,Side side) {
		this.name=name;
		this.entree=entree;
		this.side=side;
		drink=null;
		dessert=null;
	}

	/**
	 * Constructor
	 * @param name The name of the menu
	 * @param entree The entree of the menu
	 * @param side The side of the menu
	 * @param drink The drink of the menu
	 */

	public Menu(String name,Entree entree,Side side, Drink drink) {
		this.name=name;
		this.entree=entree;
		this.side=side;
		this.drink=drink;
		dessert=null;
	}

	/**
	 * Constructor
	 * @param name The name of the menu
	 * @param entree The entree of the menu
	 * @param side The side of the menu
	 * @param drink The drink of the menu
	 * @param dessert The dessert of the menu
	 */

	public Menu(String name,Entree entree,Side side, Drink drink,Dessert dessert) {
		this.name=name;
		this.entree=entree;
		this.side=side;
		this.drink=drink;
		this.dessert=dessert;
	}

	//Setters and Getters
	
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEntree(Entree entree){
		this.entree=entree;
	}
	public Entree getEntree() {
		return entree;
	}
	public void setSide(Side side) {
		this.side=side;
	}
	public Side getSide() {
		return side;
	}
	public void setDrink(Drink drink) {
		this.drink=drink;
	}
	public Drink getDrink() {
		return drink;
	}
	public void setDessert(Dessert dessert){
		this.dessert=dessert;
	}
	public Dessert getDessert() {
		return dessert;
	}


	//Extra methods
	public int totalCalories() {
		int a;
		int b;
		int c;
		int d;
		if(entree!=null)
			a=entree.getCalories();
		else
			a=0;
		if(side!=null)
			b=side.getCalories();
		else
			b=0;
		if(drink!=null)
			c=drink.getCalories();
		else
			c=0;
		if(dessert!=null)
			d=dessert.getCalories();
		else
			d=0;
		int sumCalories=a+b+c+d;
		return sumCalories;
	}

	public double totalPrice() {
		double a;
		double b;
		double c;
		double d;
		if(entree!=null)
			a=entree.getPrice();
		else
			a=0;
		if(side!=null)
			b=side.getPrice();
		else
			b=0;
		if(drink!=null)
			c=drink.getPrice();
		else
			c=0;
		if(dessert!=null)
			d=dessert.getPrice();
		else
			d=0;
		double sumPrice=a+b+c+d;
		return sumPrice;
	}
	
	public int totalFat() {
		int a;
		int b;
		int c;
		int d;
		if(entree!=null)
			a=entree.getFat();
		else
			a=0;
		if(side!=null)
			b=side.getFat();
		else
			b=0;
		if(drink!=null)
			c=drink.getFat();
		else
			c=0;
		if(dessert!=null)
			d=dessert.getFat();
		else
			d=0;
		int sumFat=a+b+c+d;
		return sumFat;
	}
	
	public int totalSodium() {
		int a;
		int b;
		int c;
		int d;
		if(entree!=null)
			a=entree.getSodium();
		else
			a=0;
		if(side!=null)
			b=side.getSodium();
		else
			b=0;
		if(drink!=null)
			c=drink.getSodium();
		else
			c=0;
		if(dessert!=null)
			d=dessert.getSodium();
		else
			d=0;
		int sumSodium=a+b+c+d;
		return sumSodium;
	}
	
	public int totalProtein() {
		int a;
		int b;
		int c;
		int d;
		if(entree!=null)
			a=entree.getProtein();
		else
			a=0;
		if(side!=null)
			b=side.getProtein();
		else
			b=0;
		if(drink!=null)
			c=drink.getProtein();
		else
			c=0;
		if(dessert!=null)
			d=dessert.getProtein();
		else
			d=0;
		int sumProtein=a+b+c+d;
		return sumProtein;
	}
	
	public String description() {
		
		String menuDescription = "";
		
		if(entree==null) {
			menuDescription += "Entree: " + "N/A" + "\n";
		}else {
			menuDescription += "Entree: " + entree.getName() + ". " + entree.getDescription() + "\n";
		}
		
		if(side==null) {
			menuDescription += "Side: " + "N/A" + "\n";
		}else {
			menuDescription += "Side: " + side.getName() + ". " + side.getDescription() + "\n";
		}
		
		if(drink==null) {
			menuDescription += "Drink: " + "N/A" + "\n";
		}else {
			menuDescription += "Drink: " + drink.getName() + ". " + drink.getDescription() + "\n";
		}
		
		if(dessert==null) {
			menuDescription += "Dessert: " + "N/A" + "\n\n";
		}else {
			menuDescription += "Dessert: " + dessert.getName() + ". " + dessert.getDescription() + "\n";
		}
		
		return menuDescription;
	}
	
	@Override
	public String toString() {
		return name;
	}


}

