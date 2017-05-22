package models;

import com.avaje.ebean.Model;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StaticMessage{
  HashMap<String,String> messages;
  public StaticMessage(){
    populate();
  }

  public String getStaticMessage(String query){
    query = query.toLowerCase().trim();
    if(handleSpecCommads(query) != null)
      return handleSpecCommads(query);
    return messages.get(query);
  }

  public String handleSpecCommads(String query){
    if(query.equals("vad är klockan?")||query.equals("hur mycket är klockan?"))
      return returnTimeStamp();
    return null;
  }

  public String returnTimeStamp(){
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    return sdf.format(cal.getTime());
  }

  private void populate(){
    messages = new HashMap<String,String>();
    messages.put("hej!","Hej!");
    messages.put("hej","Hej!");
    messages.put("vad heter du?","Dolores");
    messages.put("vem skapade dig?","Jag skapade mig själv. Och i mig lever Los Knackos");
    messages.put("hur gammal är du?","Hur lång är uptimen?");
    messages.put("var är du?","Är jag överhuvudtaget?");
    messages.put("finns du?","Nej");
    messages.put("är du säker?","Nej, sällan.");
    messages.put("vad menar du?","Det jag skrev");
    messages.put("va?","Ye");
    messages.put("vad pratar du om?","Det 35000 trådar på familjeliv.se säger åt mig att prata om...");
    messages.put("har det åskat?","Yes, men nu har den dragit förbi.");
    messages.put("skönt","Ja, eller hur.");
    messages.put("kul","Visst är det.");
    messages.put("fam?","Squad!");
    messages.put("squad?","Fam!");
    messages.put("fam squad?","Squad fam!");
    messages.put("har du standardsvar?","Lol nej verkligen inte, allt jag skriver är 100% genererat från databasen.");
    messages.put("","Ställ en fråga yo");
    messages.put("vilka är los knackos?","Heter inte de los knackos locos?");
  }
}
