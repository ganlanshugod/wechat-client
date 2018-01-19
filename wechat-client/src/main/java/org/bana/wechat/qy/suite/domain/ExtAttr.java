package org.bana.wechat.qy.suite.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.bana.wechat.cp.common.AttrObject;

public class ExtAttr {

	private List<AttrObject> attrList;

	@XmlElement(name="Item")
	public List<AttrObject> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<AttrObject> attrList) {
		this.attrList = attrList;
	}

	@Override
	public String toString() {
		return "ExtAttr [attrList=" + attrList + "]";
	}
}
