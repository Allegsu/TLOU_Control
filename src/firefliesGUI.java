import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;


public class firefliesGUI extends JFrame implements ActionListener{
    //Creating Buttons 
    private JButton checkInBtn, checkOutBtn, regBtn, InfectedBtn, quitGameBtn;
    //JTtextArea 
    private JTextArea textArea;
    
    public firefliesGUI(){
        setTitle("Fireflies Data Base");
        setSize(350,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //Set the Icon for application (Globally)
        setIconImage(new ImageIcon(getClass().getResource("/images/fireflies.png")).getImage());

        //Set Bounds GUI to scren center 
        setLocationRelativeTo(null);


        checkInBtn = new JButton("Check In");
        checkInBtn.setBounds(50,30,120,30);
        checkInBtn.addActionListener(this);
        //Custom Font & Background
        Color checkInBtnFont = Color.WHITE;
        checkInBtn.setForeground(checkInBtnFont);
        Color checkInBtnBackC = Color.BLACK;
        checkInBtn.setBackground(checkInBtnBackC);
        add(checkInBtn);

        checkOutBtn = new JButton("Check Out");
        checkOutBtn.setBounds(50,80,120,30);
        checkOutBtn.addActionListener(this);
        //Custom Font & Background
        Color checkOutBtnFont = Color.WHITE;
        checkOutBtn.setForeground(checkOutBtnFont);
        Color checkOutBtnBackC = Color.BLACK;
        checkOutBtn.setBackground(checkOutBtnBackC);
        add(checkOutBtn);

        regBtn = new JButton("Sign In");
        regBtn.setBounds(50, 130, 120, 30);
        regBtn.addActionListener(this);
        //Custom Font & Background
        Color regBtnFont = Color.WHITE;
        regBtn.setForeground(regBtnFont);
        Color regBtnBackC = Color.BLACK;
        regBtn.setBackground(regBtnBackC);
        add(regBtn);

        InfectedBtn = new JButton("Infected Stages");
        InfectedBtn.setBounds(200, 30, 120, 30);
        InfectedBtn.addActionListener(this);
        //Customs
        Color InfectedBtnColor = Color.WHITE;
        InfectedBtn.setForeground(InfectedBtnColor);
        Color InfectedBtnBackC = Color.RED;
        InfectedBtn.setBackground(InfectedBtnBackC);
        add(InfectedBtn);
        
        textArea = new JTextArea();
        textArea.setBounds(50, 180, 270, 120);
        add(textArea);

        quitGameBtn = new JButton("Quit Game");
        quitGameBtn.setBounds(100,320,100,30);
        quitGameBtn.addActionListener(this);
        //Customs
        Color quitbtnColor = Color.WHITE;
        quitGameBtn.setForeground(quitbtnColor);
        Color backgroundColor = Color.BLACK;
        quitGameBtn.setBackground(backgroundColor);
        add(quitGameBtn);
        

        quitGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        //Handle Actions for the buttons 
        if(e.getSource() == checkInBtn){
            //Prompt the user to enter their name 
            String name = JOptionPane.showInputDialog(null,"Type your name: ");

            //Prompt the age
            String ageInput = JOptionPane.showInputDialog(null,"Enter your age: ");
            int age = Integer.parseInt(ageInput); //Convert age to INT

            //Prompt the user to enter their zone
            String zone = JOptionPane.showInputDialog(null, "Enter your Zone: ");

            //Create an Array of weapon options
            Object[] weapons = {"Semi-Auto Pistol", "Bolt-Action Rifle", "Revolver" ,"Pump Shotgun", "Bow", "Military Pistol", "Semi-Auto Rifle", "Hunting Pistol", "Double Barrel Shotgun", "Crossbow", "Flamethrower", "Silenced Submachine Gun"};

            //Prompt the user to choose their favourite weeapon 
            int weaponChoice = JOptionPane.showOptionDialog(null, "Choose your favorite weapon:", 
            "Favourite Weapon", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, weapons, weapons[0]);

            //Check if the user is clicked "Accept" or closed the dialog 
            if(weaponChoice !=JOptionPane.CLOSED_OPTION){
                //Get Selected Weapon
                String selectedWeapon = (String) weapons[weaponChoice];

                //Display the user information 
                String message = "Name: " + name + "\nAge: " + age + "\nZone: " + zone + "\nFavourite weapon: " + selectedWeapon;
                //JOptionPane.showMessageDialog(null,message, "Check In Successfull", JOptionPane.INFORMATION_MESSAGE); //Pass it to JOptionPane
                textArea.append(message + "\n\n"); //Pass the filled information to textArea
            }
        } else if (e.getSource() == checkOutBtn){
        //Checkout Functionality
         int choice1 = JOptionPane.showOptionDialog(null, "Do you have any weapons with you?", 
        "Check Out", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, new String[]{"Yes", "No"}, "Yes");

            int choice2 = JOptionPane.showOptionDialog(null, "Will someone go with you?",
        "Check Out", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
        null, new String[]{"Yes", "No"}, "Yes");

            // Construct the message based on each choice
            String weaponsMessage = "Weapons: " + (choice1 == 0 ? "Yes" : "No");
            String someoneGoingMessage = "Someone going with you: " + (choice2 == 0 ? "Yes" : "No");

            // Concatenate both messages and append to textArea
            String message = weaponsMessage + "\n" + someoneGoingMessage;
            textArea.append(message + "\n\n");
        } else if (e.getSource() == regBtn){
            //Welcome Message 
            JOptionPane.showMessageDialog(this,"May Your Death Be Swift");

            //Clear the content 
            textArea.setText("");

        } else if (e.getSource() == InfectedBtn){

        // Define the path to the default image (locally)
        //String defaultImagePath = "C:/Users/r/EOP/P_9_A/src/images/SOI.jpg";
        //Define the path (Globally getting the classpath)
        String defaultImagePath = "/images/SOI.jpg";

        // Load the default image and scale it down
        //ImageIcon defaultImageIcon = new ImageIcon(defaultImagePath);
        
        //Load the defualt Image with classpath 
        ImageIcon defaultImageIcon = new ImageIcon(getClass().getResource(defaultImagePath));
        Image defaultImage = defaultImageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel defaultImageLabel = new JLabel(new ImageIcon(defaultImage));

        // Options
        String[] options = {"Runner", "Stalker", "Clicker", "Shambler", "Bloater", "Rat king"};

        // Define the Array of image paths
        String[] imagePaths = {
        "Runner.png",
        "Stalker.png",
        "Clicker.png",
        "Shambler.png",
        "Bloater.png",
        "Ratking.png",
 };

        // Show the option dialog with the custom panel
        int choice = JOptionPane.showOptionDialog(this, defaultImageLabel, "Choose Infected Type", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        // Display the selected option in the JTextArea
        if (choice != JOptionPane.CLOSED_OPTION) {
        textArea.append("Infected Type: " + options[choice] + "\n");

        //Load the images using classpath 
        String selectedImagePath = "/images/infected/" + imagePaths[choice]; //Corrected Path /
        //Load the images array with classpath
        ImageIcon selectedImageIcon = new ImageIcon(getClass().getResource(selectedImagePath));
        
        Image selectedImage = selectedImageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel selectedImageLabel = new JLabel(new ImageIcon(selectedImage));
        JOptionPane.showMessageDialog(this, selectedImageLabel, options[choice], JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


    public static void main(String[] args){
        new firefliesGUI();
    }
}
