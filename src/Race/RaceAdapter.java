package Race;


import java.util.List;

import com.example.jsouptest.R;
import com.example.jsouptest.R.id;
import com.example.jsouptest.R.layout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RaceAdapter extends BaseAdapter {
	private LayoutInflater myInflater;
	private List<Game> games;
	
	public RaceAdapter(Context context,List<Game> game){
        myInflater = LayoutInflater.from(context);
        this.games = game;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return games.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return games.get(arg0);
	}
	
	public int getImageID(String name){
		int a=0;
		switch(name){
			case"響尾蛇":
				a=0x7f020037;
				break;
	        case"勇士":
	        	a=0x7f020038;
				break;
	        case"金鶯":
	        	a=0x7f020039;
				break;
	        case"紅襪":
	        	a=0x7f02003a;
				break;
	        case"小熊":
	        	a=0x7f02003b;
				break;
	        case"紅人":
	        	a=0x7f02003c;
				break;
	        case"印地安人":
	        	a=0x7f02003d;
				break;
	        case"落磯":
	        	a=0x7f02003e;
				break;
	        case"白襪":
	        	a=0x7f02003f;
				break;
	        case"老虎":
	        	a=0x7f020040;
				break;
	        case"太空人":
	        	a=0x7f020042;
				break;
	        case"皇家":
	        	a=0x7f020044;
				break;
	        case"天使":
	        	a=0x7f020045;
				break;
	        case"道奇":
	        	a=0x7f020046;
				break;
	        case"馬林魚":
	        	a=0x7f020047;
				break;
	        case"釀酒人":
	        	a=0x7f020048;
				break;
	        case"雙城":
	        	a=0x7f020049;
				break;
	        case"大都會":
	        	a=0x7f02004b;
				break;
	        case"洋基":
	        	a=0x7f02004c;
				break;
	        case"運動家":
	        	a=0x7f02004d;
				break;
	        case"費城人":
	        	a=0x7f02004e;
				break;
	        case"海盜":
	        	a=0x7f02004f;
				break;
	        case"教士":
	        	a=0x7f020052;
				break;
	        case"水手":
	        	a=0x7f020053;
				break;
	        case"巨人":
	        	a=0x7f020054;
				break;
	        case"紅雀":
	        	a=0x7f020055;
				break;
	        case"光芒":
	        	a=0x7f020056;
				break;
	        case"遊騎兵":
	        	a=0x7f020057;
				break;
	        case"藍鳥":
	        	a=0x7f020058;
				break;
	        case"國民":
	        	a=0x7f020059;
				break;
        }
		return a;
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return games.indexOf(getItem(position));
	}
	
	private void setImageViewSize(ImageView imgid) {
		// TODO 自動產生的方法 Stub
		DisplayMetrics metrics = myInflater.getContext().getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		LayoutParams params = imgid.getLayoutParams();
		params.width = width/8;
		params.height = height/8;
		imgid.setLayoutParams(params);
	}
	

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	    convertView = myInflater.inflate(R.layout.race_lv, null);
	    ImageView imageTeam1 = (ImageView) convertView.findViewById(R.id.imageTeam1);
	    ImageView imageTeam2 = (ImageView) convertView.findViewById(R.id.imageTeam2);
	    TextView time = (TextView) convertView.findViewById(R.id.textTime);
	    TextView textTeam1 = (TextView) convertView.findViewById(R.id.textTeam1);
	    TextView textTeam2 = (TextView) convertView.findViewById(R.id.textTeam2);
	    TextView textScroe1 = (TextView) convertView.findViewById(R.id.textScore1);
	    TextView textScroe2 = (TextView) convertView.findViewById(R.id.textScore2);
	    Game game = (Game)getItem(position);
	    textTeam1.setText(game.getTeamOne());
	    textTeam1.setTextSize(25);
	    textTeam2.setText(game.getTeamTwo());
	    textTeam2.setTextSize(25);
	    imageTeam1.setImageResource( getImageID(game.getTeamOne()));
		imageTeam2.setImageResource(getImageID(game.getTeamTwo()));
		setImageViewSize(imageTeam1);
		setImageViewSize(imageTeam2);
	    if(!game.getPreGame()){
		   textScroe1.setText(game.getScoreOne());
		    textScroe1.setVisibility(View.VISIBLE);
			textScroe2.setText(game.getScoreTwo());
		    textScroe2.setVisibility(View.VISIBLE);
		    time.setText("Vs");
		}else{
		    textScroe1.setVisibility(View.INVISIBLE);
		    textScroe2.setVisibility(View.INVISIBLE);
		    time.setText(game.getTime());
		}
		return convertView;
		
	}
	
}
