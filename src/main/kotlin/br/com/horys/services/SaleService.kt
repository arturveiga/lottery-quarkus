package br.com.horys.services

import br.com.horys.models.Sale
import br.com.horys.repositories.BetRepository
import br.com.horys.repositories.SaleRepository
import br.com.horys.repositories.UserRepository
import br.com.horys.resources.SaleResource.SaleRequest
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
class SaleService(
    private val saleRepository: SaleRepository,
    private val userRepository: UserRepository,
    private val betRepository: BetRepository,
) {

    @Transactional
    fun save(request: SaleRequest): Sale {
        val user = userRepository.findByIdOptional(request.userId).orElseThrow { RuntimeException("User not found") }
        val bet = betRepository.findByIdOptional(request.betId).orElseThrow { RuntimeException("Bet not found") }
        val amount = bet.availableReservation - request.reservation

        if (amount < 0) {
            throw RuntimeException("Size reservation is invalid")
        }

        val sale = Sale(
            bet = bet,
            user = user,
            id = null,
            image = "random",
            amountReservation = request.reservation
        )
        saleRepository.persist(sale)
        return sale
    }

}