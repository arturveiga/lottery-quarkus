package br.com.horys.resources

import br.com.horys.models.Bet
import br.com.horys.repositories.BetRepository
import br.com.horys.repositories.SupplierRepository
import br.com.horys.resources.requests.CreateBetRequest
import java.time.LocalDate
import javax.validation.Valid
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v1/bets")
@Produces(MediaType.APPLICATION_JSON)
class CreateBetResource(
    private val betRepository: BetRepository,
    private val supplierRepository: SupplierRepository
) {

    @POST
    fun save(@Valid request: CreateBetRequest): Bet {
        val supplier = supplierRepository.findById(request.supplierId) ?: throw RuntimeException("Supplier not found")
        val bet = Bet(
            id = null,
            number = request.number,
            type = Bet.TypeBet.valueOf(request.type),
            supplier = supplier,
            reservation = request.reservation,
            date = LocalDate.parse(request.date),
            availableReservation = request.reservation
        )
        betRepository.persist(
            bet
        )

        return bet
    }
}