package pl.maja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;
import pl.maja.service.MountainPeakService;
import pl.maja.service.RankingsServiceImpl;
import pl.maja.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/rankings")
public class ShowRankingsController {

    private UserService userService;
    private RankingsServiceImpl rankingsServiceImpl;
    private MountainPeakService mountainPeakService;

    public ShowRankingsController(UserService userService, RankingsServiceImpl rankingsServiceImpl, MountainPeakService mountainPeakService) {
        this.userService = userService;
        this.rankingsServiceImpl = rankingsServiceImpl;
        this.mountainPeakService = mountainPeakService;
    }

    @GetMapping("/{nickName}")
    public String showRankings(@PathVariable String nickName, Model model) {
        User user = userService.getUser(nickName);

        model.addAttribute("user", user);
        model.addAttribute("numPeaksClimbed", rankingsServiceImpl.getNumberOfPeaksClimbedByUser(user));
        model.addAttribute("totalDistance", rankingsServiceImpl.getTotalDistanceClimbedByUser(user));
        model.addAttribute("totalVerticalGain", rankingsServiceImpl.getTotalVerticalGainClimbedByUser(user));
        model.addAttribute("listHighestPeaks", rankingsServiceImpl.getList3HighestPeaks(user));
        model.addAttribute("listGreatestVerticalGains", rankingsServiceImpl.list3GreatestVerticalGains(user));
        model.addAttribute("listGreatestDistances", rankingsServiceImpl.list3GreatestDistances(user));
        model.addAttribute("mostDifficultTrip", rankingsServiceImpl.mostDifficultTrip(user));

        List<MountainPeak> listAllTrips = mountainPeakService.showAllTrips(user);
        model.addAttribute("allTrips", listAllTrips);

        return "show-rankings.html";
    }


}
