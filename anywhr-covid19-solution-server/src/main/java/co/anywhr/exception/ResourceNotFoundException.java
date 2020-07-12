package co.anywhr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author ntthuat
 */
public class ResourceNotFoundException extends ResponseStatusException {
    private String template;
    private String resource;
    private String name;

    public ResourceNotFoundException(Class<?> resource, String name) {
        this(resource.getSimpleName(), name);
    }

    public ResourceNotFoundException(String resource, String name) {
        super(HttpStatus.NOT_FOUND);
        this.template = "%s with name %s does not exist";
        this.resource = resource;
        this.name = name;
    }

    public String getMessage() {
        return String.format(this.template, this.resource, this.name);
    }
}
