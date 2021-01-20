package ca.shubbar;

import ca.shubbar.datamodel.TodoData;
import ca.shubbar.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
//        TodoItem item1 = new TodoItem("Mail birthday card",
//                "Buy a 30th birthday card for john",
//                LocalDate.of(2020, Month.APRIL, 23));
//
//        TodoItem item2 = new TodoItem("Dentist appointment",
//                "dh dghdfgh dty drty drty drty drty ",
//                LocalDate.of(2021, Month.MARCH, 12));
//
//        TodoItem item3 = new TodoItem("Design project",
//                "kojihugyfth drtyhcfg hfcgh dtyh drty drty ",
//                LocalDate.of(2018, Month.JANUARY, 05));
//
//        TodoItem item4 = new TodoItem("Canada post application",
//                "dtyhc dtyjkouigyfyrty drty ry tyd r:)",
//                LocalDate.of(2021, Month.FEBRUARY, 11));
//
//        TodoItem item5 = new TodoItem("Finish BillPresso",
//                "Oh my god, oh my godness, oh my gash, oh my allh",
//                LocalDate.of(2022, Month.APRIL, 14));
//
//
//        todoItems = new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null) {
                    TodoItem todoItem = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(todoItem.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(todoItem.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        todoListView.getSelectionModel().selectFirst();

    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());

//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());

    }


}
