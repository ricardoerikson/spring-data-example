package spring.repository;

import org.springframework.data.repository.Repository;

import spring.entity.UserProfile;

public interface UserProfileRepository extends Repository<UserProfile, Long> {

    UserProfile findByEmail(String email);


}
