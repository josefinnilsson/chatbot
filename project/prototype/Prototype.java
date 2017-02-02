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

public class Prototype{
  public void go(){
  	System.out.println(readFromFile());
    System.out.println("hello MVK");
  }

/**
* Description of method
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
		StringBuilder sb = new StringBuilder();
		String fileName = "qa-unique.txt";
		int limit = 30;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			for (int i = 0; i < limit; i++) {
				sb.append(br.readLine());
			}
		}catch(IOException e){
			System.out.println("hoi");
		}
		return sb.toString();
	}

/**
* Isolates separate Json elements and collects them in a collection
*
* @param      inData String in json format
* @return            Collection of separate strings which all are single json elements
*/
//TODO Metod som isolerar json elementen och lägger i samling



/**
* Matches a json element from a list with a question
*
* @param  question
* @param  jsonList
* @return      jsonElem
*/
//TODO Metod som hårdmatchar frågor
public JSONObject questionMatcher(String question, JSONObject[] jsonList){
  String[] words = question.split(" ");
  StringBuilder buildRegex = new StringBuilder();
  buildRegex.append(".+?");
  for(int i = 0 ; i < words.length ; i++){
    buildRegex.append(words[i]);
    if(i<(words.length-1))
      buildRegex.append(".+?");
  }
  Pattern questionPattern = Pattern.compile(buildRegex.toString());
  for(JSONObject jsonElem : jsonList){
    Matcher matcher = questionPattern.matcher(jsonElem.getString("question"));
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
