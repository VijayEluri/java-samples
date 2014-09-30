package tutorial.infrastructure.service;

import org.springframework.stereotype.Service;

@Service
public class SpringAddService {

	public int calculate(int arg1, int arg2) {
		return arg1 + arg2;
	}
}