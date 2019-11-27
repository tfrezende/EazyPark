package eazy.ui.command;

import eazy.data.Database;
import eazy.ui.MainInterface;
import eazy.ui.TextManager;
import eazy.ui.UIAction;
import eazy.ui.UIUtils;

public abstract class Command implements UIAction {

	private MainInterface catalogueInterface;
	protected Database database;
	private boolean isEnabled;

	public Command(MainInterface catalogueInterface, Database database) {
		this(catalogueInterface, database, false);
	}

	public Command(MainInterface catalogueInterface, Database database,
			boolean isEnabled) {
		this.setCatalogueInterface(catalogueInterface);
		this.isEnabled = isEnabled;
		this.database = database;
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

	public MainInterface getCatalogueInterface() {
		return catalogueInterface;
	}

	public void setCatalogueInterface(MainInterface catalogueInterface) {
		this.catalogueInterface = catalogueInterface;
	}
		
}
