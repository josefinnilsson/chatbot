import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class SessionSaver {

  private Boolean logRating = true;
  private File sessionFile;
  private FileWriter fout;
  private String question;
  private String answer;
  private int rating;

  public SessionSaver() {
    //save session as session_yyyy-MM-dd-HHmmss.json
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
    Date dateobj = new Date();
    sessionFile = new File("logs","session_"+df.format(dateobj)+".json");
    try {
      sessionFile.createNewFile(); 
    }
    catch(IOException e) {
      e.printStackTrace(); 
    }
  }

  public void logQuestion(String question){
    this.question = question;
  }

  public void logAnswer(String answer){
    this.answer = answer;
  }

  public void logRating(){
    if (logRating == false){
      this.rating = 0;
    }
    else {
      System.out.println("\n*** Hur nöjd är du med ditt svar på en skala 1-4? ***");
      Scanner sc = new Scanner(System.in);
      this.rating = sc.nextInt();
    }

    try {
      fout = new FileWriter(sessionFile, true);
      fout.write("{\"Question\" : \"" + questionOut + "\" , \"Answer\" : \""+ answerOut + "\" , \"Rating:\" : " +ratingOut + " }\n") ;
      fout.flush();
      fout.close();
    }
    catch( IOException e){e.printStackTrace(); }
  }
}
