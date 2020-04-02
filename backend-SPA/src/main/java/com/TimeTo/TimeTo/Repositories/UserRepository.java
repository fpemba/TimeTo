package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserAccount, Long> {
}
