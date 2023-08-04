package ua.holovchenko.module4web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.holovchenko.module4web.database.models.HorseRun;
import ua.holovchenko.module4web.database.models.Race;
import ua.holovchenko.module4web.database.repo.hybernate.HorseRunDAOImpl;
import ua.holovchenko.module4web.database.repo.hybernate.RaceDAOImpl;
import ua.holovchenko.module4web.database.repo.interfaces.HorseRunDAO;
import ua.holovchenko.module4web.database.repo.interfaces.RaceDAO;
import ua.holovchenko.module4web.logic.Horse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class RunExecutorServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int horseAmount = Integer.parseInt(req.getParameter("horseAmount"));
        int bet = Integer.parseInt(req.getParameter("bet"));
        List<Horse> horses = new ArrayList<>(horseAmount);
        for (int i = 0; i < horseAmount; i++) {
            horses.add(new Horse(i+1));
        }
        Horse chosenHorse = horses.get(bet-1);
        chosenHorse.setChosen(true);
        String startTime = LocalDateTime.now().toString();
        try {
            startRun(horses);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ArrayList<HorseRun> horseRuns = new ArrayList<>();
        Race race = new Race(startTime, horseRuns);
        for (Horse horse : horses) {
            horseRuns.add(new HorseRun(race, horse.getNumber(), horse.getPlace(), horse.getResult(), horse.isChosen()));
        }
        RaceDAO raceDAO = new RaceDAOImpl();
        raceDAO.save(race);
        HorseRunDAO horseRunDAO = new HorseRunDAOImpl();
        horseRuns.forEach(horseRunDAO::save);
        resp.setStatus(201);
        PrintWriter writer = resp.getWriter();
        writer.println(race.getStart_time());
        for (Horse horse : horses) {
            horse.printResult(writer);
        }
    }

    private static void startRun(List<Horse> horses) throws InterruptedException {
        horses.forEach(Horse::startHorseRun);
        while (!horses.stream().allMatch(Horse::isFinished)) {
            sleep(1000);
        }
        horses = horses.stream().sorted().toList();
        for (Horse horse: horses) {
            horse.setPlace(horses.indexOf(horse)+1);
        }
    }
}

