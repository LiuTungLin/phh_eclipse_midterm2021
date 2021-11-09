package org.eclipse.swt.snippets;

import static org.eclipse.swt.events.SelectionListener.*;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet108 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setText("Snippet 108");
	Label label = new Label (shell, SWT.NONE);
	label.setText ("Enter your name:");
	Text text = new Text (shell, SWT.BORDER);
	text.setLayoutData (new RowData (100, SWT.DEFAULT));
	Button ok = new Button (shell, SWT.PUSH);
	ok.setText ("OK");
	ok.addSelectionListener(widgetSelectedAdapter(e -> System.out.println("OK")));
	Button cancel = new Button (shell, SWT.PUSH);
	cancel.setText ("Cancel");
	cancel.addSelectionListener(widgetSelectedAdapter(e -> System.out.println("Cancel")));
	shell.setDefaultButton (cancel);
	shell.setLayout (new RowLayout ());
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}