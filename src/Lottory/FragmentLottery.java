package Lottory;

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

public class FragmentLottery extends Fragment {
	private View v;
    private String url="https://www.sportslottery.com.tw/zh/web/guest/sports-betting#m/all/s-443";
	private String title;//¤é´Á
	private ListView listV;
	private TextView textTitle;
	List<EachGame> team_list = new ArrayList<EachGame>();
	private LotteryAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	v = inflater.inflate(R.layout.lottery, container, false);
        listV = (ListView)v.findViewById(R.id.lotteryList);
        textTitle = (TextView) v.findViewById(R.id.lotteryText);
        textTitle.setText("Still Have Bug");
        /*
        textTitle.setText("Wait for Parse the Data");
        title = "";
		new Thread(runnable).start();
		Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() {
	        	textTitle.setText(title);
		        //adapter = new LotteryAdapter(v.getContext(), team_list);
		        //listV.setAdapter(adapter);
	         } 
	    }, 5000);
	    */
        return v;
    }
    
    //parse the Url  and  add the data to game
    Runnable runnable = new Runnable(){
	    @Override
	    public void run() {
			try {
				Document doc= Jsoup.connect(url).get();
				title = doc.select(".bets live clearfix").text();
				Elements next;
				int i = 0;
				//next = doc.select("div.bets live clearfix").eq(0);
				/*
				do{
				team_list.add(new EachGame(
						doc.select("div.bets live clearfix").text(),
						doc.select("bets live clearfix").text(),
						doc.select("bets live clearfix").text(),
						doc.select("bets live clearfix").text(),
						doc.select("bets live clearfix").text(),
						doc.select("bets live clearfix").text()
						));
				}while(!next.isEmpty());
				*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	};
}
