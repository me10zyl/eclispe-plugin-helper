package pluginhelper.popup.actions;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IMarkSelection;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class AlertObjectAction implements IObjectActionDelegate {

	private Shell shell;
	private IWorkbenchPart targetPart;
	
	/**
	 * Constructor for Action1.
	 */
	public AlertObjectAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
		this.targetPart = targetPart;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		AlertObjectDialog alertDialog = new AlertObjectDialog(shell);
		alertDialog.create();
		ISelection selection = targetPart.getSite().getSelectionProvider().getSelection();
		if(selection instanceof IStructuredSelection)
		{
			alertDialog.getLblNewLabel().setText(((IStructuredSelection)selection).getFirstElement().getClass().toString().substring(6));
		}else if(selection instanceof IMarkSelection)
		{
			alertDialog.getLblNewLabel().setText(((IMarkSelection)selection).getClass().toString().substring(6));
		}else if(selection instanceof ITextSelection)
		{
			alertDialog.getLblNewLabel().setText(((ITextSelection)selection).getText().toString().substring(6));
			alertDialog.getLblNewLabel().setText("这是一个编辑框");
		}
		alertDialog.open();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
