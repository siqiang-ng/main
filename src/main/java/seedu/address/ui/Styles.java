package seedu.address.ui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

//@@author SebastianLie
/**
 * helper class for autocomplete textfield
 */
public class Styles {

    /**
     * highlights a certain portion of text
     * @param text - string with text
     * @param filter - string to select in text
     * @return - TextFlow
     */
    public static TextFlow buildTextFlow(String text, String filter) {
        assert text.contains(filter);
        String caseIndependent = text.toLowerCase();
        String caseIndependentFilter = filter.toLowerCase();
        int filterIndex = caseIndependent.indexOf(caseIndependentFilter);

        Text textBefore = new Text(text.substring(0, filterIndex));
        Text textAfter = new Text(text.substring(filterIndex + filter.length()));
        Text textFilter = new Text(text.substring(filterIndex, filterIndex + filter.length()));

        textFilter.setFill(Color.LIGHTSKYBLUE);
        textFilter.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        return new TextFlow(textBefore, textFilter, textAfter);
    }
}
