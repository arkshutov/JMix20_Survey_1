package com.company.jmix20_survey_1.view.question;

import com.company.jmix20_survey_1.entity.Question;

import com.company.jmix20_survey_1.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "questions/:id", layout = MainView.class)
@ViewController("Question.detail")
@ViewDescriptor("question-detail-view.xml")
@EditedEntityContainer("questionDc")
public class QuestionDetailView extends StandardDetailView<Question> {
}