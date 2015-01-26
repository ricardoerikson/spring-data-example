package spring.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import spring.entity.UserProfile;

public interface UserProfileRepository extends Repository<UserProfile, Long> {

    List<UserProfile> findByEmail(String email);

}
