package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxCategory extends AjaxCategoryResult{
	@JsonProperty("data")
	private List<CategoryDTO> list;

	public AjaxCategory(List<CategoryDTO> list) {
		super();
		this.list = list;
	}

	public AjaxCategory() {
		super();
	}

	public List<CategoryDTO> getList() {
		return list;
	}

	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
}
