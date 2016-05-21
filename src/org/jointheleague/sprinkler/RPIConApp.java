package org.jointheleague.sprinkler;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RPIConApp extends JPanel implements Runnable, ActionListener{
	
	private JLabel rpiID;
	public void run(){
		JFrame frame = new JFrame();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 2));
		JLabel networkID = new JLabel("SSID: ");
		JLabel password = new JLabel("Password: ");
		JTextField enterNetworkID = new JTextField(12);
		JTextField enterPassword = new JTextField(12);
		JButton submitButton = new JButton("Submit");
		rpiID = new JLabel("Sprinkler ID:");
		
		frame.add(this);
		this.add(gridPanel);
		gridPanel.add(networkID);
		gridPanel.add(enterNetworkID);
		gridPanel.add(password);
		gridPanel.add(enterPassword);
		this.add(submitButton);
		this.add(rpiID);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		submitButton.addActionListener(this);
	}
	public static void main(String[] args) {
		RPIConApp a = new RPIConApp();
		SwingUtilities.invokeLater(a);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String portID = "/dev/tty.usbmodem1421";
		rpiID.setText("SprinklerID:" + 12345);
	}
}
