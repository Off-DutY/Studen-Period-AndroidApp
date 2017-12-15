package com.example.jsouptest;


import Lottory.FragmentLottery;
import News.FragmentNews;
import Race.FragmentRace;
import Record.FragmentRecord;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends FragmentActivity{
	TabHost mTabHost;
	private TabManager mTabManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Fragment setting
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabManager = new TabManager(this, mTabHost, R.id.realtabcontent);
        mTabHost.setCurrentTab(3);//Setup it will start from final page 
        //Page one Race
        
         /*
         * Set  Icon .  but in error
        mTabManager.addTab(mTabHost.newTabSpec("Race").setIndicator("Race",
        		this.getResources().getDrawable(R.drawable.race) ),
        		FragmentRace.class, null);
        */
        
        mTabManager.addTab(mTabHost.newTabSpec("Race").setIndicator("Race"),
        		FragmentRace.class,null);
        //Page two Record
        mTabManager.addTab(mTabHost.newTabSpec("Record").setIndicator("Record"
        		//,this.getResources().getDrawable(R.drawable.record)
        		),FragmentRecord.class, null);
        //Page four Game
        mTabManager.addTab(mTabHost.newTabSpec("Lottery").setIndicator("Lottery"
        		//,this.getResources().getDrawable(R.drawable.game) 
        		),FragmentLottery.class, null);
        //Page three News
        mTabManager.addTab(mTabHost.newTabSpec("News").setIndicator("News"
        		//,this.getResources().getDrawable(R.drawable.news) 
        		),FragmentNews.class, null);

        //make each fragment equal to each and align to the border.
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //Get ScreenSize  
        int screenWidth = dm.widthPixels;   //Get WidthSize
        TabWidget tabWidget = mTabHost.getTabWidget();   //Get Tab Object
        for (int i = 0; i < tabWidget.getChildCount(); i++){
        	//Set every Fragment's width
        	tabWidget.getChildTabViewAt(i).setMinimumWidth((screenWidth)/4);
        }
        
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
}
