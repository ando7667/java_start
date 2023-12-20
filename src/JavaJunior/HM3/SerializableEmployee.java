package JavaJunior.HM3;

import java.io.*;
import java.util.UUID;

public class SerializableEmployee implements Serializable {
    private String name;
    private String family;
    private String birthday;
    private int idDepartment;
    private int idPosition;
    private String startDate;
    private int idWorkSchedule;

    /**
     *
     * @param name              имя
     * @param family            фамилия
     * @param birthday          дата рождения
     * @param idDepartment      ид отдела
     * @param idPosition        ид должности
     * @param idWorkSchedule    ид графика работы
     * @param startDate         дата начала работы
     */
    public SerializableEmployee(String name,String family, String birthday, int idDepartment, int idPosition, int idWorkSchedule, String startDate) {
        this.name = name;
        this.family = family;
        this.birthday = birthday;
        this.idDepartment = idDepartment;
        this.idPosition = idPosition;
        this.idWorkSchedule = idWorkSchedule;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getIdWorkSchedule() {
        return idWorkSchedule;
    }

    public void setIdWorkSchedule(int idWorkSchedule) {
        this.idWorkSchedule = idWorkSchedule;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s, дата рождения: %s, отдел: %d, должность: %d, график работы: %d, работает с: %s", name, family, birthday, idDepartment, idPosition, idWorkSchedule, startDate);
    }

    public static String saveEmployee(Serializable obj) throws IOException {
        String filename = obj.getClass() + "_" + UUID.randomUUID().toString() + ".txt";
        File file = new File(filename);
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        }else {
            file.createNewFile();
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        return filename;
    }

    public static Serializable loadEmployee(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Serializable obj = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
            file.delete();
            return obj;
        } else {
            return null;
        }
    }
}
