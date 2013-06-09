package raccooncoding.propet.main;

/*
 * ShopGUI.java
 * The initial GUI class of the application. It generates a frame
 * with the application logo on top and two buttons for the end user below
 * to either navigate to customer list or terminate the application.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import raccooncoding.propet.customer.CustomersGUI;
import raccooncoding.propet.util.PropetJMenuBar;


public class ShopGUI extends JFrame implements ActionListener {

	//JButton label strings declared as constants
	private static String CUSTOMERS_BUTTON_LABEL = "Customers";
	private static String QUIT_BUTTON_LABEL = "Exit";

	private JPanel shopPnl;			//containing logoLlb, customerBtn & quitBtn
	private BoxLayout paneLayout;	//contentPane layout
	private BoxLayout shopLayout;	//shopPnl layout
	private JLabel logoLbl;
	private JButton customersBtn;
	private JButton quitBtn;
	private ImageIcon logo;			//ImageIcon object for logoLbl image
	private PropetJMenuBar bar = new PropetJMenuBar();

	public ShopGUI() {

		//Frame configuration
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(raccooncoding.propet.main.ProPetApp.MAIN_WINDOW_TITLE);	//gets window title from constant in com.vetapp.main.VetApp
		
		//JMenuBar
		setJMenuBar(bar.drawJMenuBar());

		//getContentPane() layout (horizontal BoxLayout)
		shopPnl = new JPanel();
		paneLayout = new BoxLayout(getContentPane(),BoxLayout.X_AXIS);
		getContentPane().setLayout(paneLayout);

		getContentPane().add(Box.createRigidArea(new Dimension(40, 0)));
		getContentPane().add(shopPnl);
		getContentPane().add(Box.createRigidArea(new Dimension(40, 0)));

		//shopPnl layout (vertical BoxLayout)
		logo = createImageIcon(raccooncoding.propet.main.ProPetApp.LOGO_IMAGE_PATH, "ProPet logo");
		logoLbl = new JLabel(logo);
		customersBtn = new JButton(CUSTOMERS_BUTTON_LABEL);
		quitBtn = new JButton(QUIT_BUTTON_LABEL);
		shopLayout = new BoxLayout(shopPnl, BoxLayout.Y_AXIS);
		shopPnl.setLayout(shopLayout);

		shopPnl.add(Box.createRigidArea(new Dimension(0, 15)));
		shopPnl.add(logoLbl);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 20)));
		shopPnl.add(customersBtn);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 10)));
		shopPnl.add(quitBtn);
		shopPnl.add(Box.createRigidArea(new Dimension(0, 15)));

		logoLbl.setAlignmentX(CENTER_ALIGNMENT);		//set logo JLabel alignment to CENTER
		customersBtn.setAlignmentX(CENTER_ALIGNMENT);	//set customers JButton alignment to CENTER
		quitBtn.setAlignmentX(CENTER_ALIGNMENT);		//set exit JButton alignment to CENTER

		//ActionListener
		customersBtn.addActionListener(this);
		quitBtn.addActionListener(this);

		//Pack, Center & Enable visibility for JFrame & all containers
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setVisible(true);
		shopPnl.setVisible(true);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CUSTOMERS_BUTTON_LABEL)) {
			new CustomersGUI();
			this.dispose();
		} else if (e.getActionCommand().equals(QUIT_BUTTON_LABEL)) {
			System.exit(0);
		}
	}
}