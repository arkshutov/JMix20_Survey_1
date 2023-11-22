package com.company.jmix20_survey_1.view.answer;

import com.company.jmix20_survey_1.entity.Answer;

import com.company.jmix20_survey_1.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "answers/:id", layout = MainView.class)
@ViewController("Answer.detail")
@ViewDescriptor("answer-detail-view.xml")
@EditedEntityContainer("answerDc")
public class AnswerDetailView extends StandardDetailView<Answer> {
}