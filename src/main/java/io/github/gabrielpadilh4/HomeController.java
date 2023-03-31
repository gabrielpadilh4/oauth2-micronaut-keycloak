package io.github.gabrielpadilh4;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static io.micronaut.security.rules.SecurityRule.IS_ANONYMOUS;

@Controller
public class HomeController {

    @Secured(IS_ANONYMOUS)
    @Get
    public Map<String, Object> index() {
        return Collections.singletonMap("Hello","World");
    }

    @Get("/secure-admin")
    @Secured({"admin_user"})
    public SecureModel securedAdmin(Authentication authentication) {
        Map<String, Object> attrs = authentication.getAttributes();
        Collection<String> roles = authentication.getRoles();
        String name = authentication.getName();

        return new SecureModel(attrs, roles, name);
    }

    @Get("/secure-viewer")
    @Secured({"user_viewer"})
    public SecureModel securedUser(Authentication authentication) {
        Map<String, Object> attrs = authentication.getAttributes();
        Collection<String> roles = authentication.getRoles();
        String name = authentication.getName();

        return new SecureModel(attrs, roles, name);
    }

}

record SecureModel (
        Map<String, Object> attrs,
        Collection<String> roles,
        String name
){}
