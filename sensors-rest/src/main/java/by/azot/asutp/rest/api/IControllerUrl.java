package by.azot.asutp.rest.api;

public interface IControllerUrl {

    public final static String USERS="/users";
    public final static String RESTUSERS="/rest/users";

    public final static String REDIRECTUSERS="redirect:/users";

    public final static String SENSORS="/sensors";
    public final static String RESTSENSORS="/rest/sensors";

    public final static String REDIRECTSENSORS="redirect:/sensors";

    public final static String ADDPAGE="/add";
    public final static String PAGE="/page={page}";
    public final static String REMOVEID="/remove/{id}";
    public final static String UPDATEID="/upd/{id}";
    public final static String FINDID="/{id}";

    public final static String FIRSTNAME="/name/{firstName}";

    public final static String USERSPAGE="users/usersPage";
    public final static String USERPAGE="users/userPage";
    public final static String USERPAGEUPDATE="users/usersFormPageUpd";
    public final static String USERFORMPAGE="users/usersFormPage";

    public final static String OBJECTUSERSLIST="usersList";
    public final static String OBJECTUSER="user";


    public final static String SENSORSPAGE="sensors/sensorsPage";
    public final static String SENSORPAGE="sensors/sensorPage";
    public final static String SENSORPAGEUPDATE="sensors/sensorsFormPageUpd";
    public final static String SENSORFORMPAGE="sensors/sensorsFormPage";

    public final static String OBJECTSENSORSLIST="sensorsList";
    public final static String OBJECTSENSOR="sensor";
}
