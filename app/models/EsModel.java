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



    public EsModel() throws UnknownHostException{
      client = new PreBuiltTransportClient(Settings.EMPTY)
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    }



    public SearchResponse getStringQuery(String query){
      SearchResponse response = client.prepareSearch("familjelivdb")
        .setQuery(QueryBuilders.matchQuery("question",query))
        .setFrom(0).setSize(60).setExplain(true)
        .get();
      return response;
    }


    public ArrayList<String> getAllAnswers(SearchHit hit){
      return (ArrayList<String>)hit.sourceAsMap().get("answers");
    }

    /*
    This model talks to elasticsearch
    */


    /*
    Sends a query to ES
    @param The query you want to ask ES
    @return the search responnse from ES
    */

    /*
    Returns the first answers
    @param a response from ES
    @return a single answer
    */
    public String getAnswer(String query){
      try{
        SearchHit firstHit = getStringQuery(query).getHits().getAt(0);
        return getAllAnswers(firstHit).get(0);
      }catch(ArrayIndexOutOfBoundsException e){
        return ("I don't know anything about that.");
    }

    }

}
