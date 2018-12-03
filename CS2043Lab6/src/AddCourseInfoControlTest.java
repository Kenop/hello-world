import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddCourseInfoControlTest {

	private DataManager dm;
	private AddCourseInfoControl control;
	
	@BeforeEach
	void setUp() throws Exception {
		dm = new DataManager();
		control = new AddCourseInfoControl(dm);
	}

	/*@Test
	void testHandleAddCourseInfo() {
		fail("Not yet implemented");
	}*/
			
	@Test
	void testHandleAddCourseInfoCase1() {
		int errorCode = control.handleAddCourseInfo("CS2043", "Software Engineering");
		assertEquals(0, errorCode);
		String[] expected = {"CS2043", "Software Engineering"};
		String[] returned = dm.getCourseInfo("CS2043");
		assertArrayEquals(expected, returned);
	}
	
	@Test
	void testHandleAddCourseInfoCase2() {
		dm.createCourseInfo("CS2043", "Software Engineering");
		dm.createCourseInfo("CS1073", "Introduction to Java");
		int errorCode = control.handleAddCourseInfo("CS2043", "Software");
		assertEquals(1, errorCode);
		String expected = "CS2043";
		String[] returned = dm.getCourseInfo("CS2043");
		assertEquals(expected, returned[0]);
	}

}
