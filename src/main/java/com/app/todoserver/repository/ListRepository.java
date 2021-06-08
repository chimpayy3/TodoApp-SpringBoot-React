package com.app.todoserver.repository;

import com.app.todoserver.models.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<Lists,Integer> {
}
