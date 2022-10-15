package br.com.horys.services

import br.com.horys.models.Bet
import br.com.horys.models.Supplier
import br.com.horys.models.User
import br.com.horys.repositories.BetRepository
import br.com.horys.repositories.UserRepository
import br.com.horys.resources.SaleResource
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Optional
import javax.inject.Inject

@QuarkusTest
internal class SaleServiceTest {
    @Inject
    private lateinit var saleService: SaleService

    @InjectMock
    private lateinit var userRepository: UserRepository

    @InjectMock
    private lateinit var betRepository: BetRepository


    @Test
    fun `test some thing`() {
        val request = SaleResource.SaleRequest(
            betId = 1,
            userId = 1,
            reservation = 10
        )

        Mockito.`when`(userRepository.findByIdOptional(Mockito.any())).thenReturn(Optional.of(USER))
        Mockito.`when`(betRepository.findByIdOptional(Mockito.any())).thenReturn(Optional.of(BET))


        val sale = saleService.save(request)

        Assertions.assertNotNull(sale.id)

    }

    companion object {
        val USER = User(
            id = 1,
            name = "Artur",
            password = "123"
        )

        private val SUPPLIER = Supplier(
            id = 1,
            description = "Fornecedor 1"
        )

        val BET = Bet(
            id = 1,
            reservation = 100,
            availableReservation = 80,
            number = 3020,
            supplier = SUPPLIER,
            updatedAt = LocalDateTime.now(),
            createdAt = LocalDateTime.now(),
            date = LocalDate.now(),
            type = Bet.TypeBet.LOTOFACIL
        )
    }
}