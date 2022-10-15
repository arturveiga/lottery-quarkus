package br.com.horys.resources

import br.com.horys.models.Supplier
import br.com.horys.repositories.SupplierRepository
import br.com.horys.resources.requests.CreateSupplierRequest
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/suppliers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CreateSupplierResource(
    private val supplierRepository: SupplierRepository
) {

    @POST
    @Transactional
    fun save(@Valid request: CreateSupplierRequest): Supplier {
        val supplier = Supplier(
            id = null,
            description = request.description
        )
        supplierRepository.persist(supplier)
        return supplier
    }
}