package com.aethercoder.dao;

import com.aethercoder.entity.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hepengfei on 05/12/2017.
 */
@Repository
public interface BuildDao extends JpaRepository<Build, Integer> {
    List<Build> findBuildsByNameAndProductAndProject(String name, Integer product, Integer project);
}
