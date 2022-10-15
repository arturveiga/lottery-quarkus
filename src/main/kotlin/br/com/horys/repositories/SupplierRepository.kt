package br.com.horys.repositories

import br.com.horys.models.Supplier
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SupplierRepository : PanacheRepository<Supplier> {
}