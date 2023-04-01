# OAuth2 Micronaut Keycloak

This is a basic application showing how is easy to setup micronaut security oauth2 with Keycloak.

To run the example, set the environment variables below:

```
$ export OAUTH_ISSUER=http://localhost:8081/realms/development
$ export OAUTH_CLIENT_SECRET=tKCakYu8SeWqtuO1sVGxvPsiJcv1ySzf
$ export OAUTH_CLIENT_ID=micronaut
```

After setting the environment variables, run with the following command:
```
$ ./gradlew run
```
## Authenticate

To authenticate to the application, access "http//localhost:8080/oauth/login/keycloak", this will redirect to keycloak
URL.

After the authentication, you have the option to access two secured resources as the following:

- /secure-viewer
    - This endpoint will validate if the user has the role *user_viewer*

- /secure-admin
    - This endpoint will validate if the user has the role *admin_user*

- At the endpoint / will show a simple "Hello World" message to any user (anonymous rule).

As an observation, maybe with only adding a user and a role in keycloak and authenticating may not load the roles for
the application, so you need to include the role in token scope and add to ID Token. 

More info, see my post at [Oauth2 Micronaut with Keycloak OpenId Connect](https://gabrielpadilh4.github.io/hello/2023/03/31/oauth2-micronaut-keycloak-openid-connect.html)
