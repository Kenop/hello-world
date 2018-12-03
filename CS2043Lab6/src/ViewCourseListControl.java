import java.util.*;

public class ViewCourseListControl {
	private DataManager dm;
	private ArrayList<String> courseList;
	
	public ViewCourseListControl(DataManager dm) {this.dm = dm;}
	
	public int handleViewCourseList(String courseId) {
		// check if the course exists
		String[] courseInfo = dm.getCourseInfo(courseId);
		if (courseInfo == null) return 1; // error: course dos not exists
		
		// get course list
		courseList = dm.getCourseList(courseId);
		return 0; // no error
	}
	
	public ArrayList<String> getCourseList() {return courseList;}
}
