package org.etherpad.lite.client.admin.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PadPanel extends JPanel {

	private JButton editButton = null;
	private JTextArea padTextArea = null;
	private JLabel padLabel = null;
	private JLabel padRoLabel = null;

	public PadPanel() {

	}

	public PadPanel(String padId, String roPadId, String padText,
			String revNumber, String padAuthors) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(3, 3, 3, 3);

		padLabel = new JLabel("<html><u>Pad id: " + padId + "</u></html>");
		padLabel.setForeground(Color.BLUE);
		padLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		add(padLabel, c);

		padRoLabel = new JLabel("<html><u>Read only pad id: " + roPadId + "</u></html>");
		padRoLabel.setForeground(Color.BLUE);
		padRoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		add(padRoLabel, c);

		JLabel revLabel = new JLabel("Revision: " + revNumber);
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		add(revLabel, c);

		JLabel padAuthorLabel = new JLabel("Authors: " + padAuthors);
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0;
		add(padAuthorLabel, c);

		padTextArea = new JTextArea();
		padTextArea.setText(padText);
		padTextArea.setEditable(false);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 4;
		JScrollPane padScrollPane = new JScrollPane(padTextArea);
		// padScrollPane.setMinimumSize(new Dimension(100, 100));
		add(padScrollPane, c);

		editButton = new JButton("Edit text");
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 4;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		add(editButton, c);
	}

	public void setEditTextButtonMenuListener(ActionListener a) {
		editButton.addActionListener(a);
	}

	public void setPadIdLabelMouseListener(MouseAdapter m) {
		padLabel.addMouseListener(m);
	}

	public void setPadRoLabelMouseListener(MouseAdapter m) {
		padRoLabel.addMouseListener(m);
	}

	public void setPadText(String padText) {
		padTextArea.setText(padText);
	}
}
