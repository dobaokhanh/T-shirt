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
public class OrderlineController {
	@Autowired
	private OrderlineRepository orderlineRepository;
	@RequestMapping(value = "/orderlines",produces={"application/json","application/xml"})
	Iterable<Orderline> Orderline(){
		return orderlineRepository.findAll();
	}
	
	@RequestMapping(value ="/orderlines/{id}", produces={"application/json","application/xml"})
	public Optional<Orderline> getOrderline(@PathVariable("id") int id){
		return orderlineRepository.findById(id);
	}
	
	@RequestMapping(value = "/orderline" , method = RequestMethod.POST, produces={"application/json","application/xml"})
    public @ResponseBody Orderline create(@RequestBody Orderline item) {
    	return orderlineRepository.save(item);
	}
	
	 @RequestMapping(value = "/orderline" , method = RequestMethod.PUT, produces={"application/json","application/xml"})
	    public @ResponseBody Orderline update(@RequestBody Orderline item) {
	    	return orderlineRepository.save(item);
	}
	 
	 @RequestMapping(value = "/orderline" , method = RequestMethod.DELETE)
	    public void delete(@RequestBody Orderline item) {
	    	orderlineRepository.delete(item);
	} 
}
