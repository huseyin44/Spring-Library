package huseyinoral.odev12.entities.concretes;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity //entity anatasyonu sayesinde veri tabanı coonectionları birlikte bu sınıfın veritabanı olduğunu söylüyorum
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String bookName;
	
	@Column(name="author")
	private String bookWriter;
	
	//@OneToMany(mappedBy="book")
	//private List<StudentBook> studentBooks;
	
	public Book() {};
	
}
