package uk.ac.ed.inf.pepa.eclipse.ui.actions;

import org.eclipse.jface.action.IAction;

public class ReversibilityVerifyDelegate extends BasicProcessAlgebraModelActionDelegate{

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		ActionCommands.checkReversibility(model);
	}

	@Override
	protected void checkStatus() {
		this.action.setEnabled(this.model.isDerivable());
	}

}
