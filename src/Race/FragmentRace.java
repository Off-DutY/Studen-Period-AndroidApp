package Race;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.example.jsouptest.R;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

//This is the first page

public class FragmentRace extends Fragment {
    private View v;
    private String url="http://mlb.tw/mlb/portal/schedule/regularseasonschedule.action";
	private String title;//¤é´Á
	private int [] gameCount = new int[3];
	private ListView listV;
	private TextView textTitle;
	List<Game> game_list = new ArrayList<Game>();
	private RaceAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	v = inflater.inflate(R.layout.race, container, false);
        listV = (ListView)v.findViewById(R.id.raceList);
        textTitle = (TextView) v.findViewById(R.id.raceText);
        
        textTitle.setText("Wait for Parse the Data");
		new Thread(runnable).start();
		Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() {
	        	 textTitle.setText(title);
	        	 adapter = new RaceAdapter(v.getContext(), game_list);
	        	 listV.setAdapter(adapter);
	         } 
	    }, 5000);
	    
        return v;
    }
    
  //parse the Url  and  add the data to game
    Runnable runnable = new Runnable(){
	    @Override
	    public void run() {
			try {
				Document doc= Jsoup.connect(url).get();
				Elements next;
				for(int j=0;j<1;j++){
					title = doc.select("h4.p").eq(j).text();
					int i = 1;//first row(0) do not read, so start at 1
					next = doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(2);
					do{
						String[] d = next.text().split(",");
						String[] firArray = d[0].split(" ");
						//have not start game
						// Team 1  , Team 2 , Start Time , preGame 
						if(firArray[0].equals("AM") | firArray[0].equals("PM")){
							game_list.add(new Game(
									doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(0).text(),
									doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(1).text(),
									doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(2).text(),
									true)
							);
						}else{
						// already ended the game 
						// Team 1  , Team 2 , Score 1 , Score 2
							String[] secondArray = d[1].split(" ");
							game_list.add(new Game(
									doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(0).text(),
									doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(i).select("td").eq(1).text(),
									firArray[1],
									secondArray[2]));
						}
						next = doc.select("table.schedule_table > tbody").eq(j).select("tr").eq(++i).select("td").eq(2);
					}while(!next.isEmpty());
					gameCount[j]=i-1;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	};

}
