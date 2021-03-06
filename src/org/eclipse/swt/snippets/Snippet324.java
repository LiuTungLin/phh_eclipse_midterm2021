package org.eclipse.swt.snippets;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Snippet324 {

	static String stateMask (int stateMask) {
		String string = "[";
		if ((stateMask & SWT.CTRL) != 0) string += " CTRL";
		if ((stateMask & SWT.ALT) != 0) string += " ALT";
		if ((stateMask & SWT.SHIFT) != 0) string += " SHIFT";
		if ((stateMask & SWT.COMMAND) != 0) string += " COMMAND";
		if ((stateMask & SWT.BUTTON1) != 0) string += " BUTTON1";
		if ((stateMask & SWT.BUTTON2) != 0) string += " BUTTON2";
		if ((stateMask & SWT.BUTTON3) != 0) string += " BUTTON3";
		if ((stateMask & SWT.BUTTON4) != 0) string += " BUTTON4";
		if ((stateMask & SWT.BUTTON5) != 0) string += " BUTTON5";
		return string + "], ";
	}

	public static void main (String [] args) {
		Display display = new Display ();
		final Shell shell = new Shell (display);
		shell.setText("Snippet 324");
		Listener listener = e -> {
			String string = "Unknown";
			switch (e.type) {
				case SWT.MouseDoubleClick: string = "DOUBLE-CLICK"; break;
				case SWT.MouseDown: string = "DOWN"; break;
				case SWT.MouseMove: string = "MOVE"; break;
				case SWT.MouseUp: string = "UP"; break;
				case SWT.MouseEnter: string = "ENTER"; break;
				case SWT.MouseExit: string = "EXIT"; break;
				case SWT.MouseVerticalWheel: string = "WHEEL VERTICAL"; break;
				case SWT.MouseHorizontalWheel: string = "WHEEL HORIZONTAL"; break;
			}
			string += " - button=" + e.button + ", ";
			string += "stateMask=0x" + Integer.toHexString (e.stateMask) + stateMask(e.stateMask);
			string += "location=(" + e.x + ", " + e.y + "), ";
			if (e.type == SWT.MouseVerticalWheel) {
				string += "detail=";
				string += e.detail == SWT.SCROLL_PAGE ? "SCROLL_PAGE, " : "SCROLL_LINE, ";
			}
			string += "count=" + e.count + ", widget=" + e.widget;
			System.out.println (string);
		};
		shell.addListener (SWT.MouseDoubleClick, listener);
		shell.addListener (SWT.MouseDown, listener);
		shell.addListener (SWT.MouseMove, listener);
		shell.addListener (SWT.MouseUp, listener);
		shell.addListener (SWT.MouseEnter, listener);
		shell.addListener (SWT.MouseExit, listener);
		shell.addListener (SWT.MouseWheel, listener);
		shell.addListener (SWT.MouseHorizontalWheel, listener);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(10, 10, 100, 100);
		button.addListener (SWT.MouseDoubleClick, listener);
		button.addListener (SWT.MouseDown, listener);
		button.addListener (SWT.MouseMove, listener);
		button.addListener (SWT.MouseUp, listener);
		button.addListener (SWT.MouseEnter, listener);
		button.addListener (SWT.MouseExit, listener);
		button.addListener (SWT.MouseWheel, listener);
		button.addListener (SWT.MouseHorizontalWheel, listener);
		shell.setSize(240, 240);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}