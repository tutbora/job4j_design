package ru.job4j.generics;

public class RoleStore extends Base implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    private RoleStore(String id) {
        super(id);
    }

    @Override
    public void add(Role model) {
        var rsl = store.findById(model.getId());
        if (rsl == null) {
            store.add(model);
        }
    }

    @Override
    public boolean replace(String id, Role model) {
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
    public Role findById(String id) {
        return store.findById(id);
    }
}
