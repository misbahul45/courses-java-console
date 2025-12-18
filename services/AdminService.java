package services;
import java.util.ArrayList;
import java.util.List;
import interfaces.UserService;
import models.admin.Admin;
import models.admin.AdminImpl;

public class AdminService implements UserService<Admin>{

    private static final String FILE = "data/admin.txt";

    @Override
    public Admin create(Admin user) {
        String line=String.join("|",
            user.getIdString(),
            user.getFullname(),
            user.getEmail(),
            user.getPassword()
        );
        Fileservice.append(FILE, line);
        return user;
    }

    @Override
    public Admin update(String id, Admin user) {
        this.delete(id);
        return create(user);
    }

    @Override
    public boolean delete(String id) {
        List<String> lines=Fileservice.readAll(FILE);
        boolean removed=lines.removeIf(l -> l.startsWith(id+"|"));
        Fileservice.writeAll(FILE, lines);
        return removed;
    }

    @Override
    public Admin findOne(String id) {
        
        return null;
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins=new ArrayList<Admin>();

        for (String line : Fileservice.readAll(FILE)) {
            String[] d=line.split("\\|");

            admins.add(new AdminImpl(d[0], d[1], d[2],d[3]));
        }
        return admins;
    }
}