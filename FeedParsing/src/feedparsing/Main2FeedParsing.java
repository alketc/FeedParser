package feedparsing;

import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

public class Main2FeedParsing  {

	public static void main (String [] args)throws Exception{
		
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader(new File("link.txt")));
		
		while((line = br.readLine())!= null){
		
			URL url = null;
			System.out.println("---------------------------------------------------------");
			System.out.println(line);
			
			if(line.equals("")){
				System.exit(-1);
			}
			else{ 
				url = new URL(line);
			}
			
			Feed feed = FeedParser.parse(url);
			
		    String link = "";
		    String pubdate = "";
		    String title = "";
		   String desc = "";
		
		
		System.out.println("** HEADER **");
		FeedHeader header = feed.getHeader();
		System.out.println("Title feed: " + header.getTitle());
		System.out.println("Link feed: " + header.getLink());
		System.out.println("Description feed : " + header.getDescription());
		System.out.println("Language feed: " + header.getLanguage());
		System.out.println("PubDate feed: " + header.getPubDate());
		
		//titleFeed = header.getTitle();
		//descFeed = header.getDescription();
		
		
		System.out.println("** ITEMS **");
		int items = feed.getItemCount();
		for (int i = 0; i < items; i++) {
			FeedItem item = feed.getItem(i);
			System.out.println("Title: " + item.getTitle());
			System.out.println("Link: " + item.getLink());
			System.out.println("Plain text description: " + item.getDescriptionAsText());
			System.out.println("HTML description: " + item.getDescriptionAsHTML());
			System.out.println("PubDate: " + item.getPubDate());
	    
			title = item.getTitle();
			desc = item.getDescriptionAsText();
			
		}	
		
	}br.close();
		   	 		
	
  }
}
