
package huseyinoral.odev12.business.concretes;

import huseyinoral.odev12.business.abstracts.StudentService;
import huseyinoral.odev12.core.exception.NullBookNameException;
import huseyinoral.odev12.core.exception.ProblemDetails;
import huseyinoral.odev12.core.exception.ValidationProblemsDetails;
import huseyinoral.odev12.core.properties.ErrorProperties;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dataAccess.abstracts.StudentDao;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Student;
import huseyinoral.odev12.mapStruct.StudentMapper;
import huseyinoral.odev12.request.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RestControllerAdvice  //Valdation çalışması için
@Component
public class StudentManager implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ErrorProperties errorProperties;

	private final ModelMapper modelMapper = new ModelMapper();
	private final StudentMapper studentMapper;

	
	private String successMessageCode;
	private String failCodeStudentId;
	private String failStudentId;
	private String failCodeStudentIdAndAge;
	private String failStudentIdAndAge;
	private String failStudentIdNull;
	
	
	@Autowired
	public StudentManager(StudentDao studentDao, StudentMapper studentMapper, @Value("${app.config.success}") String successMessageCode,
						  @Value("${app.config.failCodeStudentId}") String failCodeStudentId, @Value("${app.config.failStudentId}") String failStudentId, @Value("${app.config.failCodeStudentIdAndAge}") String failCodeStudentIdAndAge
			, @Value("${app.config.failStudentIdAndAge}") String failStudentIdAndAge, @Value("${app.config.failStudentIdNull}") String failStudentIdNull
			, ErrorProperties errorProperties) {
		super();
		this.studentDao = studentDao;
		this.studentMapper = studentMapper;
		this.successMessageCode = successMessageCode;
		this.failCodeStudentId = failCodeStudentId;
		this.failStudentId = failStudentId;
		this.failCodeStudentIdAndAge = failCodeStudentIdAndAge;
		this.failStudentIdAndAge = failStudentIdAndAge;
		this.failStudentIdNull=failStudentIdNull;
		this.errorProperties=errorProperties;

	}
	
	@Override
	public DataResult<List<StudentDto>> getAll() {
		List<Student> students=this.studentDao.findAll();
		//List<StudentDto> sDto=students.stream().map(student -> modelMapper.map(student,StudentDto.class)).collect(Collectors.toList()); //MODELMAPPER
		List<StudentDto> dtos = students.stream().map(student -> studentMapper.map(student)).toList(); //toList yerine .collect(Collectors.toList()); buda kullanılaryor ama eski sürümü
		return new SuccesDataResult(dtos,successMessageCode,SUCCESS_MESSAGE,"Students Listelendi");
	}

	@Override
	@Transactional
	public DataResult add(StudentDto studentDto) {
		
		//Student student=modelMapper.map(studentDto, Student.class); //MODELMAPPER
		Student student = studentMapper.map(studentDto); //MapStruct
		
		
		if(student.getStudentName()==null  ) {
			throw new NullBookNameException("500","Fail","studentName NULL olmamalı");
		}
		
		else if(student.getStudentName().length()==0) {
			throw new NullBookNameException("501","Fail","studentName boş olmamalı");
		}
		
		else if(student.getStudentSurname()==null  ) {
			throw new NullBookNameException("502","Fail","studentSurname NULL olmamalı");
		}
		
		else if(student.getStudentSurname().length()==0) {
			throw new NullBookNameException("503","Fail","studentSurname Boş olmamalı");
		}
		
		else if(student.getTc().length()!=11) {
			throw new NullBookNameException("520","Fail","TC 11 HANE OLMALI");
		}
		
		else if(studentDao.existsByTc(student.getTc())==true) {
			throw new NullBookNameException("550","Fail","KAYITLI TC");
		}
		
		this.studentDao.save(student);
		
		return new SuccesDataResult(studentDao.findById(student.getStId()).get(),"0000","Succes","Student Eklendi");
	}

	@Override
	public DataResult update(StudentDto studentDto) {
		
		//Student student=modelMapper.map(studentDto, Student.class);
		Student student = studentMapper.map(studentDto); //MapStruct
		
		if(student.getStudentName()==null  ) {
			throw new NullBookNameException("505","Fail","studentName NULL olmamalı UPDATE FAIL");
		}
		
		else if(student.getStudentName().length()==0) {
			throw new NullBookNameException("506","Fail","studentName boş olmamalı UPDATE FAIL");
		}
		
		else if(student.getStudentSurname()==null  ) {
			throw new NullBookNameException("507","Fail","studentSurname NULL olmamalı UPDATE FAIL");
		}
		
		else if(student.getStudentSurname().length()==0) {
			throw new NullBookNameException("508","Fail","studentSurname Boş olmamalı UPDATE FAIL");
		}
		
		else if(student.getStId()<0 ) {
			throw new NullBookNameException("510","Fail","studentSurname Boş olmamalı UPDATE FAIL");
		}
		
		else if(studentDao.findById(student.getStId()).orElse(null)==null) {
			throw new NullBookNameException("511","Fail","studentId Bulanamadı UPDATE FAIL");
		}
		
		this.studentDao.save(student);
		return new SuccesDataResult(studentDao.findById(student.getStId()).get(),"0000","Succes","Student Güncellendi");
	}

	@Override
	public DataResult<StudentDto> delete(StudentDto studentDto,int id) {
		
		//Student student=modelMapper.map(studentDto, Student.class);
		Student student = studentMapper.map(studentDto); //MapStruct
		
		if(studentDao.findById(student.getStId()).orElse(null) == null ) {
			throw new NullBookNameException("512","Fail","studentId Bulanamadı DELETE FAIL");
		}
		
		this.studentDao.deleteById(id);
		return new SuccesDataResult(student,"0000","Succes","Student Silindi") ;
	}
	
	@Override
	public DataResult<StudentDto> getByStudentName(RequestStudent requestStudent) {
		//System.out.println(requestStudent+"sadasdsa");
		//if(studentDao.findById(requestStudentNameAndStId.getStId()).orElse(null) == null) {
			//throw new NullBookNameException("411","Fail","Id Bulanamadı");
		//}
		
		
		//else if(!studentDao.findById(requestStudentNameAndStId.getStId()).get().getStudentName().equals(requestStudentNameAndStId.getStudentName()) ) {
			//throw new NullBookNameException("410","Fail","Id Ve StudentName Aynı Olan Öğrenci Bulanamadı");
		//}
		
		return new SuccesDataResult(studentDao.getByStudentName(requestStudent.getStudentName()),"0000","Succes","Data Listelendi");
	}

	@Override
	public boolean existsByTc(String tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataResult<Optional<StudentDto>> findByStIdAndAgeGreaterThan( RequestStudent requestStudent) {
		
		Optional.ofNullable(requestStudent.getStId()).orElseThrow(()->  new NullBookNameException(errorProperties.toString(),FAIL_MESSAGE,failStudentIdNull));
		//optional ofnullable yerine of 
		Optional.ofNullable(studentDao.findById(requestStudent.getStId()).orElseThrow(()->  new NullBookNameException(failCodeStudentId,FAIL_MESSAGE,failStudentId)));
		
		Optional.ofNullable(studentDao.findByStIdAndAgeGreaterThan(requestStudent.getStId(),requestStudent.getAge()))
					.orElseThrow(()->  new NullBookNameException(failCodeStudentIdAndAge,FAIL_MESSAGE,failStudentIdAndAge));
	
		Student student=studentDao.findByStIdAndAgeGreaterThan(requestStudent.getStId(),requestStudent.getAge());
		StudentDto studentDto = studentMapper.map(student);
		Optional<StudentDto> getStudent=Optional.of(studentDto);
		
		return new SuccesDataResult<>(getStudent, successMessageCode, SUCCESS_MESSAGE, "Data Listelendi");
		
	}

	@Override
	public StudentDto findByStIdAndStudentName( RequestStundetIdAndName requestStudent) {

		Student student=studentDao.findByStIdAndStudentName(requestStudent.getStId(),requestStudent.getStudentName());
		StudentDto studentDto=studentMapper.map(student);

		return studentDto;
	}

	@Override
	public StudentDto findByStIdOrStudentNameOrStudentSurnameOrTc(RequestStudent requestStudent) {
		Student student=studentDao.findByStIdOrStudentNameOrStudentSurnameOrTc(requestStudent.getStId(),requestStudent.getStudentName(),requestStudent.getStudentSurname(),requestStudent.getTc());
		StudentDto studentDto=studentMapper.map(student);

		return studentDto;
	}

	@Override
	public StudentDto getByStudentName2( RequestStudent2 requestStudent) {
		requestStudent.validateStudentIdVeName();
		Student student=studentDao.findByStIdAndStudentName(requestStudent.getStudentIdVeName().getStId(), requestStudent.getStudentIdVeName().getStudentName());
		StudentDto studentDto=studentMapper.map(student);
		return studentDto;
	}

	@ExceptionHandler
	public ProblemDetails problemDetails(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemsDetails validationProblemsDetails=new ValidationProblemsDetails();
		validationProblemsDetails.setMessage("VALIDATION EXCEPTION");
		validationProblemsDetails.setValidationErrors(new HashMap<String,String>());  //hangi alan ,ne hatası var

		for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemsDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());//ilki hangi kolon digeri hata bilgisi
		}
		return validationProblemsDetails;
	}
}