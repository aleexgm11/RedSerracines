package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

class Utils {

	/*
	 * return the frame to which 'c' belongs
	 */
	static Frame getWindow(Component c) {
		Frame w = null;
		if (c != null) {
			if (c instanceof Frame) {
				w = (Frame) c;
				w.setMaximumSize(new Dimension(75, 75));
			}
			else
				w = (Frame) SwingUtilities.getWindowAncestor(c);
			w.setMaximumSize(new Dimension(75, 75));

		}
		

		return w;
	}

	static void showErrorMsg(String msg) {
		showErrorMsg(null, msg);
	}

	static void showErrorMsg(Component c, String msg) {
		JOptionPane.showMessageDialog(getWindow(c), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	static void quit(Component c) {

		int n = JOptionPane.showOptionDialog(getWindow(c), "¿Seguro de que quieres salir?", "Slir",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		if (n == 0) {
			System.exit(0);
		}
	}

}