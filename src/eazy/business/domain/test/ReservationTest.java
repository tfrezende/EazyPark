package eazy.business.domain.test;

public class ReservationTest {
	Reservation reser;
	
	@Before
	public void setUp() throws Exception {
		reser = new Reservation(null, null, null, null, null);
	}
	
	@Test
	public void testGetId() {
		assertNotNull(reser.getId());
		assertFalse(reser.getId() == 0);
	}
	
	@Test
	public void testGetStartDate() {
		assertNotNull(reser.getStartDate());
		assertFalse(reser.getStartDate() == 0);
	}
	
	Test
	public void testGetEndDate() {
		assertNotNull(reser.getEndDate());
		assertFalse(reser.getEndDate() == 0);
	}
	
	@Test
	public void testGetUser() {
		assertNotNull(reser.getUser());
		assertFalse(reser.getUser() == "");
	}
	
	@Test
	public void testGetSpace(){		
		assertNotNull(reser.getSpace());
		assertFalse(reser.getSpace().isEmpty());
	}

}