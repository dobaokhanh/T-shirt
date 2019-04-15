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
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	@RequestMapping(value = "/orders",produces={"application/json","application/xml"})
	Iterable<Myorder> order(){
		return orderRepository.findAll();
	}
	
	@RequestMapping(value ="/order/{id}", produces={"application/json","application/xml"})
	public Optional<Myorder> getOrder(@PathVariable("id") int id){
		return orderRepository.findById(id);
	}
	
	@RequestMapping(value = "/order" , method = RequestMethod.POST, produces={"application/json","application/xml"})
    public @ResponseBody Myorder create(@RequestBody Myorder item) {
    	return orderRepository.save(item);
	}
	
	 @RequestMapping(value = "/order" , method = RequestMethod.PUT, produces={"application/json","application/xml"})
	    public @ResponseBody Myorder update(@RequestBody Myorder item) {
	    	return orderRepository.save(item);
	}
	 
	 @RequestMapping(value = "/order" , method = RequestMethod.DELETE)
	    public void delete(@RequestBody Myorder item) {
	    	orderRepository.delete(item);
	} 
}
