package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.competition;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class CompetitionDiaryComponent extends AbstractComponent {

    private VerticalLayout componentRootLayout;

    private Button btnAdd;

    private DatePicker datePicker;

    private TextField tfSearchPlace;

    private TextField tfSearchDiscipline;

    private Grid<CompetitionDiaryEntry> competitionDiaryEntryGrid;
    private List<CompetitionDiaryEntry> competitionDiaryEntryBuffer;
    private InMemoryDataProvider<CompetitionDiaryEntry> competitionDiaryEntryInMemoryDataProvider;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

        this.competitionDiaryEntryBuffer = new ArrayList<>();

    }

    @Override
    protected void initializeComponents() {

        this.initializeGrid();
        this.initializeRootLayout();

    }

    private void initializeGrid(){

        this.competitionDiaryEntryGrid = new Grid<>();
        this.competitionDiaryEntryGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.competitionDiaryEntryGrid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
        this.competitionDiaryEntryGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

        Grid.Column<CompetitionDiaryEntry> competitionDiaryDateColumn = this.competitionDiaryEntryGrid.addColumn(CompetitionDiaryEntry::getDate).setHeader("Datum");
        Grid.Column<CompetitionDiaryEntry> competitionDiaryPlaceColumn = this.competitionDiaryEntryGrid.addColumn(CompetitionDiaryEntry::getPlace).setHeader("Ort");
        Grid.Column<CompetitionDiaryEntry> competitionDiaryDisciplineColumn = this.competitionDiaryEntryGrid.addColumn(CompetitionDiaryEntry::getDicipline).setHeader("Disziplin");
        Grid.Column<CompetitionDiaryEntry> competitionDiaryResaultColumn = this.competitionDiaryEntryGrid.addColumn(CompetitionDiaryEntry::getResaults).setHeader("Ergebnis");
        Grid.Column<CompetitionDiaryEntry> competitionDiaryFeelingColumn = this.competitionDiaryEntryGrid.addColumn(CompetitionDiaryEntry::getFeeling).setHeader("Zufriedenheit");

        Grid.Column<CompetitionDiaryEntry> shareIconColumn = this.competitionDiaryEntryGrid.addComponentColumn(entry -> new Button(VaadinIcon.SHARE.create()));

        this.btnAdd = new Button();
        this.btnAdd.setText("Hinzufügen");
        this.btnAdd.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        this.datePicker = new DatePicker();
        this.datePicker.setLocale(Locale.GERMANY);
        this.datePicker.setClearButtonVisible(true);
        this.datePicker.setWidth("150px");

        this.tfSearchPlace = new TextField();
        this.tfSearchPlace.setClearButtonVisible(true);
        this.tfSearchPlace.setPrefixComponent(VaadinIcon.SEARCH.create());
        this.tfSearchPlace.setWidth("150px");

        this.tfSearchDiscipline = new TextField();
        this.tfSearchDiscipline.setClearButtonVisible(true);
        this.tfSearchDiscipline.setPrefixComponent(VaadinIcon.SEARCH.create());
        this.tfSearchDiscipline.setWidth("150px");

        HeaderRow headerRow = this.getCompetitionDiaryEntryGrid().appendHeaderRow();
        headerRow.getCell(competitionDiaryDateColumn).setComponent(this.getDatePicker());
        headerRow.getCell(competitionDiaryPlaceColumn).setComponent(this.getTfSearchPlace());
        headerRow.getCell(competitionDiaryDisciplineColumn).setComponent(this.getTfSearchDiscipline());
    }

    private void initializeRootLayout(){

        this.componentRootLayout = new VerticalLayout();

        this.getComponentRootLayout().add(this.getCompetitionDiaryEntryGrid());

    }

    @Override
    protected void initializeComponentsActions() {


    }
}
