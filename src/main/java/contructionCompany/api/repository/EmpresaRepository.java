package contructionCompany.api.repository;

import contructionCompany.api.domain.empresa.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from Empresa p
            where p.id = :id
            """)
    boolean findAtivoById(Long id);
}