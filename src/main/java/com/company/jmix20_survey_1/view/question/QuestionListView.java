package com.company.jmix20_survey_1.view.question;

import com.company.jmix20_survey_1.entity.Question;

import com.company.jmix20_survey_1.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "questions", layout = MainView.class)
@ViewController("Question.list")
@ViewDescriptor("question-list-view.xml")
@LookupComponent("questionsDataGrid")
@DialogMode(width = "64em")
public class QuestionListView extends StandardListView<Question> {
}