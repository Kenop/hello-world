
public class RegisterCourseControl {
	private DataManager dm;
	
	public RegisterCourseControl(DataManager dm) {this.dm = dm;}
	
	public int handleRegisterCourse(String studentId, String courseId) {
		// check of the course exists
		String[] courseInfo = dm.getCourseInfo(courseId);
		if (courseInfo == null) return 1; // error: course does not exist
		
		// check dupliacate registration
		String[] courseRegistration = dm.getCourseRegistration(studentId, courseId);
		if (courseRegistration != null) return 2; // error: same registration already exists
		
		// create new course registration
		dm.createCourseRegistration(studentId, courseId);
		return 0; // no error
	}
}
