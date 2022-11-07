package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractObserver;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.HeaderComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.event.TrainingsDiaryEventListener;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.event.TrainingsDiaryClickedEventRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class DiaryTabContainer extends AbstractComponent implements TrainingsDiaryEventListener {

    private VerticalLayout componentRootLayout;

    private Tabs diary;
    private Tab trainingTab;
    private Tab competitionTab;
    private Tab trainingPlanTab;

    private HorizontalLayout tabContent;

    private final HeaderComponent headerComponent;

    private final TrainingDiaryGridComponent trainingDiaryGridComponent;

    private final TrainingDiaryFormComponent trainingDiaryFormComponent;

    private final AbstractObserver<TrainingsDiaryEventListener> trainingsDiaryObserver;


    private void attachListener(){

        this.getTrainingsDiaryObserver().addEventListenersForShowingForm(this);

    }

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.attachListener();
        this.initializeTabComponent();
        this.initializeComponentRootLayout();

    }

    private void initializeTabComponent(){

        this.trainingTab = new Tab("Training");
        this.competitionTab = new Tab("Wettkampf");
        this.trainingPlanTab = new Tab("Trainingsplan");

        this.diary = new Tabs();
        this.diary.add(this.getTrainingTab());
        this.diary.add(this.getCompetitionTab());
        this.diary.add(this.getTrainingPlanTab());

        this.tabContent = new HorizontalLayout();
        this.tabContent.setSizeFull();
        this.getTabContent().add(this.getTrainingDiaryGridComponent());
        this.getTabContent().add(this.getTrainingDiaryFormComponent());

    }

    private void initializeComponentRootLayout(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();
        this.getComponentRootLayout().add(this.getHeaderComponent());
        this.getComponentRootLayout().add(this.getDiary());
        this.getComponentRootLayout().add(this.getTabContent());
        this.getComponentRootLayout().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, this.getDiary());

    }

    private void setTabContent(Tab selectedTab) {

        this.getTabContent().removeAll();

        switch (selectedTab.getLabel()){
            case "Training":
                //TODO: this.getTabContent.addComponent
                this.getTabContent().add(this.getTrainingDiaryGridComponent());
                this.getTabContent().add(this.getTrainingDiaryFormComponent());
                System.out.println("Training Tab");
                break;

            case "Wettkampf":
                System.out.println("Wettkampf Tab");
                break;

            case "Trainingsplan":
                System.out.println("Trainingsplan");
                break;
        }


    }

    @Override
    protected void initializeComponentsActions() {

        this.getDiary().addSelectedChangeListener(
                event -> this.setTabContent(event.getSelectedTab())
        );
    }

    @Override
    public void handleClickGrid(TrainingsDiaryClickedEventRequest event) {

        this.getTrainingDiaryFormComponent().setVisible(true);

        TrainingDiaryEntry entry = event.getEntry();
        String session = entry.getSession();
        String feeling = entry.getFeeling();
        Date date = entry.getDate();

        this.getTrainingDiaryFormComponent().setTextArea(session, feeling);

    }
}
