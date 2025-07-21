package app.repository;

import app.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Este é um repositório mock (simulado) para fins de exemplo.
// Em uma aplicação real, você usaria um banco de dados (SQL, NoSQL, etc.).
public class UsuarioRepository {

    // Simula um armazenamento em memória com um ConcurrentHashMap para thread-safety
    private final Map<String, Usuario> usuarios = new ConcurrentHashMap<>();
    // Usado para gerar IDs sequenciais para novos usuários
    private final AtomicLong idCounter = new AtomicLong();

    public UsuarioRepository() {
        // Adiciona alguns usuários de exemplo ao inicializar o repositório
        save(new Usuario(null, "Alice Silva", "alice@example.com"));
        save(new Usuario(null, "Bruno Costa", "bruno@example.com"));
        save(new Usuario(null, "Carla Santos", "carla@example.com"));
    }

    public List<Usuario> findAll() {
        // Retorna todos os usuários como uma nova ArrayList para evitar modificações externas
        return new ArrayList<>(usuarios.values());
    }

    public Optional<Usuario> findById(String id) {
        // Retorna um Optional contendo o usuário se encontrado, ou um Optional vazio
        return Optional.ofNullable(usuarios.get(id));
    }

    public Usuario save(Usuario usuario) {
        // Se o usuário não tem um ID, gera um novo
        if (usuario.getId() == null || usuario.getId().isEmpty()) {
            usuario.setId(String.valueOf(idCounter.incrementAndGet()));
        }
        // Armazena o usuário no mapa
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Usuario update(Usuario usuario) {
        // Verifica se o usuário existe antes de atualizar
        if (usuarios.containsKey(usuario.getId())) {
            usuarios.put(usuario.getId(), usuario);
            return usuario;
        }
        // Em um projeto real, você lançaria uma exceção ou retornaria um erro
        throw new IllegalArgumentException("Usuário não encontrado para atualização com ID: " + usuario.getId());
    }

    public void delete(String id) {
        // Remove o usuário do mapa
        usuarios.remove(id);
    }
}
