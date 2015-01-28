package spring.login;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.entity.UserProfile;
import spring.repository.UserProfileRepository;

public class CMSAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserProfile profile = userProfileRepository.findByEmail(authentication.getPrincipal().toString());

        if (profile == null)
            throw new UsernameNotFoundException(String.format("Invalid credentials", authentication.toString()));

        String suppliedPasswordHash = DigestUtils.sha1Hex(authentication.getCredentials().toString());

        if (!profile.getPasswordHash().equals(suppliedPasswordHash))
            throw new BadCredentialsException("Invalid credentials");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(profile, null,
                profile.getAuthorities());

        return token;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
