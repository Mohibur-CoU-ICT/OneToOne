package com.mohibur.OneToOne.Repository;

import com.mohibur.OneToOne.Entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    @Query(value = "select up_id from user where id = :userId", nativeQuery = true)
    long getUserProfileId(@RequestParam(value = "userId") long userId);
}
