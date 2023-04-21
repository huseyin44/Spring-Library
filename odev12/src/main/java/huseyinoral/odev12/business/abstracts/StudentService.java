package huseyinoral.odev12.business.abstracts;

import java.util.List;
import java.util.Optional;

import huseyinoral.odev12.request.RequestStudent2;
import huseyinoral.odev12.request.RequestStundetIdAndName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.request.RequestStudent;


@Repository
public interface StudentService {
	
	String SUCCESS_MESSAGE = "Success";
	String FAIL_MESSAGE="Fail";
	
	DataResult<List<StudentDto>> getAll();
	DataResult add(StudentDto studentDto);
	DataResult update(StudentDto studentDto);
	DataResult<StudentDto> delete(StudentDto studentDto,int id);
	
	DataResult<StudentDto> getByStudentName(RequestStudent requestStudent);
	//DataResult<StudentDto> getByStudentNameAndStId(RequestStudentNameAndStId requestStudentNameAndStId);
	//DataResult<StudentDto> getByStudentNameAndStId(String studentName, int id);
	
	boolean existsByTc(String tc);
	
	DataResult<Optional<StudentDto>> findByStIdAndAgeGreaterThan(RequestStudent requestStudent);

	StudentDto findByStIdAndStudentName(RequestStundetIdAndName requestStudent);

	StudentDto findByStIdOrStudentNameOrStudentSurnameOrTc(RequestStudent requestStudent);

	StudentDto getByStudentName2 (RequestStudent2 requestStudent);
}
