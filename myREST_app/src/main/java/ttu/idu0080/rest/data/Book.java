package ttu.idu0080.rest.data;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Digits;
import javax.validation.Valid;
import javax.validation.constraints.Size;


@Entity
@Table(name="BOOK")
public class Book implements java.io.Serializable  {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String name ;
	private String author ;
	private String pages ;
	private int published ;


	public Book() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPages() {
		return pages;
	}


	public void setPages(String pages) {
		this.pages = pages;
	}


	public int getPublished() {
		return published;
	}


	public void setPublished(int published) {
		this.published = published;
	}



}
