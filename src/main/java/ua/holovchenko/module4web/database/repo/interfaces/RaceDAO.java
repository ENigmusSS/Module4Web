package ua.holovchenko.module4web.database.repo.interfaces;

import ua.holovchenko.module4web.database.models.Race;

public interface RaceDAO extends GenericDAO<Race> {
    Race getRaceInfo(String id);
    long getRacesCount();
}
