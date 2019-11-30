package eazy.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import eazy.business.BusinessException;
import eazy.data.ParkData;
import eazy.data.UserData;
import eazy.ui.command.Command;
import eazy.ui.command.ConsultCommand;
import eazy.ui.command.PaymentCommand;
import eazy.ui.command.ReserveCommand;

public class MainInterface {
	
	private final int NUM_OPCOES = 3;
	protected final Map<Integer, UIAction> actions;
	protected Log log;
	
	public MainInterface() {
		UserData userData = new UserData();
		ParkData parkData = new ParkData(true, userData.getUsers());
		this.actions = new LinkedHashMap<>();
		actions.put(1, new ConsultCommand(this, parkData));
		actions.put(2, new ReserveCommand(this, parkData));
		actions.put(3, new PaymentCommand(this, parkData));
	}
	
	private String getMenu() {
		StringBuffer sb = new StringBuffer(); //poe numa lista o menu

		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.menu"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.1"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.allocation"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.2"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.assign.notes"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.3"));
		sb.append(UIUtils.INSTANCE.getTextManager().getText("menu.products.selection"));
		sb.append("\n");
		
		sb.append(UIUtils.INSTANCE.getTextManager().getText("message.ask.option"));
		
		return sb.toString();
	}
	
	public void showMenu() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print(getMenu());
		Integer option = uiUtils.readInteger(null);
		while (option != 0) {
			if (option > 0 && option <= NUM_OPCOES) {
				Command command = (Command) actions.get(option);
				try {
					command.execute();
				} catch (BusinessException be) {
					System.out.println(uiUtils.getTextManager().getText(
							be.getMessage(), be.getArgs()));
					
				} catch (Exception e) {
					uiUtils.handleUnexceptedError(e);
				}
			}
			System.out.print(getMenu());			
			option = uiUtils.readInteger(null);
		}
	}
	
	

}
