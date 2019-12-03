package eazy.business.domain.test;

public class PaymentTest {
	Payment pay;
	
	@Before
	public void setUp() throws Exception {
		pay = new Payment(null);
	}
	
	@Test
	public void testGetUser() {
		assertNotNull(pay.getUser());
		assertFalse(pay.getUser() == "");
	}
	
	@Test
	public void testGetSpace(){		
		assertNotNull(pay.getSpace());
		assertFalse(pay.getSpace().isEmpty());
	}
	
	@Test
	public void testGetValue() {
		assertNotNull(pay.getValue());
		assertFalse(pay.getValue() == 0);
	}
	
	@Test
	public void testGetDate() {
		assertNotNull(pay.getDate());
		assertFalse(pay.getDate() == 0);
	}
		
}
