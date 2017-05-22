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
    It fetches search hits from fromSize to toSize
    */
    public EsModel() throws UnknownHostException{
      client = new PreBuiltTransportClient(Settings.EMPTY)
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
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
        .setQuery(QueryBuilders.matchQuery("question",query))
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
    /*
    Iterates over all hits and all their threds until it finds a suitable answer.
    Right now suitable means shorter than "maxLength"
    @param a response from ES
    @return a single answer
    */
    public String getAnswer(String query, int maxLength){
      for(SearchHit thread : getStringQuery(query).getHits()){
        ArrayList<String> threadResponses = (ArrayList<String>)thread.sourceAsMap().get("answers");
        for(String answer : threadResponses){
          if(answer.length()<maxLength)
            return answer;
        }
      }

      return ("I don't know anything about that.");
    }
}
