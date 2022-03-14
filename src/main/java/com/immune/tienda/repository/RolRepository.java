package com.immune.tienda.repository;

import com.immune.tienda.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{     //En el rol repository solamente se inserta una Querry.

    @Query(value="SELECT COUNT(*), R.nombre FROM usuario as u INNER JOIN Rol as R on u.id_Rol = R.id group by R.id", nativeQuery = true) //Unir el id rol con el rol id.
    public Iterable<String> getCount();

}