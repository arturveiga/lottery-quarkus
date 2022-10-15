package br.com.horys.repositories

import br.com.horys.models.Sale
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SaleRepository : PanacheRepository<Sale> {
}