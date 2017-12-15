package Record;

import java.util.List;

import com.example.jsouptest.R;
import com.example.jsouptest.R.id;
import com.example.jsouptest.R.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RecordAdapter extends BaseAdapter {
	private LayoutInflater myInflater;
	private List<PerTeam> teams;
	public RecordAdapter(Context context,List<PerTeam> team){
        myInflater = LayoutInflater.from(context);
        this.teams = team;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return teams.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return teams.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return teams.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = myInflater.inflate(R.layout.record_lv, null);
		TextView name = (TextView) convertView.findViewById(R.id.recordname);
		TextView win = (TextView)  convertView.findViewById(R.id.recordwin);
		TextView lose = (TextView)  convertView.findViewById(R.id.recordlose);
		TextView rate = (TextView)  convertView.findViewById(R.id.recordrate);
	    PerTeam team = (PerTeam)getItem(position);
	    if(!team.getInside()){
	    	
		    name.setText(team.getName());
		    name.setTextSize(20);
		    win.setText(team.getWin());
		    win.setTextSize(20);
			lose.setText(team.getLose());
			lose.setTextSize(20);
			rate.setText(team.getWinRate());
			rate.setTextSize(20);
	    }else{
	    	name.setText(team.getLocal());
	    	name.setBackgroundColor(Color.BLUE);
	    	name.setTextColor(Color.WHITE);
		    name.setTextSize(20);
		    win.setVisibility(win.INVISIBLE);
		    lose.setVisibility(win.INVISIBLE);
		    rate.setVisibility(win.INVISIBLE);
	    }
		return convertView;
	}

}
