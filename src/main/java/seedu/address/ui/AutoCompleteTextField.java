package seedu.address.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandMasterList;

//@@author SebastianLie
/**
 * AutoComplete added to textfield.
 * listens to user input and populates
 * drop down menu with existing commands
 * solution adopted from https://stackoverflow.com/questions/36861056/javafx-textfield-auto-suggestions
 */
public class AutoCompleteTextField extends TextField {

    private final SortedSet<String> entries;
    private ContextMenu entriesPopup;
    private final Logger logger = LogsCenter.getLogger(getClass());
    private History history;
    private ArrayList<String> entriesList = new ArrayList<>();

    /**
     * Listener added
     */
    private ChangeListener<String> changeListener = new ChangeListener<>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            String enteredText = getText();
            String mainRequest = enteredText.substring(0,Math.min(enteredText.length(),6));
            if (enteredText == null || enteredText.isEmpty()) {
                entriesPopup.hide();
            } else {
                List<String> filteredEntries = entries.stream()
                        .filter(e -> e.toLowerCase().contains(mainRequest.toLowerCase()))
                        .collect(Collectors.toList());
                if (!filteredEntries.isEmpty()) {
                    populatePopup(filteredEntries, enteredText);
                    if (!entriesPopup.isShowing()) {
                        //position of popup
                        entriesPopup.show(AutoCompleteTextField.this, Side.BOTTOM, 0, 0);
                    }
                } else {
                    entriesPopup.hide();
                }
            }
        }
    };

    /**
     * initialises all commands and their usages,
     * popup-menu as well as listener
     */
    public AutoCompleteTextField() {
        super();
        this.entries = new TreeSet<>();
        this.entriesPopup = new ContextMenu();
        entries.addAll(CommandMasterList.getCommandWords());
        setListener();

    }

    /**
     * adds listener to suggest commands
     */
    private void setListener() {
        textProperty().addListener(changeListener);
        logger.info("Listening to command box.");
    }

    /**
     * populates contextmenu
     * of command to be entered
     * if any suggestion is selected,
     * set the textfield to suggestion
     * @param searchResult
     * @param searchRequest
     */
    private void populatePopup(List<String> searchResult, String searchRequest) {
        List<CustomMenuItem> menuItems = new LinkedList<>();

        int maxEntries = 10;
        int count = Math.min(searchResult.size(), maxEntries);
        entriesList.clear();
        for (int i = 0; i < count; i++) {
            final String result = searchResult.get(i);

            entriesList.add(result);
            Label entryLabel = new Label();
            entryLabel.setGraphic(Styles.buildTextFlow(result, searchRequest));
            entryLabel.setPrefHeight(10);
            CustomMenuItem item = new CustomMenuItem(entryLabel, true);
            menuItems.add(item);

            item.setOnAction(actionEvent -> {
                setText(result);
                positionCaret(result.length());
                entriesPopup.hide();
            });
        }
        entriesPopup.getItems().clear();
        entriesPopup.getItems().addAll(menuItems);
    }

    /**
     * shutsdown listener for autocomplete
     */
    public void shutdown() {
        logger.info("Shutting down autocomplete listener for commandbox....");
        textProperty().removeListener(changeListener);
    }

    /**
     * helps to autocomplete on ctrl key press
     * sets cursor position at
     */
    public void setAutoCompleteResult() {
        // return if no suggestions
        if (entriesList.isEmpty() || !entriesPopup.isShowing()) {
            return;
        }
        String result = entriesList.get(0);
        setText(result);
        positionCaret(result.length());
        entriesPopup.hide();
    }
    /**
     * hide autocomplete results if needed
     */
    public void hidePopUp() {
        entriesPopup.hide();

    }
}
