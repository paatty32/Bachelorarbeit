package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.config.security.SecurityService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.MutableTrainingPlanEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlanEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.TrainingPlanUiService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractObserver;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplandialogform.TrainingPlanDialogFormEventListener;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplandialogform.TrainingPlanDialogFormEventRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplanform.TrainingPlanFormDeleteEntryEventRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplanform.TrainingPlanFormEventListener;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplanform.TrainingPlanFormEventRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplangrid.TrainingPlanGridEventListener;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplangrid.TrainingPlanGridEventRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingplanContainer extends AbstractComponent implements TrainingPlanGridEventListener,
        TrainingPlanDialogFormEventListener, TrainingPlanFormEventListener {

    private HorizontalLayout componentRootLayout;

    private final TrainingPlanGridComponent trainingPlanGridComponent;

    private final TrainingPlanFormComponent trainingPlanFormComponent;

    private final TrainingPlanDialogFormComponent trainingPlanDialogFormComponent;

    private final AbstractObserver<TrainingPlanDialogFormEventListener> trainingPlanDialogFormComponentObserver;

    private final AbstractObserver<TrainingPlanGridEventListener> trainingPlanGridObserver;

    private final AbstractObserver<TrainingPlanFormEventListener> trainingPlanFormEventListenerObserver;

    private final SecurityService securityService;

    private final TrainingPlanUiService trainingPlanUiService;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.attachTrainingPlanGridEventListener();
        this.attachTrainingPlanDialogFormEventListener();
        this.attachTrainingPlanFormEventListener();
        this.initializeComponentRootLayout();

    }

    private void attachTrainingPlanGridEventListener(){

        this.getTrainingPlanGridObserver().addEventListeners(this);

    }

    private void attachTrainingPlanFormEventListener(){

        this.getTrainingPlanFormEventListenerObserver().addEventListeners(this);

    }

    private void attachTrainingPlanDialogFormEventListener(){

        this.getTrainingPlanDialogFormComponentObserver().addEventListeners(this);

    }

    private void initializeComponentRootLayout(){

        this.componentRootLayout = new HorizontalLayout();
        this.componentRootLayout.setSizeFull();

        this.getComponentRootLayout().add(this.getTrainingPlanGridComponent());
        this.getComponentRootLayout().add(this.getTrainingPlanFormComponent());
        this.getComponentRootLayout().add(this.getTrainingPlanDialogFormComponent());

    }

    @Override
    protected void initializeComponentsActions() {

    }

    @Override
    public void handleButtonAdd() {

        this.getTrainingPlanDialogFormComponent().openDialog();

    }

    @Override
    public void handleGridClick(TrainingPlanGridEventRequest event) {

        TrainingPlanEntry trainingPlanEntry = event.getTrainingPlanEntry();

        this.getTrainingPlanFormComponent().fillForm(trainingPlanEntry);
        this.getTrainingPlanFormComponent().setClickedEntryId(trainingPlanEntry);

        this.getTrainingPlanFormComponent().setVisible(true);

    }

    @Override
    public void handleButtonSave(TrainingPlanDialogFormEventRequest event) {

        MutableTrainingPlanEntry newEntry = event.getNewEntry();

        Long userId = this.getSecurityService().getUserId();

        this.getTrainingPlanUiService().addnewTrainingPlanEntry(userId, newEntry);
        List<TrainingPlanEntry> trainingPlanEntriesByUser = this.getTrainingPlanUiService().getTrainingPlanEntriesByUser(userId);

        this.getTrainingPlanGridComponent().clearData();
        this.getTrainingPlanGridComponent().refreshGrid(trainingPlanEntriesByUser);

    }

    @Override
    public void handleButtonUpdate(TrainingPlanFormEventRequest event) {

        MutableTrainingPlanEntry entry = event.getUpdatedEntry();

        this.getTrainingPlanUiService().updateEntry(entry);

        Long userId = this.getSecurityService().getUserId();

        List<TrainingPlanEntry> trainingPlanEntriesUpdated = this.getTrainingPlanUiService().getTrainingPlanEntriesByUser(userId);

        this.getTrainingPlanGridComponent().clearData();
        this.getTrainingPlanGridComponent().refreshGrid(trainingPlanEntriesUpdated);

    }

    @Override
    public void handleButtonDelete(TrainingPlanFormDeleteEntryEventRequest event) {

        Long userId = this.getSecurityService().getUserId();

        Long deleteEntryId = event.getDeleteEntryId();

        this.getTrainingPlanUiService().deleteTrainingPlanEntry(userId, deleteEntryId);

        List<TrainingPlanEntry> trainingPlanEntriesUpdated = this.getTrainingPlanUiService().getTrainingPlanEntriesByUser(userId);

        this.getTrainingPlanGridComponent().clearData();
        this.getTrainingPlanGridComponent().refreshGrid(trainingPlanEntriesUpdated);

        this.getTrainingPlanFormComponent().setVisible(false);

    }
}
