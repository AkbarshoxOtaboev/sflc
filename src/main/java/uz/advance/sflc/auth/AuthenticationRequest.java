package uz.advance.sflc.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign in request")
public class AuthenticationRequest {
    @Schema(description = "username", example = "jon")
    @Size(min = 5, max = 50, message = "The username must contain from 5 to 50 characters")
    @NotBlank(message = "The username cannot be empty")
    private String username;

    @Schema(description = "password", example = "aw@$?qw")
    @Size(min=8, max = 255, message = "The password must be between 8 and 255 characters long")
    @NotBlank(message = "The password cannot be empty")
    private String password;
}
