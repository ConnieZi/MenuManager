//package kaz83_FinalProject_CMPINF0401;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Class FileManager
 * @author:Kangying Zi
 * created:11/12/2020
 */


public class FileManager {
	
	/**
	 * Method readItems
	 * @param fileName a String
	 * @return an ArrayList<MenuItem> object
	 */
	
	public static ArrayList<MenuItem> readItems(String fileName){
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr); 
			
			ArrayList<MenuItem> MenuItems= new ArrayList<MenuItem>();
			ArrayList<String> tempReader= new ArrayList<String>();
			
			String line=br.readLine();
			while(line!=null) {
				tempReader.add(line);  
				line=br.readLine();                     
				}
			for(String s:tempReader) {
				
				String[] str=s.split("@@"); 
				
				MenuItem menuItem = new MenuItem(str[0],str[2],Integer.parseInt(str[3]),Double.parseDouble(str[7]),
						Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6])); 
				
				if(str[1].equals("Entree")){
					menuItem = new Entree(str[0],str[2],Integer.parseInt(str[3]),Double.parseDouble(str[7]),
							Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]));
				}else if(str[1].equals("Side")){
					menuItem = new Side(str[0],str[2],Integer.parseInt(str[3]),Double.parseDouble(str[7]),
							Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]));
				}else if(str[1].equals("Drink")){
					menuItem = new Drink(str[0],str[2],Integer.parseInt(str[3]),Double.parseDouble(str[7]),
							Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]));
				}else if(str[1].equals("Dessert")){
					menuItem = new Dessert(str[0],str[2],Integer.parseInt(str[3]),Double.parseDouble(str[7]),
							Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]));
				}

				MenuItems.add(menuItem); //assign the entree to an element of arrayList Entrees
				
			}
			fr.close();
			br.close();
			
			return MenuItems;
		}catch(IOException|NullPointerException e) {
			System.out.println(e.fillInStackTrace());
			return null ;
		}
	}

	/**
	 * Method writeMenus
	 * @param fileName an String
	 * @param menus an Menu type arrayList
	 */
	
	public static void writeMenus(String fileName, ArrayList<Menu> menus ) { //menus contains multiple different Menu objects
		try {
			
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0;i<menus.size();i++) {
				Menu temp = menus.get(i);
				
				//All the things needed in a menu
				bw.write(temp.toString());   //get the name of the MENU!
				
				bw.write("\nEntree:"+temp.getEntree().getName()+". "+"Description:"+temp.getEntree().getDescription()+"; "
				          +"Calories:"+temp.getEntree().getCalories()+"; "+"Fat:"+temp.getEntree().getFat()+"; "
				          +"Sodium:"+temp.getEntree().getSodium()+"; "+"Protein:"+temp.getEntree().getProtein()+"; "
				          +"Price:"+temp.getEntree().getPrice());   
				bw.write("\nSide:"+temp.getSide().getName()+". "+"Description:"+temp.getSide().getDescription()+"; "
				          +"Calories:"+temp.getSide().getCalories()+"; "+"Fat:"+temp.getSide().getFat()+"; "
				          +"Sodium:"+temp.getSide().getSodium()+"; "+"Protein:"+temp.getSide().getProtein()+"; "
				          +"Price:"+temp.getSide().getPrice());
				bw.write("\nDrink:"+temp.getDrink().getName()+". "+"Description:"+temp.getDrink().getDescription()+"; "
				          +"Calories:"+temp.getDrink().getCalories()+"; "+"Fat:"+temp.getDrink().getFat()+"; "
				          +"Sodium:"+temp.getDrink().getSodium()+"; "+"Protein:"+temp.getDrink().getProtein()+"; "
				          +"Price:"+temp.getDrink().getPrice());
				bw.write("\nDessert:"+temp.getDessert().getName()+". "+"Description:"+temp.getDessert().getDescription()+"; "
				          +"Calories:"+temp.getDessert().getCalories()+"; "+"Fat:"+temp.getDessert().getFat()+"; "
				          +"Sodium:"+temp.getDessert().getSodium()+"; "+"Protein:"+temp.getDessert().getProtein()+"; "
				          +"Price:"+temp.getDessert().getPrice());
				
				bw.write("\n\nTotal calories:"+temp.totalCalories());
				bw.write("\nTotal price:"+temp.totalPrice());
				bw.write("\nTotal fat:"+temp.totalFat());
				bw.write("\nTotal sodium:"+temp.totalSodium());
				bw.write("\nTotal protein:"+temp.totalProtein()+"\n\n");
			}
			bw.close();
			fw.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
