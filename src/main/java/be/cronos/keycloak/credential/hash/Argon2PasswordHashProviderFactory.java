package be.cronos.keycloak.credential.hash;

import de.mkammerer.argon2.Argon2Constants;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.credential.hash.PasswordHashProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

/**
 * @author <a href="mailto:dries.eestermans@is4u.be">Dries Eestermans</a>
 */
public class Argon2PasswordHashProviderFactory implements PasswordHashProviderFactory {
    private static final Logger LOG = Logger.getLogger(Argon2PasswordHashProviderFactory.class);

    public static final String ID = "argon2";

    public static final int DEFAULT_ITERATIONS = 1;

    public static final int DEFAULT_MEMORY = 65536;

    public static final int DEFAULT_PARALLELISM = 1;

    public static final int DEFAULT_MAX_TIME = 1000;

    @Override
    public PasswordHashProvider create(KeycloakSession session) {
        return new Argon2PasswordHashProvider(ID, Argon2Types.ARGON2id, DEFAULT_ITERATIONS, DEFAULT_MEMORY, DEFAULT_PARALLELISM, Argon2Constants.DEFAULT_HASH_LENGTH, Argon2Constants.DEFAULT_SALT_LENGTH, DEFAULT_MAX_TIME, session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void close() {
    }
}
