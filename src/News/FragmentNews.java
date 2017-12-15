package News;

import java.util.Random;

import com.example.jsouptest.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentNews extends Fragment {
	private Button btnDo,btn2,btn3,btn4;
	private TextView txtShow;
	private View v;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    	
        // TODO Auto-generated method stub
    	v = inflater.inflate(R.layout.news, container, false);
    	
    	btnDo = (Button) v.findViewById(R.id.tryonce);
        txtShow = (TextView) v.findViewById(R.id.LuckGame);
        btn2 = (Button) v.findViewById(R.id.Yahoo);
        btn3 = (Button) v.findViewById(R.id.MLB);
        btn4 = (Button) v.findViewById(R.id.Lottery);
        
        btnDo.setOnClickListener(new Button.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				Random ran = new Random();
	        	int a  = ran.nextInt(10)+1;
				// TODO Auto-generated method stub
				txtShow.setText("您的幸運場次:"+ a );
			}
		});
        btn2.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
	    		Uri uri=Uri.parse("https://tw.sports.yahoo.com/mlb/");
	    		Intent i=new Intent(Intent.ACTION_VIEW,uri);
	    		startActivity(i);
	    		}
		});
        btn3.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
	    		Uri uri=Uri.parse("http://mlb.mlb.com/home");
	    		Intent j=new Intent(Intent.ACTION_VIEW,uri);
	    		startActivity(j);
	    		}
		});
        btn4.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
	    		Uri uri=Uri.parse("https://www.sportslottery.com.tw/zh/home");
	    		Intent j=new Intent(Intent.ACTION_VIEW,uri);
	    		startActivity(j);
	    		}
		});
        return v;
    }

}
