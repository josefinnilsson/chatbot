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

    TransportClient client;
    int answerIndex;
    int fromSize;
    int toSize;
    SearchResponse currentSearchResponse;

    /*
    This model talks to elasticsearch
    The answerIndex variable is used to fetch a certain answer from the results from elasticsearch.
    fromSize and toSize is what delimits what range of results are fetched from elasticsearch.
    TODO Currently if an entire thread is over the message max length the answerIndex will grow to large.
    In later implementation we will have to increase the range when the answerIndex hits fromSize.
    */
    public EsModel() throws UnknownHostException{
      client = new PreBuiltTransportClient(Settings.EMPTY)
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
      answerIndex = 0;
      fromSize = 0;
      toSize = 60;
    }



    /*
    Sends a query to ES
    @param The query you want to ask ES
    @return the search responnse from ES
    */
    public SearchResponse getStringQuery(String query){
      SearchResponse response = client.prepareSearch("familjelivdb")
      	.setQuery(QueryBuilders.multiMatchQuery(query,"answers","question"))
        .setFrom(fromSize).setSize(toSize).setExplain(true)
        .get();
      return response;
    }

    /**
    @param search hit from Elasticsearch
    @return All answers from the hit as ArrayList.
    */
    public ArrayList<String> getAllAnswers(SearchHit hit){
      return (ArrayList<String>)hit.sourceAsMap().get("answers");
    }

    /**
    resets index for answer iteration
    */
    public void resetIndex(){
    answerIndex = 0;
    }

    /*
    Returns the first answers
    @param a response from ES
    @return a single answer
    */
    public String getNextAnswer(String query){
      try{
        SearchHit firstHit = getStringQuery(query).getHits().getAt(0);
        return getAllAnswers(firstHit).get(answerIndex++);
      }catch(ArrayIndexOutOfBoundsException e){
        return ("I don't know anything about that.");
    }

    }

}
