package jp.canetrash.sample.javaee7.mvc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

	private Map<Long, Hello> hellos = new ConcurrentHashMap<Long, Hello>();

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Hello());
		return "hello/createForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Hello hello, BindingResult result) {
		if (result.hasErrors()) {
			return "hello/createForm";
		}
		this.hellos.put(hello.assignId(), hello);
		return "redirect:/hello/" + hello.getId();
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Hello hello = this.hellos.get(id);
		if (hello == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(hello);
		return "hello/view";
	}
}
