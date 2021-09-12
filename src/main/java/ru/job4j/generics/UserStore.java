package ru.job4j.generics;

public class UserStore extends Base implements Store<User> {
    
    private final Store<User> store = new MemStore<>();

    private UserStore(String id) {
        super(id);
    }

    @Override
    public void add(User model) {
        var rsl = store.findById(model.getId());
        if (rsl == null) {
            store.add(model);
        }
    }

    @Override
    public boolean replace(String id, User model) {
        var rsl = store.findById(model.getId());
        if (rsl != null) {
            store.replace(model.getId(), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        var rsl = store.findById(id);
        if (rsl != null) {
            store.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}