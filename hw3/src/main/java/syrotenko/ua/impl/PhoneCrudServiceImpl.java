package syrotenko.ua.impl;

import syrotenko.ua.db.PhoneDb;
import syrotenko.ua.entity.Phone;

public class PhoneCrudServiceImpl implements CrudService<Phone> {

    private PhoneDb phoneDb = new PhoneDb();

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void createCRUD(Phone phone) {
        phoneDb.create(phone);
        System.out.println("Phone created");

    }

    @Override
    public void updateCRUD(Phone phone) {
        phoneDb.update(phone);
    }

    @Override
    public void deleteCRUD(String serialNumber) {
        phoneDb.delete(serialNumber);
    }

    @Override
    public Phone findOneCRUD(String serialNumber) {
        return phoneDb.findOne(serialNumber);
    }

    @Override
    public Phone[] findAllCRUD() {
        return phoneDb.findAll();
    }
}
