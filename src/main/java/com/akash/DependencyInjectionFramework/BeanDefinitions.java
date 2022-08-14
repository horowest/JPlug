package com.akash.DependencyInjectionFramework;

import java.util.List;

public class BeanDefinitions {
	private String name;
	private String className;
	// private List<DependencyBean> dependencies;
	
	public BeanDefinitions(String name, String className) {
		this.name = name;
		this.className = className;
		// this.dependencies = dependencies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

//	public List<DependencyBean> getDependencies() {
//		return dependencies;
//	}
//
//	public void setDependencies(List<DependencyBean> dependencies) {
//		this.dependencies = dependencies;
//	}

	@Override
	public String toString() {
		return "BeanDefinitions [name=" + name + ", className=" + className + ", dependencies=" + /*dependencies +*/ "]";
	}
	
	
	
}
