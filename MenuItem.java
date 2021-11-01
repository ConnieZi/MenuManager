

/**
 * Class MenuItem
 * @author:Kangying Zi
 * created:11/12/2020
 */

public class MenuItem {
	private String name;    
	private String description;
	private int calories;
	private int fat;
	private int sodium;
	private int protein;
	private double price;
	
	public MenuItem(String name,String desc,int cal,double price,int fat,int sodium,int protein)
	{
		this.name=name;
		description=desc;
		calories=cal;
		this.fat=fat;
		this.sodium=sodium;
		this.protein=protein;
		this.price=price;
	}
	
//Getters and Setters
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String desc) {
		description=desc;
	}
	public String getDescription() {
		return description;
	}
	public void setCalories(int cal) {
		calories=cal;
	}
	public int getCalories() {
		return calories;
	}
	public void setFat(int fat) {
		this.fat=fat;
	}
	public int getFat(){
		return fat;
	}
	public void setSodium(int sodium) {
		this.sodium=sodium;
	}
	public int getSodium() {
		return sodium;
	}
	public void setProtein(int protein) {
		this.protein=protein;
	}
	public int getProtein() {
		return protein;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
