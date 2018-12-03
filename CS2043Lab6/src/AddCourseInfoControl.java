
public class AddCourseInfoControl {
	private DataManager dm;
	
	public AddCourseInfoControl(DataManager dm) {this.dm = dm;}
	
	int handleAddCourseInfo(String courseId, String courseTitle) {
		// check duplicate course info
		String[] courseInfo = dm.getCourseInfo(courseId);
		if (courseInfo != null) return 1; // error: course info already exists
		
		// create new course info
		dm.createCourseInfo(courseId, courseTitle);
		return 0; // no error
	}
}
