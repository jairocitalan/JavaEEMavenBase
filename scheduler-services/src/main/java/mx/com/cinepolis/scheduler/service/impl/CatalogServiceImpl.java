package mx.com.cinepolis.scheduler.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import mx.com.arquitectura.base.model.UserDO;
import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.data.persistence.dao.UserDAO;
import mx.com.cinepolis.scheduler.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{
    @Inject
    private UserDAO userDAO;
	
	
    /**
     * {@inheritDoc}
     */
    @Override
    public  UserTO getUser() {
        UserTO userTO = new UserTO();
        userTO.setIdUser(1L);
        userTO.setName("Javier");
        userTO.setAvatarUrl("francisco.rodriguez@axity.com.mx");
        userTO.setName("jrodriguez");
        return userTO;
    }

	@Override
	public List<CatalogsTO> getEstados(String pais) {
		List<CatalogsTO> catalogsToList= new ArrayList<>();
		
		if(pais.equals("Mexico")){
			catalogsToList.add(new CatalogsTO() {{
				setId(1);
				setName("Puebla");
			}});
			
			catalogsToList.add(new CatalogsTO() {{
				setId(2);
				setName("Chiapas");
			}});
			
			catalogsToList.add(new CatalogsTO() {{
				setId(3);
				setName("Tlaxcala");
			}});
			
			catalogsToList.add(new CatalogsTO() {{
				setId(4);
				setName("CDMX");
			}});
			
			
		}else if(pais.equals("USA")) {
				catalogsToList.add(new CatalogsTO() {{
					setId(1);
					setName("California");
				}});
				
				catalogsToList.add(new CatalogsTO() {{
					setId(2);
					setName("New York");
				}});
				
				catalogsToList.add(new CatalogsTO() {{
					setId(3);
					setName("Texas");
				}});
		}
		
		return catalogsToList;
	}

	@Override
	public List<UserTO> getOutUser() {
		List<UserDO> usrDOList = userDAO.findAll();
		
		return usrDOList.stream().map(x -> 
			    new UserTO() {{
				setLogin(x.getLogin());
				setFollowin(x.getFollowing());
				setFollowers(x.getFollowers());    
				setAvatarUrl(x.getAvatarUrl());
				setName(x.getName());
				setIdUser(x.getIdUser());
		}}).collect(Collectors.toList());
		
	
	}

	@Override
	public void registerUser(UserTO userTO) {
		UserDO userDo = new UserDO();
		userDo.setIdUser(userTO.getIdUser());
		userDo.setLogin(userTO.getLogin());
		userDo.setName(userTO.getName());
		userDo.setFollowing(userTO.getFollowin());
		userDo.setFollowers(userTO.getFollowers());
		userDo.setAvatarUrl(userTO.getAvatarUrl());
		userDAO.create(userDo);
	}

	@Override
	public UserTO findById(Long id) {
	
		return null;
	}

}













