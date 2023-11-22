package com.company.jmix20_survey_1.view.voite;

import com.company.jmix20_survey_1.entity.Answer;
import com.company.jmix20_survey_1.entity.Question;
import com.company.jmix20_survey_1.view.main.MainView;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.radiobuttongroup.JmixRadioButtonGroup;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route(value = "VoiteView", layout = MainView.class)
@ViewController("VoiteView")
@ViewDescriptor("voite-view.xml")
public class VoiteView extends StandardView {
    @Autowired
    private DataManager dataManager;

    @ViewComponent
    private VerticalLayout vboxLayout;
    @ViewComponent
    private Span spanQuestion;

    @ViewComponent
    private Span spanResult;

    @ViewComponent
    private RadioButtonGroup<String> ratioAnswers;

    @Subscribe(id = "buttonStart", subject = "clickListener")
    public void onButtonStartClick(final ClickEvent<JmixButton> event) {

        List<Question> questions = dataManager.load(Question.class).all().list();

        if(!questions.isEmpty()) {
            Question current_question = questions.get(0);
            vboxLayout.setVisible(true);
            spanQuestion.setText(current_question.getQuestionName());

            ratioAnswers.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
            ratioAnswers.setLabel("Answers");

            List<Answer> current_answers = current_question.getVarAnswers();
            if(!current_answers.isEmpty()) {
                List<String> outputList = new ArrayList<>(current_answers.size());
                for(Answer obj : current_answers){
                    outputList.add(obj.getAnswerName());
                }
                ratioAnswers.setItems(outputList);
            }
        }
    }

    @Subscribe("ratioAnswers")
    public void onRatioAnswersComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixRadioButtonGroup, Object> event) {

        spanResult.setText("Currently selected: " + ratioAnswers.getValue());
    }


}