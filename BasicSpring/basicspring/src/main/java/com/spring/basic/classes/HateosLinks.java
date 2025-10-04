package com.spring.basic.classes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;


public class HateosLinks {
	private List<Link> links = new ArrayList<>();
	public void addLink(Link verifyLink)
	{
		links.add(verifyLink);
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	

}
