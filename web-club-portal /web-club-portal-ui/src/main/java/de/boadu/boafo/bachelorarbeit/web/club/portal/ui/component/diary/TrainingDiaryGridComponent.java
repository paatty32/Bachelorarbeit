package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.List;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryGridComponent extends AbstractComponent {

    private VerticalLayout componentRootLayout;

    private Icon iconAddEntry;

    private Grid<TrainingDiaryEntry> trainingDiaryGrid;
    private List<TrainingDiary> trainingDiaryList;


    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.initializeGrid();
        this.initializeComponentRootLayout();

    }

    private void initializeGrid(){

        this.trainingDiaryGrid = new Grid<>();
        this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getDate).setHeader("Datum");
        this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getSession).setHeader("Einheit");
        this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getFeeling).setHeader("Gefühlszustand");
        this.trainingDiaryGrid.addThemeVariants((GridVariant.LUMO_NO_BORDER));


    }

    private void initializeComponentRootLayout(){
        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();
        this.getComponentRootLayout().add(this.getTrainingDiaryGrid());
    }


    @Override
    protected void initializeComponentsActions() {

    }
}
