package Lottory;

import java.util.List;

import com.example.jsouptest.R;

import Race.Game;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LotteryAdapter extends BaseAdapter {
	private LayoutInflater myInflater;
	private List<EachGame> lotterys;
	
	public LotteryAdapter(Context context,List<EachGame> lottery){
        myInflater = LayoutInflater.from(context);
        this.lotterys = lottery;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lotterys.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lotterys.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return lotterys.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = myInflater.inflate(R.layout.lottery_lv, null);
		TextView team1 = (TextView) convertView.findViewById(R.id.textTeam1);
		TextView team2 = (TextView) convertView.findViewById(R.id.textTeam2);
		TextView rate1 = (TextView) convertView.findViewById(R.id.rateTeam1);
		TextView rate2 = (TextView) convertView.findViewById(R.id.rateTeam2);
		TextView time = (TextView) convertView.findViewById(R.id.textPass);
		TextView pass = (TextView) convertView.findViewById(R.id.textTime);
		EachGame game = (EachGame)getItem(position);
		team1.setText(game.getTeam1());
		team2.setText(game.getTeam2());
		rate1.setText(game.getRate1());
		rate2.setText(game.getRate2());
		time.setText(game.getTime());
		pass.setText(game.getPass());
		
		return convertView;
	}

}
