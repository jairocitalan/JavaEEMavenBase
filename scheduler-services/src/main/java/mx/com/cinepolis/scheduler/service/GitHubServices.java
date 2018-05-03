package mx.com.cinepolis.scheduler.service;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LogeoTO;

public interface GitHubServices {
	
	
	GitHubUserTO getDataGitHubUser(String log);
        
	LogeoTO login(String user,String pass);
	
	GitHubUserTO register(GitHubUserTO gitHubUserTO) ;
		
}
