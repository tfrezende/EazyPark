package eazy.ui.command;

import eazy.business.BusinessException;
import eazy.business.domain.EvalGroup;
import eazy.data.Database;
import eazy.data.ParkData;
import eazy.data.UserData;
import eazy.ui.MainInterface;
import eazy.ui.UIUtils;

public class ConsultCommand extends Command {
	
	private EvalGroup evalGroup;
	private final int MIN_MEMBERS = 2;
	private final int MAX_MEMBERS = 5;

	public ConsultCommand(MainInterface mainInterface, ParkData parkData) {
		super(mainInterface, parkData);
	}

	public void execute() throws Exception {
		
		System.out.println("\n" + UIUtils.INSTANCE.getTextManager().getText("menu.allocation"));
		
		String group = UIUtils.INSTANCE.readString("message.ask.group");
		
		evalGroup = database.getGroup(group);
		
		testAllocation(evalGroup);
		
		Integer numReviewers = UIUtils.INSTANCE.readInteger("message.ask.num.evaluators");
		testNumReviewers(numReviewers);				
		
		evalGroup.allocate(numReviewers);
		
	}
	
	public void testAllocation(EvalGroup group) throws Exception {
		if (evalGroup.isAllocated()) {
			throw new BusinessException("exception.allocated.group");
		}
	}
	
	public void testNumReviewers(Integer numReviewers) throws Exception {
		if(numReviewers < MIN_MEMBERS || numReviewers > MAX_MEMBERS) {
			throw new BusinessException("exception.invalid.reviewers");
		}
	}
	
}