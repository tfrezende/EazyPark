package eazy.ui.command;

import eazy.data.ParkData;
import eazy.data.UserData;
import eazy.ui.MainInterface;
import eazy.ui.TextManager;
import eazy.ui.UIAction;
import eazy.ui.UIUtils;

public abstract class Command implements UIAction {

	private MainInterface mainInterface;
	protected ParkData parkData;
	protected UserData userData;
	private boolean isEnabled;

	public Command(MainInterface mainInterface, UserData userData, ParkData parkData) {
		this(mainInterface, userData, parkData, false);
	}

	public Command(MainInterface mainInterface, UserData userData, ParkData parkData, 
			boolean isEnabled) {
		this.setMainInterface(mainInterface);
		this.isEnabled = isEnabled;
		this.parkData = parkData;
		this.userData = userData;
	}

	protected TextManager getTextManager() {
		return UIUtils.INSTANCE.getTextManager();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public MainInterface getmainInterface() {
		return mainInterface;
	}

	public void setMainInterface(MainInterface mainInterface) {
		this.mainInterface = mainInterface;
	}
		
}
