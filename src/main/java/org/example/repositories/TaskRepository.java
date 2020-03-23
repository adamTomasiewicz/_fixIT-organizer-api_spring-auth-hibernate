package org.example.repositories;

import org.example.models.dao.TaskDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskDAO, Long> {


  Optional<TaskDAO> findTaskById(Long id);
  Optional<TaskDAO> findTaskByUuid(String uuid);

  @Query("select t from TaskDAO t")//JPQL
  List<TaskDAO> findTasksAll();
  List<TaskDAO> findTaskByName(String name);
  List<TaskDAO> findTaskByDescription(String description);
  List<TaskDAO> findTaskByColorCategory(String colorCategory);

  List<TaskDAO> findTaskByUrgency(int urgency);
  List<TaskDAO> findTaskByImportance(int importance);

  List<TaskDAO> findTaskByCreateLocalDateTime(Date date);
 // List<TaskDAO> findTaskByListOfDatesIn(List<LocalDateTime> listOfDates);

  @Transactional
  @Modifying
  void deleteTaskByUuid(String uuid);
  
  
  //@Query(value = "select h from Hotel h where h = (select a.hotel from Address a where a.city = ?1)") //JPQL
  //List<Hotel> findHotelByAddressCity(String city);
  
//@Query("delete from Hotel h where h.partnerCode = :partnerCode") //JPQL
 

}
