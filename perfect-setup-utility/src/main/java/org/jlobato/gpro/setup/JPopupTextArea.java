package org.jlobato.gpro.setup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author JLOBATO
 *
 */
public class JPopupTextArea extends JTextArea {

	/**
	 *
	 */
	final static String COPY = "Copy";
	/**
	 *
	 */
	final static String CUT = "Cut";
	/**
	 *
	 */
	final static String PASTE = "Paste";
	/**
	 *
	 */
	final static String SELECTALL = "Select All";

	/**
	 *
	 */
	private static final long serialVersionUID = 2581494762693602197L;

	/**
	 *
	 */
	public JPopupTextArea() {
		addPopupMenu();
	}

	/**
	 *
	 */
	private void addPopupMenu() {
		final JPopupMenu menu = new JPopupMenu();
		final JMenuItem copyItem = new JMenuItem();
		copyItem.setAction(getActionMap().get(DefaultEditorKit.copyAction));
		copyItem.setText(COPY);

		final JMenuItem cutItem = new JMenuItem();
		cutItem.setAction(getActionMap().get(DefaultEditorKit.cutAction));
		cutItem.setText(CUT);

		final JMenuItem pasteItem = new JMenuItem(PASTE);
		pasteItem.setAction(getActionMap().get(DefaultEditorKit.pasteAction));
		pasteItem.setText(PASTE);

		final JMenuItem selectAllItem = new JMenuItem(SELECTALL);
		selectAllItem.setAction(getActionMap().get(DefaultEditorKit.selectAllAction));
		selectAllItem.setText(SELECTALL);

		menu.add(copyItem);
		menu.add(cutItem);
		menu.add(pasteItem);
		menu.add(new JSeparator());
		menu.add(selectAllItem);

		add(menu);
		addMouseListener(new PopupTriggerMouseListener(menu, this));
	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	public static class PopupTriggerMouseListener extends MouseAdapter {
		/**
		 *
		 */
		private JPopupMenu popup;
		/**
		 *
		 */
		private JComponent component;

		/**
		 *
		 * @param popup
		 * @param component
		 */
		public PopupTriggerMouseListener(JPopupMenu popup, JComponent component) {
			this.popup = popup;
			this.component = component;
		}

		/**
		 *
		 */
		private void showMenuIfPopupTrigger(MouseEvent e) {
			if (e.isPopupTrigger()) {
				component.grabFocus();
				popup.show(component, e.getX() + 3, e.getY() + 3);
			}
		}

		/**
		 *
		 */
		public void mousePressed(MouseEvent e) {
			showMenuIfPopupTrigger(e);
		}

		/**
		 *
		 * @param e
		 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
		 */
		public void mouseReleased(MouseEvent e) {
			showMenuIfPopupTrigger(e);
		}

	}

}
