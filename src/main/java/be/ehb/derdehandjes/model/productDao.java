package be.ehb.derdehandjes.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public interface productDao extends CrudRepository<product, Integer> {
    @Query("SELECT p FROM product p WHERE p.categorie LIKE %:categorie%")
    public List<product> search(@Param("categorie") String categorie);

    @Query("SELECT DISTINCT p.categorie FROM product p")
    public List<product> uniq(@Param("categorie") String categorie);
}
