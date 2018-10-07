package org.jlobato.gpro.user;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;

public class UsuarioUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5116907255204725254L;
	
	private JTextField userNameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JComboBox languageCombo;

	private IUsuario model;

	public UsuarioUI() {
		buildUI();
	}

	private void buildUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 1, 1);
		
		//User Name
		add(new JLabel("User name:"), constraints);
		constraints.weightx = 1;
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(userNameField = new JTextField(), constraints);
		constraints.weightx = 0;
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;
		
		//Login
		add(new JLabel("username:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(usernameField = new JTextField(), constraints);
		constraints.gridy = 2;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;
		
		//Clave
		add(new JLabel("password:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(passwordField = new JPasswordField(), constraints);
		constraints.gridy = 3;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;
		
		//Idioma
		add(new JLabel("Idioma:"), constraints);
		constraints.gridx = 1;
		//constraints.fill = GridBagConstraints.BOTH;
		add(languageCombo = new JComboBox(createLanguagesComboBoxModel()), constraints);
		constraints.gridy = 4;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;
		//Renderer
		LanguageComboBoxRenderer renderer = new LanguageComboBoxRenderer();
		languageCombo.setRenderer(renderer);
		languageCombo.setMaximumRowCount(10);

		
		constraints.gridy = 5;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.gridwidth = 2;
		add(new JPanel(), constraints);
		
	}

	/**
	 * 
	 * @return
	 */
	private ComboBoxModel createLanguagesComboBoxModel() {
		Iterator<ILanguage> languages = LanguageManager.getInstance().getLanguages();
		DefaultComboBoxModel result = new DefaultComboBoxModel();
		while(languages.hasNext()) {
			ILanguage language = languages.next();
			result.addElement(language);
		}
		result.setSelectedItem(LanguageManager.getInstance().getDefaultLanguage());
		return result;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setModel(IUsuario usuario) {
		this.model = usuario;
		if (this.model != null) {
			this.userNameField.setText(usuario.getName());
			this.usernameField.setText(usuario.getContextoUsuario().getUsername());
			this.passwordField.setText(usuario.getContextoUsuario().getPassword());
			if (usuario.getContextoUsuario().getLanguage() != null) this.languageCombo.setSelectedItem(usuario.getContextoUsuario().getLanguage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public IUsuario getModel() {
		return this.model;
	}

	public JTextField getUserNameField() {
		return userNameField;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
	public JComboBox getLanguageCombo() {
		return languageCombo;
	}
	
	/**
	 * 
	 * @author jlobato
	 *
	 */
	class LanguageComboBoxRenderer extends JPanel implements ListCellRenderer {
		
		private JLabel iconLabel;
		private JLabel textLabel;

		/**
		 * 
		 */
		private static final long serialVersionUID = 9009539737172106897L;
		
		/**
		 * 
		 */
		public LanguageComboBoxRenderer() {
			super(new GridLayout(1, 2, 0, 0));
			setBorder(new EmptyBorder(2, 2, 2, 2));
			add(iconLabel = new JLabel());
			add(textLabel = new JLabel());
		}

		/**
		 * 
		 */
		public Component getListCellRendererComponent(JList combo, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			ILanguage languageToBeRendered = (ILanguage)value;
			
			if (isSelected) {
	            this.setBackground(combo.getSelectionBackground());
	            this.setForeground(combo.getSelectionForeground());
	        } else {
	        	this.setBackground(combo.getBackground());
	        	this.setForeground(combo.getForeground());
	        }
			
			iconLabel.setIcon(languageToBeRendered.getIcon());
			iconLabel.setText("");
			if (languageToBeRendered.getIcon() != null) {
				textLabel.setText(languageToBeRendered.getDescription());
				textLabel.setFont(combo.getFont());
			}
			
			return this;
		}
		
	}

}
