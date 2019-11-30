package eazy.data;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import eazy.business.domain.Address;
import eazy.business.domain.User;


public class UserData {

	private Map<Integer, User> users;	
	private final Log log;
	
	public UserData() {
		this(true);
	}
	
	public UserData(boolean initData) {
		this.log = LogFactory.getLog(getClass());
		this.users = new HashMap<Integer, User>();
		if(initData) {
			initData();
		}
	}
	
	public Map<Integer, User> getUsers() {
		return users;
	}

	public void initData() {
		try {
			
			Random r = new Random();
			users.put(1, new User("Erick", "senha", r.nextInt(), 0, 
					new Address("Rua 29", "321", "90520-001"),
					"51993535338"));
			users.put(2, new User("Lucas", "12345", r.nextInt(), 0, 
					new Address("Rua 24", "453", "90630-001"),
					"51993535339"));
			users.put(3, new User("Thalles", "abcde", r.nextInt(), 0, 
					new Address("Rua 27", "250", "90890-002"),
					"51993535340"));
			users.put(4, new User("Ingrid", "tcp", r.nextInt(), 0, 
					new Address("Rua 30", "372", "90520-002"),
					"51993535341"));
			users.put(5, new User("Joao", "arq2", r.nextInt(), 0, 
					new Address("Rua 60", "176", "90120-002"),
					"51993535342"));
			users.put(6, new User("Sergio", "sisop1", r.nextInt(), 0, 
					new Address("Rua 50", "16", "90360-002"),
					"51993535343"));
			users.put(7, new User("Luigi", "orgb", r.nextInt(), 0, 
					new Address("Rua 70", "256", "90310-002"),
					"51993535344"));
			users.put(8, new User("Tristao", "ckt1", r.nextInt(), 0, 
					new Address("Rua 60", "99", "90120-001"),
					"51993535345"));
			users.put(9, new User("Fernanda", "sd", r.nextInt(), 0, 
					new Address("Rua 50", "317", "90360-001"),
					"51993535346"));
			users.put(10, new User("Roger", "teomag", r.nextInt(), 0, 
					new Address("Rua 40", "415", "90720-001"),
					"51993535347"));
			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
}
