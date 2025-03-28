package dio.springbootweb.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    @Operation(summary = "Saudação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saudação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public String sayHello() {
        return "Olá, mundo!";
    }
}