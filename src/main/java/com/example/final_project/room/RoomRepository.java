package com.example.final_project.room;

import com.example.final_project.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("select r from Room r join fetch Stay s on r.stay.id = s.id where s.id = :stayId order by r.id desc ")
    List<Room> findByStayId(@Param("stayId")Integer stayId);


}
