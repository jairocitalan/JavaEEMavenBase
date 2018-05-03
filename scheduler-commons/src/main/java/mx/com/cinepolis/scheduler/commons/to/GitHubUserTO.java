package mx.com.cinepolis.scheduler.commons.to;

public class GitHubUserTO {

	private String login;
	private String name;
	private String avatar_url;
	private int followers;
	private int following;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String log) {
		this.login = log;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	
	
	
	
	
}
