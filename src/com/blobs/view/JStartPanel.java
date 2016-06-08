package com.blobs.view;


import javax.swing.*;

import com.blobs.MVC;

import java.awt.Color;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;

/**
 * This is where the start screen of the UI should be.
 */
public class JStartPanel extends JComponent implements MouseListener {
	JButton startbutton;
	/**
	 * The default constructor of the class, yay!
	 */
	public JStartPanel() {
		startbutton = new JButton("Start Game");
		startbutton.setBounds(0, 0, 300, 300);
		startbutton.addMouseListener(this);
		this.add(startbutton);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MVC.getController().startGame();
		startbutton.setBackground(new Color(255));
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
