package huseyinoral.odev12.api.controllers;

import huseyinoral.odev12.business.abstracts.StudentService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.request.RequestStudent;
import huseyinoral.odev12.request.RequestStudent2;
import huseyinoral.odev12.request.RequestStundetIdAndName;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/students") //düzelticek
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/getall")
    public DataResult<List<StudentDto>> getAll() {
        DataResult<List<StudentDto>> students = this.studentService.getAll();
        return students;
    }

    @PostMapping("/add")
    public Result add(@RequestBody StudentDto studentDto) {
        return this.studentService.add(studentDto);
    }

    @PutMapping("/update")
    public Result update(@RequestBody StudentDto studentDto) {
        return this.studentService.update(studentDto);
    }

    @DeleteMapping("/delete")
    public Result delete(StudentDto studentDto, @RequestParam int id) {
        return this.studentService.delete(studentDto, id);
    }

    //validasyon
    //request param içine classs verek istek at
    //@RequestParam String studentName,@RequestParam int id
    //requestparam fieldlar için kullanılıyor
    @GetMapping(value = "/getByStudentName")
    public DataResult<StudentDto> getByStudentName(RequestStudent requestStudent) {
        return this.studentService.getByStudentName(requestStudent);
    }

    @GetMapping(value = "/findByStIdAndAgeGreaterThan")
    public DataResult<Optional<StudentDto>> findByStIdAndAgeGreaterThan(@Valid RequestStudent requestStudent) {
        return this.studentService.findByStIdAndAgeGreaterThan(requestStudent);
    }

    @GetMapping(value = "/findByStIdAndStudentName")
    public StudentDto findByStIdAndStudentName(@RequestBody @Valid RequestStundetIdAndName requestStudent) {
        return this.studentService.findByStIdAndStudentName(requestStudent);
    }

    @GetMapping(value = "/findByStIdOrStudentNameOrStudentSurnameOrTc")
    public StudentDto findByStIdOrStudentNameOrStudentSurnameOrTc(@Valid @RequestBody RequestStudent requestStudent) {
        return this.studentService.findByStIdOrStudentNameOrStudentSurnameOrTc(requestStudent);
    }

    @GetMapping(value = "/findByStIdAndStudentName222")
    public StudentDto getByStudentName2(@RequestBody RequestStudent2 requestStudent) {
        return this.studentService.getByStudentName2(requestStudent);
    }
}
