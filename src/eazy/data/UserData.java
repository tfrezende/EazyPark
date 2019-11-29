package eazy.data;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class UserData {

	private final Log log;
	
	public UserData() {
		this(true);
	}
	
	public UserData(boolean initData) {
		this.log = LogFactory.getLog(getClass());
		
		if(initData) {
			initData();
		}
	}
	
	public void initData() {
		try {
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
}
