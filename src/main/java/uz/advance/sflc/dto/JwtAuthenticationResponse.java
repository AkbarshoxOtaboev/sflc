package uz.advance.sflc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Access token response")
public class JwtAuthenticationResponse {

    @Schema(description = "access_token", example = "dasndlknsdlkanlksdn.sjdhkiajshdi...")
    private String token;
}
