package models;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryBuilders.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import static org.elasticsearch.common.xcontent.XContentFactory.* ;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import java.util.*;
import java.net.*;
import java.io.*;
public class EsModel{


    /*
    This model talks to elasticsearch
    */
    public EsModel(){
    //TODO

    }

    /*
    Sends a query to ES
    @param The query you want to ask ES
    @return the search responnse from ES
    */
    private void getResponse(String query){
        //TODO
    }

    /*
    Returns the answers from an ES query
    @return all answers from ES
    */
    public String getAllAnswers(){
        //TODO
        return null;
    }

    /*
    Returns the first answers
    @param a response from ES
    @return a single answer
    */
    public String getAnswer(String param){
         //TODO
      return "Hello ES!"; 
    }


}
