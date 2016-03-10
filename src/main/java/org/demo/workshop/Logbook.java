package org.demo.workshop;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Logbook extends CrudRepository<Message, Long>
{
  List<Message> findByPlanet(String planet);
}
