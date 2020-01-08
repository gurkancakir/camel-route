package com.gurkan.camel.repository;

import com.gurkan.camel.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileEntity, Integer> {
}
