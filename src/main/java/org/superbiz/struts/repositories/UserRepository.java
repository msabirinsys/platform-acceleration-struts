package org.superbiz.struts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.superbiz.struts.User;

/**
 * Created by msabir on 1/30/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}