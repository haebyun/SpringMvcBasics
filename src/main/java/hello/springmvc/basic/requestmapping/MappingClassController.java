package hello.springmvc.basic.requestmapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    private final Set<String> members = new HashSet<>();

    @GetMapping
    public String getUsers() {
        return members.stream()
                .map(s -> s + "\n")
                .collect(Collectors.joining());
    }

    @PostMapping(value = "/{userId}")
    public String saveUser(@PathVariable String userId) {
        members.add(userId);
        return "ok";
    }

    @GetMapping(value = "/{userId}")
    public String findUser(@PathVariable String userId) {
        if(members.contains(userId)) {
            return "find userId = " + userId;
        }
        return "no";
    }

    @PatchMapping(value = "/{userId}")
    public String updateUser(@PathVariable String userId) {
        if(members.contains(userId)) {
            return "update userId = " + userId;
        }
        return "no";
    }

    @DeleteMapping(value = "/{userId}")
    public String deleteUser(@PathVariable String userId) {
        if(members.contains(userId)) {
            members.remove(userId);
            return "delete userId = " + userId;
        }
        return "no";
    }
}
