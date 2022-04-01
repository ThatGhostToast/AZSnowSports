package com.azsnowsports.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "blogs")
public class BlogList {

	// List for holding all of the orders
	private List<PostModel> blogs = new ArrayList<PostModel>();

	/**
	 * Method used for returning the list of blogs tagged with XmlElement
	 * 
	 * @return returns the list of blogs
	 */
	@XmlElement(name = "blogs")
	public List<PostModel> getOrders() {
		return this.blogs;
	}

	/**
	 * Method used to set the list of orders
	 * 
	 * @param orders Orders being added into the list
	 */
	public void setOrders(List<PostModel> orders) {
		this.blogs = orders;
	}
}
