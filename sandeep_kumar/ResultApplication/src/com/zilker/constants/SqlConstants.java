package com.zilker.constants;

public class SqlConstants {
	public static final String GET_RESULTS_BY_ID_NOT_APPLIED = "SELECT * FROM result_details WHERE student_registration_number=? AND written_in=? AND grade <> 'S' AND result_id NOT IN (SELECT result_id FROM revaluation_details)";
	public static final String GET_RESULTS_BY_ID = "SELECT * FROM result_details WHERE student_registration_number=? AND written_in=?";
	public static final String GET_REVAL_DETAILS_BY_STUDENT_ID = "SELECT DISTINCT revaluation_details.revaluation_id,result_details.subject_code,revaluation_details.revaluation_status,revaluation_details.updated_grade FROM revaluation_details,result_details,student_details WHERE result_details.student_registration_number=? AND result_details.result_id=revaluation_details.result_id AND written_in=?";
	public static final String GET_REVAL_DETAILS_BY_SUBJECT = "SELECT distinct revaluation_details.revaluation_id,result_details.subject_code,revaluation_details.revaluation_status,revaluation_details.updated_grade FROM revaluation_details,result_details,student_details,faculty_details,faculty_subject_details WHERE revaluation_details.result_id = result_details.result_id AND student_details.student_registration_number = result_details.student_registration_number AND student_details.college_code = ? AND revaluation_details.revaluation_status='applied' AND result_details.subject_code IN (SELECT faculty_subject_details.subject_code FROM faculty_subject_details WHERE faculty_registration_number =?)";
	public static final String GET_ALL_APPROVED_REVAL_REQUEST = "SELECT distinct revaluation_details.revaluation_id,result_details.subject_code,revaluation_details.revaluation_status,revaluation_details.updated_grade FROM revaluation_details,result_details WHERE revaluation_status='approved' AND revaluation_details.result_id = result_details.result_id";
	public static final String GET_RESULT_BY_DEPT = "SELECT * FROM result_details,student_details WHERE result_details.student_registration_number=student_details.student_registration_number AND student_details.college_code=? AND student_details.department=? AND result_details.written_in=?";
	public static final String INSERT_STUDENT = "INSERT INTO student_details values(?,?,?,?,?)";
	public static final String INSERT_FACULTY = "INSERT INTO faculty_details values(?,?,?,?)";
	public static final String INSERT_COLLEGE = "INSERT INTO college_details values(?,?)";
	public static final String REGISTER_STUDENT = "INSERT INTO login_details (registration_number, user_password, role) values(?,?,?)";
	public static final String REGISTER_FACULTY = "INSERT INTO login_details (registration_number, user_password, role) values(?,?,?)";
	public static final String LOGIN = "SELECT * FROM login_details WHERE registration_number=? AND user_password=?";
	public static final String SELECT_STUDENT = "SELECT * FROM student_details WHERE student_registration_number=?";
	public static final String SELECT_FACULTY = "SELECT * FROM faculty_details WHERE faculty_registration_number=?";
	public static final String INSERT_RESULT = "INSERT INTO result_details (student_registration_number, subject_code, grade, written_in) values(?,?,?,?)";
	public static final String APPLY_REVAL = "INSERT INTO revaluation_details (result_id, revaluation_status) values(?,?)";
	public static final String REVAL_COUNT = "SELECT count(*) FROM revaluation_details,result_details WHERE revaluation_details.result_id=result_details.result_id AND result_details.student_registration_number=? AND result_details.written_in=?";
	public static final String UPDATE_STATUS_BY_FACULTY = "UPDATE revaluation_details set revaluation_status=? WHERE revaluation_id=?";
	public static final String UPDATE_GRADE = "UPDATE revaluation_details set updated_grade=?,revaluation_status=? WHERE revaluation_id=?";
	public static final String CURRENT_GRADE = "SELECT result_details.grade FROM result_details,revaluation_details WHERE result_details.result_id=revaluation_details.result_id AND revaluation_details.revaluation_id=?";
	public static final String INSERT_SUBJECT = "INSERT INTO subject_details values(?,?)";
	public static final String DELETE_STUDENT = "DELETE FROM student_details WHERE student_registration_number=?";
	public static final String DELETE_FACULTY = "DELETE FROM faculty_details WHERE faculty_registration_number=?";
	public static final String DELETE_SUBJECT = "DELETE FROM subject_details WHERE subject_code=?";
	public static final String DELETE_COLLEGE = "DELETE FROM college_details WHERE college_code=?";
	public static final String INSERT_FACULTY_SUBJECT = "INSERT INTO faculty_subject_details values (default,?,?)";
	public static final String DELETE_FACULTY_SUBJECT = "DELETE FROM faculty_subject_details WHERE faculty_subject_id=?";
	public static final String GET_SUBJECTS_NOT_ENROLLED = "SELECT distinct subject_code,subject_name FROM subject_details WHERE subject_code NOT IN (SELECT subject_code FROM faculty_subject_details WHERE faculty_registration_number = ?)";
	public static final String GET_ALL_STUDENT_DETAILS="SELECT * FROM student_details";
	public static final String GET_ALL_FACULTY_DETAILS="SELECT * FROM faculty_details";
	public static final String GET_ALL_SUBJECT_DETAILS="SELECT * FROM subject_details";
	public static final String GET_ALL_COLLEGE_DETAILS="SELECT * FROM college_details";
	public static final String GET_SUBJECTS_ENROLLED="SELECT * FROM faculty_subject_details,subject_details WHERE faculty_registration_number=? AND subject_details.subject_code=faculty_subject_details.subject_code";
}
