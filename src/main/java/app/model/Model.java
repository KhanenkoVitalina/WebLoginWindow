package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) throws SavedNameException {
        if(isExist(user.getLogin())) {
            SavedNameException e = new SavedNameException("saved name");
            e.setExistingElemtnt(user.getLogin());
            throw e;
        }
        model.add(user);
    }

    public List<String> list() {
        return model.stream()
                .map(User::getLogin)
                .collect(Collectors.toList());
    }
    public boolean isExist(String name){
        List<String> list = this.list();
        for(String login: list){
            if(login.equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}
