package be.onurbugdayci.mvc.services;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloService implements Hello{
    @Override
    public String sayHello() {
        return "Hello World";
    }
}
