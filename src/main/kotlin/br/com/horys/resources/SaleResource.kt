package br.com.horys.resources

import br.com.horys.models.Sale
import br.com.horys.resources.SaleResource.SaleResponse
import br.com.horys.services.SaleService
import javax.validation.Valid
import javax.validation.constraints.Positive
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/v1/sales")
class SaleResource(
    private val service: SaleService
) {

    @POST
    fun save(@Valid request: SaleRequest): SaleResponse {
        return service.save(request).toResponse()
    }

    class SaleRequest(
        @field:Positive(message = "Invalid bet") val betId: Long = 0,
        @field:Positive(message = "Invalid user") val userId: Long = 0,
        @field:Positive(message = "Invalid size reservation") val reservation: Int = 0,
    )

    class SaleResponse(
        val userId: Long,
        val betId: Long,
        val reservation: Int
    )
}

private fun Sale.toResponse(): SaleResponse {
    return SaleResponse(
        userId = this.user.id!!,
        betId = this.bet.id!!,
        reservation = this.amountReservation
    )
}