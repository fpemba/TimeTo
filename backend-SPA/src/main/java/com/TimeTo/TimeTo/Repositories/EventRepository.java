package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository <Event, Long>{
}
