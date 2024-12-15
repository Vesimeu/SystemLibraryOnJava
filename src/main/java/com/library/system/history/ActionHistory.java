package com.library.system.history;

import java.util.ArrayList;
import java.util.List;

public class ActionHistory {
    private final List<String> actions = new ArrayList<>();
    private final List<HistoryMemento> historySnapshots = new ArrayList<>();

    // Добавление действия в историю
    public void addAction(String action) {
        actions.add(action);
        System.out.println("Action added: " + action);
    }

    // Получение всей истории
    public List<String> getActions() {
        System.out.println("**ACTIONS**");
        return actions; // Защита от модификации
    }

    // Создание снапшота текущего состояния (Memento)
    public HistoryMemento saveState() {
        HistoryMemento memento = new HistoryMemento(new ArrayList<>(actions));
        historySnapshots.add(memento);
        System.out.println("State saved with " + actions.size() + " actions.");
        //Теперь можем очистить action
        return memento;
    }

    // Восстановление состояния из снапшота
    public void restoreState(HistoryMemento memento) {
        if (memento != null) {
            actions.clear();
            actions.addAll(memento.getSavedActions());
            System.out.println("State restored with " + actions.size() + " actions.");
        }
    }

    // Вложенный класс Memento для сохранения состояния
    public static class HistoryMemento {
        private final List<String> savedActions;

        public HistoryMemento(List<String> actions) {
            this.savedActions = actions;
        }

        private List<String> getSavedActions() {
            return savedActions;
        }
    }
}
