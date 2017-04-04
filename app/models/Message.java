package models;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Message extends Model {
	@Id
	public Integer id;

	public String name;

	public Message(){}

	public Message(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public void setMessage(String name){
		this.name = name;
	}

}
