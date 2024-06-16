package com.myProperty.Property_Manageent.Repository;

import com.myProperty.Property_Manageent.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
