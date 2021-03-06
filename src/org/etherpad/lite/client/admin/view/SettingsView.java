package org.etherpad.lite.client.admin.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

public class SettingsView extends JDialog {
	private JButton saveButton = null;
	private JButton cancelButton = null;
	private JTextField hostTextField = null;
	private JTextField apiTextField = null;
	private JLabel protocolLabel = null;
	private JCheckBox sslCheckBox = null;

	public SettingsView() {
		super(null, JDialog.DEFAULT_MODALITY_TYPE);

		createGUI();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/icons/eplite.png")));

		setTitle("EP Lite Admin settings");
		setSize(400, 300);
		setResizable(true);
		CenteredFrame.center(this, getWidth(), getHeight());
	}

	private void createGUI() {
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(3, 3, 3, 3);

		JLabel hostLabel = new JLabel("URL: ");
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		mainPanel.add(hostLabel, c);
		JLabel apiLabel = new JLabel("API Key: ");
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		mainPanel.add(apiLabel, c);

		protocolLabel = new JLabel("http://");
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.2;
		mainPanel.add(protocolLabel, c);
		
		hostTextField = new JTextField(20);
		hostTextField.setToolTipText("URL: example.com:9001");
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.8;
		mainPanel.add(hostTextField, c);
		
		sslCheckBox = new JCheckBox("SSL");
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
		c.gridwidth = 2;
		mainPanel.add(sslCheckBox, c);
		
		apiTextField = new JTextField(20);
		apiTextField.setToolTipText("APIKEY: See APIKEY.txt on server");
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		c.gridwidth = 2;
		mainPanel.add(apiTextField, c);

		saveButton = new JButton("Save");
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 1;
		mainPanel.add(saveButton, c);

		cancelButton = new JButton("Cancel");
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 2;
		mainPanel.add(cancelButton, c);

		getContentPane().add(mainPanel);
	}

	public String getHostTextFieldText() {
		return hostTextField.getText();
	}

	public void setHostTextFieldText(String hostTextFieldText) {
		this.hostTextField.setText(hostTextFieldText);
	}
	
	public void setHostTextFieldFocusListener(FocusAdapter a) {
		this.hostTextField.addFocusListener(a);
	}

	public String getApiTextFieldText() {
		return apiTextField.getText();
	}

	public void setApiTextFieldText(String apiTextFieldText) {
		this.apiTextField.setText(apiTextFieldText);
	}

	public void setSaveButtonListener(ActionListener actionListener) {
		saveButton.addActionListener(actionListener);
	}

	public void setCancelButtonListener(ActionListener actionListener) {
		cancelButton.addActionListener(actionListener);
	}
	
	public void setSslCheckBoxChangeListener(ChangeListener c) {
		sslCheckBox.addChangeListener(c);
	}
	
	public void setSslCheckBoxSelected(boolean selected) {
		sslCheckBox.setSelected(selected);
		if (selected) {			
			protocolLabel.setText("https://");
		} else {
			protocolLabel.setText("http://");
		}
	}
	
	public void setProtocolLabelText(String text) {
		protocolLabel.setText(text);
	}
	
	public String getProtocolLabelText() {
		return protocolLabel.getText();
	}
}
