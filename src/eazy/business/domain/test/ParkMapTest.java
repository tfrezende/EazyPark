package eazy.business.domain.test;

public class ParkMapTest {
	ParkMap pMap;
	
	@Before
	public void setUp() throws Exception {
		pMap = new ParkMap(null, null, null);
	}
	
	@Test
	public void testGetSpaceMap(){		
		assertNotNull(pMap.getSpaceMap());
		assertFalse(pMap.getSpaceMap().isEmpty());
	}
	
	@Test
	public void testGetName() {
		assertNotNull(pMap.getName());
		assertFalse(pMap.getName() == "");
	}
	
	@Test
	public void testGetId() {
		assertNotNull(pMap.getId());
		assertFalse(pMap.getId() == 0);
	}
	
	@Test
	public void testGetAdress() {
		assertNotNull(pMap.getAddress());
		assertFalse(pMap.getAddress() == "");
	}
}
