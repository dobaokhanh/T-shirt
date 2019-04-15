package fi.vamk.e1700699.tshirt;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value = "/users",produces={"application/json","application/xml"})
	Iterable<User> user(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value ="/user/{id}", produces={"application/json","application/xml"})
	public Optional<User> getUser(@PathVariable("id") int id){
		return userRepository.findById(id);
	}
	
	@RequestMapping(value = "/user" , method = RequestMethod.POST, produces={"application/json","application/xml"})
    public @ResponseBody User create(@RequestBody User item) {
    	return userRepository.save(item);
	}
	
	 @RequestMapping(value = "/user" , method = RequestMethod.PUT, produces={"application/json","application/xml"})
	    public @ResponseBody User update(@RequestBody User item) {
	    	return userRepository.save(item);
	}
	 
	 @RequestMapping(value = "/user" , method = RequestMethod.DELETE)
	    public void delete(@RequestBody User item) {
	    	userRepository.delete(item);
	} 
}
