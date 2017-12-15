package Record;

import android.R.bool;

public class PerTeam {
	private String name;
	private String win;
	private String lose;
	private String winRate;
	private boolean inside;
	private String local;
	public PerTeam(String name,String win,String lose,String winRate){
		this.name = name;
		this.win = win;
		this.lose = lose;
		this.winRate = winRate;
		this.inside = false;
	}
	public PerTeam(boolean inside,String local){
		this.inside = inside;
		this.local = local;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setWin(String win){
		this.win = win;
	}
	public String getWin(){
		return win;
	}
	public void setLose(String lose){
		this.lose = lose;
	}
	public String getLose(){
		return lose;
	}
	public void setWinRate(String rate){
		this.winRate = rate;
	}
	public String getWinRate(){
		return winRate;
	}
	public void setLocal(String local){
		this.local = local;
	}
	public String getLocal(){
		return local;
	}
	public void setInside(boolean inside){
		this.inside = inside;
	}
	public boolean getInside(){
		return inside;
	}
}
