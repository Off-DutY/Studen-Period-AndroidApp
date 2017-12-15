package Lottory;

public class EachGame {
	String team1;
	String team2;
	String time;
	String rate1;
	String rate2;
	String pass;
	public EachGame(String team1,String team2,String time,
			String rate1,String rate2,String pass){
		this.team1 = team1;
		this.team2 = team2;
		this.time = time;
		this.rate1 = rate1;
		this.rate2 = rate2;
		this.pass = pass;
	}
	public void setTeam1(String str){
		this.team1 = str;
	}
	public String getTeam1(){
		return team1;
	}
	public void setTeam2(String str){
		this.team2 = str;
	}
	public String getTeam2(){
		return team2;
	}
	public void setPass(String str){
		this.pass = str;
	}
	public String getPass(){
		return pass;
	}
	public void setRate1(String str){
		this.rate1 = str;
	}
	public String getRate1(){
		return rate1;
	}
	public void setRate2(String str){
		this.rate2 = str;
	}
	public String getRate2(){
		return rate2;
	}
	public void setTime(String str){
		this.time = str;
	}
	public String getTime(){
		return time;
	}
}
