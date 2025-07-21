package app;

import io.jooby.Jooby;
import app.controller.UsuarioController;
import io.jooby.jackson.JacksonModule;

public class App extends Jooby {

    public App() {
        install(new JacksonModule());

        get("/", ctx -> "Bem-vindo à API de Usuários Jooby!");

        mount(new UsuarioController());
    }

    public static void main(String[] args) {
        runApp(args, App::new);
    }
}
