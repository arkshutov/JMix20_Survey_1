package com.company.jmix20_survey_1.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "QUESTION")
@Entity
public class Question {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "QUESTION_NAME", nullable = false)
    @NotNull
    private String questionName;

    @Composition
    @OneToMany(mappedBy = "question")
    private List<Answer> varAnswers;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public List<Answer> getVarAnswers() {
        return varAnswers;
    }

    public void setVarAnswers(List<Answer> varAnswers) {
        this.varAnswers = varAnswers;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}