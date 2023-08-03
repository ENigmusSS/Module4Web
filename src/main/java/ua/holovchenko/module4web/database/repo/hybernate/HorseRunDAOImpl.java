package ua.holovchenko.module4web.database.repo.hybernate;

import ua.holovchenko.module4web.database.models.HorseRun;
import ua.holovchenko.module4web.database.repo.interfaces.HorseRunDAO;

public class HorseRunDAOImpl extends GenericDAOImpl<HorseRun> implements HorseRunDAO {

    @Override
    protected void init() {
        aClass = HorseRun.class;
    }

}
