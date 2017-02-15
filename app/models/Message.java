package models; 

import java.util.*; 
import javax.persistence.*;  
import com.avaje.ebean.Model; 
import play.data.format.*; 
import play.data.validation.*; 

@Entity
public class Message extends Model {
	@Id
	public String id; 

	@Constraints.Required
	public String message; 
}