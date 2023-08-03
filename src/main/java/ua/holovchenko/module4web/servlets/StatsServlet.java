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
import java.util.List;

@WebServlet(name = "stats", value = "/stats")
public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        RaceDAO raceDAO = new RaceDAOImpl();
        writer.println("Races organised:" + raceDAO.getRacesCount());
        List<Race> results = raceDAO.getAll();
        results.forEach(writer::println);
    }
}
