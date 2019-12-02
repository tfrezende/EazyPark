package eazy.ui.command;

import java.util.Map;
import java.util.Scanner;

import eazy.business.domain.ParkMap;
import eazy.business.domain.ParkSpace;
import eazy.data.ParkData;
import eazy.ui.MainInterface;
import eazy.ui.UIUtils;

public class ConsultCommand extends Command {

	public ConsultCommand(MainInterface mainInterface, ParkData parkData) {
		super(mainInterface, parkData);
	}

	public void execute() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		Map<Integer, ParkMap> parkingLots = parkData.getParkingLots();
		
		System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("menu.consult"));
		System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("message.ask.lot"));
		
		for (Map.Entry<Integer, ParkMap> parkLot : parkingLots.entrySet()) {
			System.out.println(parkLot.getKey() + " - " + parkLot.getValue().getName());
		}
		Integer lot = 0;
		
		do {
			lot = scanner.nextInt();
			if(!parkingLots.containsKey(lot)) {
				System.out.println("Estacionamento invalido");
			}
		}while(!parkingLots.containsKey(lot));
		
		scanner.close();
		
		ParkMap activeLot = parkingLots.get(lot);
			
		displayMap(activeLot);		
		
	}
	
	private void displayMap(ParkMap lot) {
		System.out.println("Vagas:");
		for(ParkSpace space : lot.getSpaceMap()){
			if(space.getStatus()) {
				System.out.println(space.getId() + " - ocupada");
			}
			else {
				System.out.println(space.getId() + " - livre");
			}
		}
	}
	

	
}