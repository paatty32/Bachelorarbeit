package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.HeaderComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class DiaryTabContainerComponent extends AbstractComponent {

    private VerticalLayout componentRootLayout;

    private Tabs diary;
    private Tab trainingTab;
    private Tab competitionTab;
    private Tab trainingPlanTab;

    private VerticalLayout tabContent;

    private final HeaderComponent headerComponent;

    private final TrainingDiaryGridComponent trainingDiaryGridComponent;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

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

        this.tabContent = new VerticalLayout();
        this.tabContent.setSizeFull();
        this.getTabContent().add(this.getTrainingDiaryGridComponent());

    }

    private void initializeComponentRootLayout(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();
        this.getComponentRootLayout().add(this.getHeaderComponent());
        this.getComponentRootLayout().add(this.getDiary());
        this.getComponentRootLayout().add(this.getTabContent());
        this.getComponentRootLayout().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, this.getDiary());

    }

    @Override
    protected void initializeComponentsActions() {

        this.getDiary().addSelectedChangeListener(
                event -> this.setTabContent(event.getSelectedTab())
        );
    }

    private void setTabContent(Tab selectedTab) {

        this.getTabContent().removeAll();

        switch (selectedTab.getLabel()){
            case "Training":
                //TODO: this.getTabContent.addComponent
                this.getTabContent().add(this.getTrainingDiaryGridComponent());
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

}
