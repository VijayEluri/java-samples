package tutorial.agile.service;

import javax.annotation.Resource;

import tutorial.infrastructure.service.SpringAddService;

public class AddService {

	@Resource
	protected SpringAddService springAddService;

	public int calculate(int arg1, int arg2) {
		return springAddService.calculate(arg1, arg2);
	}
}