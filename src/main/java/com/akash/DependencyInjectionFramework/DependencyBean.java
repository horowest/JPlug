package com.akash.DependencyInjectionFramework;

public class DependencyBean {
	private String propName;
	private String ref;
	
	public DependencyBean(String propName, String ref) {
		this.propName = propName;
		this.ref = ref;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	@Override
	public String toString() {
		return "DependencyBean [propName=" + propName + ", ref=" + ref + "]";
	}
	
	
}
