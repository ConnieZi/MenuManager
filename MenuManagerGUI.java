

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuManagerGUI {
	
	/* Global variables representing SWING controls for main and the child (popup) frame */
	private JFrame menuManagerFrame;    //first window
	private JFrame menuDetailFrame;     //second window
	private JList lstMenuList;          
	
	private ArrayList<Menu> menuList;
	MenuManager menu;
	
	//Add here all the other SWING gui elements as private elements
	
	private JLabel lblEntree;
	private JLabel lblSide;
	private JLabel lblDrink;
	private JLabel lblDessert;
	private JLabel lblName;
	private JLabel lblOr;
	
	private JComboBox<Object> cboEntreeOptions;
	private JComboBox<Object> cboSideOptions;
	private JComboBox<Object> cboDrinkOptions;
	private JComboBox<Object> cboDessertOptions;
	
	private JButton btnCreateMenu;
	private JButton btnRandomGenerate;
	
	private JTextField txtName;
	
	//Right half of the first window
	private JButton btnDetails;
	private JButton btnSaveToFile;
	private JButton btnAscending;
	private JButton btnDescending;
	
	private JLabel lblSort;
	private JLabel lblBy;
	private JLabel lblCreatedMenus;
	private JComboBox<Object> cboAttributesOptions;
	
	//FOR CHILD WINDOW
	private JLabel lblEntree1;
	private JLabel lblSide1;
	private JLabel lblDrink1;
	private JLabel lblDessert1;
	
	private JLabel lblCalories;
	private JLabel lblFat;
	private JLabel lblProtein;
	private JLabel lblPrice;
	private JLabel lblSodium;
	
	private JTextArea txtEntree;
	private JTextArea txtSide;
	private JTextArea txtDrink;
	private JTextArea txtDessert;
	
	private JTextField txtCalories;
	private JTextField txtFat;
	private JTextField txtProtein;
	private JTextField txtPrice;
	private JTextField txtSodium;
	
	int selectedIndex1;
	int selectedIndex2;
	int selectedIndex3;
	int selectedIndex4;
	
	ArrayList<Entree> entrees;
	ArrayList<Side> sides;
	ArrayList<Drink> drinks;
	ArrayList<Dessert> desserts;
	
	Menu selectedMenu;
	
	String[] attributeName;
	
	String sortAttribute;
	
	//getter and setter of menuList
	public ArrayList<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Menu> menuList) {
		this.menuList = menuList;
	}
	
	/**
	 * Constructor
	 */
	public MenuManagerGUI() {
		
		//Initialize here MenuManager object here
		menu=new MenuManager("data/dishes.txt");
		
		//Initialize all the graphical components and set their behavior
		
		entrees=menu.getEntrees();
		sides=menu.getSides();
		drinks=menu.getDrinks();
		desserts=menu.getDesserts();
		
		String[] entreeNames = new String[entrees.size()];
		int i=0;
		for(Entree s:entrees) {
			entreeNames[i]=s.getName();
			i++;
		}
		
		String[] sideNames = new String[sides.size()];
		int j=0;
		for(Side s:sides) {
			sideNames[j]=s.getName();
			j++;
		}
		
		String[] drinkNames = new String[drinks.size()];
		int k=0;
		for(Drink s:drinks) {
			drinkNames[k]=s.getName();
			k++;
		}
		
		String[] dessertNames = new String[desserts.size()];
		int t=0;
		for(Dessert s:desserts) {
			dessertNames[t]=s.getName();
			t++;
		}
		
		
	//Initialize and place all graphic components, and load the arrayLists
		//Entrees
		lblEntree=new JLabel("Entree");
		lblEntree.setBounds(15,30,150,25);
		lblEntree.setFont(new Font("Arial", 1, 16));
		
		cboEntreeOptions = new JComboBox<Object>(entreeNames);
		cboEntreeOptions.setBounds(75,30,190,25);
		cboEntreeOptions.setSelectedIndex(0);
		
		//Sides
		lblSide=new JLabel("Side");
		lblSide.setBounds(15,70,150,25);
		lblSide.setFont(new Font("Arial", 1, 16));
		
		cboSideOptions = new JComboBox<Object>(sideNames);
		cboSideOptions.setBounds(75,70,190,25);
		cboSideOptions.setSelectedIndex(0);
		
		//Drinks
		lblDrink=new JLabel("Drink");
		lblDrink.setBounds(15,110,150,25);
		lblDrink.setFont(new Font("Arial", 1, 16));
		
		cboDrinkOptions = new JComboBox<Object>(drinkNames);
		cboDrinkOptions.setBounds(75,110,190,25);
		cboDrinkOptions.setSelectedIndex(0);
		
		
		//Desserts
		lblDessert=new JLabel("Dessert");
		lblDessert.setBounds(15,150,150,25);
		lblDessert.setFont(new Font("Arial", 1, 16));
		
		cboDessertOptions = new JComboBox<Object>(dessertNames);
		cboDessertOptions.setBounds(75,150,190,25);
		cboDessertOptions.setSelectedIndex(0);
		
		//Name
		lblName=new JLabel("Name");
		lblName.setBounds(15,190,150,25);
		lblName.setFont(new Font("Arial", 1, 16));
		
		txtName=new JTextField();
		txtName.setBounds(75,190,150,25);
		
		//Lower part
		btnCreateMenu=new JButton("Create Menu with these Dishes");
		btnCreateMenu.setBounds(50,235,220,30);
		
		lblOr=new JLabel("Or");
		lblOr.setBounds(145,270,150,25);
		
		//Right half
		//Menu List
		lblCreatedMenus=new JLabel("Created Menus");
		lblCreatedMenus.setBounds(370,25,150,25);
		lblCreatedMenus.setFont(new Font("Arial", 1, 16));
		lblCreatedMenus.setForeground(Color.BLUE);
		
		btnRandomGenerate=new JButton("Generate Random Menu");
		btnRandomGenerate.setBounds(50,300,220,30);
		
		btnDetails=new JButton("Details");
		btnDetails.setBounds(300,280,120,25);
		
		btnSaveToFile=new JButton("Save To File");
		btnSaveToFile.setBounds(430,280,120,25);
		
		lblSort=new JLabel("Sort menu list");
		lblSort.setBounds(300,310,150,25);
		
		lblBy=new JLabel("By");
		lblBy.setBounds(310,335,150,25);
		
		attributeName=new String[] {"Calories","Fat","Sodium","Protein","Price"};
		cboAttributesOptions=new JComboBox<Object>(attributeName);
		cboAttributesOptions.setSelectedIndex(0);
		cboAttributesOptions.setBounds(330,335,90,25);
		
		btnAscending=new JButton("Ascending");
		btnAscending.setBounds(440,335,120,25);
		
		btnDescending=new JButton("Descending");
		btnDescending.setBounds(440,370,120,25);
		
		//initialize and place the components of child window below
		lblEntree1=new JLabel("Entree");
		lblEntree1.setBounds(15,30,150,25);
		lblEntree1.setFont(new Font("Arial", 1, 16));
		
		txtEntree=new JTextArea();
		txtEntree.setBounds(80,30, 470, 51);
		txtEntree.setEditable(false);
		
		lblSide1=new JLabel("Side");
		lblSide1.setBounds(15,85,150,25);
		lblSide1.setFont(new Font("Arial", 1, 16));
		
		txtSide=new JTextArea();
		txtSide.setBounds(80,85, 470, 51);
		txtSide.setEditable(false);
		
		lblDrink1=new JLabel("Drink");
		lblDrink1.setBounds(15,140,150,25);
		lblDrink1.setFont(new Font("Arial", 1, 16));
		
		txtDrink=new JTextArea();
		txtDrink.setBounds(80,140, 470, 51);
		txtDrink.setEditable(false);
		
		lblDessert1=new JLabel("Dessert");
		lblDessert1.setBounds(15,195,150,25);
		lblDessert1.setFont(new Font("Arial", 1, 16));
		
		txtDessert=new JTextArea();
		txtDessert.setBounds(80,195, 470, 51);
		txtDessert.setEditable(false);
		
		//
		lblCalories=new JLabel("Calories");
		lblCalories.setBounds(10,260,150,25);
		lblCalories.setFont(new Font("Arial", 1, 16));
		
		txtCalories=new JTextField();
		txtCalories.setBounds(80,260,50,30);
		txtCalories.setEditable(false);
		
		lblFat=new JLabel("Fat");
		lblFat.setBounds(230,260,150,25);
		lblFat.setFont(new Font("Arial", 1, 16));
		
		txtFat=new JTextField();
		txtFat.setBounds(260,260,50,30);
		txtFat.setEditable(false);
		
		lblProtein=new JLabel("Protein");
		lblProtein.setBounds(410,260,150,25);
		lblProtein.setFont(new Font("Arial", 1, 16));
		
		txtProtein=new JTextField();
		txtProtein.setBounds(470,260,50,30);
		txtProtein.setEditable(false);
		
		lblPrice=new JLabel("Price");
		lblPrice.setBounds(15,320,150,25);
		lblPrice.setFont(new Font("Arial", 1, 16));
		
		txtPrice=new JTextField();
		txtPrice.setBounds(80,320,50,30);
		txtPrice.setEditable(false);
		
		lblSodium=new JLabel("Sodium");
		lblSodium.setBounds(200,320,150,25);
		lblSodium.setFont(new Font("Arial", 1, 16));
		
		txtSodium=new JTextField();
		txtSodium.setBounds(260,320,50,30);
		txtSodium.setEditable(false);
		
		initMenuManagerGUI();
		initMenuDetailFrame();
	}

	/**
	 * Initialize the contents of the main frame.
	 */
	private void initMenuManagerGUI() {
		
		menuManagerFrame = new JFrame("Menu Manager");
		menuManagerFrame.setBounds(100, 100, 600, 450);
		menuManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuManagerFrame.getContentPane().setLayout(null);
		
		menuManagerFrame.add(lblEntree);
		menuManagerFrame.add(cboEntreeOptions);
		
		menuManagerFrame.add(lblSide);
		menuManagerFrame.add(cboSideOptions);
		
		menuManagerFrame.add(lblDrink);
		menuManagerFrame.add(cboDrinkOptions);
		
		menuManagerFrame.add(lblDessert);
		menuManagerFrame.add(cboDessertOptions);
		
		menuManagerFrame.add(lblName);
		menuManagerFrame.add(txtName);
		
		menuManagerFrame.add(btnCreateMenu);
		
		menuManagerFrame.add(lblOr);
		
		menuManagerFrame.add(btnRandomGenerate);
		
		menuManagerFrame.add(lblCreatedMenus);
		
		menuManagerFrame.add(btnDetails);
		
		menuManagerFrame.add(btnSaveToFile);
		
		menuManagerFrame.add(lblSort);
		
		menuManagerFrame.add(lblBy);
		
		menuManagerFrame.add(cboAttributesOptions);
		
		menuManagerFrame.add(btnAscending);
		
		menuManagerFrame.add(btnDescending);
		
		
		selectedIndex1=0;
		selectedIndex2=0;
		selectedIndex3=0;
		selectedIndex4=0;
		
		cboEntreeOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JComboBox cb1 = (JComboBox)e.getSource();
        		selectedIndex1 = cb1.getSelectedIndex();
        	}
		});
		
		cboSideOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JComboBox cb2 = (JComboBox)e.getSource();
        		selectedIndex2 = cb2.getSelectedIndex();
        	}
		});
		
		cboDrinkOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JComboBox cb3 = (JComboBox)e.getSource();
        		selectedIndex3 = cb3.getSelectedIndex();
        	}
		});
		
		cboDessertOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JComboBox cb4 = (JComboBox)e.getSource();
        		selectedIndex4 = cb4.getSelectedIndex();
        		
        	}
		});
		
		menuList = new ArrayList<Menu>();
		          //Here is how you need to add an arraylist of Menus to fill a JList element
        lstMenuList = new JList<Object>(menuList.toArray()); //cast arrayList to array!
        			 //Because we override the toString() method in class Menu, the elements of the 
        			 //array generated are the names of menus!
		
		lstMenuList.setBounds(300, 50, 250, 220);
		
		btnCreateMenu.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		
        			// If the name input is empty
        			if(txtName.getText().equals("")){
        				JOptionPane.showMessageDialog(menuManagerFrame,"Error!");
        			}
        			else{
        				Menu m1 = new Menu(txtName.getText()); //Every time I click on the button,
        				                                //a new menu should be created
        				m1.setEntree(entrees.get(selectedIndex1));
        				m1.setSide(sides.get(selectedIndex2));
        				m1.setDrink(drinks.get(selectedIndex3));
        				m1.setDessert(desserts.get(selectedIndex4));
        				menuList.add(m1);
        				lstMenuList.setListData(menuList.toArray());
        		}
        	}
	 });
					menuManagerFrame.add(lstMenuList);
					
		btnRandomGenerate.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		// If the name input is empty
    			if(txtName.getText().equals("")){
    				JOptionPane.showMessageDialog(menuManagerFrame,"Error!");
    			}
    			else {
    				menuList.add(menu.randomMenu(txtName.getText()));
    				lstMenuList.setListData(menuList.toArray());
    			}
    	}
 });
					
		//JList action listener, which detects when a different Menu is selected
		lstMenuList.addListSelectionListener(new ListSelectionListener() {
			  public void valueChanged(ListSelectionEvent evt) {
				   
				    	if (!evt.getValueIsAdjusting()) {
				       // Get what is the currently selectedMenu
				    	selectedMenu = (Menu)lstMenuList.getSelectedValue();
				    }
			  }
		});
		
		btnDetails.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		//If no menu is selected
        		if(lstMenuList.getSelectedIndex()<0) {
        			menuDetailFrame.setVisible(false);
        		}else{
        		menuDetailFrame.setTitle(selectedMenu.getName());
        		showMenuDetails(selectedMenu);
        		menuDetailFrame.setVisible(true);}
    	}
 });
		
		btnSaveToFile.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		FileManager.writeMenus("data/menus.txt",menuList);
    	}
 });
		
		sortAttribute="Calories";
		cboAttributesOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		JComboBox cb = (JComboBox)e.getSource();
        		sortAttribute = attributeName[cb.getSelectedIndex()];
        	}
		});
		
		btnAscending.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if(sortAttribute.equals("Calories")) {
        			sortMenusAscending("Calories");
        		}else if(sortAttribute.equals("Fat")) {
        			sortMenusAscending("Fat");
        		}else if(sortAttribute.equals("Price")) {
        			sortMenusAscending("Price");
        		}else if(sortAttribute.equals("Sodium")) {
        			sortMenusAscending("Sodium");
        		}else if(sortAttribute.equals("Protein")) {
        			sortMenusAscending("Protein");
        		}
        		
    	}
 });
		btnDescending.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if(sortAttribute.equals("Calories")) {
        			sortMenusDescending("Calories");
        		}else if(sortAttribute.equals("Fat")) {
        			sortMenusDescending("Fat");
        		}else if(sortAttribute.equals("Price")) {
        			sortMenusDescending("Price");
        		}else if(sortAttribute.equals("Sodium")) {
        			sortMenusDescending("Sodium");
        		}else if(sortAttribute.equals("Protein")) {
        			sortMenusDescending("Protein");
        		}
        		
    	}
 });
		
		menuManagerFrame.setVisible(true);
	}
	
	/**
	 * Initialize the child frame of the main frame which needs to show the details of each Menu
	 */
	private void initMenuDetailFrame(){
		menuDetailFrame = new JFrame("Menu detail");
		menuDetailFrame.setBounds(700, 200, 600, 450);
		menuDetailFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		menuDetailFrame.getContentPane().setLayout(null);
		menuDetailFrame.setVisible(false);
		
		//Add here all the Swing GUI components for showing menu details
		
		menuDetailFrame.add(lblEntree1);
		menuDetailFrame.add(txtEntree);
		
		menuDetailFrame.add(lblSide1);
		menuDetailFrame.add(txtSide);
		
		menuDetailFrame.add(lblDrink1);
		menuDetailFrame.add(txtDrink);
		
		menuDetailFrame.add(lblDessert1);
		menuDetailFrame.add(txtDessert);
		
		menuDetailFrame.add(lblCalories);
		menuDetailFrame.add(txtCalories);
		
		menuDetailFrame.add(lblFat);
		menuDetailFrame.add(txtFat);
		
		menuDetailFrame.add(lblProtein);
		menuDetailFrame.add(txtProtein);
		
		menuDetailFrame.add(lblPrice);
		menuDetailFrame.add(txtPrice);
		
		menuDetailFrame.add(lblSodium);
		menuDetailFrame.add(txtSodium);
		
		
	}
	
	private void showMenuDetails(Menu selectedMenu){
		
		//Update here the information shown in the labels and text fields based on the selected Menu
		Entree entree=selectedMenu.getEntree();
		Side side=selectedMenu.getSide();
		Drink drink=selectedMenu.getDrink();
		Dessert dessert=selectedMenu.getDessert();
		
		//For entree
		txtEntree.setText(entree.getName()+"."+entree.getDescription()
				+". Calories:"+entree.getCalories()+". Price:$"+entree.getPrice()+". Fat:"+
				entree.getFat()+"%. Sodium:"+entree.getSodium()+"%. Protein:"+entree.getProtein()+"gr");
		txtEntree.setLineWrap(true);
		txtEntree.setWrapStyleWord(true);
		txtEntree.setEditable(false);
		
		//For side
		txtSide.setText(side.getName()+"."+side.getDescription()
		+". Calories:"+side.getCalories()+". Price:$"+side.getPrice()+". Fat:"+
		side.getFat()+"%. Sodium:"+side.getSodium()+"%. Protein:"+side.getProtein()+"gr");
		txtSide.setLineWrap(true);
		txtSide.setWrapStyleWord(true);
		txtSide.setEditable(false);
		
		//For drink
		txtDrink.setText(drink.getName()+"."+drink.getDescription()
		+". Calories:"+drink.getCalories()+". Price:$"+drink.getPrice()+". Fat:"+
		drink.getFat()+"%. Sodium:"+drink.getSodium()+"%. Protein:"+drink.getProtein()+"gr");
		txtDrink.setLineWrap(true);
		txtDrink.setWrapStyleWord(true);
		txtDrink.setEditable(false);
		
		//For dessert
		txtDessert.setText(dessert.getName()+"."+dessert.getDescription()
		+". Calories:"+dessert.getCalories()+". Price:$"+dessert.getPrice()+". Fat:"+
		dessert.getFat()+"%. Sodium:"+dessert.getSodium()+"%. Protein:"+dessert.getProtein()+"gr");
		txtDessert.setLineWrap(true);
		txtDessert.setWrapStyleWord(true);
		txtDessert.setEditable(false);
		
		//For attributes
		txtCalories.setText(String.valueOf(entree.getCalories()+side.getCalories()+drink.getCalories()
								+dessert.getCalories()));
		txtFat.setText(String.valueOf(entree.getFat()+side.getFat()+drink.getFat()
								+dessert.getFat())+"%");
		txtProtein.setText(String.valueOf(entree.getProtein()+side.getProtein()+drink.getProtein()
        						+dessert.getProtein())+"gr.");
		txtPrice.setText("$"+String.valueOf(entree.getPrice()+side.getPrice()+drink.getPrice()
								+dessert.getPrice()));
		txtSodium.setText(String.valueOf(entree.getSodium()+side.getSodium()+drink.getSodium()
								+dessert.getSodium())+"%");
		
	}
	
	
	private void sortMenusAscending(String sortAttribute) {//valid input parameters: "calories","price","fat","sodium","protein"
		
		//(1) Sort menuList based on sortAttribute (from lowest to highest). E.g. if sortAttribute is equals to "fat", the list of menu needs
		//to be sorted based on total fat from the menu with least amount of total fat to the highest amount of total fat
		
			if(sortAttribute.equals("Calories")) {
			
			//Bubble sort according to Calories
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalCalories()>menuList.get(j).totalCalories()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
			
		}else if(sortAttribute.equals("Price")) {
			
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalPrice()>menuList.get(j).totalPrice()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}else if(sortAttribute.equals("Fat")) {
			
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalFat()>menuList.get(j).totalFat()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}else if(sortAttribute.equals("Sodium")) {
			
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalSodium()>menuList.get(j).totalSodium()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}else {
			
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalProtein()>menuList.get(j).totalProtein()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}
		
		//(2) Update lstMenuList based on the sorted menuList
		lstMenuList.setListData(menuList.toArray());
	}
	
	private void sortMenusDescending(String sortAttribute) {
		
		//(1) Sort menuList based on sortAttribute (from highest to lowest). E.g. if sortAttribute is equals to "calories", the list of menu needs
		//to be sorted based on total fat from the menu with least amount of total fat to the highest amount of total fat
		if(sortAttribute.equals("Calories")) {
			
			//Bubble sort according to Calories
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalCalories()<menuList.get(j).totalCalories()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}else if(sortAttribute.equals("Fat")) {
				boolean noSwaps=false;
				for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
				int swaps=0;
				for(int j=1;j<=i;j++) {
					if(menuList.get(j-1).totalFat()<menuList.get(j).totalFat()) {
						Menu temp=menuList.get(j-1);
						menuList.set(j-1,menuList.get(j));
						menuList.set(j,temp);
						swaps++;
					}
				}
				if(swaps==0) noSwaps=true;
				}
		}else if(sortAttribute.equals("Price")) {
				boolean noSwaps=false;
				for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
				int swaps=0;
				for(int j=1;j<=i;j++) {
					if(menuList.get(j-1).totalPrice()<menuList.get(j).totalPrice()) {
						Menu temp=menuList.get(j-1);
						menuList.set(j-1,menuList.get(j));
						menuList.set(j,temp);
						swaps++;
					}
				}
				if(swaps==0) noSwaps=true;
				}
		}else if(sortAttribute.equals("Sodium")) {
			boolean noSwaps=false;
			for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
			int swaps=0;
			for(int j=1;j<=i;j++) {
				if(menuList.get(j-1).totalSodium()<menuList.get(j).totalSodium()) {
					Menu temp=menuList.get(j-1);
					menuList.set(j-1,menuList.get(j));
					menuList.set(j,temp);
					swaps++;
				}
			}
			if(swaps==0) noSwaps=true;
			}
		}else if(sortAttribute.equals("Protein")) {
				boolean noSwaps=false;
				for(int i= menuList.size()-1;i>=0&&!noSwaps;i-- ) {
				int swaps=0;
				for(int j=1;j<=i;j++) {
					if(menuList.get(j-1).totalProtein()<menuList.get(j).totalProtein()) {
						Menu temp=menuList.get(j-1);
						menuList.set(j-1,menuList.get(j));
						menuList.set(j,temp);
						swaps++;
					}
				}
				if(swaps==0) noSwaps=true;
				}
		}
		//Update lstMenuList based on the sorted menuList
		lstMenuList.setListData(menuList.toArray());
	}

	public static void main(String[] args) {

		MenuManagerGUI gui = new MenuManagerGUI();
		gui.menuManagerFrame.setVisible(true);
		
	}

}
