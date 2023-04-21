package huseyinoral.odev12.mapStruct;

import java.util.List;

import org.mapstruct.Mapper;

import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.entities.concretes.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	Student map(StudentDto studentDto);
    StudentDto map(Student student);
    
    List<StudentDto> mapList(List<Student> student);
    
}
