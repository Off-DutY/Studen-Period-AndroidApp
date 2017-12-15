package Race;
public class Game {
	private String team_one;
	private String team_two;
	private String score_one;
	private String score_two;
	private String time;
	private Boolean preGame;
    public Game(String team_one,String team_two,String score_one,String score_two) {
    	this.team_one = team_one;
    	this.team_two = team_two;
    	this.score_one = score_one;
    	this.score_two = score_two;
    	this.preGame = false;
    }
    public Game(String team_one,String team_two,String time,Boolean preGame) {
    	this.team_one = team_one;
    	this.team_two = team_two;
    	this.time = time;
    	this.preGame = preGame;
    }
    public String getTeamOne(){
            return team_one;
    }
    public String getTeamTwo(){
        return team_two;
    }
    public void setTeamOne(String ss){
    	this.team_one = ss;
    }
    public void setTeamTwo(String ss){
        this.team_two = ss;
    }
    public String getScoreOne(){
    	return score_one;
    }
    public String getScoreTwo(){
        return score_two;
    }
    public void setScoreOne(String name){
    	this.score_one = name;
    }
    public void setScoreTwo(String name){
    	this.score_two = name;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
    	this.time = time;
    }
    public void setPreGame(Boolean pre) {
    	this.preGame = pre;
	}
    public Boolean getPreGame(){
    	return this.preGame;
    }
}