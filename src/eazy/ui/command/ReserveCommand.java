package eazy.ui.command;

import java.util.ArrayList;
import java.util.List;

import eazy.business.BusinessException;
import eazy.business.domain.Evaluation;
import eazy.business.domain.Product;
import eazy.business.domain.Reviewer;
import eazy.data.Database;
import eazy.data.ParkData;
import eazy.data.UserData;
import eazy.ui.MainInterface;
import eazy.ui.UIUtils;

public class ReserveCommand extends Command {
	
	private List<Product> products = new ArrayList<>();
	private List<Reviewer> reviewers;
	

	public ReserveCommand(MainInterface mainInterface, ParkData parkData) {
		super(mainInterface, parkData);
	}

	@Override
	public void execute() throws Exception {
		final Integer MIN_VALUE = -3;
		final Integer MAX_VALUE = 3;
		
		products = database.getAllProducts();
		
		System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("menu.assign.notes"));
		
		System.out.println("--- Produtos registrados ---");
		for(Product regProd : products) {
			System.out.println(regProd.getId() + "\t" + regProd.getName());
		}
		
		Integer productId = UIUtils.INSTANCE.readInteger("message.ask.product");
		Product product = products.get(productId);

		reviewers = product.getReviewers();
		
		System.out.println("--- Avaliadores registrados ---");
		for(Reviewer regRev : reviewers) {
			System.out.println(regRev.getId() + "\t" + regRev.getName());
		}
		
		Integer reviewerId = UIUtils.INSTANCE.readInteger("message.ask.reviewer");
		
		Reviewer reviewer = null;
		
		for(Reviewer rev : reviewers) {
			if(rev.getId() == reviewerId) {
				reviewer = rev;
			}
		}
		
		if(reviewer == null) {
			throw new BusinessException("exception.reviewer.not.found");
		}
		else{
			Integer score = UIUtils.INSTANCE.readInteger("message.ask.score");
			
			if(score <= MIN_VALUE || score >= MAX_VALUE) {
				throw new BusinessException("exception.invalid.score");
			}
			else {
				Evaluation evaluation = new Evaluation(product.getGroup(), product, reviewer);
				product.addEvaluation(evaluation);
				product.addScore(reviewer, score);
				System.out.println("Nota registrada");
			}
			
		}
		
	}
	
}
