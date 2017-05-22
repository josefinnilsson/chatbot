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
    StaticMessage statMsg;
    EsModel esModel;
    int messageLengthLimit;

  //Possibly move the length limit to the model? TODO
  public ElasticsearchController(){
    messageLengthLimit = 255;
    try{
      esModel = new EsModel();
    }catch(Exception e){
      System.out.println("COULD NOT CONSTRUCT ESMODEL");
    }
    try{
      statMsg = new StaticMessage();
    }catch(Exception e){
      System.out.println("COULD NOT CONSTRUCT STATICMESSAGE");
    }
  }

  /**
  Creates a new message with the return from Elasticsearch and saves it.
  @param message model with message from the user.
  */
  public void Query(Message msg){

    String queryString = msg.getName();
    String queryResult;
    //Get static response
    queryResult = statMsg.getStaticMessage(queryString);
    //Get queryResult as string from ES-Model if static response is null
    if(queryResult == null){
      queryResult = esModel.getAnswer(queryString, messageLengthLimit);
    }
    Answer answer = new Answer();
    answer.setAnswer(queryResult);
    answer.setMessage(msg);
    answer.save();
  }
}
