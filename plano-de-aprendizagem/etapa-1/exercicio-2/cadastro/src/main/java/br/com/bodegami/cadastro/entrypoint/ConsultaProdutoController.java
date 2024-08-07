package br.com.bodegami.cadastro.entrypoint;

import br.com.bodegami.cadastro.entrypoint.dto.ProdutoResponse;
import br.com.bodegami.cadastro.usecase.ConsultarProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ConsultaProdutoController {

    @Autowired
    private ConsultarProdutoUseCase consultarProdutoUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> consultaProdutoPorId(@PathVariable Long id) {

        var response = consultarProdutoUseCase.consultarPorId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> consultarProdutos() {

        List<ProdutoResponse> response = consultarProdutoUseCase.consultarTodosProdutos();

        return ResponseEntity.ok(response);
    }

}
