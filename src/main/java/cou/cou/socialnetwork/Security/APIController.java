package cou.cou.socialnetwork.Security;

import cou.cou.socialnetwork.Security.MessageAuthentification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class APIController {
    @GetMapping(value = "/user")
    public MessageAuthentification publicEndpoint() {
        return new MessageAuthentification("All good. You DO NOT need to be authenticated to call /user.");
    }

    @GetMapping(value = "/friend")
    public MessageAuthentification privateScopedEndpoint() {
        return new MessageAuthentification("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    } 
}
