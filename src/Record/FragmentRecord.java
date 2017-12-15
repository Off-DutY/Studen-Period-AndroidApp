package Record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.example.jsouptest.R;
import com.example.jsouptest.R.id;
import com.example.jsouptest.R.layout;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentRecord extends Fragment {
    private View v;
    private String url="http://tslc.stats.com/mlb/standings.asp";
	private String title;//日期
	private ListView listV;
	private TextView textTitle;
	List<PerTeam> team_list = new ArrayList<PerTeam>();
	private RecordAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	v = inflater.inflate(R.layout.record, container, false);
        listV = (ListView)v.findViewById(R.id.recordList);
        textTitle = (TextView) v.findViewById(R.id.recordText);
        
        textTitle.setText("Wait for Parse the Data");
        title = "";
		new Thread(runnable).start();
		Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() {
	        	textTitle.setText("戰績排名");
		        adapter = new RecordAdapter(v.getContext(), team_list);
		        listV.setAdapter(adapter);
	         } 
	    }, 5000);
	    
        return v;
    }
    //#shsMLBstandings > table:nth-child(3) > tbody > tr:nth-child(2) > td
    //#shsMLBstandings > table:nth-child(5) > tbody > tr:nth-child(2) > td
    //parse the Url  and  add the data to game
      Runnable runnable = new Runnable(){
  	    @Override
  	    public void run() {
  	    	team_list.add(new PerTeam("球隊","勝|","負|","勝率"));
  			try {
  				Document doc= Jsoup.connect(url).get();
  				
  				for(int local=3;local<6;local+=2){
  					String pa = doc.select("#shsMLBstandings > table:nth-child("+local+") > tbody > tr.shsTableTtlRow > td").text();
	  				for(int i=3;i<=17;i+=7){
	  					team_list.add(new PerTeam(true,
	  							pa+doc.select( "#shsMLBstandings > table:nth-child("+local+") > tbody > tr:nth-child(" + (i-1) + ") > td").text()
	  							));
		  				for(int j=i+1;j<=i+5;j++){
			  				team_list.add(new PerTeam(
			  						doc.select("table:nth-child("+local+") > tbody > tr:nth-child("+j+")").select("td").eq(0).text(),
			  						doc.select("table:nth-child("+local+") > tbody > tr:nth-child("+j+")").select("td").eq(1).text()+"|",
					  				doc.select("table:nth-child("+local+") > tbody > tr:nth-child("+j+")").select("td").eq(2).text()+"|",
					  				doc.select("table:nth-child("+local+") > tbody > tr:nth-child("+j+")").select("td").eq(3).text()
					  		));
		  				}
	  				}
  				}
  				
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  	    }
  	};
}
