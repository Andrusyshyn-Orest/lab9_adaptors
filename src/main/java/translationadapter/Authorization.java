package translationadapter;

import database.Авторизація;

public class Authorization extends Авторизація {
    public boolean authorize(DataBase db) {
        return super.авторизуватися(db);
    }
}
