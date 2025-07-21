package app.controller;

import app.model.Usuario;
import app.repository.UsuarioRepository;
import io.jooby.Context;
import io.jooby.Jooby;

import java.util.Optional;

public class UsuarioController extends Jooby {

  public UsuarioController() {
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    // GET /usuarios - lista todos os usuários
    get("/usuarios", ctx -> usuarioRepository.findAll());

    // GET /usuarios/{id} - busca por ID
    get("/usuarios/{id}", ctx -> {
      String id = ctx.path("id").value();
      Optional<Usuario> usuario = usuarioRepository.findById(id);
      return usuario.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + id));
    });

    // POST /usuarios - cria um novo usuário
    post("/usuarios", ctx -> {
      Usuario usuario = ctx.body().to(Usuario.class);
      return usuarioRepository.save(usuario);
    });

    // PUT /usuarios/{id} - atualiza usuário
    put("/usuarios/{id}", ctx -> {
      String id = ctx.path("id").value();
      Usuario usuario = ctx.body().to(Usuario.class);
      usuario.setId(id);
      return usuarioRepository.update(usuario);
    });

    // DELETE /usuarios/{id} - remove usuário
    delete("/usuarios/{id}", ctx -> {
      String id = ctx.path("id").value();
      usuarioRepository.delete(id);
      return "Usuário com ID " + id + " excluído com sucesso.";
    });
  }
}
