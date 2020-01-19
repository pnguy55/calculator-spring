package equation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationRepository extends JpaRepository<Equation, Long>, CrudRepository<Equation, Long> {
    @Query("SELECT COUNT(u) FROM Equation u")
    Long countEquations();
}
