package translationadapter;

import database.БазаДаних;

public class DataBase extends БазаДаних {
    public String getUserData() {
        return super.отриматиДаніКористувача();
    }

    public String getStatisticData() {
        return super.отриматиСтатистичніДані();
    }
}
