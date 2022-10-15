package br.com.horys.resources

import br.com.horys.models.User
import br.com.horys.repositories.UserRepository
import br.com.horys.resources.UserResource.UserResponse
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/v1/users")
class UserResource(
    private val userRepository: UserRepository
) {

    @POST
    fun save(@Valid request: UserRequest): UserResponse {
        val user = User(
            id = null,
            name = request.name,
            password = request.password
        )
        userRepository.persist(user)
        return user.toResponse()
    }

    class UserRequest(
        @field:NotBlank val name: String = "",
        @field:NotBlank val password: String = ""
    )

    class UserResponse(
        val name: String,
    )
}

private fun User.toResponse(): UserResponse {
    return UserResponse(
        name = this.name
    )
}
