package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryGridComponent extends AbstractComponent {

    private VerticalLayout componentRootLayout;

    private Icon iconAddEntry;

    private Button btnAdd;

    private DatePicker datePicker;

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

        /*Test Zwecke*/
        List<TrainingDiaryEntry> trainingDiaryEntries = new ArrayList<>();
        TrainingDiaryEntryDto trainingDiaryDto = new TrainingDiaryEntryDto();
        trainingDiaryDto.setSession("2x3x200m 4 min P; 6 min SP. 200 Sprüunge; Krafttraining; Auslaufen + Dehnen");
        trainingDiaryDto.setFeeling("Teest");
        trainingDiaryEntries.add(trainingDiaryDto);

        TrainingDiaryEntryDto trainingDiaryDto2 = new TrainingDiaryEntryDto();
        trainingDiaryDto2.setSession("2x3x200m 4 min P; 6 min SP. 200 Sprüunge; Krafttraining");
        trainingDiaryDto2.setFeeling("Sehr gut");
        trainingDiaryEntries.add(trainingDiaryDto2);

        this.btnAdd = new Button();
        this.btnAdd.setText("Hinzufügen");
        this.btnAdd.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        this.trainingDiaryGrid = new Grid<>();
        Grid.Column<TrainingDiaryEntry> dateColumn = this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getDate).setHeader("Datum");
        Grid.Column<TrainingDiaryEntry> sessionColumn = this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getSession).setHeader("Einheit");
        Grid.Column<TrainingDiaryEntry> feelingColumn = this.trainingDiaryGrid.addColumn(TrainingDiaryEntry::getFeeling).setHeader("Gefühlszustand");
        Grid.Column<TrainingDiaryEntry> shareIconColumn = this.trainingDiaryGrid.addComponentColumn(entry -> new Button(VaadinIcon.SHARE.create(), doOnClickShare()));
        Grid.Column<TrainingDiaryEntry> deleteIconColumn = this.trainingDiaryGrid.addComponentColumn(trainingDiaryEntry -> new Button(VaadinIcon.CLOSE_CIRCLE_O.create(), doOnClickClose()));
        //this.trainingDiaryGrid.addThemeVariants((GridVariant.LUMO_NO_BORDER));
        this.trainingDiaryGrid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);


        this.datePicker = new DatePicker();
        this.datePicker.setClearButtonVisible(true);

        HeaderRow headerRow = this.getTrainingDiaryGrid().appendHeaderRow();
        headerRow.getCell(dateColumn).setComponent(this.getDatePicker());

        this.getTrainingDiaryGrid().setItems(trainingDiaryEntries);

    }

    private ComponentEventListener<ClickEvent<Button>> doOnClickShare() {
        return buttonClickEvent -> {
            System.out.println("Klick test");
        };
    }

    private ComponentEventListener<ClickEvent<Button>> doOnClickClose() {
        return buttonClickEvent -> {
            System.out.println("Klick close");
        };
    }

    private void initializeComponentRootLayout(){
        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();
        this.getComponentRootLayout().add(this.getBtnAdd());
        this.getComponentRootLayout().add(this.getTrainingDiaryGrid());
    }

    @Override
    protected void initializeComponentsActions() {

        this.getDatePicker().addValueChangeListener(doOnClickDate());

    }

    private HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<DatePicker, LocalDate>> doOnClickDate() {
        return datePickerLocalDateComponentValueChangeEvent -> {

            LocalDate date = datePicker.getValue();
            if (date == null) {
                System.out.println("Feld ist leer");
            } else {
                System.out.println(date);
            }
        };
    }
}
