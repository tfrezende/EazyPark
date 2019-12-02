package eazy.ui.command;

import eazy.business.domain.ParkSpace;
import eazy.business.domain.Payment;
import eazy.business.domain.User;
import eazy.data.ParkData;
import eazy.ui.MainInterface;

public class PaymentCommand extends Command {

	public PaymentCommand(MainInterface mainInterface, ParkData parkData) {
		super(mainInterface, parkData);
	}

	@Override
	
	public void execute() throws Exception {
		
		ParkSpace activeSpace = parkData.getParkingLots().get(1).getSpaceMap().get(3);
		
		activeSpace.status = false;
		Payment payment = new Payment(activeSpace);
		User activeUser = activeSpace.getUser();
		System.out.println("--- RECIBO ---");
		System.out.println("Estacionamento: " + activeSpace.getParkingLot().getName());
		System.out.println("Vaga: " + activeSpace.getId());
		System.out.println("Usuario: " + activeSpace.getUser().getName());
		System.out.println("Tempo ocupado: " + activeSpace.getHoursOccupied() + " horas");
		System.out.println("Valor: " + payment.getValue());
		System.out.println("");
		
		System.out.println("--- DEBITO --");
		System.out.println("Credito anterior: " + activeUser.getCredit());
		System.out.println("Valor: " + payment.getValue());
		activeUser.setCredit(activeUser.getCredit() - payment.getValue());
		System.out.println("Credito atual: " + activeUser.getCredit());
		activeUser.getPayments().add(payment);
		
		activeSpace.setHoursOccupied(0.0);
	}
	
	
}
