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

/*
This controller talks with the Elasticsearch model.
*/
public class ElasticsearchController extends Controller {
  EsModel esModel = new EsModel();

  public ElasticsearchController(){
  }

  /**
  Creates a new message with the return from Elasticsearch and saves it.
  @param message model with message from the user.
  */
  public void Query(Message msg){
    //Message to return
    Message message = new Message();
    String queryString = msg.getName();
    //Get queryResult as string from ES-Model
    String queryResult = esModel.getAnswer(queryString);
    //Set return-message text to query result
    message.setMessage(queryResult);
    //Save return-message for view
    message.save();
  }
}
