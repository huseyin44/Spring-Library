package huseyinoral.odev12.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import huseyinoral.odev12.request.RequestStundetIdAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.request.RequestStudent;



@Repository
public interface StudentDao  extends JpaRepository<Student,Integer> {
	
	//Student getByStudentNameAndStId(String studentName,int id);  //select * from students where student_name= studentName
	Student getByStudentName(String studentName);
	boolean existsByTc(String tc);
	
	Student findByStIdAndAgeGreaterThan(int stId, int age );

	Student findByStIdAndStudentName(int stId,String studentName);

	Student findByStIdOrStudentNameOrStudentSurnameOrTc(int stId,String studentName,String studentSurname,String tc );
	
}
