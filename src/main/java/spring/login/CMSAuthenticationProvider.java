package spring.login;

import org.springframework.beans.factory.annotation.Autowired;

import spring.repository.UserProfileRepository;

public class CMSAuthenticationProvider {
    
    private UserProfileRepository userProfileRepository;

    @Autowired
    public CMSAuthenticationProvider(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
    
    
    

}
