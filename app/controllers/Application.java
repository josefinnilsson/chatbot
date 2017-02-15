package controllers; 

import play.*; 
import play.mvc.*; 
import play.data.Form;
import models.*;
import views.html.*;

public class Application extends Controller {

	public Result index() {
		return redirect("path"); 
	}
	
	public Result addMessage() {
		Message message = Form.form(Message.class).bindFromRequest().get(); 
		message.save(); 
		return redirect(routes.Application.index()); 
	}
}