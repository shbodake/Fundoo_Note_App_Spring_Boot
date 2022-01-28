package com.project.fundoonotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.repo.LabelRepository;

/**
* @Service : creating service layer
* @Autowired : enabling automatic dependency Injection
* @Override : Overriding implemented methods from interface
*/
@Service
public class LabelService implements ILabelService {
	
	 /**
     * Autowiring LabelRepository to Dependency injection to save in DB
     */
	@Autowired
	private LabelRepository labelRepository;

	/**
     * implementing method to update Label
     */
	@Override
	public Label updateLabel(int id, LabelDto labelDto) {
		Label label = labelRepository.getById(id);
		label.updateLabel(labelDto);
		return labelRepository.save(label);

	}

	/**
     * implementing method to delete Label by id in DB
     */
	@Override
	public void deleteLabelbyID(int id) {
		labelRepository.deleteById(id);
	}

	/**
     * implementing method to get all Labels
     */
	@Override
	public List<Label> getAllLabels() {
		return labelRepository.findAll();
	}

	 /**
     * implementing method to get label by its ID
     */
	@Override
	public Label geLabelById(int id) {
		return labelRepository.findById(id).get();
	}

	/**
     * implementing method to crete Label in table
     */
	@Override
	public Label creatLabel(LabelDto labelDto) {
		Label label= null;
		label = new Label(labelDto);
		return labelRepository.save(label);
	}

	

}
