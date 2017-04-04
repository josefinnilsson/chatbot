package models;

public class EsModel extends Model{


    /*
    This model talks to elasticsearch
    */
    public EsModel(){
    //TODO
    }

    /*
    Sends a query to ES and returns the entire response
    @param The query you want to ask ES
    @return the search responnse from ES
    */
    private void getResponse(String query){
        //TODO
    }

    /*
    Return the answers from an ES query
    @return all answers from ES
    */
    public String getAllAnswers(){
        //TODO
    }

    /*
    Returns the first answers
    @param a response from ES
    @return a single answer
    */
    public String getAnswer(Response response){
        //TODO
    }


}
