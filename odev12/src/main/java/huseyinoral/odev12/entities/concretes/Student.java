package huseyinoral.odev12.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int stId;
	
	@Column(name="tc")
	@NotNull
	private String tc;
	
	@Column(name="name")
	@NotNull
	private String studentName;
	
	@Column(name="surname")
	@NotNull
	private String studentSurname;
	
	@Column(name="age")
	private int age;

	
	public Student() {};
	
	
}