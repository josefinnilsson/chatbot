import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;


public class Prototype{

String fileName = "qa-unique.txt";
BufferedReader br;

  public void input(){
        Scanner terminalInput = new Scanner(System.in);
    System.out.println("Hello! I am Dolores. Please ask me something");
    while(true){
      try{
        br = new BufferedReader(new FileReader(fileName));
      } catch(IOException e){
        System.out.println("File not found");
      }
      System.out.print(">");
      //get user input
      String question = terminalInput.nextLine();
      JSONObject result;
      do{
        result = questionMatcher(question,stringToJSON());
      }while(result == null);
      System.out.println(getAnswer(result));
    }
  }

/**
* Description of metho1
*
* @param  parameter1 Description of parameter1
* @param  parameter2 Description of parameter2
* @return      Description of return
*/

/**
* This method should handle trailing broken json elements
*
* @return      The next X TODO lines of the txt doc
*/
//TODO Metod som läser in från txt doc lite i taget allt eftersom man ber om det.
	public String readFromFile(){
    try{
      /*
      if(lineIndex != 0){
  			for (int i = 0;i<lineIndex ;i++ ) {
  				br.readLine();
  			}
  		}
  		lineIndex++;
      */
  		return br.readLine();
    }catch(IOException e){
      System.out.println("Something went wrong");
      return null;
    }
	}

/**
* Isolates separate Json elements and collects them in a collection
*
* @param      inData String in json format
* @return            Collection of separate strings which all are single json elements
*/
//TODO Metod som isolerar json elementen och lägger i samling
public JSONObject[] stringToJSON(){
  int size = 100;
  JSONObject[] jsons = new JSONObject[size];
  for(int i = 0 ; i < size ; i++){
    jsons[i] = new JSONObject(readFromFile());
  }
  return jsons;
}


/**
* Matches a json element from a list with a question
*
* @param  question
* @param  jsonList
* @return      jsonElem
*/
//TODO Metod som hårdmatchar frågor
public JSONObject questionMatcher(String question, JSONObject[] jsonList){
  question = question.replaceAll("[^a-öA-Ö0-9\\s]", "");
  String[] words = question.toLowerCase().split(" ");
  StringBuilder buildRegex = new StringBuilder();
  buildRegex.append(".*?");
  for(int i = 0 ; i < words.length ; i++){
    buildRegex.append(words[i]);
    if(i<(words.length-1))
      buildRegex.append("\\s.*?");
    else
      buildRegex.append(".*");

  }
  String reg = buildRegex.toString();
  System.out.println(reg);
  Pattern questionPattern = Pattern.compile(reg);
  for(JSONObject jsonElem : jsonList){
    Matcher matcher = questionPattern.matcher(jsonElem.getString("question").toLowerCase());
    if(matcher.find()) return jsonElem;
  }
  return null;
}



/**
* Isolates the first answer in a json element
*
* @param  jsonElem
* @return     answer
*/
//TODO Metod som plockar ut första svaret
	public String getAnswer(JSONObject elem) {
		JSONArray arr = elem.getJSONArray("answers");
		return arr.getString(0);
	}

}
