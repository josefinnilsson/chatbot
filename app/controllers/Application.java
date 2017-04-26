package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import models.*;
import views.html.*;
import static play.libs.Json.toJson;
import java.util.*;
import com.avaje.ebean.Model;
import javax.inject.Inject;
import play.data.FormFactory;
import play.data.DynamicForm;

public class Application extends Controller {

	@Inject
	private FormFactory formFactory;
	private ElasticsearchController esController = new ElasticsearchController();

	public Result index() {
		return ok(index.render("Index"));
	}

	public Result help() {
		return ok(help.render("Help"));
	}

	public Result addMessage() {
		Form<Message> messageForm = formFactory.form(Message.class);
		Message message = messageForm.bindFromRequest().get();
		message.save();
		//Ultimately queries ES
		esController.Query(message);
		return redirect(routes.Application.index());
	}

	public Result getMessages() {
		Model.Finder<Integer, Message> finder = new Model.Finder<>(Message.class);
		List<Message> messages = finder.all();
		return ok(toJson(messages));
	}

	public Result getAnswers() {
		Model.Finder<Integer, Answer> answerFinder = new Model.Finder<>(Answer.class); 
		List<Answer> answers = answerFinder.all(); 
		return ok(toJson(answers)); 
	}
}
