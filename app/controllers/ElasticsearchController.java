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

    EsModel esModel;
    int messageLengthLimit;

  //Possibly move the length limit to the model? TODO
  public ElasticsearchController(){
    messageLengthLimit = 140;
    try{
      esModel = new EsModel();
    }
    catch(Exception e){System.out.println("COULD NOT CONSTRUCT ESMODEL");}
  }

  /**
  Creates a new message with the return from Elasticsearch and saves it.
  @param message model with message from the user.
  */
  public void Query(Message msg){

    String queryString = msg.getName();
    //Get queryResult as string from ES-Model
    String queryResult = esModel.getNextAnswer(queryString);
    while(queryResult.length()>messageLengthLimit){
      queryResult = esModel.getNextAnswer(queryString);
    }
    esModel.resetIndex();
    //Message to return
    // Message message = new Message();
    // //Set return-message text to query result
    // message.setMessage(queryResult);
    // //Save return-message for view
    // message.save();

    Answer answer = new Answer(); 
    answer.setAnswer(queryResult); 
    answer.setMessage(msg); 
    answer.save(); 
  }
}
