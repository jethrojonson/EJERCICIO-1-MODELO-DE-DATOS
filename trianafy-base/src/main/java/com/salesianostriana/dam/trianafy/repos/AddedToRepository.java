package com.salesianostriana.dam.trianafy.repos;

import com.salesianostriana.dam.trianafy.model.AddedTo;
import com.salesianostriana.dam.trianafy.model.AddedToPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepository extends JpaRepository<AddedTo, AddedToPk> {
}
