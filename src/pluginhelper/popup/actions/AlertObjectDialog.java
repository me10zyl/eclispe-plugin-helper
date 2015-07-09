package pluginhelper.popup.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AlertObjectDialog extends Dialog {
	private Label lblNewLabel;

	public Label getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(Label lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AlertObjectDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
		fl_container.marginHeight = 5;
		container.setLayout(fl_container);
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("\u65E0\u6CD5\u663E\u793A");
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.NEXT_ID, "\u590D\u5236", true);
		Button button2 = createButton(parent, IDialogConstants.OK_ID, "È·¶¨", true);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StringSelection stsel = new StringSelection(lblNewLabel.getText());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
			}
		});
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 148);
	}
}
