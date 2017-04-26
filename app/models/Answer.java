package models; 

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Answer extends Model {

	@Id 
	public Integer id; 

	public String answer; 

	public Boolean positiveRating = false; 

	@OneToOne()
	@JoinColumn(name="id_message")
	public Message message; 

	public Answer(){}

	public Answer(String answer) {
		this.answer = answer; 
	}

	public String getAnswer() {
		return answer; 
	}

	public int getId() {
		return id; 
	}

	public void setAnswer(String answer) {
		this.answer = answer; 
	}

	public void setMessage(Message message) {
		this.message = message; 
	}
}