package cinema;

import java.util.UUID;

public class Token {

    UUID token;

    public Token() {
        token = UUID.randomUUID();
    }

    public Token(UUID uuid) {
        this.token = uuid;
    }

    public void setToken(String usedToken) {
        token = UUID.fromString(usedToken);
    }

    public UUID getToken() {
        return token;
    }
}
