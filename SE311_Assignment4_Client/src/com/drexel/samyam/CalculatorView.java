package com.drexel.samyam;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorView extends JFrame {
	private static final long serialVersionUID = 21305503976948004L;
	private JLabel outputLabel;
	private JPanel buttonsPanel;
	private JPanel exteriorPanel;
	private JPanel outputPanel;
	
	public CalculatorView() {
		setTitle("Basic Calculator");
		
		outputLabel = new JLabel(" ", JLabel.CENTER);
		outputPanel = new JPanel();
		exteriorPanel = new JPanel();
		
		outputLabel.setPreferredSize(new Dimension(280, 40));
		
		outputLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		outputPanel.add(outputLabel);
		
		// buttons panel to contain all the buttons in the calculator
		buttonsPanel = new JPanel(new GridLayout(4, 4));
		
		// add buttons to the buttons panel
		buttonsPanel.add(new JButton("1"));
		buttonsPanel.add(new JButton("2"));
		buttonsPanel.add(new JButton("3"));
		buttonsPanel.add(new JButton("+"));

		buttonsPanel.add(new JButton("4"));
		buttonsPanel.add(new JButton("5"));
		buttonsPanel.add(new JButton("6"));
		buttonsPanel.add(new JButton("-"));

		buttonsPanel.add(new JButton("7"));
		buttonsPanel.add(new JButton("8"));
		buttonsPanel.add(new JButton("9"));
		buttonsPanel.add(new JButton("*"));

		buttonsPanel.add(new JButton("0"));
		buttonsPanel.add(new JButton("="));
		buttonsPanel.add(new JButton("C"));
		buttonsPanel.add(new JButton("/"));
		
		// add panels to the outermost panel
		exteriorPanel.setLayout(new BorderLayout());
		exteriorPanel.add(outputPanel, BorderLayout.NORTH);
		exteriorPanel.add(buttonsPanel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		
		add(exteriorPanel);
		setSize(600,600);
		setMaximumSize(new Dimension(300, 300));
		setMinimumSize(new Dimension(300, 300));
		pack();
		setVisible(true);	
	}
	public JPanel getButtonPanel() {
		return buttonsPanel;
	}
	
	
}
