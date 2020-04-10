package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.Month;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MonthRepository extends CrudRepository<Month, String> {
    Optional<Month> findById(String id);
}
