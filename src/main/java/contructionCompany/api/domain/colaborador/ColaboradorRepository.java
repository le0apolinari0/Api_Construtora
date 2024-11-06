package contructionCompany.api.domain.colaborador;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//contrato de assinatura
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Page<Colaborador> findAllByAtivoTrue(Pageable paginacao);
}
