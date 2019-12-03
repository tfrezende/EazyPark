package eazy.business.domain.test;

public class ParkSpaceTest {
	ParkSpace pSpace;
	
	@Before
	public void setUp() throws Exception {
		pSpace = new ParkSpace(null, null);
	}
	
	@Test
	public void testIsAvailable() {
		assertNotNull(pSpace.isAvailable());
	}
	
	@Test
	public void testGetStatus() {
		assertNotNull(pSpace.getStatus());
	}
	
	@Test
	public void testGetUser() {
		assertNotNull(pSpace.getUser());
		assertFalse(pSpace.getUser() == "");
	}
	
	@Test
	public void testGetId() {
		assertNotNull(pSpace.getId());
		assertFalse(pSpace.getId() == 0);
	}
	
	@Test
	public void testGetHoursOccupied(){		
		assertNotNull(pSpace.getHoursOccupied());
		assertFalse(pSpace.getHoursOccupied().isEmpty());
	}
	
	@Test
	public void testGetReservations() {
		assertNotNull(pSpace.getReservations());
		assertFalse(pSpace.getReservations() == "");
	}
	
	@Test
	public void testCalculateCost() {
		assertNotNull(eval.calculateCost());
		assertTrue(eval.calculateCost(0) == 0);
		assertTrue(eval.calculateCost(3) == 15);
		assertTrue(eval.calculateCost(5) == 25);
		assertTrue(eval.calculateCost(10) == 50);
		assertFalse(eval.calculateCost(-1) == -5);
		assertFalse(eval.calculateCost(-10) == -50);
	}
	
	@Test
	public void testGetHourlyRate() {
		assertNotNull(pSpace.getHourlyRate());
		assertFalse(pSpace.getHourlyRate() == 0);
	}
	
	public void testGetParkingLot() {
		assertNotNull(pSpace.getParkingLot());
		assertFalse(pSpace.getParkingLot() == "");
	}
	
}
