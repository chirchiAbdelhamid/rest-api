package com.ncq.restApi.mapper;

import org.springframework.stereotype.Component;

import com.ncq.restApi.Representation.WorkflowCategoryRepresentation;
import com.ncq.restApi.model.Category;

@Component
public class CategoryToRepresentationMapper {

	public WorkflowCategoryRepresentation toRepresentation(Category category) {
		if (category != null) {
			return new WorkflowCategoryRepresentation(category.getName(), category.getDescription(),
					category.getCreateAt(), category.getUpdateAt(), category.getEnabled(),
					this.toRepresentation(category.getParentCategory()));
		} else {
			return null;
		}

	}

}
