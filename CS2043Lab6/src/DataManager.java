import java.util.*;

// source code change test
// third change
public class DataNanager {
	
	int integer = 0;
	
	class CourseInfoData {
		String courseId;
		String courseTitle;
		CourseInfoData(String courseId, String courseTitle) {
			this.courseId = courseId;
			this.courseTitle = courseTitle;
		}
	}
	
	class CourseRegistrationData {
		String studentId;
		String courseId;
		CourseRegistrationData(String studentId, String courseId){
			this.studentId = studentId;
			this.courseId = courseId;
		}
	}
	
	private ArrayList<CourseInfoData> courseInfoTable = new ArrayList<CourseInfoData>();
	private ArrayList<CourseRegistrationData> courseRegistrationTable = new ArrayList<CourseRegistrationData>();
	
	public void createCourseInfo(String courseId, String courseTitle) {
		CourseInfoData courseInfo = new CourseInfoData(courseId, courseTitle);
		courseInfoTable.add(courseInfo);
	}
	
	public String[] getCourseInfo(String courseId) {
		for (int i = 0; i < courseInfoTable.size(); i++) {
			CourseInfoData courseInfo = courseInfoTable.get(i);
			if (courseInfo.courseId == courseId) {
				String[] courseInfoArray = new String[2];
				courseInfoArray[0] = courseInfo.courseId;
				courseInfoArray[1] = courseInfo.courseTitle;
				return courseInfoArray;
			}
		}
		return null;
	}

	public void createCourseRegistration(String studentId, String courseId) {
		CourseRegistrationData courseRegistration = new CourseRegistrationData(studentId, courseId);
		courseRegistrationTable.add(courseRegistration);
	}
	
	public String[] getCourseRegistration(String studentId, String courseId) {
		for (int i = 0; i < courseRegistrationTable.size(); i++) {
			CourseRegistrationData courseRegistration = courseRegistrationTable.get(i);
			if ((courseRegistration.studentId == studentId) && (courseRegistration.courseId == courseId)) {
				String[] courseRegistrationArray = new String[2];
				courseRegistrationArray[0] = courseRegistration.studentId;
				courseRegistrationArray[1] = courseRegistration.courseId;
				return courseRegistrationArray;
			}
		}
		return null;
	}
	
	public ArrayList<String> getCourseList(String courseId) {
		ArrayList<String> courseList = new ArrayList<String>();
		for (int i = 0; i < courseRegistrationTable.size(); i++) {
			CourseRegistrationData courseRegistration = courseRegistrationTable.get(i);
			if (courseRegistration.courseId == courseId) courseList.add(courseRegistration.studentId);
		}
		return courseList;
	}
}
