package com.spring.core.aop;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(prefix="icecream",value="enabled",havingValue="ButterScotch",matchIfMissing = false)
public class ButterScotch {
	@Autowired
	private Vanilla vanilla;
	
	@PostConstruct
	public void butterScotchVibes() {
		System.out.println("ButterScotch is my fav");
		vanilla.vanillaVibes();
	}

}
