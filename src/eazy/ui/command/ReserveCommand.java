package eazy.ui.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import eazy.business.domain.ParkMap;
import eazy.business.domain.ParkSpace;
import eazy.business.domain.Reservation;
import eazy.business.domain.User;
import eazy.data.ParkData;
import eazy.data.UserData;
import eazy.ui.MainInterface;
import eazy.ui.UIUtils;

public class ReserveCommand extends Command {
		

	private Scanner scanner;

	public ReserveCommand(MainInterface mainInterface, ParkData parkData, UserData userData) {
		super(mainInterface, parkData, userData);
	}

	@Override
	public void execute() throws Exception {
		
		ParkMap activeLot = selectParkingLot();
		User activeUser = userData.getUsers().get(3);
				
		displayMap(activeLot);
		
		ParkSpace activeSpace = selectActiveSpace(activeLot);		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		scanner = new Scanner(System.in);
		
		System.out.println("Defina a data inicial da reserva");
		System.out.println("Dia: ");
		String diaInicial = scanner.nextLine();
		System.out.println("Mes: ");
		String mesInicial = scanner.nextLine();
		System.out.println("Ano: ");
		String anoInicial = scanner.nextLine();
		
		System.out.println("Defina a data final da reserva");
		System.out.println("Dia: ");
		String diaFinal = scanner.nextLine();
		System.out.println("Mes: ");
		String mesFinal = scanner.nextLine();
		System.out.println("Ano: ");
		String anoFinal = scanner.nextLine();
		
		Date dataInicial = dateFormat.parse(diaInicial + "-" + mesInicial +
				"-" + anoInicial);		
		Date dataFinal = dateFormat.parse(diaFinal + "-" + mesFinal +
				"-" + anoFinal);
		
		//scanner.close();
		
		if(activeSpace.hasReservation(dataInicial, dataFinal)) {
			System.out.println("Erro: vaga indisponivel para esse periodo");
		}
		else {
			
			Reservation reservation = new Reservation(
					activeSpace.getReservations().size(),
					dataInicial, dataFinal, activeUser,
					activeSpace);
			
			activeSpace.getReservations().add(reservation);
			System.out.println("Reserva efetuada com sucesso para " + activeUser.getName());
		}
		
	}
	
	private ParkSpace selectActiveSpace(ParkMap lot) {
		Integer space = 0;
		scanner = new Scanner(System.in);
		do {
			System.out.println("Selecione uma vaga por ID");
			space = scanner.nextInt();
			
			
		}while(space < 0 || space >= lot.getSpaceMap().size());
		
		//scanner.close();
		
		return lot.getSpaceMap().get(space);
		
	}
	
	private ParkMap selectParkingLot() {
		
		scanner = new Scanner(System.in);
		Map<Integer, ParkMap> parkingLots = parkData.getParkingLots();
				
		for (Map.Entry<Integer, ParkMap> parkLot : parkingLots.entrySet()) {
			System.out.println(parkLot.getKey() + " - " + parkLot.getValue().getName());
		}
		Integer lot = 0;
		
		do {
			System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("message.ask.lot"));
			lot = scanner.nextInt();
			if(!parkingLots.containsKey(lot)) {
				System.out.println("Estacionamento invalido");
			}
		}while(!parkingLots.containsKey(lot));
		
		//scanner.close();
		
		return parkingLots.get(lot);
		
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
