package mx.com.cinepolis.scheduler.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LogeoTO;
import mx.com.cinepolis.scheduler.service.GitHubServices;



@Stateless
@LocalBean
public class GitHubFacadeEJB {

	@Inject
    GitHubServices gitHubServices;
	

	public GitHubUserTO getGitHubUser(String log) {
		return gitHubServices.getDataGitHubUser(log);
		
	}

	public LogeoTO logeo(String user,String pass) {
		return gitHubServices.login(user, pass);
	}
	
	
	public GitHubUserTO register(GitHubUserTO gitHubUserTO) {
		return gitHubServices.register(gitHubUserTO);
	}
	
	
}
