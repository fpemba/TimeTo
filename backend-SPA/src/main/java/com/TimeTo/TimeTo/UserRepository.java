package com.TimeTo.TimeTo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserAccount, Long> {
}
