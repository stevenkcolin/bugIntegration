package com.aethercoder.dao;

import com.aethercoder.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hepengfei on 05/12/2017.
 */
@Repository
public interface BugDao extends JpaRepository<Bug, Integer> {
}
