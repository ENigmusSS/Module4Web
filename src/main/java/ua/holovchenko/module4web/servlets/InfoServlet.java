package ua.holovchenko.module4web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.holovchenko.module4web.database.models.Race;
import ua.holovchenko.module4web.database.repo.hybernate.RaceDAOImpl;
import ua.holovchenko.module4web.database.repo.interfaces.RaceDAO;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "info", value = "/race/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startTime = req.getParameter("startTime");
        RaceDAO raceDAO = new RaceDAOImpl();
        Race race = raceDAO.getRaceInfo(startTime);
        PrintWriter writer = resp.getWriter();
        writer.println(race.getStartTime());
        race.getHorseRuns().forEach(writer::println);
    }
}
