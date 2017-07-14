package battle;
import java.awt.BorderLayout;


//import differentchars.Rogue;
//import differentchars.Assassin;
import differentchars.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NumberFormatException;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyWindow extends JFrame implements ActionListener {
	
	JTextField name,strength,defense,health;
	JTextField name2,strength2,defense2,health2;
	JButton create, cancel;
	JComboBox comboBox;
	JComboBox comboBox2;
	public boolean selectedBox;
	public boolean selectedBox2;
	public String selectedClass;
	public String selectedClass2;
	
	public Character character1;
	public Character character2;
	public Rogue rogue1;
	public Rogue rogue2;
	public Assassin assassin1;
	public Assassin assassin2;
	public Medic medic1;
	public Medic medic2;
	public Tank tank1;
	public Tank tank2;
	
	MyWindow(String title) {
		super(title);
		//this.setSize(400,650);
		this.init();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	void init() {
		//To Revert, create one Panel without GridLayout and add everything to that (then add back spaces)
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel actionPanel = new JPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Player 1"));
		panel2.setBorder(BorderFactory.createTitledBorder("Player 2"));
		
		//JLabel space3 = new JLabel("                                                                                                                   ");
		//panel.add(space3);
		
		//JLabel player1 = new JLabel("Player 1:");
		//panel.add(player1);
		
		//JLabel space4 = new JLabel("                                                                                                                   ");
		//panel.add(space4);
		
		JLabel class1 = new JLabel("Class:");
		JLabel class2 = new JLabel("Class:");
		panel.add(class1);
		panel2.add(class2);
		
		String[] classOptions = {"Ordinary", "Rogue", "Assassin", "Medic", "Tank"};
		comboBox = new JComboBox(classOptions);
		comboBox2 = new JComboBox(classOptions);
		
		panel.add(comboBox);
		panel2.add(comboBox2);
		
		comboBox.addActionListener(this);
		comboBox2.addActionListener(this);

		JLabel lname = new JLabel("Name:");
 
		name = new JTextField(10);
		
		panel.add(lname);
		panel.add(name);
		
		JLabel sName = new JLabel("Strength");
		strength = new JTextField(10);
		panel.add(sName);
		panel.add(strength);
		
		JLabel dName = new JLabel("Defense");
		defense = new JTextField(10);
		panel.add(dName);
		panel.add(defense);
		
		JLabel hName = new JLabel("Health");
		health = new JTextField(10);
		panel.add(hName);
		panel.add(health);
		
		//JLabel space = new JLabel("                                                                                                                   ");
		//panel.add(space);
		
		//JLabel player2 = new JLabel("Player 2:");
		//panel2.add(player2);
		
		//JLabel space2 = new JLabel("                                                                                                                   ");
		//panel.add(space2);
		
		
		JLabel lname2 = new JLabel("Name:");
		 
		name2 = new JTextField(10);
		
		panel2.add(lname2);
		panel2.add(name2);
		
		JLabel sName2 = new JLabel("Strength");
		strength2 = new JTextField(10);
		panel2.add(sName2);
		panel2.add(strength2);
		
		JLabel dName2 = new JLabel("Defense");
		defense2 = new JTextField(10);
		panel2.add(dName2);
		panel2.add(defense2);
		
		JLabel hName2 = new JLabel("Health");
		health2 = new JTextField(10);
		panel2.add(hName2);
		panel2.add(health2);
		
		
		create = new JButton("Create");
		cancel = new JButton("Clear");
		
		actionPanel.add(create);
		actionPanel.add(cancel);
		create.addActionListener(this);
		cancel.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		
		this.add(panel, BorderLayout.PAGE_START);
		this.add(panel2, BorderLayout.CENTER);
		this.add(actionPanel, BorderLayout.PAGE_END);
		
		
		this.pack();
		this.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == comboBox) {
			selectedBox = true;
			selectedClass = (String) comboBox.getSelectedItem();
			//System.out.println(selectedClass);
			//System.out.println("1 run");
		}
		else if (event.getSource() == comboBox2) {
			selectedBox2 = true;
			selectedClass2 = (String) comboBox2.getSelectedItem();
			//System.out.println(selectedClass2);
			//System.out.println("2 run");
		}
		if (event.getSource() == create) {
			try {
				Character player1 = new Character();
				Character player2 = new Character();
				Arena battle = new Arena();
				
				if (selectedBox) {
					switch(selectedClass){
						case "Rogue":
							rogue1 = new Rogue();
							rogue1.strength = Integer.parseInt(strength.getText());
							rogue1.defense = Integer.parseInt(defense.getText());
							rogue1.health = Integer.parseInt(health.getText());
							rogue1.name = name.getText();
							rogue1.isMedic = false;
							rogue1.myClass = selectedClass;
							character1 = rogue1;
							break;
						case "Assassin":
							assassin1 = new Assassin();
							assassin1.strength = Integer.parseInt(strength.getText());
							assassin1.defense = Integer.parseInt(defense.getText());
							assassin1.health = Integer.parseInt(health.getText());
							assassin1.name = name.getText();
							assassin1.isMedic = false;
							assassin1.myClass = selectedClass;
							character1 = assassin1;
							break;
						case "Medic": 
							medic1 = new Medic();
							medic1.strength = Integer.parseInt(strength.getText());
							medic1.defense = Integer.parseInt(defense.getText());
							medic1.health = Integer.parseInt(health.getText());
							medic1.name = name.getText();
							medic1.isMedic = true;
							medic1.myClass = selectedClass;
							character1 = medic1;
							break;
						case "Tank": 
							tank1 = new Tank();
							tank1.strength = Integer.parseInt(strength.getText());
							tank1.defense = Integer.parseInt(defense.getText());
							tank1.health = Integer.parseInt(health.getText());
							tank1.name = name.getText();
							tank1.isMedic = false;
							tank1.myClass = selectedClass;
							character1 = tank1;
							break;
						case "Ordinary": 
							character1 = new Character(Integer.parseInt(strength.getText()), Integer.parseInt(defense.getText()), Integer.parseInt(health.getText()));
							character1.name = name.getText();
							character1.isMedic = false;
							character1.myClass = "Ordinary";
							break;
						default:
							//System.out.println("No class was input");
							break;
					}//end switch
					
				} else {
					character1 = new Character(Integer.parseInt(strength.getText()), Integer.parseInt(defense.getText()), Integer.parseInt(health.getText()));
					character1.name = name.getText();
					character1.isMedic = false;
					character1.myClass = "Ordinary";
				}//end if
				
				if (selectedBox2) {
					switch(selectedClass2){
						case "Rogue":
							rogue2 = new Rogue();
							rogue2.strength = Integer.parseInt(strength2.getText());
							rogue2.defense = Integer.parseInt(defense2.getText());
							rogue2.health = Integer.parseInt(health2.getText());
							rogue2.name = name2.getText();
							rogue2.isMedic = false;
							rogue2.myClass = selectedClass2;
							character2 = rogue2;
							break;
						case "Assassin":
							assassin2 = new Assassin();
							assassin2.strength = Integer.parseInt(strength2.getText());
							assassin2.defense = Integer.parseInt(defense2.getText());
							assassin2.health = Integer.parseInt(health2.getText());
							assassin2.name = name2.getText();
							assassin2.isMedic = false;
							assassin2.myClass = selectedClass2;
							character2 = assassin2;
							break;
						case "Medic": 
							medic2 = new Medic();
							medic2.strength = Integer.parseInt(strength2.getText());
							medic2.defense = Integer.parseInt(defense2.getText());
							medic2.health = Integer.parseInt(health2.getText());
							medic2.name = name2.getText();
							medic2.isMedic = true;
							medic2.myClass = selectedClass2;
							character2 = medic2;
							break;
						case "Tank": 
							tank2 = new Tank();
							tank2.strength = Integer.parseInt(strength2.getText());
							tank2.defense = Integer.parseInt(defense2.getText());
							tank2.health = Integer.parseInt(health2.getText());
							tank2.name = name2.getText();
							tank2.isMedic = false;
							tank2.myClass = selectedClass2;
							character2 = tank2;
							break;
						case "Ordinary": 
							character2 = new Character(Integer.parseInt(strength.getText()), Integer.parseInt(defense.getText()), Integer.parseInt(health.getText()));
							character2.name = name.getText();
							character2.isMedic = false;
							character2.myClass = "Ordinary";
							break;
					default:
						//System.out.println("No class was input");
						break;
				}//end switch
					//System.out.println("run");
				} else {
					character2 = new Character(Integer.parseInt(strength2.getText()), Integer.parseInt(defense2.getText()), Integer.parseInt(health2.getText()));
					character2.name = name2.getText();
					character2.isMedic = false;
					character2.myClass = "Ordinary";
					//System.out.println("not run");
				}
				
				//System.out.println("ran");
				
				//System.out.println(character1.myClass);
				//System.out.println(character2.myClass );
				
				int dialogResult = JOptionPane.showConfirmDialog(this, "\nName: " + character1.name + "\nClass: " + character1.myClass + "\nHealth: " + character1.health + "\nStrength: " + character1.strength + "\nDefense: " + character2.defense + "\nvs."+ "\nName: " + character2.name + "\nClass: " + character2.myClass + "\nHealth: " + character2.health + "\nStrength: " + character2.strength + "\nDefense: " + character2.defense  );
				if(dialogResult == JOptionPane.YES_OPTION) {
					battle.runBattle(character1, character2);
				}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter in appropriate values", "Error", JOptionPane.ERROR_MESSAGE);
			}//end try catch
			
        } else if (event.getSource() == cancel) {
        	name.setText("");
        	strength.setText("");
        	defense.setText("");
        	health.setText("");
        }//end if else
			
	}//end method
	
}//end class
